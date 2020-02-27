package com.epam.database01.db;

import android.provider.BaseColumns;

final class FeedReaderContract {
    private FeedReaderContract() {}

    static class FeedEntry implements BaseColumns {
        static final String TABLE_NAME = "customers";
        static final String COLUMN_SURNAME = "surname";
        static final String COLUMN_FIRST_NAME = "firstname";
        static final String COLUMN_PATRONYMIC = "patronymic";
        static final String COLUMN_AGE = "age";
    }
}
