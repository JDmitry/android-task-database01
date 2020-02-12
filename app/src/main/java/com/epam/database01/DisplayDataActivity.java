package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class DisplayDataActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        toolbar = (Toolbar) findViewById(R.id.toolbar_displaydataActivity);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SQLiteDatabase db = helper.getReadableDatabase();
    }
}
