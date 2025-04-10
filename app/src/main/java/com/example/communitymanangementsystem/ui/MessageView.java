package com.example.communitymanangementsystem.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.communitymanangementsystem.Adapter.MessageAdapter;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.model.MessageViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.ButtonListener.ChatListener;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

import java.util.ArrayList;
import java.util.List;

public class MessageView extends AppCompatActivity implements ChatListener {

    private RecyclerView view;
    private List<MessageViewModel> model;
    private MessageAdapter adapter;

    private NavbarListener navbarListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message_view);

        model = new ArrayList<>();

        adapter = new MessageAdapter(model,(ChatListener) this);

        view = findViewById(R.id._messageItem);

        navbarListener = new NavbarListener(this);

        ResidentsViewModel resident = new ResidentsViewModel(
                1,
                "John",
                "Michael",
                "Doe", //
                "Male",
                "1990-05-15",
                "john.doe@example.com",
                "Filipino",
                "Christian","21",
                "09171234567",
                "Bachelor's Degree",
                "Single",
                "75kg",
                "Urban",
                "House No. 12",
                "5'10\"",
                "2015",
                "Sitio 1",
                "Yes",
                "Purok 3",
                "Concrete",
                "Yes",
                "Permanent",
                "Active",
                "2025-04-04"
        );

        ResidentsViewModel resident2 = new ResidentsViewModel(
                1,
                "Wren",
                "Montero",
                "Javier", //
                "Male",
                "1990-05-15",
                "john.doe@example.com",
                "Filipino",
                "Christian","21",
                "09171234567",
                "Bachelor's Degree",
                "Single",
                "75kg",
                "Urban",
                "House No. 12",
                "5'10\"",
                "2015",
                "Sitio 1",
                "Yes",
                "Purok 3",
                "Concrete",
                "Yes",
                "Permanent",
                "Active",
                "2025-04-04"
        );
        model.add(new MessageViewModel(1, resident, "sa", "12:00 PM", "message1", 5));
        model.add(new MessageViewModel(2, resident2, "sa", "01:00 PM", "message2", 3));
        view.setHasFixedSize(true);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onChatListener(MessageViewModel message) {
        System.out.println("you click the messege: "+message.getMessage());
    }
}