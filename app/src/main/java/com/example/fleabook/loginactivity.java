package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    Button mloginBtn, mjoinBtn;
    EditText mLIdtxt, mLPwtxt;
//    String strId;
//    String strPw;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mloginBtn=findViewById(R.id.loginBtn);
        mjoinBtn=findViewById(R.id.joinBtn);
        mLIdtxt=findViewById(R.id.LoginIdtxt);
        mLPwtxt=findViewById(R.id.LoginPwtxt);

        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strId = mLIdtxt.getText().toString();
                String strPw = mLPwtxt.getText().toString();

                Intent intent = new Intent(loginactivity.this, homeactivity.class);
                //finish();

                intent.putExtra("strId", strId);
                intent.putExtra("strPw", strPw);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_SHORT).show();
            }
        });

        mjoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(loginactivity.this, joinactivity.class);
                startActivity(intent1);
                //finish();

            }
        });


    }
}