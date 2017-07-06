package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.to.bookinginfoTO;

public class bookinginfoDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(bookinginfoTO data) {
        try {
            String query = "insert into bookinginfo(movieID, screenID, starttime,bookingdate,showdate) values(?,?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getMovieID());
            stmt.setString(2, data.getScreenID());
            stmt.setTime(3, data.getStarttime());
            //stmt.setTime(4, data.getEndtime());
            stmt.setTimestamp(4, data.getBookingdate());
            stmt.setDate(5, data.getShowdate());
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

    public int  getBookingID() {
        try {
            String query = "select last_insert_id()";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);            
            int result = 0;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = rs.getInt(1);
            }
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("PRIMARY")) {
                errormessage = "This Booking ID is Already Inserted";
            }
            return 0;
        }
    }

    
    public boolean updateRecord(bookinginfoTO data) {
        try {
            String query = "update bookinginfo set movieID=?, screenID=?, starttime=?"
                    + ",endtime=?,bookingdate=?,showdate=? where bookingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getMovieID());
            stmt.setString(2, data.getScreenID());
            stmt.setTime(3, data.getStarttime());
            stmt.setTime(4, data.getEndtime());
            stmt.setTimestamp(5, data.getBookingdate());
            stmt.setDate(6, data.getShowdate());
            stmt.setInt(7, data.getBookingID());
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
            String query = "delete from bookinginfo where bookingID = ?";
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

    public bookinginfoTO getRecord(String bookingID) {
        try {
            String query = "select bookingID, movieID , screenID , starttime, endtime,bookingdate,"
                    + "showdate from bookinginfo where bookingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, bookingID);
            bookinginfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new bookinginfoTO();
                result.setBookingID(rs.getInt("bookingID"));
                result.setMovieID(rs.getInt("movieID"));
                result.setScreenID(rs.getString("screenID"));
                result.setStarttime(rs.getTime("starttime"));
                result.setEndtime(rs.getTime("endtime"));
                result.setBookingdate(rs.getTimestamp("bookingdate"));
                result.setShowdate(rs.getDate("showdate"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<bookinginfoTO> getAllRecord() {
        try {
            String query = "select bookingID, movieID , screenID , starttime, endtime,bookingdate,showdate from bookinginfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<bookinginfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    bookinginfoTO res = new bookinginfoTO();
                    res.setBookingID(rs.getInt("bookingID"));
                    res.setMovieID(rs.getInt("movieID"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
                    res.setBookingdate(rs.getTimestamp("bookingdate"));
                    res.setShowdate(rs.getDate("showdate"));
                    result.add(res);
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
