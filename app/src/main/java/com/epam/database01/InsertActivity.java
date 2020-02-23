package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText surname;
    private EditText firstName;
    private EditText patronymic;
    private EditText age;
    private Button button;
    private DBHelper helper;
    private SQLiteDatabase db;
    private ContentValues contentValues;
    private String col_one;
    private String col_two;
    private String col_three;
    private int col_four;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        toolbar = findViewById(R.id.toolbar_insertActivity);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        surname = findViewById(R.id.surname);
        firstName = findViewById(R.id.first_name);
        patronymic = findViewById(R.id.patronymic);
        age = findViewById(R.id.age);

        button = findViewById(R.id.add_button);

        helper = new DBHelper(getApplicationContext());

        db = helper.getWritableDatabase();

        contentValues = new ContentValues();
    }

    public void sendData(View view) {
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_SURNAME, col_one = surname.getText().toString());
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_FIRST_NAME, col_two = firstName.getText().toString());
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_PATRONYMIC, col_three = patronymic.getText().toString());
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_AGE, col_four = Integer.parseInt(age.getText().toString()));

        long newRoeId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, contentValues);
        System.out.println(newRoeId);

        finish();
    }
}