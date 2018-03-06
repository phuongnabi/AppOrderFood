package com.example.sulleynguyen.apporderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sulleynguyen.apporderfood.DTO.EmployeeDTO;
import com.example.sulleynguyen.apporderfood.Database.CreateDatabase;

/**
 * Created by sulleynguyen on 2/24/18.
 */

public class EmployeeDAO {

    SQLiteDatabase database;

    public EmployeeDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }

    public long AddEmployee(EmployeeDTO employeeDTO){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_EMPOYEE_USERNAME,employeeDTO.getUSERNAME());
        contentValues.put(CreateDatabase.TB_EMPOYEE_GENDER,employeeDTO.getGENDER());
        contentValues.put(CreateDatabase.TB_EMPOYEE_PASSWORD,employeeDTO.getPASSWORD());
        contentValues.put(CreateDatabase.TB_EMPOYEE_IDCARD,employeeDTO.getIDCARD());
        contentValues.put(CreateDatabase.TB_EMPOYEE_BIRTHDAY,employeeDTO.getBIRTHDAY());

        long check = database.insert(CreateDatabase.TB_EMPLOYEE, null,contentValues);
        return check;
    }

    public boolean checkEmployee(){
        String query = "SELECT * FROM " + CreateDatabase.TB_EMPLOYEE;
        Cursor cursor = database.rawQuery(query,null);

        if(cursor.getCount() != 0){
            return  true;
        }
        return false;

    }

    public boolean checkLogin(String userName, String password){

      String query = "SELECT * FROM " + CreateDatabase.TB_EMPLOYEE + " WHERE " + CreateDatabase.TB_EMPOYEE_USERNAME + " = '"
              + userName + "' AND " + CreateDatabase.TB_EMPOYEE_PASSWORD + " = '" + password + "'";

      Cursor cursor = database.rawQuery(query,null);

        if(cursor.getCount() != 0){
            return  true;
        }
        return false;

    }
}
