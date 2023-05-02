package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TaskActivity extends AppCompatActivity {

    public static final String SAVED_TASK_KEY = "edu.utsa.cs3443.taskActivity_savedTask";
    public static final String SAVED_TASK_INDEX_KEY = "edu.utsa.cs3443.taskActivity_savedTaskIndex";
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
        }
        else {
            titleBox.setText(MainActivity.noteList.get(taskIndex).getTitle());
            contentBox.setText(MainActivity.noteList.get(taskIndex).getContent());
        }

        cancelButton.setOnClickListener(new CancelButtonController(this));
        saveButton.setOnClickListener(new TaskSaveButtonController(this, titleBox, contentBox, dateSelector, timeSelector, completedCheckbox, taskIndex));
    }
}