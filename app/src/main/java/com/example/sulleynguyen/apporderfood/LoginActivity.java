package com.example.sulleynguyen.apporderfood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sulleynguyen.apporderfood.DAO.EmployeeDAO;

/**
 * Created by sulleynguyen on 2/27/18.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOkLogin, btnRegisterLogin;
    EditText edUsernameLogin, edPasswordLogin;
    EmployeeDAO employeeDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnOkLogin = findViewById(R.id.btnOkLogin);
        btnRegisterLogin = findViewById(R.id.btnRegisterLogin);
        edUsernameLogin = findViewById(R.id.edUsernameLogin);
        edPasswordLogin = findViewById(R.id.edPasswordLogin);

        employeeDAO = new EmployeeDAO(this);
        showButtonOKandRegister();


        //dang su su kien click
        btnOkLogin.setOnClickListener(this);
        btnRegisterLogin.setOnClickListener(this);


    }

    private void showButtonOKandRegister() {
        boolean check = employeeDAO.checkEmployee();

        if (check) {
            btnRegisterLogin.setVisibility(View.GONE);
            btnOkLogin.setVisibility(View.VISIBLE);
        } else {
            btnRegisterLogin.setVisibility(View.VISIBLE);
            btnOkLogin.setVisibility(View.GONE);
        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btnOkLogin:
                processBtnLogin();

                ;break;
            case R.id.btnRegisterLogin:

                processBtnRegister();
                break;
        }
    }

    private void processBtnLogin() {
        String strUserName = edUsernameLogin.getText().toString();
        String strPassword = edPasswordLogin.getText().toString();
        boolean check = employeeDAO.checkLogin(strUserName, strPassword);

        if (check) {
            //Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
            //chuyen qua trang chu
            Intent intentHomePage = new Intent(LoginActivity.this,HomePageActivity.class);
            intentHomePage.putExtra("username",edUsernameLogin.getText().toString());
            startActivity(intentHomePage);
        } else {
            Toast.makeText(LoginActivity.this, "Login Fail", Toast.LENGTH_SHORT).show();
        }


    }

    private void processBtnRegister() {
        //chuyen qua trang dang ky
        Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intentRegister);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showButtonOKandRegister();
    }
}

