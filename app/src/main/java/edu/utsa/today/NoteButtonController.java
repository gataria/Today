package edu.utsa.today;

import android.content.Intent;
import android.view.View;

import androidx.activity.result.contract.ActivityResultContracts;

public class NoteButtonController implements View.OnClickListener {
    Note note;
    MainActivity mainActivity;
    int index;

    public NoteButtonController(MainActivity mainActivity, int index) {
        this.mainActivity = mainActivity;
        this.index = index;
    }

    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, NoteActivity.class);
        intent.putExtra(MainActivity.NOTE_KEY, note);
        intent.putExtra(MainActivity.NOTE_INDEX_KEY, index);
        mainActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
    }
}
