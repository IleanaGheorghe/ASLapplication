package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser=(EditText)findViewById(R.id.etUser);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnLog=(Button)findViewById(R.id.btnLogin);
        tvCreate=(TextView)findViewById(R.id.tvCreate);

      /*  databaseHelper = new DatabaseHelper(LoginActivity.this);
        inputValidation = new InputValidation(LoginActivity.this);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputValidation.isInputEditTextFilled(etUser, getString(R.string.error_message))) {
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(etUser, getString(R.string.error_message))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(etPassword, getString(R.string.error_message))) {
                    return;
                }

                if (databaseHelper.checkUser(etUser.getText().toString().trim()
                        , etPassword.getText().toString().trim())) {

                    Intent intent = new Intent(getApplicationContext(), afterLogActivity.class);
                    intent.putExtra("key", etUser.getText().toString());
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(),"Inccorect data",Toast.LENGTH_LONG).show();
                }
            }
        });*/
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
