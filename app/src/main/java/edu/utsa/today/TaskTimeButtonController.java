package edu.utsa.today;

import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Calendar;

public class TaskTimeButtonController implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    TaskActivity taskActivity;
    Button timeButton;
    Button dateButton;
    Calendar userTime;
    int hourOfDay;
    int minute;
    TimePickerDialog timePickerDialog;

    public TaskTimeButtonController( TaskActivity taskActivity, Button timeButton, Button dateButton ) {
        this.taskActivity = taskActivity;
        this.timeButton = timeButton;
        this.dateButton = dateButton;
    }

    @Override
    public void onClick(View view) {
        userTime = Calendar.getInstance();
        hourOfDay = userTime.get( Calendar.HOUR_OF_DAY );
        minute = userTime.get( Calendar.MINUTE );


        timePickerDialog = new TimePickerDialog( this.taskActivity, this,
                hourOfDay, minute, false ); /* TODO: see if there's a way to get AM/PM|24hr user pref for time */

        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {

        String minuteString = String.format( "%02d", minute );

        String timeString;
        if( hourOfDay == 0 )
        {
            timeString = "12:" + minuteString + " AM";
        }
        else if( hourOfDay < 12 )
        {
            timeString = hourOfDay + ":" + minuteString + " AM";
        }
        else if( hourOfDay == 12 )
        {
            timeString = hourOfDay + ":" + minuteString + " PM";
        }
        else
        {
            timeString = (hourOfDay - 12) + ":" + minuteString + " PM";
        }

        if (TaskActivity.savedDate.get(Calendar.YEAR) == 1970 && TaskActivity.savedDate.get(Calendar.MONTH) == Calendar.JANUARY && TaskActivity.savedDate.get(Calendar.DAY_OF_MONTH) == 1) {
            Calendar today = Calendar.getInstance();
            TaskActivity.savedDate.set(today.get(Calendar.YEAR),
                    today.get(Calendar.MONTH),
                    today.get(Calendar.DAY_OF_MONTH),
                    hourOfDay, minute);
            String dateString;
            dateString = TaskActivity.savedDate.get(Calendar.YEAR) + "-"
                    + (TaskActivity.savedDate.get(Calendar.MONTH) + 1) + "-"
                    + TaskActivity.savedDate.get(Calendar.DAY_OF_MONTH);
            dateButton.setText(dateString);
        }
        else {
            TaskActivity.savedDate.set(TaskActivity.savedDate.get(Calendar.YEAR),
                TaskActivity.savedDate.get(Calendar.MONTH),
                TaskActivity.savedDate.get(Calendar.DAY_OF_MONTH),
                hourOfDay, minute);
        }

        timeButton.setText( timeString );
    }
}
