package com.example.petstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Client.db";
    public static final String TABLE_NAME = "Client_Table";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "Surname";
    public static final String COL_3 = "Pet_Name";
    public static final String COL_4 = "Pet_Previous_diagnosis";
    public static final String COL_5 = "Pet_Previous_prescriptions";
    public static final String COL_6 = "Account_Number";
    private String Account_Number;
    private String Pet_Previous_prescriptions;
    private String Pet_Previous_diagnosis;
    private String Pet_Name;
    private byte[] Surname;


    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name, Surname,  Pet_Name,  Pet_Previous_diagnosis, Pet_Previous_prescriptions, Account_Number )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String s1, String string, String toString, String s, String Name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, Name);
        contentValues.put(COL_2, Surname);
        contentValues.put(COL_3, Pet_Name);
        contentValues.put(COL_4, Pet_Previous_diagnosis);
        contentValues.put(COL_5, Pet_Previous_prescriptions);
        contentValues.put(COL_6, Account_Number);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getClient() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String Name, String Surname, String Pet_Name, String Pet_Previous_diagnosis, String Pet_Previous_prescriptions, String Account_Number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, Name);
        contentValues.put(COL_2, Surname);
        contentValues.put(COL_3, Pet_Name);
        contentValues.put(COL_4, Pet_Previous_diagnosis);
        contentValues.put(COL_5, Pet_Previous_prescriptions);
        contentValues.put(COL_6, Account_Number);

       db.update(TABLE_NAME, contentValues, "ID=?", new String[] {Name});
        return true;
    }
        public Integer deleteData(String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[] {ID});
        }
}