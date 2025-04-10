package com.example.communitymanangementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.controller.AuthenticationController;
import com.example.communitymanangementsystem.model.AuthenticationViewModel;
import com.example.communitymanangementsystem.model.ResidentsViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.AlertListener;

import java.util.ArrayList;
import java.util.List;

public class LoginView extends AppCompatActivity {

    private EditText username, password;
    AuthenticationController adapter;
    private TextView loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_view);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);


        List<AuthenticationViewModel> users = new ArrayList<>();
        users.add(new AuthenticationViewModel(1, new ResidentsViewModel(
                1, "John", "Michael", "Doe", "Male", "1990-05-15",
                "john.doe@example.com", "Filipino", "Christian", "21", "09171234567",
                "Bachelor's Degree", "Single", "75kg", "Urban", "House No. 12",
                "5'10\"", "2015", "Sitio 1", "Yes", "Purok 3", "Concrete",
                "Yes", "Permanent", "Active", "2025-04-04"
        ), "admin", "1234"));

        adapter = new AuthenticationController(users);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = username.getText().toString().trim();
                String inputPassword = password.getText().toString().trim();

                boolean success = adapter.onLogin(inputUsername, inputPassword);

                if (success) {
                    Intent i = new Intent(LoginView.this, DashboardView.class);
                    startActivity(i);
                } else {
                    AlertListener.showSimpleAlert(LoginView.this, "Error", "Email or Password is in correct!", "OK");
                }
            }
        });
    }
}