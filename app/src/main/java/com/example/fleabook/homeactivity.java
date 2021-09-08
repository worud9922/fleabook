package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class homeactivity extends AppCompatActivity {

    TextView getLD1, getLD2;
    private ListView mPlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getLD1 = findViewById(R.id.getLogData1);
        getLD2 =findViewById(R.id.getLogData2);


        Intent intent = getIntent(); //로그인 정보 -> 홈화면
        Bundle bundle = intent.getExtras();
        String strEmail = bundle.getString("Email");
        String strPw = bundle.getString("Pw");

        getLD1.setText(strEmail);
        getLD2.setText(strPw);

        mPlist=(ListView)findViewById(R.id.Plist);
        List<String> data = new ArrayList<>();


    }
}
