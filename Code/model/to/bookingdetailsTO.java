package model.to;

/**
 *
 * @author Shubham Sethi
 */
public class bookingdetailsTO {
    private int bookingID;
    private String seatname;
    private int SrNo;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getSeatname() {
        return seatname;
    }

    public void setSeatname(String seatname) {
        this.seatname = seatname;
    }

    public int getSrNo() {
        return SrNo;
    }

    public void setSrNo(int SrNo) {
        this.SrNo = SrNo;
    }

}