package edu.utsa.today;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerButtonController implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    Activity activity;
    Context context;

    public DatePickerButtonController (Context context, Activity activity){
        this.activity = activity;
        this.context = context;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        TaskActivity.selectedDate.set(year, month, day);

        activity.setContentView(R.layout.activity_task);
        Button datePickerButton = activity.findViewById(R.id.dateSelector);
        if (year == 1970 && month == 0 && day == 1) {
            datePickerButton.setText(R.string.empty_date_selector);
        }
        else {
            String dateString = month + "/" + day + "/" + year; //'murica
            datePickerButton.setText(dateString);
        }
    }

    @Override
    public void onClick(View view) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(context, this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }
}
