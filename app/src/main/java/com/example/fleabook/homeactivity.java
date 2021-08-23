package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class homeactivity extends AppCompatActivity {
//양채윤이 사용자 인증 데이터 넘길 곳? 홈 메인 화면

    TextView getLD1, getLD2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getLD1 = findViewById(R.id.getLogData1);
        getLD2 = findViewById(R.id.getLogData2);

        Intent intent = getIntent();
        String strId = intent.getStringExtra("strId");
        String strPw = intent.getStringExtra("strPw");

        getLD1.setText(strId);
        getLD2.setText(strPw);

    }
}
