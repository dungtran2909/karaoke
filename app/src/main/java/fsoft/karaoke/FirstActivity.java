package fsoft.karaoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Thread timeS=new Thread(){
            public void run()
            {
                try
                {
                    sleep(5000); // thoi gian chuyen quan man hinh khac
                } catch (Exception e) {

                }
                finally
                {
                    Intent activitymoi=new Intent("fsoft.karaoke.MAINACTIVITY");
                    startActivity(activitymoi);
                }
            }
        };
        timeS.start();
    }
    // ket thuc man hinh dau tien, sau khi chuyen man hinh activity
    protected void onPause(){
        super.onPause();
        finish();
    }
}
