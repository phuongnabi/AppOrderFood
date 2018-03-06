package com.example.sulleynguyen.apporderfood.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sulleynguyen.apporderfood.DTO.TableDinnerDTO;
import com.example.sulleynguyen.apporderfood.Database.CreateDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sulleynguyen on 3/1/18.
 */

public class TableDinnerDAO {

    SQLiteDatabase database;
    public  TableDinnerDAO(Context context){
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }


    public boolean addTableDinner(String nameTableDinner){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_TABLE_TABLENAME,nameTableDinner);
        contentValues.put(CreateDatabase.TB_TABLE_TABLESTATUS,"false");

        long check = database.insert(CreateDatabase.TB_TABLEDINNER,null,contentValues);
        if(check!=0){
            return true;
        }else
            return false;

    }

    public List<TableDinnerDTO> getAllTableDinner(){
        List<TableDinnerDTO> tableDinnerList = new ArrayList<TableDinnerDTO>();
        String query = "SELECT * FROM " + CreateDatabase.TB_TABLEDINNER;
        Cursor cursor = database.rawQuery(query,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            TableDinnerDTO tableDinnerDTO = new TableDinnerDTO();
            tableDinnerDTO.setTableCode(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_TABLE_TABLECODE)));
            tableDinnerDTO.setTableName(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_TABLE_TABLENAME)));
            tableDinnerList.add(tableDinnerDTO);

            cursor.moveToNext();
        }
        return tableDinnerList;
    }
}
