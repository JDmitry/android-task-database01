package com.epam.database01;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.epam.database01.db.DBHelper;
import com.epam.database01.db.FeedReaderContract;
import com.epam.database01.model.Customer;
import java.util.ArrayList;
import java.util.List;

class Display {
    private List<Customer> customers;
    private Cursor cursor;

    @SuppressLint("Recycle")
    Display(DisplayActivity displayActivity) {
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

    List<Customer> getCustomer() {
        return customers;
    }
    Cursor getCursor() {
        return cursor;
    }
}
