package com.example.proga;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="ACCOUNT_DB";
    public static final String TABLE_ACCOUNTS ="accounts";

    public static final String KEY_ID ="_id";
    public static final String KEY_NAME ="name";
    public static final String KEY_MAIL ="mail";
    public static final String KEY_PASS ="pass";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table "+ TABLE_ACCOUNTS +
        //        "("+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
        //        KEY_NAME + " TEXT, " +
        //        KEY_MAIL + " TEXT, " +
        //        KEY_PASS + " TEXT)");

        db.execSQL("create table " + TABLE_ACCOUNTS + "(" + KEY_ID
                + " integer primary key," + KEY_NAME + " text," + KEY_MAIL + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+ TABLE_ACCOUNTS);
        onCreate(db);
    }
}
