package fsoft.karaoke;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    ImageView imgVN,imgUSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        addEvents();
        addControls();
    }

    public void ChangeLanguage(String language){
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        Intent intent = new Intent(LanguageActivity.this, KaraokeActivity.class);
        startActivity(intent);

    }

    private void addEvents() {
//        imgVN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChangeLanguage("vi");
//            }
//        });
//        imgUSA.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ChangeLanguage("en");
//            }
//        });
//       });
    }

    private void addControls() {
        imgVN = findViewById(R.id.imgVN);
        imgUSA = findViewById(R.id.imgUSA);

    }
}
