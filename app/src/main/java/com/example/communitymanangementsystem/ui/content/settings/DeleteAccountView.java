package com.example.communitymanangementsystem.ui.content.settings;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DeleteAccountView extends AppCompatActivity {
    private NavbarListener navbarListener;
    private EditText delete;
    private TextView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_account_view);
        this.delete = findViewById(R.id._deleteAccountTxt);
        this.btn = findViewById(R.id._deleteAccountBtn);
        this.navbarListener = new NavbarListener(this);


        btn.setOnClickListener(v -> {
            DeleteAccount();
        });
    }

    public void DeleteAccount(){
        String input = delete.getText().toString().trim();

        if (input.equalsIgnoreCase("Confirm")) {
            SweetAlertDialog successDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE);
            successDialog.setTitleText("Success")
                    .setContentText("Delete Account successfully.")
                    .setConfirmText("OK")
                    .setConfirmClickListener(sDialog -> {
                        sDialog.dismissWithAnimation();
                        delete.setHint("Enter \"Confirm\" to delete Account");
                    })
                    .show();
        } else {
            SweetAlertDialog errorDialog = new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE);
            errorDialog.setTitleText("Error")
                    .setContentText("Wrong input. Please type 'Confirm'.")
                    .setConfirmText("OK")
                    .setConfirmClickListener(sDialog -> {
                        sDialog.dismissWithAnimation();
                        delete.setHint("Enter \"Confirm\" to delete Account");
                    })
                    .show();
        }
    }
}