package edu.utsa.today;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Collections;
import java.util.Date;

public class TaskSaveButtonController implements View.OnClickListener {
    Activity activity;
    EditText userTitleBox;
    EditText userNoteBox;
    Button userDateSelector;
    Button userTimeSelector;
    CheckBox userCompletionCheckbox;
    int taskIndex;

    public TaskSaveButtonController(Activity activity, EditText userTitleBox, EditText userNoteBox, Button userDateSelector, Button userTimeSelector, CheckBox userCompletionCheckbox, int taskIndex) {
        this.activity = activity;
        this.userTitleBox = userTitleBox;
        this.userNoteBox = userNoteBox;
        this.userDateSelector = userDateSelector;
        this.userTimeSelector = userTimeSelector;
        this.userCompletionCheckbox = userCompletionCheckbox;
        this.taskIndex = taskIndex;
    }

    public void onClick(View view) {

        Task task;
        String userTitle = userTitleBox.getText().toString();
        String userNote = userNoteBox.getText().toString();
        Date userDueDate /*= userDateSelector.getDate(however you do that)*/= new Date();
        boolean userCompletion /*= userCompletionCheckbox.getCheckmarkStatus(however you do that)*/= false;
        if (taskIndex == -1) { //if new task
            /*
            if (userTitle.equals("") &&
                userNote.equals("") &&
                userDueDate.equals( [what does no selection in a date selector look like? is it equal to "new Date()", "new Date(0)", or something else?] ) &&
                userCompletion == false) { //if task is empty, cancel activity
                activity.setResult(Activity.RESULT_CANCELED);
                activity.finish();
            }
            else { //if task is not empty, add new task to taskList and sort.
                task = new Task(userTitle, userContent, userDueDate));
                if (userTitle.equals("")) task.setTitle("Untitled Task");
                MainActivity.taskList.add(task);
                Collections.sort(MainActivity.taskList);
                activity.setResult(Activity.RESULT_OK);
                activity.finish();
            }*/
        }
        else if (taskIndex >= 0 && taskIndex < MainActivity.taskList.size()) { //if taskIndex is in range of taskList
            task = MainActivity.taskList.get(taskIndex);
            Task userTask = new Task(userTitle, userNote, userDueDate);
            userTask.setCompleted(userCompletion);
            if (task.compareTo(userTask) == 0) { //if task wasn't changed, cancel activity (with no-change toast)
                Toast noUpdateToast = Toast.makeText(view.getContext(), "No changes made.\nTask has not been updated.", Toast.LENGTH_SHORT);
                noUpdateToast.show();
                activity.setResult(Activity.RESULT_CANCELED);
                activity.finish();
            }
            else {
                if (userTask.getTitle().equals("")) userTask.setTitle("Untitled Task");
                MainActivity.taskList.set(taskIndex, userTask);
                Collections.sort(MainActivity.taskList);
                activity.setResult(Activity.RESULT_OK);
                activity.finish();
            }
        }


    }
}
