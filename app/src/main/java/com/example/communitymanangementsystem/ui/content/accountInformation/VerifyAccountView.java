package com.example.communitymanangementsystem.ui.content.accountInformation;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class VerifyAccountView extends AppCompatActivity {
    private EditText name, middleName, lastName, email, number, birthday, gender,
            citizenShip, relegion, weigth, sector, house_blg, height,
            house_owner, house_material, sitio, since_year, family_head, shelter_type;
    private NavbarListener navbarListener;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_account_view);

        this.name = findViewById(R.id._firstName);
        this.middleName = findViewById(R.id._middleName);
        this.lastName = findViewById(R.id._lastName);
        this.email = findViewById(R.id._email);
        this.number = findViewById(R.id._phone);
        this.birthday = findViewById(R.id._birthday);
        this.gender = findViewById(R.id._gender);
        this.citizenShip = findViewById(R.id._citizenShip);
        this.relegion = findViewById(R.id._relegion);
        this.weigth = findViewById(R.id._weight);
        this.sector = findViewById(R.id._sector);
        this.house_blg = findViewById(R.id._houseBlg);
        this.height = findViewById(R.id._height);
        this.house_owner = findViewById(R.id._houseOwner);
        this.house_material = findViewById(R.id._houseMaterial);
        this.since_year = findViewById(R.id._sinceYear);
        this.family_head = findViewById(R.id._familyHead);
        this.shelter_type = findViewById(R.id._shelter_type);

        navbarListener = new NavbarListener(this);

        Editimage();
    }


    private boolean isAnyFieldEmpty() {
        return isEmpty(name) || isEmpty(lastName) || isEmpty(middleName) || isEmpty(email) ||
                isEmpty(number) || isEmpty(birthday) || isEmpty(gender) || isEmpty(citizenShip) ||
                isEmpty(relegion) || isEmpty(weigth) || isEmpty(sector) || isEmpty(house_blg) ||
                isEmpty(height) || isEmpty(house_owner) || isEmpty(house_material) || isEmpty(since_year) ||
                isEmpty(family_head) || isEmpty(shelter_type);
    }


    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    private ImageView putprofilehere1;
    private String imageBase64 = "";
    private String imageFilename = "";



    private void Editimage() {
        TextView editbtnprofile = findViewById(R.id.editbtn);
        putprofilehere1 = findViewById(R.id.putprofilehere1);

        // Set up the click listener for the edit button to select an image
        editbtnprofile.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();

            // Get the filename from URI
            imageFilename = getFileNameFromUri(selectedImageUri);

            System.out.println(imageFilename);

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);

                // Convert to rounded bitmap
                float radius = TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        300,
                        getResources().getDisplayMetrics()
                );

                Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(output);

                Paint paint = new Paint();
                RectF rectF = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());

                paint.setAntiAlias(true);
                canvas.drawRoundRect(rectF, radius, radius, paint);

                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0, 0, paint);

                // Set image to ImageView
                putprofilehere1.setImageBitmap(output);

                // Convert to Base64
                imageBase64 = bitmapToBase64(bitmap);

                // Log the filename and base64 (optional)
                Log.d("ImageInfo", "Filename: " + imageFilename);
                Log.d("ImageInfo", "Base64: " + imageBase64);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Helper method: get file name from URI
    private String getFileNameFromUri(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

    // Helper method: convert bitmap to Base64 string
    private String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.NO_WRAP);
    }

}
