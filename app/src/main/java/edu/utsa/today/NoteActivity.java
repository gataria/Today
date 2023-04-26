package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    public static final String SAVED_NOTE_KEY = "edu.utsa.cs3443.noteActivity_savedNote";
    public static final String SAVED_NOTE_INDEX_KEY = "edu.utsa.cs3443.noteActivity_savedNoteIndex";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        EditText titleBox = findViewById(R.id.titleBox);
        EditText contentBox = findViewById(R.id.contentBox);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button saveButton = findViewById(R.id.saveButton);

        int noteIndex = getIntent().getIntExtra(MainActivity.NOTE_INDEX_KEY, -1);
        if (noteIndex == -1) {
            titleBox.setText("");
            contentBox.setText("");
        }
        else {
            titleBox.setText(MainActivity.noteList.get(noteIndex).getTitle());
            contentBox.setText(MainActivity.noteList.get(noteIndex).getContent());
        }

        cancelButton.setOnClickListener(new CancelButtonController(this));
        saveButton.setOnClickListener(new SaveButtonController(this, titleBox, contentBox, noteIndex));
    }
}