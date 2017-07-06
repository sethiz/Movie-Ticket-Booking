package model.to;

/**
 *
 * @author Shubham Sethi
 */
public class screeninfoTO {
    private String screenID;
    private String screenname;
    private int totalseats;    

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    @Override
    public String toString() {
        return screenname;
    }

    
}
