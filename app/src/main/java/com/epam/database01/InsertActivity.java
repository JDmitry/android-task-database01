package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.epam.database01.db.Insert;

public class InsertActivity extends AppCompatActivity {
    private EditText surname;
    private EditText firstName;
    private EditText patronymic;
    private EditText age;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Toolbar toolbar = findViewById(R.id.toolbar_insertActivity);
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
    }

    public void sendData(View view) {
        new Insert(this,
                surname.getText().toString(),
                firstName.getText().toString(),
                patronymic.getText().toString(),
                Integer.parseInt(age.getText().toString()));
        finish();
    }
}