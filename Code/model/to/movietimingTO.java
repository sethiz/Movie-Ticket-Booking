package model.to;

import java.sql.Time;

/**
 *
 * @author Shubham Sethi
 */
public class movietimingTO {
    private int timingID;
    private int movieID;
    private String screenID;
    private Time starttime;
    private Time endtime;
    private String moviename;
    private String screenname;

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getScreenname() {
        return screenname;
    }

    @Override
    public String toString() {
        return screenname;
    }
    
    public Time Timings(){
        return starttime;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public int getTimingID() {
        return timingID;
    }

    public void setTimingID(int timingID) {
        this.timingID = timingID;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    public Time toString(int a) {
        return starttime;
    }
}