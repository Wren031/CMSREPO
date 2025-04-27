package com.example.communitymanangementsystem.ui.content.settings;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.example.communitymanangementsystem.ui.LoginView;

public class SettingsView extends AppCompatActivity {
    private NavbarListener navbarListener;
    private ImageView notification, password, deleteAccount, qrCode, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings_view);
        this.navbarListener = new NavbarListener(this);
        this.notification = findViewById(R.id._notificationBtn);
        this.password = findViewById(R.id._changePassword);
        this.deleteAccount = findViewById(R.id._deleteAccount);
        this.qrCode = findViewById(R.id._qrCode);
        this.logout = findViewById(R.id._logout);

        this.qrCode.setOnClickListener(v ->{
            Intent i = new Intent(SettingsView.this, QrCodeView.class);
            startActivity(i);
        });

        this.logout.setOnClickListener(v ->{
            showOnLogoutDialog();
        });

        this.deleteAccount.setOnClickListener(v ->{
            Intent i = new Intent(SettingsView.this, DeleteAccountView.class);
            startActivity(i);
        });

        this.notification.setOnClickListener(v ->{
            Intent i = new Intent(SettingsView.this, NotificationSettingsView.class);
            startActivity(i);
        });
        this.password.setOnClickListener(v ->{
            Intent i = new Intent(SettingsView.this, PasswordSettingsView.class);
            startActivity(i);
        });
    }

    private void showOnLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout ")
                .setMessage("Are you sure want to logout?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent i = new Intent(SettingsView.this, LoginView.class);
                    startActivity(i);
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }
}