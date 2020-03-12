package com.epam.database01.db;

import android.content.Context;

import com.epam.database01.InsertActivity;

public interface Insertable {
    void setData(Context context,
                 String surname,
                 String firstName,
                 String patronymic,
                 String age);
}
