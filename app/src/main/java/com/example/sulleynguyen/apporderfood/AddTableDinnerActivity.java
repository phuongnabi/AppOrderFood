package com.example.sulleynguyen.apporderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sulleynguyen.apporderfood.DAO.TableDinnerDAO;
import com.example.sulleynguyen.apporderfood.R;

/**
 * Created by sulleynguyen on 3/1/18.
 */

public class AddTableDinnerActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edAddNameTableDinner;
    Button btnOkAddTableDinner;
    TableDinnerDAO tableDinnerDAO;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_addtabledinner);

        edAddNameTableDinner = (EditText)findViewById(R.id.edAddNameTablerDinner);
        btnOkAddTableDinner = (Button)findViewById(R.id.btnOkAddTableDinner);

        tableDinnerDAO = new TableDinnerDAO(this);
        btnOkAddTableDinner.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        String sNameTableDinner = edAddNameTableDinner.getText().toString();
        if(sNameTableDinner.equals("") || sNameTableDinner != null){
            boolean check =  tableDinnerDAO.addTableDinner(sNameTableDinner);
            Intent intent = new Intent();
            intent.putExtra("resultAdd",check);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
    }
}
