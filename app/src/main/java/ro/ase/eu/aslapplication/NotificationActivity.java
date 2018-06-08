package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Random;

import ro.ase.eu.aslapplication.clase.HttpParse;
import ro.ase.eu.aslapplication.clase.NotificationService1;

public class NotificationActivity extends AppCompatActivity {
    private static final String SEARCH_URL="https://ileanadaniela19.000webhostapp.com/Notificari/getExpresieRandom.php";
    Random r = new Random();
    int id = r.nextInt(207 - 1) + 1;

    HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static String nume,urlImagine;
    String parseResult;
    HashMap<String,String> resultHash=new HashMap<>();

    String finalResultJSON;

    TextView tvNotificare;
    WebView wvNotificare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Intent intent=getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNotificare=(TextView) findViewById(R.id.tvNotificare);
        wvNotificare=(WebView) findViewById(R.id.wvNotificare);

        getSearchExpression(id);
    }

    private void getSearchExpression(final int id){
        class GetSearchExpression extends AsyncTask<String,Void,String> {

            ProgressDialog loading;

            @Override
            protected String doInBackground(String... strings) {
                resultHash.put("id", String.valueOf(strings[0]));
                parseResult = httpParse.postRequest(resultHash,SEARCH_URL);
                return parseResult;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(NotificationActivity.this, "Încărcare cuvânt...","Vă rugăm asteptați...",true,true);
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                loading.dismiss();

                finalResultJSON=httpResponseMsg;
                new NotificationActivity.GetHttpResponse(NotificationActivity.this).execute();
            }
        }
        GetSearchExpression gse=new GetSearchExpression();
        gse.execute(String.valueOf(id));
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
            tvNotificare.setText(nume);
            wvNotificare.loadUrl(urlImagine);
        }
    }
}
