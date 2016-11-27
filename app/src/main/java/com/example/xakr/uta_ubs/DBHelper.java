package com.example.xakr.uta_ubs;

/**
 * Created by xakR on 11/25/2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper{

    public static Cursor userCursor;
    public static final String DATABASE_NAME= "ubsdb.db";
    public static final String MEMBER_TABLE_NAME="users_table";
    public static final String COL_0="RID";
    public static final String COL_1="FNAME";
    public static final String COL_2="LNAME";
    public static final String COL_3="EMAILID";
    public static final String COL_4="PHNUM";
    public static final String COL_5="NETID";
    public static final String COL_6="UNAME";
    public static final String COL_7="PW";
    public static final String COL_8="SQ";


    public static final String CLUB_TABLE_NAME="club_table";
    public static final String COL_10="CID";
    public static final String COL_11="CLUB_NAME";
    public static final String COL_12="ADMIN";
    public static final String COL_13="FUNCTION";


    public static final String TRADE_TABLE_NAME="trade_table";
    public static final String COL_ITID="ITID";
    public static final String COL_ITNAME="ITNAME";
    public static final String COL_PRICE="PRICE";
    public static final String COL_INFO="INFO";
    public static final String COL_EID="EID";
    public static final String COL_PHNUM="PHNUM";
    public static final String COL_FOTO="FOTO";


    public static final String POST_TABLE_NAME="post_table";
    public static final String COL_PID="PID";
    public static final String COL_WNAME="WNAME";
   // public static final String COL_LNAME="LNAME";
    public static final String COL_SUB="SUB";
    //public static final String COL_ABOUT="ABOUT";

    private static DBHelper INSTANCE= null;
    private Context context;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;

        //SQLiteDatabase db= this.getWritableDatabase();//remove line for insertion line code
    }

    public static DBHelper getInstance(Context context){
        if(INSTANCE==null){
            INSTANCE = new DBHelper(context.getApplicationContext());
        }
        return INSTANCE;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + MEMBER_TABLE_NAME +"(RID INTEGER PRIMARY KEY AUTOINCREMENT, FNAME TEXT, LNAME TEXT, EMAILID TEXT," +
                " PHNUM TEXT, NETID TEXT, UNAME TEXT, PW TEXT, SQ TEXT)");
        db.execSQL("CREATE TABLE " + CLUB_TABLE_NAME +"(CID INTEGER PRIMARY KEY AUTOINCREMENT, CLUB_NAME TEXT, ADMIN TEXT, FUNCTION TEXT)");
        db.execSQL("CREATE TABLE " + TRADE_TABLE_NAME +"(ITID INTEGER PRIMARY KEY AUTOINCREMENT, ITNAME TEXT, PRICE TEXT, INFO TEXT," +
                " EID TEXT, PHNUM TEXT, FOTO TEXT)");
        db.execSQL("CREATE TABLE " + POST_TABLE_NAME +"(PID INTEGER PRIMARY KEY AUTOINCREMENT, WNAME TEXT, SUB TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + MEMBER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CLUB_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TRADE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + POST_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertMemberData(String fname, String lname, String eid, String phnum, String netid, String uname, String pw,String sq ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, fname);
        contentValues.put(COL_2, lname);
        contentValues.put(COL_3, eid);
        contentValues.put(COL_4, phnum);
        contentValues.put(COL_5, netid);
        contentValues.put(COL_6, uname);
        contentValues.put(COL_7, pw);
        contentValues.put(COL_8,sq);

        long result = db.insert(MEMBER_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertClubData(String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_13,func);
        long result = db.insert(CLUB_TABLE_NAME, null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertTradeData(String itname, String price, String info, String eid, String phnum, String foto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ITNAME, itname);
        contentValues.put(COL_PRICE, price);
        contentValues.put(COL_INFO, info);
        contentValues.put(COL_EID, eid);
        contentValues.put(COL_PHNUM, phnum);
        contentValues.put(COL_FOTO, foto);

        long result = db.insert(TRADE_TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insertPostData(String wname,String sub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_WNAME,wname);
        //contentValues.put(COL_LNAME,lname);
        contentValues.put(COL_SUB,sub);

        long result = db.insert(POST_TABLE_NAME, null ,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public void setUser(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        this.userCursor = db.rawQuery("select * from "+MEMBER_TABLE_NAME+" where UNAME = '" + userName+"' ",null);
    }

    public Cursor getUser(){
        return (this.userCursor);
    }


    public Cursor validateUser(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ MEMBER_TABLE_NAME +" where UNAME = '" + userName+"' ",null);
        return res;
    }

    public Cursor getEmail(String netId){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ MEMBER_TABLE_NAME +" where NETID = '" + netId+"' ",null);
        return res;
    }


    public Cursor getClubAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ CLUB_TABLE_NAME,null);
        return res;
    }

    public Cursor getTradeAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TRADE_TABLE_NAME,null);
        return res;
    }

    public Cursor getPostAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ POST_TABLE_NAME,null);
        return res;
    }

    public boolean updateClubData(String cid,String cname,String admin,String func) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_10,cid);
        contentValues.put(COL_11,cname);
        contentValues.put(COL_12,admin);
        contentValues.put(COL_13,func);
        db.update(CLUB_TABLE_NAME, contentValues, "CID = ?",new String[] { cid });
        return true;
    }

    public boolean updateTradeData(String itid,String itname,String price,String info,String eid,String phnum,String foto) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_ITID,itid);
        contentValues.put(COL_ITNAME,itname);
        contentValues.put(COL_PRICE,price);
        contentValues.put(COL_INFO,info);
        contentValues.put(COL_EID,eid);
        contentValues.put(COL_PHNUM,phnum);
        contentValues.put(COL_FOTO,foto);
        db.update(TRADE_TABLE_NAME, contentValues, "ITID = ?",new String[] { itid });
        return true;
    }

    public boolean updatePostData(String pid,String wname,String sub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PID,pid);
        contentValues.put(COL_WNAME,wname);
        contentValues.put(COL_SUB,sub);
        //contentValues.put(COL_13,about);
        db.update(POST_TABLE_NAME, contentValues, "PID = ?",new String[] { pid });
        return true;
    }

    public Integer deleteClubData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(CLUB_TABLE_NAME, "CID = ?",new String[] {id});
    }

    public Integer deleteTradeData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TRADE_TABLE_NAME, "ITID = ?",new String[] {id});
    }
    public Integer deletePostData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(POST_TABLE_NAME, "PID = ?",new String[] {id});
    }
}