package ro.ase.eu.aslapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class afterLogActivity extends BaseActivity {
    TextView tvLearn, tvTranslate;
    ImageView ivLearn,ivTranslate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_log);

        Intent intent=getIntent();
        String username=intent.getStringExtra("key");

        Toast.makeText(getApplicationContext(),"Welcome "+username+" !",Toast.LENGTH_SHORT).show();

        tvLearn=(TextView) findViewById(R.id.tvLearn);
        tvTranslate=(TextView) findViewById(R.id.tvTranslate);

        ivLearn=(ImageView)findViewById(R.id.ivLearn);
        ivTranslate=(ImageView)findViewById(R.id.ivTranslate);

        tvTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),TranslateActivity1.class);
                startActivity(intent1);
            }
        });
        tvLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getApplicationContext(),LearnActivity1.class);
                startActivity(intent2);
            }
        });
    }
}
