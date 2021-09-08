package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sellactivity extends AppCompatActivity {

    private Button mBtnmodify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        mBtnmodify=findViewById(R.id.Btnmodify);

        mBtnmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sellactivity.this, fixmypostactivity.class);
                startActivity(intent);
            }
        });

    }
}