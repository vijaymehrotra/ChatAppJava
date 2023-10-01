package com.example.mywhatsapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywhatsapp.Models.MessageModel;
import com.example.mywhatsapp.R;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessageModel> messageModels;
    Context context;

    public ChatAdapter(ArrayList<MessageModel> messageModels, Context context) {
        this.messageModels = messageModels;
        this.context = context;
    }

    int SENDER_VIEW_TYPE = 1;
    int RECEVER_VIEW_TYPE = 1;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(SENDER_VIEW_TYPE == viewType){
            View view = LayoutInflater.from(context).inflate(R.layout.sample_sender , parent , false);
            return new SenderViewHolder(view);
        }
        else{
            View view = LayoutInflater.from(context).inflate(R.layout.sample_recever , parent , false);
            return new ReceverViewHolder(view);
        }


    }

    @Override
    public int getItemViewType(int position) {
        if(messageModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())){
            return SENDER_VIEW_TYPE;
        }
        else{
            return RECEVER_VIEW_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel messageModel = messageModels.get(position);

        if(holder.getClass() == SenderViewHolder.class){
            ((SenderViewHolder)holder).SenderrMsg.setText(messageModel.getMessage());
        }
        else{
            ((ReceverViewHolder)holder).recieverMsg.setText(messageModel.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public class ReceverViewHolder extends RecyclerView.ViewHolder {
        TextView recieverMsg,recievertime;
        public ReceverViewHolder(@NonNull View itemView) {
            super(itemView);
            recieverMsg = itemView.findViewById(R.id.recevertext);


        }
    }

    public class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView SenderrMsg,Sendertime;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            SenderrMsg = itemView.findViewById(R.id.senderText);
            Sendertime = itemView.findViewById(R.id.senderTime);
        }
    }
}
