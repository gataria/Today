package edu.utsa.today;

import android.location.Location;
import java.util.Date;

public class Task implements Comparable<Task> {
    private String title;
    private String note;
    private Date date;
    private boolean completed = false;

    /*  The user should not be able to create a new already-completed task,
        so the completed boolean variable isn't in the constructor. */
    public Task(String title, String note, Date date) {
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
    public Date getDate() {
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
    public void setDate(Date date) {
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
        int comp = this.date.compareTo(task.getDate());
        if (comp == 0) comp = this.title.compareTo(task.getTitle());
        if (comp == 0) comp = this.note.compareTo(task.getNote());
        if (comp == 0) comp = Boolean.compare(this.completed, task.isCompleted());
        return comp;
    }
}