package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button click =(Button) findViewById(R.id.btn);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PassiveActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ActivityLife Cycle","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ActivityLife Cycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ActivityLife Cycle","onPause");
        Toast.makeText(this, "Come back soon :)", Toast.LENGTH_SHORT).show();
    }
    protected void onRestart() {
        super.onRestart();
        Log.d("ActivityLife Cycle","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ActivityLife Cycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ActivityLife Cycle","onDestroy");
        Toast.makeText(this, "All cleared", Toast.LENGTH_SHORT).show();
        
    }





}