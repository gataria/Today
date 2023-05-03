package edu.utsa.today;

import android.location.Location;

import java.util.Calendar;
import java.util.Date;

public class Task implements Comparable<Task> {
    private String title;
    private String note;
    private Calendar date;
    private boolean completed = false;

    /*  The user should not be able to create a new already-completed task,
        so the completed boolean variable isn't in the constructor. */
    public Task(String title, String note, Calendar date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    /* GETTERS */
    /**
     * Gets the String title of a Task.
     *
     * @return title String
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the String note of a Task.
     *
     * @return note String
     */
    public String getNote() {
        return note;
    }

    /**
     * Gets the due Date for a task.
     *
     * @return task's due Date
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Gets the completion status for a task.
     *
     * @return task completion boolean
     */
    public boolean isCompleted() {
        return completed;
    }

    /* SETTERS */
    /**
     * Sets a user-given String value for the task's title.
     *
     * @param title: the user-given title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets a user-given String value for the task's note.
     *
     * @param note: the user-given note String
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Sets a user-given Date value for the task's date.
     *
     * @param date: the user-given Date
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Sets a user-given boolean value for the task's completion status
     *
     * @param completed: the user-given completion status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(Task task) {
        int comp = task.getDate().get(Calendar.YEAR) - this.date.get(Calendar.YEAR);
        if (comp == 0) comp = task.getDate().get(Calendar.MONTH) - this.date.get(Calendar.MONTH);
        if (comp == 0) comp = task.getDate().get(Calendar.DAY_OF_MONTH) - this.date.get(Calendar.DAY_OF_MONTH);
        if (comp == 0) comp = task.getDate().get(Calendar.HOUR_OF_DAY) - this.date.get(Calendar.HOUR_OF_DAY);
        if (comp == 0) comp = task.getDate().get(Calendar.MINUTE) - this.date.get(Calendar.MINUTE);
        if (comp == 0) comp = this.title.compareTo(task.getTitle());
        if (comp == 0) comp = this.note.compareTo(task.getNote());
        if (comp == 0) comp = Boolean.compare(this.completed, task.isCompleted());
        return comp;
    }

    public static Task clone(Task originTask) {
        Task cloneTask = new Task(
                originTask.getTitle(),
                originTask.getNote(),
                (Calendar)(originTask.getDate()).clone()
        );
        cloneTask.setCompleted(originTask.isCompleted());
        return cloneTask;
    }
}