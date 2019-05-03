package fsoft.karaoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText edtTK,edtMK;
    Button btnDN;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtTK.getText().toString();
                String password = edtMK.getText().toString();

                Boolean chkEmailPassword = db.emailpassword(email,password);
                if(chkEmailPassword==true){
                    Intent intent = new Intent(LoginActivity.this,InfoUserActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "ĐỊT CỤ SAI RỒI, NHẬP LẠI!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        edtTK = findViewById(R.id.edtTK);
        edtMK = findViewById(R.id.edtMK);
        btnDN = findViewById(R.id.btnDN);

    }
}
