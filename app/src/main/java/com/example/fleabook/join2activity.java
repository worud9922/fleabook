package com.example.fleabook;

        import androidx.appcompat.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class join2activity extends AppCompatActivity {

    private FirebaseAuth mAuth; //fb 인증처리
    private DatabaseReference mRef; //실시간 db
    private EditText mJId, mJPw;
    private Button mfinjoin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_2);

        mAuth = FirebaseAuth.getInstance();
        mRef = FirebaseDatabase.getInstance().getReference();

        mJId = findViewById(R.id.JoinIdtxt);
        mJPw = findViewById(R.id.JoinPwtxt);
        mfinjoin = findViewById(R.id.finjoinBtn);

        mfinjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //회원가이 처리 시작

            }
        });

    }
}