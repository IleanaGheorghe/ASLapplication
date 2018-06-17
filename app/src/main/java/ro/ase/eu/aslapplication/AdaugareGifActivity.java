package ro.ase.eu.aslapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import ro.ase.eu.aslapplication.clase.HttpParse;
import ro.ase.eu.aslapplication.clase.InputValidation;

public class AdaugareGifActivity extends BaseActivity {

    private TextView tvNumeActivitate;
    private EditText etNume, etUrl;
    private WebView webViewAdauga;
    private Button btnAdauga;

    String numeA,pathA;
    Boolean CheckEditText ;

    String finalResult ;
    String HttpURL = "https://ileanadaniela19.000webhostapp.com/LoginRegister/adaugareGif.php";
    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaugare_gif);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

        tvNumeActivitate=(TextView) findViewById(R.id.tvNumeActivitate);
        etNume=(EditText) findViewById(R.id.etNumeExpresie);
        etUrl=(EditText) findViewById(R.id.etUrlExpresie);
        webViewAdauga=(WebView) findViewById(R.id.wvPreview);
        webViewAdauga.setBackgroundColor(Color.WHITE);
        webViewAdauga.getSettings().setLoadWithOverviewMode(true);
        webViewAdauga.getSettings().setUseWideViewPort(true);

        btnAdauga=(Button) findViewById(R.id.btnAdaugaGif);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if(CheckEditText) {
                    Log.d("valori ", numeA + " " + pathA);
                    Log.e("valori ", numeA + " " + pathA);
                    webViewAdauga.loadUrl(pathA);
                    AdaugareGif(numeA, pathA);
                }else {
                    Toast.makeText(AdaugareGifActivity.this, "Completati toate campurile!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot(){

        numeA=etNume.getText().toString();
        pathA=etUrl.getText().toString();

        if(TextUtils.isEmpty(numeA) || TextUtils.isEmpty(pathA))
        {
            CheckEditText = false;
        }
        else {

            CheckEditText = true ;
        }
    }
    public void AdaugareGif(final String nume, final String path){

        class AdaugareGifClass extends AsyncTask<String,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {

                super.onPostExecute(httpResponseMsg);

                Toast.makeText(AdaugareGifActivity.this,httpResponseMsg.toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                hashMap.put("nume",params[0]);
                hashMap.put("path",params[1]);

                finalResult = httpParse.postRequest(hashMap, HttpURL);

                return finalResult;
            }
        }
        AdaugareGifClass adaugareGifClass=new AdaugareGifClass();
        adaugareGifClass.execute(nume,path);
    }
}
