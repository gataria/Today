package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

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
        saveButton.setOnClickListener(new NoteSaveButtonController(this, titleBox, contentBox, noteIndex));
    }
}