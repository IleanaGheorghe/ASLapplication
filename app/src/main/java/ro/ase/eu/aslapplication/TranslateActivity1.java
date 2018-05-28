package ro.ase.eu.aslapplication;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
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

import java.util.ArrayList;
import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class TranslateActivity1 extends BaseActivity {
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView tvTranslate;
    private EditText etMessage;
    private Button buttonGo;
    private WebView wvTranslate;
    private ImageButton mSpeakBtn;
    private TextView tvMic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate1);

        Intent intent=getIntent();

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
}
