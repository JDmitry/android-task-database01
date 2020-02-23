package com.epam.database01;

import android.provider.BaseColumns;
public final class FeedReaderContract {

    private FeedReaderContract() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "customers";
        public static final String COLUMN_SURNAME = "surname";
        public static final String COLUMN_FIRST_NAME = "firstname";
        public static final String COLUMN_PATRONYMIC = "patronymic";
        public static final String COLUMN_AGE = "age";
    }
}
