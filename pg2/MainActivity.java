package com.example.activityy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String TAG="activitylifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { btnOnclick();

            }
        });
        Log.d(TAG, "onCreate: ");
        Toast.makeText(this, "oncreate", Toast.LENGTH_SHORT).show();
    }
    private void btnOnclick(){
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }


    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: Activity is about to become visible");
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: Activity has become visible");
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: Another activity is taking focus");
        Toast.makeText(this, "onPaus", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: Activity is no longer visible");
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: Activity is being restarted after being stopped");
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: Activity is being destroyed");
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }
}
