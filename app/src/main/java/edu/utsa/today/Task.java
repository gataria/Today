package edu.utsa.today;

import android.location.Location;
import java.util.Date;

public class Task {
    /*  TODO: ask Prof. Long if storing the note as a String is good,
        or if we should figure out how to use Android's local DB
        https://developer.android.com/training/data-storage/room
    */
    private String title;
    private String note;
    private Date date;
    private Location location;
    private boolean completed = false;

    /*  The user should not be able to create a new already-completed task,
        so the completed boolean variable isn't in the constructor. */
    public Task(String title, String note, Date date, Location location) {
        this.title = title;
        this.note = note;
        this.date = date;
        this.location = location;
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
     * Gets the geographic Location for a task.
     *
     * @return task's set Location
     */
    public Location getLocation() {
        return location;
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
     * Sets a user-given Location value for the task's location.
     *
     * @param location: the user-given Location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Sets a user-given boolean value for the task's completion status
     *
     * @param completed: the user-given completion status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}