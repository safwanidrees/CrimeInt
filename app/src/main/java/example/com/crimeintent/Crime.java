package example.com.crimeintent;


import java.util.Date;
import java.util.UUID;

public class Crime {

    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private UUID mId;

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }


    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }


}

