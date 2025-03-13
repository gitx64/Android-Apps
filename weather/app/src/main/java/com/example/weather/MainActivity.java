package com.example.weather; // Replace with your package name

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Replace activity_main if needed

        TextView cityName = findViewById(R.id.CityName);
        EditText searchBar = findViewById(R.id.search_bar);
        TextView weatherInfo = findViewById(R.id.weatherInfo);
        Button searchButton = findViewById(R.id.search_button);


        String url;

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = searchBar.getText().toString();
                cityName.setText(city);

            }
        });
    }
}