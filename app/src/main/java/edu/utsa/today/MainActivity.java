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

    public static final String NOTE_KEY = "edu.utsa.cs3443.mainActivity_noteObject";
    public static final String NOTE_INDEX_KEY = "edu.utsa.cs3443.mainActivity_noteIndex";
    public static final String TASK_KEY = "edu.utsa.cs3443.mainActivity_taskObject";
    public static final String TASK_INDEX_KEY = "edu.utsa.cs3443.mainActivity_taskIndex";
    public static final int REQUEST_CODE = 0;
    static ArrayList<Note> noteList;
    static ArrayList<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteList = new ArrayList<>();
        refreshNoteList();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                refreshNoteList();
            }
        }
    }

    private void refreshNoteList() {
        setContentView(R.layout.activity_main);
        LinearLayout listLL = findViewById(R.id.mainLL);
        listLL.removeAllViews();

        for (int i = 0; i < noteList.size(); i++) {
            Button noteButton = new Button(this);
            noteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            noteButton.setText(noteList.get(i).getTitle());
            noteButton.setOnClickListener(new NoteButtonController(this, i));
            int finalI = i;
            noteButton.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Delete Note");
                    builder.setMessage("Are you sure you want to delete this note?");
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            noteList.remove(finalI);
                            refreshNoteList();
                        }
                    });
                    builder.setNegativeButton("Cancel", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return true;
                }
            });

            listLL.addView(noteButton);
        }

        Button newNoteButton = new Button(this);
        newNoteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newNoteButton.setText("+");
        newNoteButton.setOnClickListener(new NoteButtonController(this, -1));
        listLL.addView(newNoteButton);
    }
}