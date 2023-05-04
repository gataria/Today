package edu.utsa.today;

import android.app.Activity;
import android.view.View;

public class CancelButtonController implements View.OnClickListener {

    Activity activity;

    public CancelButtonController (Activity activity) {
        this.activity = activity;
    }

    public void onClick(View view) {
        activity.setResult(Activity.RESULT_CANCELED);
        activity.finish();
    }
}
