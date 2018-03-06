package com.example.sulleynguyen.apporderfood.FramentApp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.sulleynguyen.apporderfood.R;

import java.util.Calendar;

/**
 * Created by sulleynguyen on 2/24/18.
 */

public class DatePickerFragement extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int iYear = calendar.get(Calendar.YEAR);
        int iMonth = calendar.get(Calendar.MONTH);
        int iDay = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,iDay,iMonth,iYear);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        EditText edBirthDay = getActivity().findViewById(R.id.edBirthdayRegister);
        String strBirthDay = dayOfMonth + "/" + (month+1) + "/" + year;
        edBirthDay.setText(strBirthDay);
    }
}
