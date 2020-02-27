package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
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
        String col_surname = surname.getText().toString();
        String col_first_name = firstName.getText().toString();
        String col_patronymic = patronymic.getText().toString();
        String col_age = age.getText().toString();

        if (surname.length() == 0 || firstName.length() == 0 || age.length() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(),"Fill all the required fields", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        } else {
            if (patronymic.length() == 0) {
                patronymic.setText("_");
                col_patronymic = patronymic.getText().toString();
            }
            new Insert(this, col_surname, col_first_name, col_patronymic, col_age);
            finish();
        }
    }
}