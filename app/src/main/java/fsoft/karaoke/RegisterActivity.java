package fsoft.karaoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edtNhapTK, edtNhapMK, edtNhapLaiMK;
    Button btnDK, btnDN;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= edtNhapTK.getText().toString();
                String s2 = edtNhapMK.getText().toString();
                String s3 = edtNhapLaiMK.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_LONG).show();
                }
                else {
                    if(s2.equals(s3)){
                        Boolean chkemail = db.chkemail(s1);
                        if(chkemail==true){
                            Boolean insert = db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_LONG).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Pass do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        edtNhapTK = findViewById(R.id.edtNhapTK);
        edtNhapMK = findViewById(R.id.edtNhapMK);
        edtNhapLaiMK = findViewById(R.id.edtNhapLaiMK);
        btnDK = findViewById(R.id.btnDK);
        btnDN = findViewById(R.id.btnDN);

    }
}

