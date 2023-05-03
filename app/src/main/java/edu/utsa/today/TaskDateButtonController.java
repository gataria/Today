package edu.utsa.today;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class TaskDateButtonController implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    TaskActivity taskActivity;
    Button dateButton;
    /* FIXME: cleanup static variables */
    Calendar userDate;
    int year;
    int month;
    int dayOfMonth;
    DatePickerDialog datePickerDialog;

    public TaskDateButtonController(TaskActivity taskActivity, Button dateButton ) {
        this.taskActivity = taskActivity;
        this.dateButton = dateButton;
    }

    @Override
    public void onClick(View view) {
        userDate = Calendar.getInstance();
        year = userDate.get(Calendar.YEAR);
        month = userDate.get(Calendar.MONTH);
        dayOfMonth = userDate.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog( this.taskActivity,
                this, year, month, dayOfMonth );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        String dateString = year + "-" + ( month + 1 ) + "-" + day; /* YYYY-MM-DD */

        TaskActivity.savedDate.set( year, month, day );

        dateButton.setText( dateString );
    }
}
