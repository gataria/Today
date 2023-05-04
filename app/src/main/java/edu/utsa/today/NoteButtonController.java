package edu.utsa.today;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;

public class NoteButtonController {
    MainActivity mainActivity;
    int index;

    public NoteButtonController(MainActivity mainActivity, int index) {
        this.mainActivity = mainActivity;
        this.index = index;
    }

    public class NoteButtonAccessController implements View.OnClickListener {
        public void onClick(View view) {
            Intent intent = new Intent(mainActivity, NoteActivity.class);
            intent.putExtra(MainActivity.NOTE_INDEX_KEY, index);
            mainActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
        }
    }

    public class NoteButtonDeleteController implements View.OnLongClickListener, DialogInterface.OnClickListener {
        @Override
        public boolean onLongClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity );
            builder.setTitle("Delete Note");
            builder.setMessage("Are you sure you want to delete this note?");
            builder.setPositiveButton("Delete", this );
            builder.setNegativeButton("Cancel", null );
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity.noteList.remove(index);
            mainActivity.refreshNoteList();
        }
    }
}
