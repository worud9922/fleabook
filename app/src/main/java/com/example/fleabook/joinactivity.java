package com.example.fleabook;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

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
import com.google.firebase.firestore.FirebaseFirestore;


public class joinactivity extends AppCompatActivity {

    private FirebaseAuth mAuth;//
//    private DatabaseReference mRef;
    private Button mBtnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();//
//        mRef = FirebaseDatabase.getInstance().getReference("Fleabook");
        mBtnJoin=findViewById(R.id.finjoinBtn);

        mBtnJoin.setOnClickListener(new View.OnClickListener() {//회원가입 완료
            @Override
            public void onClick(View view) {
                storageUploader();
                return;
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // 현재 사용자 로그인 여부 확인
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
        }
    }

    //회원가입
    private void storageUploader() {
        final String mEmail = ((EditText) findViewById(R.id.JoinEmailtxt)).getText().toString();
        final String mPw = ((EditText) findViewById(R.id.JoinPwtxt)).getText().toString();
        final String mPwCheck = ((EditText) findViewById(R.id.JoinPwChecktxt)).getText().toString();
        final String mPhone = ((EditText) findViewById(R.id.JoinPhonetxt)).getText().toString();
        final String mBirth = ((EditText) findViewById(R.id.JoinBirthtxt)).getText().toString();
        final String mNickname = ((EditText) findViewById(R.id.JoinNicktxt)).getText().toString();

        if(mEmail.length() > 0 && mPw.length() > 0 && mPwCheck.length() > 0){//공백확인
            if(mPw.equals(mPwCheck)) {//비밀번호 일치

        if (mEmail.length() > 0 && mPhone.length() > 9 && mBirth.length() > 5 && mNickname.length() > 0) {
//            loaderLayout.setVisibility(View.VISIBLE);
            mAuth.createUserWithEmailAndPassword(mEmail, mPw)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            FirebaseFirestore db = FirebaseFirestore.getInstance();

                            UserAccount account = new UserAccount(mEmail, mPw, mPhone, mBirth, mNickname);
                            db.collection("users").document(user.getUid()).set(account)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            FirebaseUser user = mAuth.getCurrentUser();
                                            Intent intent1 = new Intent(joinactivity.this, loginactivity.class);
                                            startActivity(intent1);//로그인 화면으로 이동
                                            Toast.makeText(joinactivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(joinactivity.this, "fail", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }

                    });
        }
        else {
            Toast.makeText(joinactivity.this,"회원정보를 입력해주세요.",Toast.LENGTH_SHORT).show();
        }
            }
            else{//비밀번호 오류시
                Toast.makeText(joinactivity.this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                return;
            }
        }else {//이메일, 비밀번호, 비밀번호 재입력이 공백일 시
            Toast.makeText(joinactivity.this,"이메일 또는 비밀번호를 입력해 주세요.",Toast.LENGTH_SHORT).show();
        }
    }
}
