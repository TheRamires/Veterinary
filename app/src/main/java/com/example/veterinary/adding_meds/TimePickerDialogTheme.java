package com.example.veterinary.adding_meds;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import com.example.veterinary.R;

import java.util.Calendar;

public class TimePickerDialogTheme extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minutes = calendar.get(Calendar.MINUTE);


        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,hour,minutes,true);



        return timePickerDialog;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String myHour = String.format("%02d",hourOfDay, 1);
        String myMinutes = String.format("%02d",minute, 1);

        TextView textview = (TextView)getActivity().findViewById(R.id.time);
        textview.setText(myHour+":"+ myMinutes);

    }
}