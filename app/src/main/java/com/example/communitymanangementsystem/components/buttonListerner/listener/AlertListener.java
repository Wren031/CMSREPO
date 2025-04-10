package com.example.communitymanangementsystem.components.buttonListerner.listener;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class AlertListener {

    public static void showSimpleAlert(Context context, String title, String message, String positiveButtonText) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, null);


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void showConfirmationAlert(Context context, String title, String message, String positiveButtonText, String negativeButtonText, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, positiveAction)
                .setNegativeButton(negativeButtonText, negativeAction);


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
