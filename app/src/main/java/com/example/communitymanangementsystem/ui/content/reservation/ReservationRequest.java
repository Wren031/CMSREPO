package com.example.communitymanangementsystem.ui.content.reservation;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.DatePicker.DatePickerViewModel;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class ReservationRequest extends AppCompatActivity {
    private NavbarListener navbarListener;
    private DatePickerViewModel viewModel;
    private EditText startDate, startTime, endTime;
    private TextView sumbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reservation_request);

        navbarListener = new NavbarListener(this);

        viewModel = new ViewModelProvider(this).get(DatePickerViewModel.class);

        startDate = findViewById(R.id.start_date);
        startTime = findViewById(R.id.start_time);
        endTime = findViewById(R.id.end_time);
        sumbit = findViewById(R.id.sumbitBtn);

        startDate.setOnClickListener(v -> viewModel.pickDate(ReservationRequest.this));

        startTime.setOnClickListener(v -> viewModel.pickStartTime(ReservationRequest.this));
        endTime.setOnClickListener(v -> viewModel.pickEndTime(ReservationRequest.this));

        sumbit.setOnClickListener(v -> {
            if (isFieldEmpty()) {
                new SweetAlertDialog(ReservationRequest.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("SOMETHING WENT WRONG")
                        .setContentText("An error has occurred, please try again.")
                        .show();
            }else {
                new SweetAlertDialog(ReservationRequest.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Success")
                        .setContentText("Your operation was successful!")
                        .setConfirmText("OK")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Intent i = new Intent(ReservationRequest.this, ReservationContent.class);
                                startActivity(i);
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .show();
            }
        });

        viewModel.getSelectedDate().observe(this, date -> startDate.setText(date));
        viewModel.getSelectedStartTime().observe(this, time -> startTime.setText(time));
        viewModel.getSelectedEndTime().observe(this, time -> endTime.setText(time));

    }

    public boolean isFieldEmpty() {
        return isEmpty(startDate) || isEmpty(startTime) || isEmpty(endTime);
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

}