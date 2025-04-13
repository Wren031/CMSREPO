package com.example.communitymanangementsystem.ui.content.medicine;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MedicineContent extends AppCompatActivity {

    private TextView submit, add, minus, qty, med;
    private int quantity = 0;
    private NavbarListener navbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medicine_content);

        navbarListener = new NavbarListener(this);


        this.submit = findViewById(R.id._submitMedReq);
        this.add = findViewById(R.id._addQty);
        this.minus = findViewById(R.id._minusQty);
        this.qty = findViewById(R.id._medQty);
        this.med = findViewById(R.id._medName);

        updateQuantityDisplay();

        add.setOnClickListener(v -> addQuantity());
        minus.setOnClickListener(v -> subtractQuantity());

        submit.setOnClickListener(v -> {
            if (quantity < 1) {
                new SweetAlertDialog(MedicineContent.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("PLEASE ADD QUANTITY")
                        .setContentText("An error has occurred, please try again.")
                        .show();
            } else {
                String name = med.getText().toString();
                String message = "You requested " + "x"+quantity + " " + name + "(s).";

                new SweetAlertDialog(MedicineContent.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("REQUEST SUBMITTED")
                        .setContentText(message)
                        .show();

            }
        });
    }

    private void addQuantity() {
        quantity++;
        updateQuantityDisplay();
    }

    private void subtractQuantity() {
        if (quantity > 0) {
            quantity--;
            updateQuantityDisplay();
        }
    }

    private void updateQuantityDisplay() {
        qty.setText(String.valueOf(quantity));
    }
}
