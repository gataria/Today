package edu.utsa.today;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout noteListLL = findViewById(R.id.noteList);

        ArrayList<Note> noteList = new ArrayList<>();
        noteList.add(new Note("Test Note", "This is a test note. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", new Date(0), new Date(0)));

        refreshNoteListLL(noteListLL, noteList);
    }

    protected void refreshNoteListLL(LinearLayout noteListLL, ArrayList<Note> noteList) {

        //noteListLL.removeAllViews();
        //TODO: Something's fucked with how I built the note list below. The sample list (found in activity_main.xml and cleared with the above line) looks how I want, but the stuff below doesn't.

        //TODO: The "New Note Button" will need an onClickListener to send us to NoteActivity to create a new note
        LinearLayout newNoteButton = new LinearLayout(this);
        TextView newNoteText = new TextView(this);

        newNoteText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        newNoteText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        newNoteText.setText("+");

        newNoteButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        newNoteButton.setOrientation(LinearLayout.VERTICAL);
        newNoteButton.setGravity(View.TEXT_ALIGNMENT_CENTER);
        newNoteButton.setBackgroundColor(Color.LTGRAY);

        newNoteButton.addView(newNoteText);
        noteListLL.addView(newNoteButton);

        for (int i = 0; i < noteList.size(); i++) {
            //TODO: "Note Entries" will need an onClickListener to send us to NoteActivity with the text boxes prepopulated with the note's contents to edit
            LinearLayout noteEntry = new LinearLayout(this);
            TextView noteTitle = new TextView(this);
            TextView noteBody = new TextView(this);

            noteTitle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 50));
            noteTitle.setPadding(0, 0, 0, 0);
            noteTitle.setAutoSizeTextTypeUniformWithConfiguration(10, 25, 1, TypedValue.COMPLEX_UNIT_SP);
            noteTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            noteTitle.setSingleLine(true);
            noteTitle.setText(noteList.get(i).getTitle());

            noteBody.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
            noteBody.setPadding(0, 0, 0, 0);
            noteBody.setAutoSizeTextTypeUniformWithConfiguration(10, 25, 1, TypedValue.COMPLEX_UNIT_SP);

            noteEntry.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
            noteEntry.setOrientation(LinearLayout.VERTICAL);
            if (i % 2 == 0) { noteEntry.setBackgroundColor(Color.BLUE); }
            else { noteEntry.setBackgroundColor(Color.CYAN); }

            noteEntry.addView(noteTitle);
            noteEntry.addView(noteBody);
            noteListLL.addView(noteEntry, 0);
        }
    }
}