package edu.utsa.today;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_INDEX_KEY = "edu.utsa.cs3443.mainActivity_noteIndex";
    public static final String TASK_INDEX_KEY = "edu.utsa.cs3443.mainActivity_taskIndex";
    public static final int REQUEST_CODE = 0;
    static ArrayList<Note> noteList = new ArrayList<>();
    static ArrayList<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshNoteList();
        refreshTaskList();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                refreshNoteList();
                refreshTaskList();
            }
        }
    }

    void refreshNoteList() {
        LinearLayout listLL = findViewById(R.id.mainLL);
        listLL.removeAllViews();

        for (int i = 0; i < noteList.size(); i++) {
            Button noteButton = new Button(this);
            NoteButtonController noteButtonController = new NoteButtonController( this, i );
            noteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            noteButton.setText(noteList.get(i).getTitle());
            noteButton.setOnClickListener( noteButtonController.new NoteButtonAccessController() );
            noteButton.setOnLongClickListener( noteButtonController.new NoteButtonDeleteController() );

            listLL.addView(noteButton);
        }

        Button newNoteButton = new Button(this);
        NoteButtonController newNoteButtonController = new NoteButtonController( this, -1 );
        newNoteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newNoteButton.setText("+");
        newNoteButton.setOnClickListener( newNoteButtonController.new NoteButtonAccessController() );
        listLL.addView(newNoteButton);
    }
    void refreshTaskList() {
        LinearLayout taskLL = findViewById(R.id.taskLL);
        taskLL.removeAllViews();

        for (int i = 0; i < taskList.size(); i++) {
            Button taskButton = new Button(this);
            TaskButtonController taskButtonController = new TaskButtonController(this, i);
            taskButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            taskButton.setText(taskList.get(i).getTitle());
            taskButton.setOnClickListener(taskButtonController.new TaskButtonAccessController());
            taskButton.setOnLongClickListener(taskButtonController.new TaskButtonDeleteController());

            taskLL.addView(taskButton);
        }

        Button newTaskButton = new Button(this);
        TaskButtonController taskButtonController = new TaskButtonController( this, -1 );
        newTaskButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newTaskButton.setText("+");
        newTaskButton.setOnClickListener( taskButtonController.new TaskButtonAccessController() );
        taskLL.addView(newTaskButton);
    }
}