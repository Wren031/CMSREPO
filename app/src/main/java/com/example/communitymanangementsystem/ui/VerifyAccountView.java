package com.example.communitymanangementsystem.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.communitymanangementsystem.R;
import com.example.communitymanangementsystem.components.buttonListerner.listener.AlertListener;
import com.example.communitymanangementsystem.components.buttonListerner.listener.NavbarListener;

public class VerifyAccountView extends AppCompatActivity {

    private TextView sumbit;

    private EditText FirstName;
    private EditText LastName;
    private EditText MiddleName;
    private EditText Email;
    private EditText Phone;
    private EditText Birthday;
    private EditText Gender;
    private EditText Citizinship;
    private EditText Relegion;
    private EditText Weight;
    private EditText Houseblg;
    private EditText Height;
    private EditText HouseOwner;
    private EditText HouseMaterial;
    private EditText Sitio;
    private EditText SinceYear;
    private EditText FamilyHead;
    private EditText ShelterType;

    private NavbarListener navbarListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verify_account_view);
        navbarListener = new NavbarListener(this);

        FirstName = findViewById(R.id.first_name);
        LastName = findViewById(R.id.last_name);
        MiddleName = findViewById(R.id.middle_name);
        Email = findViewById(R.id.email_name);
        Phone = findViewById(R.id.phone_number);
        Birthday = findViewById(R.id.birthday);
        Gender = findViewById(R.id.gender);
        Citizinship = findViewById(R.id.citizenship);
        Relegion = findViewById(R.id.relegion);
        Weight = findViewById(R.id.weight);
        Houseblg = findViewById(R.id.house_blg);
        Height = findViewById(R.id.height);
        HouseOwner = findViewById(R.id.house_owner);
        HouseMaterial = findViewById(R.id.house_material);
        Sitio = findViewById(R.id.setio);
        SinceYear = findViewById(R.id.since_year);
        FamilyHead = findViewById(R.id.family_head);
        ShelterType = findViewById(R.id.shelter_type);

        sumbit = findViewById(R.id.submit_btn);

        sumbit.setOnClickListener(v -> {
            if (isAnyFieldEmpty()) {

                AlertListener.showSimpleAlert(VerifyAccountView.this, "Error", "Field is empty!", "OK");
            } else {
                AlertListener.showSimpleAlert(VerifyAccountView.this, "Good Day!", "Register Succefully", "OK");
            }
        });


    }

    private boolean isAnyFieldEmpty() {
        return isEmpty(FirstName) || isEmpty(LastName) || isEmpty(MiddleName) || isEmpty(Email) ||
                isEmpty(Phone) || isEmpty(Birthday) || isEmpty(Gender) || isEmpty(Citizinship) ||
                isEmpty(Relegion) || isEmpty(Weight) || isEmpty(Houseblg) || isEmpty(Height) ||
                isEmpty(HouseOwner) || isEmpty(HouseMaterial) || isEmpty(Sitio) || isEmpty(SinceYear) ||
                isEmpty(FamilyHead) || isEmpty(ShelterType);
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }
}