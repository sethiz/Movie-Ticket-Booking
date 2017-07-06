package model.to;

/**
 *
 * @author Shubham Sethi
 */
public class screenseatinfoTO {

    private int srNo;
    private String seatname;
    private String screenID;
    private int typeID;
    private String seattype;
    private String screenname;
    private int charge;

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getSeattype() {
        return seattype;
    }

    @Override
    public String toString() {
        return seatname;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getSeatname() {
        return seatname;
    }

    public void setSeatname(String seatname) {
        this.seatname = seatname;
    }

    public String getScreenID() {
        return screenID;
    }

    public void setScreenID(String screenID) {
        this.screenID = screenID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
}
