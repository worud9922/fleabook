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
    String strId, strPw;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();


        mloginBtn=findViewById(R.id.loginBtn);
        mjoinBtn=findViewById(R.id.joinBtn);

        mLIdtxt=findViewById(R.id.LoginIdtxt);
        mLPwtxt=findViewById(R.id.LoginPwtxt);



        mLIdtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mLPwtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strId = mLIdtxt.getText().toString();
                strPw = mLPwtxt.getText().toString();

                Intent intent = new Intent(loginactivity.this, homeactivity.class);
                startActivity(intent);
                //finish();
                intent.putExtra("로그인id(strId)", strId);
                intent.putExtra("로그인pw(strPw)", strPw);

                Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_SHORT).show();
            }

        });

        mjoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginactivity.this, joinactivity.class);
                startActivity(intent);
                //finish();

            }
        });


    }
}