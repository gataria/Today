package edu.utsa.today;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerButtonController extends DialogFragment implements View.OnClickListener {

    Activity activity;
    Context context;

    public DatePickerButtonController (Context context, Activity activity){
        this.activity = activity;
        this.context = context;
    }

    public class DatePickerFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            TaskActivity.savedDate.set(year, month, day);

            activity.setContentView(R.layout.activity_task);
            Button datePickerButton = activity.findViewById(R.id.dateSelector);
            if (year == 1970 && month == 0 && day == 1) {
                datePickerButton.setText(R.string.empty_date_selector);
            } else {
                String dateString = month + "/" + day + "/" + year; //'murica
                datePickerButton.setText(dateString);
            }

            System.out.println("teehee :3");
        }
    }

    @Override
    public void onClick(View view) {
//        Calendar calendar = Calendar.getInstance();
//
//        DialogFragment fragment;
//
//        fragment.show( getActivity().getSupportFragmentManager(), "datePicker" );
    }
}
