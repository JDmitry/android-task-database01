package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertDataActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText surname, firstname, patronymic, age;
    private String surnameText, firstnameText, patronymicText;
    private int ageNumber;
    private DBHelper helper;
    private SQLiteDatabase db;
    private ContentValues values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);

        toolbar = (Toolbar) findViewById(R.id.toolbar_inserdataActivity);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        surname = (EditText) findViewById(R.id.surname);
        firstname = (EditText) findViewById(R.id.firstname);
        patronymic = (EditText) findViewById(R.id.patronymic);
        age = (EditText) findViewById(R.id.age);

        helper = new DBHelper(this);
        values = new ContentValues();
    }

    public void sendDataToDB(View view) {
        surnameText = surname.getText().toString();
        firstnameText = firstname.getText().toString();
        patronymicText = patronymic.getText().toString();
        ageNumber = Integer.parseInt(age.getText().toString());

        db = helper.getWritableDatabase();

        values.put("SURNAME", surnameText);
        values.put("FIRSTNAME", firstnameText);
        values.put("PATRONYMIC", patronymicText);
        values.put("AGE", ageNumber);

        long newRowId = db.insert("Customers", null, values);
    }
}

