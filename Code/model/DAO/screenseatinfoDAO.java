package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.to.screenseatinfoTO;

public class screenseatinfoDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(screenseatinfoTO data) {
        try {
            String query = "insert into screenseatinfo(seatname,screenID,typeID) values(?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getSeatname());
            stmt.setString(2, data.getScreenID());
            stmt.setInt(3, data.getTypeID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "This Seat is Already Added in this Screen";
            }
            return false;
        }
    }

    public boolean updateRecord(screenseatinfoTO data) {
        try {
            String query = "update screenseatinfo set seatname=?,screenID=?, typeID=? where srNo = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getSeatname());
            stmt.setString(2, data.getScreenID());
            stmt.setInt(3, data.getTypeID());
            stmt.setInt(4, data.getSrNo());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String srNo) {
        try {
            String query = "delete from screenseatinfo where srNo = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, srNo);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public screenseatinfoTO getRecord(String srNo) {
        try {
            String query = "SELECT a.seatname, d.screenname, c.typename FROM screenseatinfo a "
                    + "INNER JOIN seattype c ON a.typeID = c.typeID INNER JOIN screeninfo d "
                    + "ON d.screenID = a.screenID where srNo = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, srNo);
            screenseatinfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new screenseatinfoTO();
                result.setSrNo(rs.getInt("srNo"));
                result.setSeatname(rs.getString("seatnname"));
                result.setScreenname(rs.getString("screenname"));
                result.setSeattype(rs.getString("seattype"));
                result.setScreenID(rs.getString("screenID"));
                result.setTypeID(rs.getInt("typeID"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<screenseatinfoTO> getAllRecord() {
        try {
            String query = "select a.seatname, d.screenname, c.typename, a.srNo, a.screenID, a.typeID from"
                    + " screenseatinfo a inner join seattype c on a.typeID = c.typeID inner join "
                    + "screeninfo d on d.screenID = a.screenID";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<screenseatinfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    screenseatinfoTO res = new screenseatinfoTO();
                    res.setSeatname(rs.getString("seatname"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setSeattype(rs.getString("typename"));
                    res.setSrNo(rs.getInt("srNo"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setTypeID(rs.getInt("typeID"));
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
    
    public List<screenseatinfoTO> getRecords(String screenid) {
        try {
            String query = "select ssi.seatname,ssi.screenID, ssi.typeID,st.charges from screenseatinfo ssi inner join seattype st on ssi.typeID = st.typeID  where screenid = ? order by charges desc";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, screenid);
            List<screenseatinfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    screenseatinfoTO res = new screenseatinfoTO();
                    res.setSeatname(rs.getString("seatname"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setTypeID(rs.getInt("typeID"));
                    res.setCharge(rs.getInt("charges"));
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
    public int getPrice(String screenid, String seatname) {
        try {
            String query = "select st.charges from screenseatinfo ssi inner join seattype st on ssi.typeID = st.typeID where seatname = ? and screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, seatname);
            stmt.setString(2, screenid);
            int result=0;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                do {
                    result = rs.getInt("charges");
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return 0;
        }
    }
}
