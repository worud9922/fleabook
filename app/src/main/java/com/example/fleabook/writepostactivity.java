package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class writepostactivity extends AppCompatActivity {

    private Button mBtnWfin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        mBtnWfin=findViewById(R.id.BtnWfin);

        mBtnWfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //게시글 작성 완료 -> 게시글 목록 창(커뮤니티) 이동
                Intent intent = new Intent(writepostactivity.this, homeactivity.class);
                startActivity(intent);
            }
        });

    }
}
