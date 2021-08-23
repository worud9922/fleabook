package com.example.fleabook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class joinactivity extends AppCompatActivity {

    Button nxtjoinBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        nxtjoinBtn = findViewById(R.id.nextjoinBtn);


        nxtjoinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(joinactivity.this, join2activity.class);
                startActivity(intent);
            }
        });

    }
}
