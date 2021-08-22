package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    Button loginBtn, joinBtn;
    EditText InputIdtxt, InputPwtxt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();

        loginBtn=findViewById(R.id.loginBtn);
        joinBtn=findViewById(R.id.joinBtn);
        InputIdtxt=findViewById(R.id.InputIdtxt);
        InputPwtxt=findViewById(R.id.InputPwtxt);



        InputIdtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        InputPwtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginactivity.this, homeactivity.class);

                Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_SHORT).show();
            }

        });

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginactivity.this, joinactivity.class);

            }
        });


    }
}