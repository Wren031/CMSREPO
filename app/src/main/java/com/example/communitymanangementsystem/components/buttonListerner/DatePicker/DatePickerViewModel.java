package com.example.communitymanangementsystem.components.buttonListerner.DatePicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;

public class DatePickerViewModel extends ViewModel {

    private final MutableLiveData<String> selectedDate = new MutableLiveData<>();
    private final MutableLiveData<String> selectedStartTime = new MutableLiveData<>();
    private final MutableLiveData<String> selectedEndTime = new MutableLiveData<>();

    // Date picker
    public void pickDate(Context context) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String date = String.format("%02d/%02d/%04d", monthOfYear + 1, dayOfMonth, year1);
                    selectedDate.setValue(date);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    public void pickStartTime(Context context) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                (view, hourOfDay, minute1) -> {
                    String time = String.format("%02d:%02d", hourOfDay, minute1);
                    selectedStartTime.setValue(time);
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }

    public void pickEndTime(Context context) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                context,
                (view, hourOfDay, minute1) -> {
                    String time = String.format("%02d:%02d", hourOfDay, minute1);
                    selectedEndTime.setValue(time);
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }

    public LiveData<String> getSelectedDate() {
        return selectedDate;
    }

    public LiveData<String> getSelectedStartTime() {
        return selectedStartTime;
    }

    public LiveData<String> getSelectedEndTime() {
        return selectedEndTime;
    }
}
