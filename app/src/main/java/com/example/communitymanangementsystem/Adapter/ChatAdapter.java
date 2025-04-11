package com.example.communitymanangementsystem.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.ChatViewModel;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<ChatViewModel> modelList;

    public ChatAdapter(List<ChatViewModel> modelList) {
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout._layout_message_content_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewHolder holder, int position) {
        ChatViewModel chat = modelList.get(position);
//        holder.message.setText(chat.getMessageSent());
        holder.sentBy.setText(chat.getSentBy().getFullName());
        holder.sentTo.setText(chat.getSentTo().getFullName());
    }

    @Override
    public int getItemCount() {
        return (modelList != null) ? modelList.size() : 0;
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView sentBy;
        TextView sentTo;
        TextView message;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            sentBy = itemView.findViewById(R.id._sentByID);
            sentTo = itemView.findViewById(R.id._sentToID);
            message = itemView.findViewById(R.id._inputBox);
        }
    }
}
