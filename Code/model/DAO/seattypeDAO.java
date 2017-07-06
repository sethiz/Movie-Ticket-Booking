package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.to.seattypeTO;

public class seattypeDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(seattypeTO data) {
        try {
            String query = "insert into seattype(typename,charges) values(?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getTypename());
            stmt.setInt(2, data.getCharges());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "This Type Name is Already Inserted";
            }
            return false;
        }
    }

    public boolean updateRecord(seattypeTO data) {
        try {
            String query = "update seattype set typename=?, charges=? where typeID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getTypename());
            stmt.setInt(2, data.getCharges());
            stmt.setInt(3, data.getTypeID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String typeID) {
        try {
            String query = "delete from seattype where typeID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, typeID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("foreign")) {
                errormessage = "This Seat Type is currently in use.";
            }
            return false;
        }
    }

    public seattypeTO getRecord(String typeID) {
        try {
            String query = "select typeID , typename , charges from seattype where typeID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, typeID);
            seattypeTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new seattypeTO();
                result.setTypeID(rs.getInt("typeID"));
                result.setTypename(rs.getString("typename"));
                result.setCharges(rs.getInt("charges"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<seattypeTO> getAllRecord() {
        try {
            String query = "select typeID , typename , charges from seattype";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<seattypeTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    seattypeTO res = new seattypeTO();
                    res.setTypeID(rs.getInt("typeID"));
                    res.setTypename(rs.getString("typename"));
                    res.setCharges(rs.getInt("charges"));
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