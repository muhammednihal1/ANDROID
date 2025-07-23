package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn= findViewById(R.id.add);
        Button btn2= findViewById(R.id.sub);
        Button btn3= findViewById(R.id.div);
        Button btn4= findViewById(R.id.mul);
        EditText et1= findViewById(R.id.et1);
        EditText et2= findViewById(R.id.et2);
        TextView result = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());
                result.setText("Result: " + (a + b));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());
                result.setText("Result: " + (a - b));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());
                result.setText("Result: " + (a * b));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());
                result.setText("Result: " + (a / b));
            }
        });

    }
}
