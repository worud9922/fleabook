package com.example.fleabook;

import static android.text.TextUtils.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class loginactivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    private EditText mEmail;
    private EditText mPw;
    private Button mloginBtn, mjoinBtn;

//    String strId;
//    String strPw;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference("Fleabook");

        mloginBtn=findViewById(R.id.loginBtn); //로그인 버튼
        mjoinBtn=findViewById(R.id.joinBtn); //회원가입 버튼
        mEmail=findViewById(R.id.LoginIdtxt);
        mPw=findViewById(R.id.LoginPwtxt);

        mloginBtn.setOnClickListener(new View.OnClickListener() { //로그인
            @Override
            public void onClick(View v) {
                String strEmail = mEmail.getText().toString();
                String strPw = mPw.getText().toString();

                //공란 검사
                if (!validateForm()) {
                    return;
                }

                mAuth.signInWithEmailAndPassword(strEmail,strPw).addOnCompleteListener(loginactivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //로그인 성공
                            Intent intent = new Intent(loginactivity.this, homeactivity.class);
                            intent.putExtra("Email", strEmail);
                            intent.putExtra("Pw", strPw);
                            startActivity(intent);//홈 액티비티 이동
                            finish();//로그인 액티비티 종료
                            Toast.makeText(getApplicationContext(), "안녕하세요!", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "아이디 혹은 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
            //폼 빈칸 체크
            private boolean validateForm() {
                boolean valid = true;

                String strEmail = mEmail.getText().toString();
                if (isEmpty(strEmail)) { //아이디 editText가 공란이면
                    mEmail.setError("아이디를 입력해주세요.");
                    valid = false;
                } else {
                    mEmail.setError(null);
                }

                String strPw = mPw.getText().toString();
                if (isEmpty(strPw)) { //비밀번호 editText가 공란이면
                    mPw.setError("비밀번호를 입력해주세요.");
                    valid = false;
                } else {
                    mPw.setError(null);
                }
                return valid;
            }
        });




        mjoinBtn.setOnClickListener(new View.OnClickListener() { //회원가입 이동
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(loginactivity.this, joinactivity.class);
                startActivity(intent1);


            }
        });


    }
}