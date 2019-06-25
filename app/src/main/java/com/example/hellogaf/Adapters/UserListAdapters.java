package com.example.hellogaf.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hellogaf.R;

import java.util.List;

import com.example.hellogaf.Models.UserModels;
import com.example.hellogaf.viewholders.UsersViewHolder;

public class UserListAdapters extends RecyclerView.Adapter {

    private List<UserModels> userList;

    public UserListAdapters (List<UserModels> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_view_holder, parent, false);
        UsersViewHolder item = new UsersViewHolder(v);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((UsersViewHolder) viewHolder).bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
