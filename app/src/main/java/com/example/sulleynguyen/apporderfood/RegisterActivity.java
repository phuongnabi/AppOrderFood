package com.example.sulleynguyen.apporderfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sulleynguyen.apporderfood.DAO.EmployeeDAO;
import com.example.sulleynguyen.apporderfood.DTO.EmployeeDTO;
import com.example.sulleynguyen.apporderfood.FramentApp.DatePickerFragement;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText edUserNameRegister;
    EditText edPasswordRegister;
    EditText edBirthdayRegister;
    EditText edIdCardRegister;
    Button btnOKRegister, btnExitRegister;
    RadioGroup rgGender;

    String strGender;

    EmployeeDAO employeeDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        edUserNameRegister = findViewById(R.id.edUserNameRegister);
        edPasswordRegister = findViewById(R.id.edPasswordRegister);
        edBirthdayRegister = findViewById(R.id.edBirthdayRegister);
        edIdCardRegister = findViewById(R.id.edIdCardRegister);

        btnOKRegister = findViewById(R.id.btnOKRegister);
        btnExitRegister = findViewById(R.id.btnExitRegister);

        rgGender = findViewById(R.id.rgGender);

        btnOKRegister.setOnClickListener(this);
        btnExitRegister.setOnClickListener(this);
        edBirthdayRegister.setOnFocusChangeListener(this);

        employeeDAO = new EmployeeDAO(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id){
            case R.id.btnOKRegister:
                processRegister();
                ;break;

            case R.id.btnExitRegister:
                finish();
                break;

        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int id = v.getId();

        switch (id){
            case R.id.edBirthdayRegister:
                if(hasFocus){
                    //xuat popup ngay sinh
                    DatePickerFragement datePickerFragement = new DatePickerFragement();
                    datePickerFragement.show(getSupportFragmentManager(),"Birthday");
                }
                ;break;
        }
    }

    private void processRegister(){
        String strUsername = edUserNameRegister.getText().toString();
        String strPassword = edPasswordRegister.getText().toString();

        switch (rgGender.getCheckedRadioButtonId()){
            case R.id.rdMale:
                strGender = "Male";
                break;
            case R.id.rdFemale:
                strGender = "Female";
                break;
        }
        String strBirthday = edBirthdayRegister.getText().toString();
        int strIdCard = Integer.parseInt(edIdCardRegister.getText().toString());

        if(strUsername==null || strUsername.equals("")){
            Toast.makeText(RegisterActivity.this,getResources().getString(R.string.ErrorEnterUserName),Toast.LENGTH_LONG).show();
        }else if(strPassword==null || strPassword.equals("")){
            Toast.makeText(RegisterActivity.this,getResources().getString(R.string.ErrorEnterThePassword),Toast.LENGTH_LONG).show();
        }else {
            EmployeeDTO employeeDTO = new EmployeeDTO(strUsername,strPassword,strGender,strBirthday,strIdCard);

            long check = employeeDAO.AddEmployee(employeeDTO);
            if(check!=0){
                Toast.makeText(RegisterActivity.this,getResources().getString(R.string.AddEmployeeSuccess),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(RegisterActivity.this,getResources().getString(R.string.AddEmployeeFail),Toast.LENGTH_LONG).show();
            }

        }

    }
}
