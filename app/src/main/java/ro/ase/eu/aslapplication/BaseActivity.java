package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.TokenWatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.HashMap;

import ro.ase.eu.aslapplication.clase.HttpParse;


public class BaseActivity extends AppCompatActivity {
    String username;
    String URLDelete="http://ileanadaniela19.000webhostapp.com/SettingAccount/DeleteAccount.php";
    String finalResult ;
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse=new HttpParse();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meniucomun,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.logout){
            Intent intent=new Intent(BaseActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        if(id==R.id.sett){
            Intent intent=new Intent(BaseActivity.this,SettingsAccount.class);
            startActivity(intent);
        }
        if(id==R.id.delAccount){
          UserDelete(LoginActivity.EmailHolder);
        }
        if(id==R.id.itmAbout){
            Toast.makeText(this,"About is clicked",Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void UserDelete(final String email) {

        class UserDeleteClass extends AsyncTask<String, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                Intent intent=new Intent(BaseActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                Toast.makeText(BaseActivity.this, httpResponseMsg.toString(), Toast.LENGTH_LONG).show();

                finish();

            }

            @Override
            protected String doInBackground(String... params) {

                // Sending email

                hashMap.put("email", params[0]);

                finalResult = httpParse.postRequest(hashMap, URLDelete);

                return finalResult;
            }
        }

        UserDeleteClass userDeleteClass = new UserDeleteClass();

        userDeleteClass.execute(email);
    }
}
