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
import android.widget.Toast;

import java.util.HashMap;

import ro.ase.eu.aslapplication.clase.HttpParse;
import ro.ase.eu.aslapplication.clase.InputValidation;


public class CreateaccountActivity extends AppCompatActivity {
    EditText etName,etEmail,etPass, etConfPass;
    Button btnSign;

    String Name_Holder, ConfPass_Holder, EmailHolder, PasswordHolder;
    String finalResult ;
    String HttpURL = "http://ileanadaniela19.000webhostapp.com/LoginRegister/UserRegistration.php";
    Boolean CheckEditText ;
    ProgressDialog progressDialog;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    InputValidation inputValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        Intent intent=getIntent();
        inputValidation = new InputValidation(CreateaccountActivity.this);

        etName=(EditText)findViewById(R.id.etName);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPass=(EditText) findViewById(R.id.etPass);
        etConfPass=(EditText) findViewById(R.id.etConfPass);
        btnSign=(Button)findViewById(R.id.btnSignup);
       btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputValidation.isInputEditTextFilled(etName,getString(R.string.error_message))==false) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(etEmail, getString(R.string.error_message))) {
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(etEmail, getString(R.string.error_message))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(etPass, getString(R.string.error_message))) {
                    return;
                }
                if (!inputValidation.isInputEditTextMatches(etPass, etConfPass,getString(R.string.error_password))) {
                    return;
                }
                CheckEditTextIsEmptyOrNot();

                if(CheckEditText){

                    // If EditText is not empty and CheckEditText = True then this block will execute.

                    UserRegisterFunction(Name_Holder, EmailHolder, PasswordHolder,ConfPass_Holder);

                }
                else {

                    // If EditText is empty then this block will execute .
                    Toast.makeText(CreateaccountActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
    public void CheckEditTextIsEmptyOrNot(){

        Name_Holder = etName.getText().toString();
        EmailHolder = etEmail.getText().toString();
        PasswordHolder = etPass.getText().toString();
        ConfPass_Holder= etConfPass.getText().toString();


        if(TextUtils.isEmpty(Name_Holder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(ConfPass_Holder) || !PasswordHolder.contentEquals(ConfPass_Holder))
        {

            CheckEditText = false;

        }
        else {

            CheckEditText = true ;
        }

    }

    public void UserRegisterFunction(final String name, final String email, final String password, final String cfpassword){

        class UserRegisterFunctionClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(CreateaccountActivity.this,"Loading Data",null,true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                progressDialog.dismiss();

                Toast.makeText(CreateaccountActivity.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();
                Intent intent=new Intent(CreateaccountActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("name",params[0]);

                hashMap.put("email",params[1]);

                hashMap.put("password",params[2]);

                hashMap.put("confpass",params[3]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();

        userRegisterFunctionClass.execute(name,email,password,cfpassword);
    }

}
