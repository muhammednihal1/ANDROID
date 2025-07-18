package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fname="Linto";
        String pwd="12345678";
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText n=findViewById(R.id.editTextText2);
                EditText p=findViewById(R.id.editTextText3);
                String name=n.getText().toString();
                String pass=p.getText().toString();

                if(fname.equals(name) & pwd.equals(pass)) {
                    Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
