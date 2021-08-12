package com.example.ibra.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final int DATABASE_VERSIONA = 3;

    private static final String DATABASE_NAME = "contacts.db";
    private static final String DATABASE_NAME2 = "towns.db";
    private static final String TABLE_NAME = "contacts";
    private static final String TABLE_NAME2 = "towns";
    private static  final String COLUMN_ID2 = "id";
    private static final String COLUMN_START = "start";
    private static final String COLUMN_DESTINATION = "destination";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";

    private static final String COLUMN_PLATE = "plate";
    private static final String COLUMN_USER = "user";
    private static final String COLUMN_PASSWORD = "pass";
    private static final String COLUMN_LEVEL = "level";

    private static final String COLUMN_BANK = "bank";



    SQLiteDatabase db;
    private static final String TABLE_CREATE = " create table " + TABLE_NAME + "(" + COLUMN_ID + " integer primary key autoincrement not null,"
                                                    + COLUMN_NAME + " text not null ,"
                                                    + COLUMN_PLATE + " integer not null unique ,"
                                                    + COLUMN_USER + " text not null , "
                                                    + COLUMN_PASSWORD + " text not null ,"
                                                    + COLUMN_LEVEL + " integer not null , "
                                                    +COLUMN_BANK + " integer not null unique" + ")";
    private static final String TABLE_CREATE2 = " create table " + TABLE_NAME2 + "(" + COLUMN_ID2 + " integer primary key autoincrement not null ,"
                                                                    + COLUMN_START + " text not null ,"
                                                                    + COLUMN_DESTINATION+ " text not null " + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DatabaseHelper(Main2Activity contexta) {
        super(contexta, DATABASE_NAME2, null, DATABASE_VERSIONA);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2);
        this.db = db;

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = " DROP TABLE IF EXISTS " + TABLE_NAME;
        String querya = " DROP TABLE IF EXISTS " + TABLE_NAME2;
        db.execSQL(query);
        db.execSQL(querya);
        this.onCreate(db);
    }

    public void insertTowns(Contact c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = " select * from towns ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_ID2, count);
        values.put(COLUMN_START,c.getStart());
        values.put(COLUMN_DESTINATION,c.getDestination());
        db.insert( TABLE_NAME2, null, values);
        db.close();
    }
    public void insertContact(Contact c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = " select * from contacts ";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_BANK, c.getBank());
        values.put(COLUMN_LEVEL, c.getLevel());
        values.put(COLUMN_PASSWORD, c.getPass());
        values.put(COLUMN_USER, c.getUser());
        values.put(COLUMN_PLATE, c.getPlate());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String user) {
        db = this.getReadableDatabase();
        String query = " select user, pass from contacts ";
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found!";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                b = cursor.getString(1);
                if (a.equals(user)) {
                    b = cursor.getString(1);
                }
            } while (cursor.moveToNext());
        }
        return b;
    }


    public Cursor viewTowns() {
        db = this.getReadableDatabase();
        String query = " select start, destination from towns ";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }
}
