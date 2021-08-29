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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class joinactivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mRef;

    private EditText mEmail;
    private EditText mPw;
    private EditText mPwCheck;
    private EditText mPhone;
    private EditText mBirth;
    private EditText mNickname;
    private Button mBtnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference("Fleabook");

        mEmail = findViewById(R.id.JoinEmailtxt);
        mPw= findViewById(R.id.JoinPwtxt);
        mPwCheck = findViewById(R.id.JoinPwChecktxt);
        mPhone = findViewById(R.id.JoinPhonetxt);
        mBirth = findViewById(R.id.JoinBirthtxt);
        mNickname = findViewById(R.id.JoinNicktxt);
        mBtnJoin=findViewById(R.id.finjoinBtn);

        mBtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = mEmail.getText().toString();
                String strPw = mPw.getText().toString();
                String strPwChck = mPwCheck.getText().toString();
                String strPhone = mPhone.getText().toString();
                String strBirth = mBirth.getText().toString();
                String strNickname = mNickname.getText().toString();

                Intent intent1 = new Intent(joinactivity.this, loginactivity.class);

                if(strPw.equals(strPwChck)) {

                    mAuth.createUserWithEmailAndPassword(strEmail, strPw).addOnCompleteListener(joinactivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                UserAccount account = new UserAccount();
                                account.setIdToken(user.getUid());
                                account.setEmail(user.getEmail());
                                account.setPw(strPw);
                                account.setPwCheck(strPwChck);
                                account.setPhoneNum(strPhone);
                                account.setBirth(strBirth);
                                account.setNickname(strNickname);

                                mRef.child("UserAccount").child(user.getUid()).setValue(account);
//                            Toast.makeText(joinactivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                                Toast.makeText(getApplicationContext(), "회원가입 성공!", Toast.LENGTH_SHORT).show();

                                startActivity(intent1);//로그인 화면으로 이동
                                finish();

                            } else {
                                Toast.makeText(joinactivity.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else{//비밀번호 오류시
                    Toast.makeText(joinactivity.this,"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

    }
}
