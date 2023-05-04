package edu.utsa.today;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

public class TaskButtonController {
    MainActivity mainActivity;
    int index;

    public TaskButtonController(MainActivity mainActivity, int index) {
        this.mainActivity = mainActivity;
        this.index = index;
    }

    public class TaskButtonAccessController implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mainActivity, TaskActivity.class);
            intent.putExtra(MainActivity.TASK_INDEX_KEY, index);
            mainActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
        }
    }

    public class TaskButtonDeleteController implements View.OnLongClickListener, DialogInterface.OnClickListener {
        @Override
        public boolean onLongClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder( mainActivity );
            builder.setTitle("Delete Task");
            builder.setMessage("Are you sure you want to delete this task?");
            builder.setPositiveButton("Delete", this );
            builder.setNegativeButton("Cancel", null );
            AlertDialog dialog = builder.create();
            dialog.show();
            return true;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            MainActivity.taskList.remove(index);
            mainActivity.refreshTaskList();
        }
    }
}
