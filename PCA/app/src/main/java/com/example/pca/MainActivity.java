package com.example.pca;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private boolean isLoginScreenActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Email = findViewById(R.id.Email);
        EditText Password = findViewById(R.id.Password);
        Button Login = findViewById(R.id.Login);
        Button Register = findViewById(R.id.Register);

        SharedPreferences prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE);

        Login.setOnClickListener(v -> {
            if (Email.getText().toString().equals(prefs.getString("Email", "")) &&
                    Password.getText().toString().equals(prefs.getString("Password", ""))) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                isLoginScreenActive = false; // User is navigating away from login
                startActivity(new Intent(this, HomePage.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
            }
        });

        Register.setOnClickListener(v -> {
            isLoginScreenActive = false; // User is navigating away from login
            startActivity(new Intent(this, Register.class));
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (isLoginScreenActive) {
            Toast.makeText(this, "Good Day", Toast.LENGTH_SHORT).show();
        }
    }
}
