package edu.utsa.today;

import android.content.Intent;
import android.view.View;

public class TaskButtonController implements View.OnClickListener {
    MainActivity mainActivity;
    int index;

    public TaskButtonController(MainActivity mainActivity, int index) {
        this.mainActivity = mainActivity;
        this.index = index;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(mainActivity, TaskActivity.class);
        intent.putExtra(MainActivity.TASK_INDEX_KEY, index);
        mainActivity.startActivityForResult(intent, MainActivity.REQUEST_CODE);
    }
}
