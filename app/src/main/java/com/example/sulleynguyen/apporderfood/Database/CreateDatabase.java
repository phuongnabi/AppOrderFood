package com.example.sulleynguyen.apporderfood.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sulleynguyen on 2/22/18.
 */

public class CreateDatabase extends SQLiteOpenHelper {

    public static String TB_EMPLOYEE = "EMPLOYEE";
    public static String TB_FOOD = "FOOD";
    public static String TB_FOODTYPE = "FOODTYPE";
    public static String TB_TABLEDINNER = "TABLEDINNER";
    public static String TB_ORDERFOOD = "ODERFOOD";
    public static String TB_ORDERDETAIL = "ODERDETAIL";

    public static String TB_EMPLOYEE_EMPCODE = "EMPCODE";
    public static String TB_EMPOYEE_USERNAME = "USERNAME";
    public static String TB_EMPOYEE_PASSWORD = "PASSWORD";
    public static String TB_EMPOYEE_GENDER = "GENDER";
    public static String TB_EMPOYEE_BIRTHDAY = "BIRTHDAY";
    public static String TB_EMPOYEE_IDCARD = "IDCARD";

    public static String TB_FOOD_FOODCODE = "FOODCODE";
    public static String TB_FOOD_FOODNAME = "FOODNAME";
    public static String TB_FOOD_PRICE = "PRICE";
    public static String TB_FOOD_FOODTYPECODE = "FOODTYPECODE";

    public static String TB_FOODTYPE_FOODTYPECODE = "FOODTYPECODE";
    public static String TB_FOODTYPE_FOODTYPENAME = "FOODTYPENAME";


    public static String TB_TABLE_TABLECODE = "TABLECODE";
    public static String TB_TABLE_TABLENAME = "TABLENAME";
    public static String TB_TABLE_TABLESTATUS = "TABLESTATUS";


    public static String TB_ORDERFOOD_ORDERCODE = "ORDERCODE";
    public static String TB_ORDERFOOD_EMPCODE = "EMPCODE";
    public static String TB_ORDERFOOD_ORDERDATE = "ORDERDATE";
    public static String TB_ORDERFOOD_ORDERSTATUS = "ORDERSTATUS";
    public static String TB_ORDERFOOD_TABLECODE = "TABLECODE";

    public static String TB_ORDERDETAIL_ORDERCODE = "ORDERCODE";
    public static String TB_ORDERDETAIL_FOODCODE = "FOODCODE";
    public static String TB_ORDERDETAIL_QUANTITY = "QUANTITY";








    public CreateDatabase(Context context) {
        super(context, "OderFood", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbEMPLOYEE = "CREATE TABLE " + TB_EMPLOYEE + " ( " + TB_EMPLOYEE_EMPCODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_EMPOYEE_USERNAME + " TEXT, "
                + TB_EMPOYEE_PASSWORD + " TEXT, "
                + TB_EMPOYEE_GENDER + " TEXT, "
                + TB_EMPOYEE_BIRTHDAY + " TEXT, "
                + TB_EMPOYEE_IDCARD + " INTEGER) ";

        String tbTABLE = "CREATE TABLE " + TB_TABLEDINNER + " ( " + TB_TABLE_TABLECODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_TABLE_TABLENAME + " TEXT, "
                + TB_TABLE_TABLESTATUS + " TEXT )";
        String tbFOOD = "CREATE TABLE " + TB_FOOD + " ( " + TB_FOOD_FOODCODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_FOOD_FOODNAME + " TEXT, "
                + TB_FOOD_FOODTYPECODE + " INTEGER, "
                + TB_FOOD_PRICE + " TEXT )";

        String tbFOODTYPE = "CREATE TABLE " + TB_FOODTYPE + " ( " + TB_FOODTYPE_FOODTYPECODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_FOODTYPE_FOODTYPENAME + " TEXT )";

        String tbORDERFOOD = "CREATE TABLE " + TB_ORDERFOOD + " ( " + TB_ORDERFOOD_ORDERCODE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TB_ORDERFOOD_TABLECODE + " INTEGER, "
                + TB_ORDERFOOD_EMPCODE + " INTEGER, "
                + TB_ORDERFOOD_ORDERDATE + " TEXT, "
                + TB_ORDERFOOD_ORDERSTATUS + " TEXT )";

        String tbORDERDETAIL = "CREATE TABLE " + TB_ORDERDETAIL + " ( " + TB_ORDERDETAIL_ORDERCODE + " INTEGER, "
                + TB_ORDERDETAIL_FOODCODE + " INTEGER, "
                + TB_ORDERDETAIL_QUANTITY + " INTEGER,"
                + " PRIMARY KEY(" + TB_ORDERDETAIL_ORDERCODE + " , " + TB_ORDERDETAIL_FOODCODE +"))";


        db.execSQL(tbEMPLOYEE);
        db.execSQL(tbTABLE);
        db.execSQL(tbFOOD);
        db.execSQL(tbFOODTYPE);
        db.execSQL(tbORDERFOOD);
        db.execSQL(tbORDERDETAIL);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
