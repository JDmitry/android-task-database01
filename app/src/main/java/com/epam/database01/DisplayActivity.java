package com.epam.database01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.epam.database01.adapter.CustomersAdapter;
import com.epam.database01.db.Display;
import com.epam.database01.db.Displayable;
import com.epam.database01.model.Customer;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    private Displayable display;
    private CustomersAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Toolbar toolbar = findViewById(R.id.toolbar_displayActivity);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        display = new Display(this);
        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomersAdapter();
        display.createCollection();
        adapter.addAll(display.getCustomers());
        recyclerView.setAdapter(adapter);
    }

    public void addData(View view) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }
}
