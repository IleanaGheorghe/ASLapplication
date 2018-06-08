package ro.ase.eu.aslapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;

import ro.ase.eu.aslapplication.clase.AlarmReceiver1;
import ro.ase.eu.aslapplication.clase.HttpParse;


public class LoginActivity extends AppCompatActivity {
    EditText etUser, etPassword;
    Button btnLog;
    TextView tvCreate;

    String PasswordHolder;
    static String EmailHolder;
    String finalResult ;
    String HttpURL = "http://ileanadaniela19.000webhostapp.com/LoginRegister/UserLogin.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();

    private PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser=(EditText)findViewById(R.id.etUser);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLog=(Button)findViewById(R.id.btnLogin);
        tvCreate=(TextView)findViewById(R.id.tvCreate);

        Calendar calendar = Calendar.getInstance();

     // we can set time by open date and time picker dialog

        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 53);
        calendar.set(Calendar.SECOND, 0);

        Intent intent1 = new Intent(LoginActivity.this, AlarmReceiver1.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                LoginActivity.this, 0, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) LoginActivity.this
                .getSystemService(LoginActivity.this.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);


        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    UserLoginFunction(EmailHolder, PasswordHolder);

                }
                else {

                    Toast.makeText(LoginActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

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

                if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                    finish();

                    Intent intent = new Intent(LoginActivity.this, afterLogActivity.class);

                    intent.putExtra("key",EmailHolder);

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
