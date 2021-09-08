package com.example.fleabook;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Spinner extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    private android.widget.Spinner s1, s2, s3;
    private Button ch1, ch2, ch3;
    private ArrayList<String> arrayList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        s1=findViewById(R.id.spinner1);
        s2=findViewById(R.id.spinner2);
        s3=findViewById(R.id.spinner3);
        ch1=findViewById(R.id.ch1); //선택 btn
        ch2=findViewById(R.id.ch2);
        ch3=findViewById(R.id.ch3);

        showDataSpinner();


    }

    private void showDataSpinner() {
        mRef.child("areas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayList.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren());
                arrayList.add(snapshot.child("area").getValue(String.class));

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(Spinner.this,R.layout.style_spinner,arrayList);
                s1.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}


