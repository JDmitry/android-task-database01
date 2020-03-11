package com.epam.database01.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.view.Gravity;
import android.widget.Toast;
import com.epam.database01.InsertActivity;
import com.epam.database01.R;

public class Insert implements Insertable{

    @Override
    public void setData() {

    }

    @Override
    public void setData(final InsertActivity insertActivity, final String surname, final String firstName, final String patronymic, final String age) {
        DBHelper helper = new DBHelper(insertActivity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_SURNAME, surname);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_FIRST_NAME, firstName);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_PATRONYMIC, patronymic);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_AGE, Integer.parseInt(age));

        if (db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, contentValues) > 0) {
            Toast toast = Toast.makeText(insertActivity, R.string.toast_message, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
}

