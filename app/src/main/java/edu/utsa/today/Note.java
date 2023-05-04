package edu.utsa.today;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private String title;
    private String content;
    private Date createDate;
    private Date lastUpdate;
    /* lastUpdate may or may not be used, depending on
        whether I can figure out how to compare if changes were made
        while in NoteView.
     */

    /**
     * Note object constructor, requiring all fields
     * @param title The note's title
     * @param content The note's contents
     * @param createDate The Date that the note was created
     * @param lastUpdate The Date that the note was last updated
     */
    public Note (String title, String content, Date createDate, Date lastUpdate) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdate = lastUpdate;
    }


    //Getters and Setters

    /**
     * Provides the Note's title
     * @return The note's title as a String
     */
    public String getTitle () {
        return title;
    }

    /**
     * Sets the Note's title
     * @param title The title of the Note to be set
     */
    public void setTitle (String title) {
        this.title = title;
    }

    /**
     * Provides the Note's contents
     * @return The Note's contents as a String
     */
    public String getContent () {
        return content;
    }

    /**
     * Sets the Note's contents
     * @param content The contents of the Note to be set
     */
    public void setContent (String content) {
        this.content = content;
    }

    /**
     * Provides the Date of the Note's creation
     * @return The Note's createDate as a Date object
     */
    public Date getCreateDate () {
        return createDate;
    }

    /** Sets the Date of the Note's creation
     * @param createDate The createDate of the Note to be set
     */
    public void setCreateDate (Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Provides the Date of the Note's last update
     * @return The Note's last update as a Date object
     */
    public Date getLastUpdate () {
        return lastUpdate;
    }

    /**
     * Sets the Date of the Note's last update
     * @param lastUpdate The Note's last update as a Date object
     */
    public void setLastUpdate (Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    //Parcelable stuff

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        createDate = (Date) in.readSerializable();
        lastUpdate = (Date) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeSerializable(createDate);
        dest.writeSerializable(lastUpdate);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

}