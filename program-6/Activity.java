package com.example.regform;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioGroup genderGroup;
    CheckBox checkboxTerms;
    Switch switchNewMember; // Mandatory switch
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        genderGroup = findViewById(R.id.genderGroup);
        checkboxTerms = findViewById(R.id.checkboxTerms);
        switchNewMember = findViewById(R.id.switchNewMember); // Initialize switch
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            if (validateInputs()) {
                Toast.makeText(MainActivity.this, "Registration Successful!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validateInputs() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        // Name
        if (TextUtils.isEmpty(name)) {
            showToast("Name is required");
            return false;
        }

        // Email
        if (TextUtils.isEmpty(email)) {
            showToast("Email is required");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Enter a valid email address");
            return false;
        }

        // Password
        if (TextUtils.isEmpty(password)) {
            showToast("Password is required");
            return false;
        } else if (!isValidPassword(password)) {
            showToast("Password must be at least 8 characters, include uppercase, lowercase, number, and special character");
            return false;
        }

        // Gender
        if (genderGroup.getCheckedRadioButtonId() == -1) {
            showToast("Please select your gender");
            return false;
        }

        // Mandatory switch check
        if (!switchNewMember.isChecked()) {
            showToast("Please enable the switch to continue");
            return false;
        }

        // Terms and Conditions
        if (!checkboxTerms.isChecked()) {
            showToast("You must agree to the terms and conditions");
            return false;
        }

        return true;
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}

