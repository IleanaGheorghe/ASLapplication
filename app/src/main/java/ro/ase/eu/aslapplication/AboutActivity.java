package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends BaseActivity {

    private TextView tvAbout, tvDezvoltare, tvMotivatie, tvSursa, tvPrezentare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent=getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvAbout= (TextView)findViewById(R.id.tvAbout);
        tvDezvoltare=(TextView) findViewById(R.id.tvDezvoltare);
        tvSursa=(TextView) findViewById(R.id.tvSursa);
        tvPrezentare=(TextView) findViewById(R.id.tvPrezentare);
        tvMotivatie=(TextView)findViewById(R.id.tvMotivatie);

    }
}
