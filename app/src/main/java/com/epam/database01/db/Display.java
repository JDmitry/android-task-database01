package com.epam.database01.db;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.epam.database01.DisplayActivity;
import com.epam.database01.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class Display {
    private List<Customer> customers;
    private Cursor cursor;

    @SuppressLint("Recycle")
    public Display(DisplayActivity displayActivity) {
        DBHelper helper = new DBHelper(displayActivity);
        SQLiteDatabase db = helper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + FeedReaderContract.FeedEntry.TABLE_NAME, null);
        customers = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do{
                customers.add(new Customer(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4))
                );
            }while (cursor.moveToNext());
        }
    }

    public List<Customer> getCustomer() {
        return customers;
    }
    public Cursor getCursor() {
        return cursor;
    }
}
