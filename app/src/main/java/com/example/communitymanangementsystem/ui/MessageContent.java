package com.example.communitymanangementsystem.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.ChatAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ResidentsComponents;
import com.example.communitymanangementsystem.model.ChatViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageContent extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatViewModel> chatList;
    private EditText inputBox;
    private ImageView sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message_content);

        ImageView btn = findViewById(R.id._returnMessage);
        recyclerView = findViewById(R.id._chatRecyclerView);

        inputBox = findViewById(R.id._inputBox);
        sendButton = findViewById(R.id._sentMessageID);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(MessageContent.this, MessageView.class);
            startActivity(i);
        });

        chatList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
        loadMessage();

        // Setup send button listener
//        sendButton.setOnClickListener(v -> sentMessage());
    }

    public void loadMessage() {

        ResidentsComponents residentsComponents = new ResidentsComponents(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();
        if (residents != null && !residents.isEmpty()) {
            for (ResidentsViewModel resident : residents) {
                chatList.add(new ChatViewModel(
                        1,
                        resident,
                        resident,
                        "Jan 31, 2002",
                        "Im fine"
                ));
                chatList.add(new ChatViewModel(
                        1,
                        resident,
                        resident,
                        "Jan 31, 2002",
                        "Hello there, how are you?"
                ));
            }
        } else {
            System.out.println("No residents available.");
        }
        chatAdapter.notifyDataSetChanged();
    }

//    public void sentMessage() {
//        String messageText = inputBox.getText().toString().trim();
//        if (!messageText.isEmpty()) {
//            // Create and add new message to the chat list
//            ChatViewModel newMessage = new ChatViewModel(
//                    1,  // You can replace with actual sender's data
//                    new ResidentsViewModel("Sender"),  // Replace with actual sender data
//                    new ResidentsViewModel("Receiver"),  // Replace with actual receiver data
//                    "Now",  // Current timestamp
//                    messageText
//            );
//            chatList.add(newMessage);
//            chatAdapter.notifyItemInserted(chatList.size() - 1);
//            inputBox.setText("");  // Clear the input box after sending the message
//        }
//    }
}
