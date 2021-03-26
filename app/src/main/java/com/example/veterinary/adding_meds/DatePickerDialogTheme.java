package com.example.veterinary.adding_meds;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.veterinary.R;

import java.util.Calendar;

public class DatePickerDialogTheme extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

//for five

        DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,year,month,day);

//for six


        return datepickerdialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        String myMonth = String.format("%02d",month+1, 1);


        TextView textview = (TextView)getActivity().findViewById(R.id.date);

        textview.setText(day + "." + myMonth + "." + year);

    }
}