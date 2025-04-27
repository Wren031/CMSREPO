package com.example.communitymanangementsystem.ui.content.settings;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class QrCodeView extends AppCompatActivity {
    private NavbarListener navbarListener;
    private ImageView qrCodeIV;
    private TextView generateQrBtn;
    private Bitmap qrBitmap;

    private final Handler handler = new Handler(); // For delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_qr_code_view);

        qrCodeIV = findViewById(R.id.idIVQrcode);
        generateQrBtn = findViewById(R.id.QrCodeBtn);
        this.navbarListener = new NavbarListener(this);

        generateQrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "Hello Im Wren Montero Javier";

                generateQRCode(text);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        showSaveDialog();
                    }
                }, 500);
            }
        });
    }

    private void generateQRCode(String text) {
        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
        try {
            qrBitmap = barcodeEncoder.encodeBitmap(text, BarcodeFormat.QR_CODE, 500, 500);
            qrCodeIV.setImageBitmap(qrBitmap);
        } catch (WriterException e) {
            e.printStackTrace();
            Toast.makeText(QrCodeView.this, "Failed to generate QR Code.", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSaveDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("QR Code Generated")
                .setMessage("Do you want to save the QR code?")
                .setPositiveButton("Save", (dialog, which) -> {
                    saveQRCode();
                })
                .setNegativeButton("Don't Save", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    private void saveQRCode() {
        if (qrBitmap == null) {
            Toast.makeText(this, "No QR Code to save", Toast.LENGTH_SHORT).show();
            return;
        }

        String filename = "qr_code_" + System.currentTimeMillis() + ".png";
        File dir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "QRCodes");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(dir, filename);
        try (FileOutputStream out = new FileOutputStream(file)) {
            qrBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            Toast.makeText(this, "QR Code saved to: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to save QR Code", Toast.LENGTH_SHORT).show();
        }
    }
}
