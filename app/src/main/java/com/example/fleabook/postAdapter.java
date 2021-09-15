package com.example.fleabook;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class postAdapter extends RecyclerView.Adapter<postAdapter.PostViewHolder> {

    private ArrayList<postInfo> mDataset;
    private Activity activity;

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public PostViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }

    public postAdapter(Activity activity, ArrayList<postInfo> myDataset) {
        mDataset = myDataset;
        this.activity = activity;
    }



    @NonNull
    @Override
    public postAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        final PostViewHolder postViewHolder = new PostViewHolder(cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //플로팅메뉴 삭제, 수정
            }
        });

        return postViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView post = cardView.findViewById(R.id.post);
        post.setText(mDataset.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


//    private void myStartActivity(Class c, postInfo postInfo) {
//        Intent intent = new Intent(activity, c);
//        activity.startActivity(intent);
//    }


}
