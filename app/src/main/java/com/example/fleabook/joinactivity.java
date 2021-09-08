package com.example.fleabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fleabook.data.SpinnerData;
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

    private EditText mEmail, mPw, mPwCheck, mPhone, mBirth, mNickname;
    private Button mBtnJoin;

//    private Spinner s1, s2, s3;
//    private Button ch1, ch2, ch3;
//    private ArrayList<String> arrayList = new ArrayList<>();

    //라디오
    private String str_result;
    private RadioGroup mGender;
    private RadioButton mMale, mFemale;

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

        //라디오
        mGender=findViewById(R.id.gender);
        mMale=findViewById(R.id.Male);
        mFemale=findViewById(R.id.Female);

//        //스피너
//        s1=findViewById(R.id.spinner1);
//        s2=findViewById(R.id.spinner2);
//        s3=findViewById(R.id.spinner3);
//        ch1=findViewById(R.id.ch1); //선택 btn
//        ch2=findViewById(R.id.ch2);
//        ch3=findViewById(R.id.ch3);
//
//        showDataSpinner();


        //라디오
        mGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if(i==R.id.Male){
                    str_result=mMale.getText().toString();
                    Toast.makeText(joinactivity.this, "남성", Toast.LENGTH_SHORT).show();
                } else if (i==R.id.Female){
                    str_result=mFemale.getText().toString();
                    Toast.makeText(joinactivity.this, "여성", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mBtnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = mEmail.getText().toString();
                String strPw = mPw.getText().toString();
                String strPwChck = mPwCheck.getText().toString();
                String strPhone = mPhone.getText().toString();
                String strBirth = mBirth.getText().toString();
                String strNickname = mNickname.getText().toString();


                //라디오 -> 스트링이 맞냐?
                String strMale = mMale.getText().toString();
                String strFemale = mFemale.getText().toString();



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

                                SpinnerData data = new SpinnerData();
                                data.setIdToken(user.getUid());
//                                data.setS1();


//                                account.setMale(strMale);
//                                account.setFemale(strFemale);

//                                if(str_result !=null){
//                                    Toast.makeText(joinactivity.this, str_result, Toast.LENGTH_SHORT).show();
//                                } else {
//                                    Toast.makeText(joinactivity.this, "성ㅕㄹ을 선택해주세요.", Toast.LENGTH_SHORT).show();
//                                }

//                                String gender= value.getString("Gender");
//                                if (gender.equalsIgnoreCase("Male")){
//                                    mMale.setChecked(true);
//                                }else if (gender.equalsIgnoreCase("Female")){
//                                    mFemale.setChecked(true);
//                                }

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
