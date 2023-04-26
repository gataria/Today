package edu.utsa.today;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class SaveButtonController implements View.OnClickListener {
    Activity activity;
    EditText userTitleBox;
    EditText userContentBox;
    int noteIndex;

    public SaveButtonController (Activity activity, EditText userTitleBox, EditText userContentBox, int noteIndex) {
        this.activity = activity;
        this.userTitleBox = userTitleBox;
        this.userContentBox = userContentBox;
        this.noteIndex = noteIndex;
    }

    public void onClick(View view) {

        Note note;
        String userTitle = userTitleBox.getText().toString();
        String userContent = userContentBox.getText().toString();
        Date currentTime = Calendar.getInstance().getTime();
        if (noteIndex == -1) { //if new note
            if (!(userTitle.equals("") && userContent.equals(""))){ //if note not empty, add new note to top
                note = new Note(userTitle, userContent, currentTime, currentTime);
                if (userTitle.equals("")) note.setTitle("Untitled Note");
                MainActivity.noteList.add(0, note);
                activity.setResult(Activity.RESULT_OK);
                activity.finish();
            }
            else { //if note is empty, cancel activity
                activity.setResult(Activity.RESULT_CANCELED);
                activity.finish();
            }
        }
        else if (noteIndex >= 0 && noteIndex < MainActivity.noteList.size()) { //if noteIndex is in range of noteList
            note = MainActivity.noteList.get(noteIndex);
            if (note.getTitle().equals(userTitle) && note.getContent().equals(userContent)) { //if note wasn't changed, cancel activity (with no-change toast)
                Toast noUpdateToast = Toast.makeText(view.getContext(), "No changes made.\nNote has not been updated.", Toast.LENGTH_SHORT);
                noUpdateToast.show();
                activity.setResult(Activity.RESULT_CANCELED);
                activity.finish();
            }
            else {
                if (userTitle.equals("")) note.setTitle("Untitled Note");
                else note.setTitle(userTitle);
                note.setContent(userContent);
                note.setLastUpdate(currentTime);

                MainActivity.noteList.remove(noteIndex);
                MainActivity.noteList.add(0, note);

                activity.setResult(Activity.RESULT_OK);
                activity.finish();
            }
        }
    }
}
