package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String NOTE_KEY = "edu.utsa.cs3443.mainActivity_noteObject";
    public static final String NOTE_INDEX_KEY = "edu.utsa.cs3443.mainActivity_noteIndex";
    public static final int REQUEST_CODE = 0;
    static ArrayList<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLL = findViewById(R.id.mainLL);
        noteList = new ArrayList<>();
        noteList.add(new Note("Test Note", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", new Date(0), new Date(0)));

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
            noteButton.setOnClickListener(new NoteButtonController(this, noteList.get(i), i));

            listLL.addView(noteButton);
        }

        Button newNoteButton = new Button(this);
        newNoteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newNoteButton.setText("+");
        newNoteButton.setOnClickListener(new NoteButtonController(this, new Note("", "", new Date(0), new Date(0)), -1));
        listLL.addView(newNoteButton);
    }
}