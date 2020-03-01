package com.epam.database01.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.epam.database01.DisplayActivity;
import com.epam.database01.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class Display {
    private Context context;

    @SuppressLint("Recycle")
    public Display(DisplayActivity displayActivity) {
        context = displayActivity;
    }

    public List<Customer> getCustomers() {
        DBHelper helper = new DBHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FeedReaderContract.FeedEntry.TABLE_NAME, null);
        List<Customer> customers = new ArrayList<>();

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
        cursor.close();
        return customers;
    }
}
