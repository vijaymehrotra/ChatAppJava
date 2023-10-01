package com.example.mywhatsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywhatsapp.Models.Users;
import com.example.mywhatsapp.R;
import com.example.mywhatsapp.chatDetailActivity;
import com.google.firebase.auth.TwitterAuthCredential;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    ArrayList<Users> list;
    Context context;

    public UsersAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user ,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);
        Picasso.get().load(users.getProfilepic()).placeholder(R.drawable.avatar).into(holder.image);
        holder.usewName.setText(users.getUsername());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , chatDetailActivity.class);
                intent.putExtra("users" , users.getUserId());
                intent.putExtra("profilePic" , users.getProfilepic());
                intent.putExtra("userName" , users.getUsername());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView usewName , lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            usewName = itemView.findViewById(R.id.username);
            lastMessage = itemView.findViewById(R.id.lastMessage);
        }
    }
}
