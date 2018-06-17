package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

import ro.ase.eu.aslapplication.clase.HttpParse;

public class SettingsAccount extends AppCompatActivity {

    String HttpURL = "http://ileanadaniela19.000webhostapp.com/SettingAccount/UpdateAccount.php";
    String UserInformationURL="https://ileanadaniela19.000webhostapp.com/SettingAccount/UserInformation.php";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    EditText etNameSetting,etEmailSetting,etPassSetting,etConfPassSetting;
    Button btnSubmit;
    String nameHolder,emailHolder,passwordHolder;
    String parseResult;
    HashMap<String,String> resultHash=new HashMap<>();

    String finalResultJSON;
    String  emailLogin="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_account);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNameSetting = (EditText)findViewById(R.id.etNameSetting);
        etEmailSetting = (EditText)findViewById(R.id.etEmailSetting);
        etPassSetting = (EditText)findViewById(R.id.etPassSetting);
        etConfPassSetting=(EditText)findViewById(R.id.etConfPassSetting);

        btnSubmit = (Button)findViewById(R.id.btnSubmit);

        emailLogin=LoginActivity.EmailHolder;

        getUserInformation(LoginActivity.EmailHolder);

        // Setting Received name,email, password
        etNameSetting.setText(nameHolder);
        etEmailSetting.setText(emailHolder);
        etPassSetting.setText(passwordHolder);
        etConfPassSetting.setText(passwordHolder);

        // Adding click listener to submit button .
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Getting data from EditText after button click.
                GetDataFromEditText();

                // Sending name,email,password to method to update on server.
                UpdateUser(nameHolder,emailHolder,passwordHolder);

            }
        });


    }

    // Method to get existing data from EditText.
    public void GetDataFromEditText(){

        nameHolder = etNameSetting.getText().toString();
        emailHolder = etEmailSetting.getText().toString();
        passwordHolder = etPassSetting.getText().toString();

    }

    // Method to Update user information
    public void UpdateUser(final String name, final String email, final String password){

        class UpdateUserClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponse) {
                super.onPostExecute(httpResponse);

                Toast.makeText(SettingsAccount.this,httpResponse.toString(), Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SettingsAccount.this,afterLogActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("name",params[0]);
                hashMap.put("email",params[1]);
                hashMap.put("password",params[2]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }

        UpdateUserClass updateUserClass = new UpdateUserClass();
        updateUserClass.execute(name,email,password);
    }

    private void getUserInformation(final String email){
        class GetUserInformation extends AsyncTask<String,Void,String>{

            @Override
            protected String doInBackground(String... strings) {
                resultHash.put("email",strings[0]);
                parseResult = httpParse.postRequest(resultHash,UserInformationURL);
                return parseResult;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);

                finalResultJSON=httpResponseMsg;
                new GetHttpResponse(SettingsAccount.this).execute();
            }
        }
        GetUserInformation gui=new GetUserInformation();
        gui.execute(email);
    }

    private class GetHttpResponse extends AsyncTask<Void,Void,Void>{
        public Context context;

        public GetHttpResponse(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                if (finalResultJSON != null) {
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(finalResultJSON);
                        JSONObject jsonObject;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.getJSONObject(i);
                            nameHolder = jsonObject.getString("user_name").toString();
                            emailHolder = jsonObject.getString("user_email").toString();
                            passwordHolder = jsonObject.getString("user_password").toString();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            etNameSetting.setText(nameHolder);
            etEmailSetting.setText(emailHolder);
            etPassSetting.setText(passwordHolder);
        }
    }
}
