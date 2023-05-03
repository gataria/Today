package edu.utsa.today;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;

public class TaskDateSelectorController extends DialogFragment
                                        implements DatePickerDialog.OnDateSetListener, View.OnClickListener {

    public TaskDateSelectorController() {}

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int year = TaskActivity.savedDate.get(Calendar.YEAR);
        int month = TaskActivity.savedDate.get(Calendar.MONTH);
        int day = TaskActivity.savedDate.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        TaskActivity.savedDate.set(Calendar.YEAR, year);
        TaskActivity.savedDate.set(Calendar.MONTH, month);
        TaskActivity.savedDate.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void onClick(View view) {
        this.show(getActivity().getSupportFragmentManager(), "datePicker");
    }
}
