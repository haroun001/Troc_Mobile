package isetB.PlatformdeTROC;


import android.content.ContentValues;
import android.content.Context;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="user_db";

    public static final String TABLE_TROC ="user";
    public static final String COL_ID ="_id";
    public static final String COL_NAME ="name";
    public static final String COL_EMAIL ="email";
    public static final String COL_PASSWORD ="password";

    public static  final String CREATE_TROC_TABLE = "CREATE TABLE " + TABLE_TROC + "("
            +COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +COL_NAME +" TEXT NOT NULL, "
            +COL_EMAIL +" TEXT ,"
            +COL_PASSWORD +" TEXT) ";

    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DB","Table Create SQL: "+ CREATE_TROC_TABLE);
        db.execSQL( CREATE_TROC_TABLE );
        Log.d("DB","DB create!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TROC);
        onCreate(db);
    }
    public SQLiteDatabase open(){
        db=this.getWritableDatabase();
        return db;
    }


    public void addUser(user s){
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,s.getNom());
        values.put(COL_EMAIL,s.getEMAIL());
        values.put(COL_ID,s.getId());
        values.put(COL_PASSWORD,s.getPASSWORD());
        db.insert(TABLE_TROC,null,values);
    }

    public void updateuser(user u) {
        open();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,u.getNom());
        values.put(COL_EMAIL,u.getEMAIL());
        db.update(TABLE_TROC, values,COL_ID+"=?",new String []{String.valueOf(u.getId())});
    }
    public void removeuser(int id) {
        open();

        db.delete(TABLE_TROC, COL_ID+"=?", new String[]{String.valueOf(id)});
    }

    public ArrayList<user> getAlluser() {
        ArrayList<user> list =new ArrayList<user>();
        db=this.getReadableDatabase();
        Cursor c=db.query(TABLE_TROC, null, null,null,null,null,null
                ,null);
        c.moveToFirst();
        do{
            user u=new user(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            list.add(u);
        }
        while (c.moveToNext());
        c.close();
        return list;


    }
    public int getuserCount() {
        db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_TROC, null, null, null, null, null, null
                , null);
        return c.getCount();
    }


}
