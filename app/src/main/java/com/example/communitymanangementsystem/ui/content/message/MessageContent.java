package com.example.communitymanangementsystem.ui.content.message;

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
import com.example.communitymanangementsystem.components.buttonListerner.view_model.ResidentsController;
import com.example.communitymanangementsystem.model.ChatViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MessageContent extends AppCompatActivity {

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

        sendButton.setOnClickListener(v -> sentMessage());
    }

    public void loadMessage() {

        ResidentsController residentsComponents = new ResidentsController(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();

        if (residents != null && !residents.isEmpty()) {
            for (ResidentsViewModel resident : residents) {
                chatList.add(new ChatViewModel(
                        2,
                        resident,
                        resident,
                        "Jan 31, 2002",
                        "Hello there, how are you?"
                ));
                chatList.add(new ChatViewModel(
                        1,
                        resident,
                        resident,
                        "Jan 31, 2002",
                        "Im fine"
                ));
            }
        } else {
            System.out.println("No residents available.");
        }
        chatAdapter.notifyDataSetChanged();
    }

    public void sentMessage() {
        ResidentsController residentsComponents = new ResidentsController(new ArrayList<>());
        List<ResidentsViewModel> residents = residentsComponents.getResidents();

        String messageText = inputBox.getText().toString().trim();
        if (!messageText.isEmpty()) {
            ResidentsViewModel sender = residents.get(0);

            String currentTime = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());

            ChatViewModel newMessage = new ChatViewModel(
                    1,
                    sender,
                    sender,
                    currentTime,
                    messageText
            );

            chatList.add(newMessage);
            chatAdapter.notifyItemInserted(chatList.size() - 1);
            inputBox.setText("");
        }
    }

}
