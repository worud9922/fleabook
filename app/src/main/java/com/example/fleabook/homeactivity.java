package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class homeactivity extends AppCompatActivity {
//양채윤이 사용자 인증 데이터 넘길 곳? 홈 메인 화면

    TextView getLD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getLD = findViewById(R.id.getLogData);


        Intent intent = getIntent(); //로그인 정보 -> 홈화면
        Bundle bundle = intent.getExtras();
        String strEmail = bundle.getString("Email");

        getLD.setText(strEmail);


    }
}
