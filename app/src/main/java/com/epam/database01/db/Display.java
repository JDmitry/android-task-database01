package com.epam.database01.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.epam.database01.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class Display implements Displayable{
    private List<Customer> customers;

    public Display(Context displayActivity) {
        customers = new ArrayList<>();
        DBHelper helper = new DBHelper(displayActivity);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(FeedReaderContract.FeedEntry.SQL_QUERY + FeedReaderContract.FeedEntry.TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                customers.add(new Customer(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

