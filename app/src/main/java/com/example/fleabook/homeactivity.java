package com.example.fleabook;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class homeactivity extends AppCompatActivity {

    TextView getLD1, getLD2;
    private ListView mPlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        init();
        getLD1 = findViewById(R.id.getLogData1);
        getLD2 =findViewById(R.id.getLogData2);
        findViewById(R.id.writeBtn).setOnClickListener(onClickListener);
        findViewById(R.id.logoutBtn).setOnClickListener(onClickListener);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user==null){
            myStartActivity(joinactivity.class);
        }else{
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference docRef =db.collection("users").document(user.getUid());
            docRef.get().addOnCompleteListener((task) -> {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null) {
                        //Toast.makeText(getApplicationContext(), "DocumentSnapshot data: " + document.getData(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            });


            db.collection("posts")
//                    .whereEqualTo("title",true)
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                @Override
                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                    if(task.isSuccessful()){
                        ArrayList<postInfo> arrayList = new ArrayList<>();
                        for(QueryDocumentSnapshot document : task.getResult()){
                            Toast.makeText(getApplicationContext(), "DocumentSnapshot data: " + document.getData(), Toast.LENGTH_SHORT).show();
                            arrayList.add(new postInfo(
                                    document.getData().get("writeUser").toString(),
                                    document.getData().get("title").toString(),
                                    document.getData().get("contents").toString(),
                                    document.getData().get("price").toString()
                            ));
                        }

                        RecyclerView recyclerView = findViewById(R.id.recyclerview);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setLayoutManager(new LinearLayoutManager(homeactivity.this));
                        RecyclerView.Adapter mAdapter = new postAdapter(homeactivity.this,arrayList);
                        recyclerView.setAdapter(mAdapter);
                    }else{
                        Toast.makeText(getApplicationContext(), "Error getting documents", Toast.LENGTH_SHORT).show();
                    }
                }
            });




        }

//
//        Intent intent = getIntent(); //로그인 정보 -> 홈화면
//        Bundle bundle = intent.getExtras();
//        String strEmail = bundle.getString("Email");
//        String strPw = bundle.getString("Pw");
//
//        getLD1.setText(strEmail);
//        getLD2.setText(strPw);


    }

    View.OnClickListener onClickListener =view -> {
      switch (view.getId()){
          case R.id.logoutBtn:
              FirebaseAuth.getInstance().signOut();
              myStartActivity(loginactivity.class);
              Toast.makeText(getApplicationContext(), "로그아웃 완료", Toast.LENGTH_SHORT).show();
              break;
          case R.id.writeBtn:
              myStartActivity(writepostactivity.class);
              break;
      }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case 1:
//                init();
//                break;
//        }
//    }

//    private void init() {
//        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        if (firebaseUser == null) {
//            myStartActivity(joinactivity.class);
//        } else {
//            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(firebaseUser.getUid());
//            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                @Override
//                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                    if (task.isSuccessful()) {
//                        DocumentSnapshot document = task.getResult();
//                        if (document != null) {
//                            if (document.exists()) {
////                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//                                Toast.makeText(getApplicationContext(), "DocumentSnapshot data: " + document.getData(), Toast.LENGTH_SHORT).show();
//                            } else {
////                                myStartActivity(MemberInitActivity.class);
//                                Toast.makeText(getApplicationContext(), "No such document", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                     }else {
//                        Log.d(TAG, "get failed with ", task.getException());
//                    }
//                }
//            });
//
//
//        }
//    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
