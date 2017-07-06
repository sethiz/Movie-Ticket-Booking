package model.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.to.bookingdetailsTO;

public class bookingdetailsDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(bookingdetailsTO data) {
        try {
            String query = "insert into bookingdetails(bookingID, seatname) values(?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getBookingID());
            stmt.setString(2, data.getSeatname());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("PRIMARY")) {
                errormessage = "This Booking ID is Already Inserted";
            }
            return false;
        }
    }

    public boolean updateRecord(bookingdetailsTO data) {
        try {
            String query = "update bookingdetails set seatname=? where bookingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getSeatname());
            stmt.setInt(2, data.getBookingID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String bookingID) {
        try {
            String query = "delete from bookingdetails where bookingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, bookingID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public bookingdetailsTO getRecord(String bookingID) {
        try {
            String query = "select bookingID, seatname from bookingdetails where bookingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, bookingID);
            bookingdetailsTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new bookingdetailsTO();
                result.setBookingID(rs.getInt("bookingID"));
                result.setSeatname(rs.getString("seatname"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<String> getAllRecord(String movieid,String screenid, Time starttime, Date showdate) {
        try {
            String query = "select bookingID, seatname from bookingdetails where bookingID in (select bookingID from bookinginfo where movieID = ? and screenID = ? and starttime = ? and showdate = ?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,movieid);
            stmt.setString(2, screenid);
            stmt.setTime(3,starttime);
            stmt.setDate(4,showdate);
            List<String> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    result.add(rs.getString("seatname"));
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }
}