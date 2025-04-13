package com.example.communitymanangementsystem.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.MessageViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.ChatListener;
import com.example.communitymanangementsystem.ui.content.message.MessageContent;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<MessageViewModel> data;
    private ChatListener listener;
    private Context context;

    public MessageAdapter(List<MessageViewModel> data, ChatListener listener, Context context){
        this.data = data;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout._layout_message_item, parent, false);
        return new MessageAdapter.MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        MessageViewModel model = data.get(position);
        holder.name.setText(model.getResidentID().getFullName());
        holder.quantity.setText(String.valueOf(model.getQuantity()));
        holder.time.setText(model.getTime());
        holder.message.setText(model.getMessage());
        holder.itemView.setOnClickListener( v -> {
            Intent intent = new Intent(context, MessageContent.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView quantity;
        TextView time;
        TextView message;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id._name);
            message = itemView.findViewById(R.id._messageTextID);
            time = itemView.findViewById(R.id._timeID);
            quantity = itemView.findViewById(R.id._quantityID);
            image = itemView.findViewById(R.id._residentImage);
        }
    }
}
