package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;
import ro.ase.eu.aslapplication.clase.HttpParse;

public class TranslateActivity1 extends BaseActivity {
    private static final String SEARCH_URL="https://ileanadaniela19.000webhostapp.com/Translate/getExpresie.php";
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView tvTranslate;
    private EditText etMessage;
    private Button buttonGo;
    private WebView wvTranslate;
    private ImageButton mSpeakBtn;
    private TextView tvMic;

    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    String nume,urlImagine;
    String parseResult;
    HashMap<String,String> resultHash=new HashMap<>();

    String finalResultJSON;

    String text="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate1);

        Intent intent=getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvTranslate=(TextView)findViewById(R.id.tvTranslate);
        wvTranslate=(WebView) findViewById(R.id.wvTranslate);
        etMessage=(EditText)findViewById(R.id.etMessage);
        buttonGo=(Button)findViewById(R.id.buttonGo) ;
        tvMic = (TextView) findViewById(R.id.textMic);
        mSpeakBtn = (ImageButton) findViewById(R.id.btnSpeak);

        wvTranslate.setBackgroundColor(Color.WHITE);
        wvTranslate.getSettings().setLoadWithOverviewMode(true);
        wvTranslate.getSettings().setUseWideViewPort(true);
        mSpeakBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startVoiceInput();
            }
        });

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text=etMessage.getText().toString();
                getSearchExpression(text);
            }
        });
    }

    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello, say what you want to translate.");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    etMessage.setText(result.get(0));
                }
                break;
            }

        }
    }
    private void getSearchExpression(final String text){
        class GetSearchExpression extends AsyncTask<String,Void,String> {

            ProgressDialog loading;
            @Override
            protected String doInBackground(String... strings) {
                resultHash.put("text",strings[0]);
                parseResult = httpParse.postRequest(resultHash,SEARCH_URL);
                return parseResult;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TranslateActivity1.this, "Încărcare imagini...","Vă rugăm asteptați...",true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                loading.dismiss();

                finalResultJSON=httpResponseMsg;
                new TranslateActivity1.GetHttpResponse(TranslateActivity1.this).execute();
            }
        }
        GetSearchExpression gse=new GetSearchExpression();
        gse.execute(text);
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
                            nume = jsonObject.getString("nume").toString();
                            urlImagine = jsonObject.getString("path").toString();
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
            tvTranslate.setText("Cuvantul zilei este : " +nume);
            wvTranslate.loadUrl(urlImagine);
        }
    }
}
