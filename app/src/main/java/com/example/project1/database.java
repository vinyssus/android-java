package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public static final String sport = "sport";
    public database(Context context) {
        super(context, sport, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE sport (N INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT ) ");
        db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + sport);
        onCreate(db);
    }
    EditText user;
    EditText pass;
    public boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        long result = db.insert(sport, null, valeurs);
        if (result == -1)
            return false;
        else
            return true;
    }
    public String[] retournerRef() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+sport,null);
        String[] tab = new String[res.getCount()];

        System.out.println(res.getCount());
        for(int i=0;i<res.getCount();i++){
            res.moveToNext();
            tab[i] = res.getString(1);
        }
        return tab;
    }
}
