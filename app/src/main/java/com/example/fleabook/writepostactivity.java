package com.example.fleabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class writepostactivity extends AppCompatActivity {
    private FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_post);

        findViewById(R.id.BtnWfin).setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener =view -> {
        switch (view.getId()){
            case R.id.BtnWfin://작성완료
                storageUploader();
                myStartActivity(homeactivity.class);
                break;
        }
    };


    //작성
    private void storageUploader() {
        final String mTitle = ((EditText) findViewById(R.id.titleEdit)).getText().toString();
        final String mContents = ((EditText) findViewById(R.id.contentsEdit)).getText().toString();
        final String mPrice = ((EditText) findViewById(R.id.priceEdit)).getText().toString();

        if(mTitle.length() > 0 && mContents.length() > 0 && mPrice.length() > 0){//공백확인
            user=FirebaseAuth.getInstance().getCurrentUser();
            postInfo postInfo= new postInfo(user.getUid(),mTitle,mContents,mPrice);
            postUploader(postInfo);//postUploader 함수 실행
        }else {//공백일 시
            Toast.makeText(writepostactivity.this,"내용을 입력해주세요",Toast.LENGTH_SHORT).show();
        }
    }

    private void postUploader(postInfo postInfo){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("posts").add(postInfo).
                addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(writepostactivity.this,"작성완료",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(writepostactivity.this,"작성실패",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }



}
