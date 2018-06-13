package ro.ase.eu.aslapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NotificationActivity extends AppCompatActivity {
    private static final String SEARCH_URL="https://ileanadaniela19.000webhostapp.com/Notificari/random.php";

    public static String nume,urlImagine;

    TextView tvNotificare;
    WebView wvNotificare;

    private static final String JSON_ARRAY ="result";
    private static final String IMAGE_URL = "url";
    private static final String IMAGE_NAME="nume";

    private JSONArray arrayImages= null;
    private String imagesJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        getAllImages();
        Intent intent=getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvNotificare=(TextView) findViewById(R.id.tvNotificare);
        wvNotificare=(WebView) findViewById(R.id.wvNotificare);
        wvNotificare.setBackgroundColor(Color.WHITE);
        wvNotificare.getSettings().setLoadWithOverviewMode(true);
        wvNotificare.getSettings().setUseWideViewPort(true);


    }

    private void extractJSON(){
        try {
            JSONObject jsonObject = new JSONObject(imagesJSON);
            arrayImages = jsonObject.getJSONArray(JSON_ARRAY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void showImage(){
        try {
            JSONObject jsonObject = arrayImages.getJSONObject(0);
            nume=jsonObject.getString(IMAGE_URL);
            urlImagine=jsonObject.getString(IMAGE_NAME).toString();
            wvNotificare.loadUrl(nume);
            tvNotificare.setText("Cuvântul zilei este : " +urlImagine);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    private void getAllImages() {
        class GetAllImages extends AsyncTask<String,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(NotificationActivity.this, "Încărcare cuvânt...","Vă rugăm asteptați...",true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                imagesJSON = s;
                extractJSON();
                showImage();
            }

            @Override
            protected String doInBackground(String... params) {
                String uri = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while((json = bufferedReader.readLine())!= null){
                        sb.append(json+"\n");
                    }

                    return sb.toString().trim();

                }catch(Exception e){
                    return null;
                }
            }
        }
        GetAllImages gai = new GetAllImages();
        gai.execute(SEARCH_URL);
    }
}
