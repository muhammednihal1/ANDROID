package com.example.validate;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText name, mail, pass;
    RadioButton rbm, rbf;
    CheckBox cbTerms;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);
        rbm = findViewById(R.id.rbm);
        rbf = findViewById(R.id.rbf);
        cbTerms = findViewById(R.id.cbTerms);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String userName = name.getText().toString().trim();
        String userEmail = mail.getText().toString().trim();
        String userPassword = pass.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            name.setError("Name is required");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            mail.setError("Enter a valid email");
            return;
        }

        if (userPassword.length() < 6 ||
                !userPassword.matches(".*[A-Za-z].*") ||
                !userPassword.matches(".*\\d.*") ||
                !userPassword.matches(".*[@#$%^&+=!].*")) {

            pass.setError("Min 6 chars, include letter, number & special char");
            return;
        }

        if (!rbm.isChecked() && !rbf.isChecked()) {
            Toast.makeText(this, "Select your gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please accept Terms & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Form Submitted Successfully!", Toast.LENGTH_LONG).show();
        clearForm();
    }

    private void clearForm() {
        name.setText("");
        mail.setText("");
        pass.setText("");
        rbm.setChecked(false);
        rbf.setChecked(false);
        cbTerms.setChecked(false);
    }
}

