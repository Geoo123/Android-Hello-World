package com.example.hellogaf.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hellogaf.R;

import com.example.hellogaf.Models.UserModels;

public class UsersViewHolder extends RecyclerView.ViewHolder {

    private TextView mFirstName;
    private TextView mLastName;

    public UsersViewHolder(@NonNull View container) {

        super(container);
        mFirstName = container.findViewById(R.id.user_first_name);
        mLastName = container.findViewById(R.id.user_last_name);
    }

    public void bind(UserModels user) {

        mFirstName.setText(user.getFirstName());
        mLastName.setText(user.getLastName());
    }
}
