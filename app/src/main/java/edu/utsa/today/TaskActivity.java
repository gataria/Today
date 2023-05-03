package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TaskActivity extends AppCompatActivity {

    static Calendar savedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        EditText titleBox = findViewById(R.id.titleBox);
        EditText contentBox = findViewById(R.id.contentBox);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button saveButton = findViewById(R.id.saveButton);
        CheckBox completedCheckbox = findViewById(R.id.completedCheckbox);
        Button dateSelector = findViewById(R.id.dateSelector);
        Button timeSelector = findViewById(R.id.timeSelector);

        int taskIndex = getIntent().getIntExtra(MainActivity.TASK_INDEX_KEY, -1);
        if (taskIndex == -1) {
            titleBox.setText("");
            contentBox.setText("");
            savedDate = new GregorianCalendar(1970, Calendar.JANUARY, 1, 0, 0, 0);
            completedCheckbox.setChecked(false);
        }
        else {
            Task oldTask = MainActivity.taskList.get( taskIndex );

            titleBox.setText( oldTask.getTitle() );
            contentBox.setText( oldTask.getNote() );
            savedDate = (Calendar)(oldTask.getDate()).clone();
            completedCheckbox.setChecked( oldTask.isCompleted());

            String dateText = "" + savedDate.get(Calendar.YEAR) + "-" + savedDate.get(Calendar.MONTH) + "-" + savedDate.get(Calendar.DAY_OF_MONTH);
            dateSelector.setText(dateText);

            String timeText;
            int timeHour = savedDate.get(Calendar.HOUR_OF_DAY);
            String timeMinute = String.format("%02d", savedDate.get(Calendar.MINUTE));
            if (timeHour < 12) { timeText = timeHour + ":" + timeMinute + " AM"; }
            else if (timeHour == 12) { timeText = timeHour + ":" + timeMinute + " PM"; }
            else { timeText = (timeHour - 12) + ":" + timeMinute + " PM"; }
            timeSelector.setText(timeText);

        }

        cancelButton.setOnClickListener(new CancelButtonController(this));
        saveButton.setOnClickListener(new TaskSaveButtonController(this, titleBox, contentBox, completedCheckbox, taskIndex));

        dateSelector.setOnClickListener(new TaskDateButtonController(this, dateSelector ) );
        timeSelector.setOnClickListener( new TaskTimeButtonController( this, timeSelector ) );

    }
}