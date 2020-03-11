package com.epam.database01.db;

import com.epam.database01.InsertActivity;

public interface Insertable {
    void setData();

    void setData(InsertActivity insertActivity, String surname, String firstName, String patronymic, String age);
}
