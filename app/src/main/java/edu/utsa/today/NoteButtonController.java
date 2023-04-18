package edu.utsa.today;

import android.content.Intent;
import android.view.View;

import androidx.activity.result.contract.ActivityResultContracts;

public class NoteButtonController implements View.OnClickListener {
    Note note;
    MainActivity mainActivity;

    public NoteButtonController(MainActivity mainActivity, Note note) {
        this.note = note;
        this.mainActivity = mainActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, NoteActivity.class);
        intent.putExtra(MainActivity.NOTE_KEY, note);
        mainActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
    }
}
