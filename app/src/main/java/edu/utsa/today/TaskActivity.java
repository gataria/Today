package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TaskActivity extends AppCompatActivity {

    public static final String SAVED_TASK_KEY = "edu.utsa.cs3443.taskActivity_savedTask";
    public static final String SAVED_TASK_INDEX_KEY = "edu.utsa.cs3443.taskActivity_savedTaskIndex";
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

//        dateSelector.setOnClickListener(new DatePickerButtonController(this, this));

        int taskIndex = getIntent().getIntExtra(MainActivity.TASK_INDEX_KEY, -1);
        if (taskIndex == -1) {
            titleBox.setText("");
            contentBox.setText("");
            savedDate = new GregorianCalendar(1970, Calendar.JANUARY, 1, 0, 0, 0);
            completedCheckbox.setChecked(false);
        }
        else {
            titleBox.setText(MainActivity.noteList.get(taskIndex).getTitle());
            contentBox.setText(MainActivity.noteList.get(taskIndex).getContent());
            savedDate = MainActivity.taskList.get(taskIndex).getDate();
            completedCheckbox.setChecked(MainActivity.taskList.get(taskIndex).isCompleted());
        }

        cancelButton.setOnClickListener(new CancelButtonController(this));
        saveButton.setOnClickListener(new TaskSaveButtonController(this, titleBox, contentBox, completedCheckbox, taskIndex));

        dateSelector.setOnClickListener(new TempDateController(this, dateSelector) );
    }
}