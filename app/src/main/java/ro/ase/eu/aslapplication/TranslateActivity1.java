package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import ro.ase.eu.aslapplication.clase.Expresie;
import ro.ase.eu.aslapplication.clase.HttpParse;
import ro.ase.eu.aslapplication.clase.expresieListener;

public class TranslateActivity1 extends BaseActivity implements expresieListener {
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
    public String nume,urlImagine;
    public int id;
    String parseResult;
    HashMap<String,String> resultHash=new HashMap<>();

    String finalResultJSON;

    String text="";
    ArrayList<Expresie> expresies;
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
                expresies=new ArrayList<>();
                getSearchExpression(text);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        getMenuInflater().inflate(R.menu.meniucomun, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.share) {
            shareContent();
        }

        return super.onOptionsItemSelected(item);
    }
    private void shareContent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, urlImagine);
        startActivity(Intent.createChooser(shareIntent,String.valueOf("How do you want to share")));
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

    @Override
       public void onSucces(ArrayList<Expresie> array) {
        if(array.size()==1) {
            tvTranslate.setText(array.get(0).getNume());
            wvTranslate.loadUrl(array.get(0).getPath());
        }
        else{
            Handler handler=new Handler();
            Runnable runnable=new Runnable() {
                int count=0;
                boolean stop=false;
                @Override
                public void run() {
                    tvTranslate.setText(array.get(count).getNume());
                    wvTranslate.loadUrl(array.get(count).getPath());
                    count++;
                    if(count>=array.size()) {
                        stop=true;
                    }
                    if(!stop){
                        handler.postDelayed(this,4000);
                    }
                }
            };
            handler.postDelayed(runnable,600);
        }
    }

    private class GetHttpResponse extends AsyncTask<Void,Void,ArrayList<Expresie>>{
        public expresieListener expresie;

        public GetHttpResponse(expresieListener expresie) {
            this.expresie = expresie;
        }

        @Override
        protected ArrayList<Expresie> doInBackground(Void... voids) {
            try {
                if (finalResultJSON != null) {
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(finalResultJSON);
                        JSONObject jsonObject;
                        for (int i = 0; i < jsonArray.length(); i++) {
                            jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            nume = jsonObject.getString("nume").toString();
                            urlImagine = jsonObject.getString("path").toString();
                            Expresie e=new Expresie(id, nume, urlImagine);
                            expresies.add(e);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            return expresies;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Expresie> aVoid) {
            super.onPostExecute(aVoid);
            expresie.onSucces(aVoid);
        }
    }
}
