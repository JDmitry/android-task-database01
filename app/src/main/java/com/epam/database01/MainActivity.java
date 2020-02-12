package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addData(View view) {
        intent = new Intent(MainActivity.this, InsertDataActivity.class);
        startActivity(intent);
    }

    public void displayData(View view) {
        intent = new Intent(MainActivity.this, DisplayDataActivity.class);
        startActivity(intent);
    }
}
