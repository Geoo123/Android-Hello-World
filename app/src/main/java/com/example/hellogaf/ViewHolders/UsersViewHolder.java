package com.example.hellogaf.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hellogaf.R;

import com.example.hellogaf.Models.UserModels;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    private TextView mFirstName;
    private TextView mGrade;
    private TextView mReview;

    public UsersViewHolder(@NonNull View container) {

        super(container);
        mFirstName = container.findViewById(R.id.user_first_name);
        mGrade = container.findViewById(R.id.user_grade);
        mReview = container.findViewById(R.id.user_review);
    }

    public void bind(UserModels user) {

        mFirstName.setText(user.getFirstName());
        mGrade.setText(user.getGrade());
        mReview.setText(user.getReview());
    }
}
