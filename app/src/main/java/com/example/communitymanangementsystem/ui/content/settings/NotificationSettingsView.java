package com.example.communitymanangementsystem.ui.content.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

public class NotificationSettingsView extends AppCompatActivity {
    private NavbarListener navbarListener;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch darkMode, generalNotification, sound, dontDisturb, vibrate, lockScreen, reminders;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeHelper.applyTheme(this);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification_view);

        this.navbarListener = new NavbarListener(this);

        preferences = getSharedPreferences("settings_pref", MODE_PRIVATE);
        editor = preferences.edit();

        darkMode = findViewById(R.id.switchDarkMode);
        generalNotification = findViewById(R.id.switchGeneralNotification);
        sound = findViewById(R.id.switchSound);
        dontDisturb = findViewById(R.id.switchDoNotDisturb);
        vibrate = findViewById(R.id.switchVibrate);
        lockScreen = findViewById(R.id.switchLockScreen);
        reminders = findViewById(R.id.switchReminders);

        darkMode.setChecked(preferences.getBoolean("dark_mode", false));
        generalNotification.setChecked(preferences.getBoolean("general_notification", true));
        sound.setChecked(preferences.getBoolean("sound", true));
        dontDisturb.setChecked(preferences.getBoolean("dont_disturb", false));
        vibrate.setChecked(preferences.getBoolean("vibrate", true));
        lockScreen.setChecked(preferences.getBoolean("lock_screen", true));
        reminders.setChecked(preferences.getBoolean("reminders", true));

        darkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ThemeHelper.setDarkMode(this, isChecked);
            editor.putBoolean("dark_mode", isChecked).apply();
        });

        generalNotification.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("general_notification", isChecked).apply();
        });

        sound.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("sound", isChecked).apply();
        });

        dontDisturb.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("dont_disturb", isChecked).apply();
        });

        vibrate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("vibrate", isChecked).apply();
        });

        lockScreen.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("lock_screen", isChecked).apply();
        });

        reminders.setOnCheckedChangeListener((buttonView, isChecked) -> {
            editor.putBoolean("reminders", isChecked).apply();
        });
    }
}
