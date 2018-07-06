package ro.ase.eu.aslapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

import ro.ase.eu.aslapplication.clase.AlarmReceiver1;
import ro.ase.eu.aslapplication.clase.HttpParse;
import ro.ase.eu.aslapplication.clase.InputValidation;


public class LoginActivity extends AppCompatActivity {
    EditText etUser, etPassword;
    Button btnLog;
    TextView tvCreate;
    CheckBox rememberMe;
    static String PasswordHolder;
    static String EmailHolder;
    String finalResult ;
    String HttpURL = "https://ileanadaniela19.000webhostapp.com/LoginRegister/UserLogin.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();

    InputValidation inputValidation;
    private static String PREF = "PREF";
    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser=(EditText)findViewById(R.id.etUser);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLog=(Button)findViewById(R.id.btnLogin);
        tvCreate=(TextView)findViewById(R.id.tvCreate);
        rememberMe=(CheckBox) findViewById(R.id.checkBox);

        dailyNotif();
        if (!new PrefManager(this).isUserLogedOut()) {
            //user's email and password both are saved in preferences
            EmailHolder=new PrefManager(this).getEmail();
            dailyNotif();
            startHomeActivity();
        }

        inputValidation =new InputValidation(LoginActivity.this);
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    if(!inputValidation.isInputEditTextEmail(etUser,"Introduceti un email valid!")){
                        return;
                    }
                    UserLoginFunction(EmailHolder, PasswordHolder);

                }
                else {

                    Toast.makeText(LoginActivity.this, "Completati toate campurile!", Toast.LENGTH_LONG).show();

                }
            }
        });
        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CreateaccountActivity.class);
                startActivity(intent);
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot(){

        EmailHolder = etUser.getText().toString();
        PasswordHolder = etPassword.getText().toString();

        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {
            CheckEditText = false;
        }
        else {

            CheckEditText = true ;
        }
    }

    public class PrefManager {
        Context context;
        PrefManager(Context context) {
            this.context = context;
        }

        public void saveLoginDetails(String email, String password) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.commit();
        }
        public String getEmail() {
            SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
            return sharedPreferences.getString("Email", "");
        }
        public boolean isUserLogedOut() {
            SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
            boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
            boolean isPasswordEmpty = sharedPreferences.getString("Password", "").isEmpty();
            return isEmailEmpty || isPasswordEmpty;
        }
    }
    private void saveLoginDetails(String email, String password) {
        new PrefManager(this).saveLoginDetails(email, password);
    }
    public void startHomeActivity(){
        String userName=EmailHolder;
        String pwd=PasswordHolder;
        Intent intent=new Intent(getApplicationContext(),afterLogActivity.class);
        intent.putExtra("key",userName);
        startActivity(intent);
    }

    public void dailyNotif(){
        long t=System.currentTimeMillis();
        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.set(Calendar.HOUR_OF_DAY, 9);
        alarmStartTime.set(Calendar.MINUTE, 00);
        alarmStartTime.set(Calendar.SECOND, 0);

        if(t<=alarmStartTime.getTimeInMillis()) {
            AlarmManager alarmManager = (AlarmManager) getSystemService(LoginActivity.this.ALARM_SERVICE);
            Intent alarmIntent = new Intent(LoginActivity.this, AlarmReceiver1.class);

            pendingIntent = PendingIntent.getBroadcast(LoginActivity.this, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            //alarmManager.set(AlarmManager.RTC_WAKEUP,alarmStartTime.getTimeInMillis(),pendingIntent);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        }
    }

    public void UserLoginFunction(final String email, final String password){

        class UserLoginClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(LoginActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){                    finish();
                    Intent intent = new Intent(LoginActivity.this, afterLogActivity.class);
                    intent.putExtra("key",EmailHolder);
                    if(rememberMe.isChecked()){
                        saveLoginDetails(EmailHolder,PasswordHolder);
                    }
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("email",params[0]);
                hashMap.put("password",params[1]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }

        UserLoginClass userLoginClass = new UserLoginClass();

        userLoginClass.execute(email,password);
    }

}
