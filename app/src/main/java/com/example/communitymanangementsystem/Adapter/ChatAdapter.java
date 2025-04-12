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

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatViewModel> modelList;

    private static final int VIEW_TYPE_RIGHT = 1;
    private static final int VIEW_TYPE_LEFT = 2;

    public ChatAdapter(List<ChatViewModel> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int getItemViewType(int position) {
        ChatViewModel chat = modelList.get(position);
        if (chat.getChatID() == 1) {
            return VIEW_TYPE_RIGHT;
        } else {
            return VIEW_TYPE_LEFT;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_RIGHT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_right, parent, false);
            return new RightViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_left, parent, false);
            return new LeftViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatViewModel chat = modelList.get(position);
        if (holder instanceof RightViewHolder) {
            ((RightViewHolder) holder).bind(chat);
        } else if (holder instanceof LeftViewHolder) {
            ((LeftViewHolder) holder).bind(chat);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class RightViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage, time;


        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessage = itemView.findViewById(R.id.text_message_right);
            time = itemView.findViewById(R.id._dateTime);
        }

        public void bind(ChatViewModel chat) {
            textMessage.setText(chat.getMessageSent());
            time.setText(chat.getDateTime());
        }
    }

    public static class LeftViewHolder extends RecyclerView.ViewHolder {
        TextView textMessage, time;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            textMessage = itemView.findViewById(R.id.text_message_left);
            time = itemView.findViewById(R.id._dateTime);
        }

        public void bind(ChatViewModel chat) {
            textMessage.setText(chat.getMessageSent());
            time.setText(chat.getDateTime());
        }
    }
}
