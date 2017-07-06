package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.to.screeninfoTO;

public class screeninfoDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(screeninfoTO data) {
        try {
            String query = "insert into screeninfo(screenID,screenname,totalseats) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getScreenID());
            stmt.setString(2, data.getScreenname());
            stmt.setInt(3, data.getTotalseats());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "This Seat is Already Inserted in this Screen";
            }
            return false;
        }
    }

    public boolean updateRecord(screeninfoTO data) {
        try {
            String query = "update screeninfo set screenname=?, totalseats=? where screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getScreenname());
            stmt.setInt(2, data.getTotalseats());
            stmt.setString(3, data.getScreenID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String screenID) {
        try {
            String query = "delete from screeninfo where screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, screenID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("foreign")) {
                errormessage = "This Screen is currently in use.";
            }
            return false;
        }
    }

    public screeninfoTO getRecord(String screenID) {
        try {
            String query = "select screenID , screenname , totalseats from screeninfo where screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, screenID);
            screeninfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new screeninfoTO();
                result.setScreenID(rs.getString("screenID"));
                result.setScreenname(rs.getString("screenname"));
                result.setTotalseats(rs.getInt("totalseats"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<screeninfoTO> getAllRecord() {
        try {
            String query = "select screenID , screenname , totalseats from screeninfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<screeninfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    screeninfoTO res = new screeninfoTO();
                    res.setScreenID(rs.getString("screenID"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setTotalseats(rs.getInt("totalseats"));
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