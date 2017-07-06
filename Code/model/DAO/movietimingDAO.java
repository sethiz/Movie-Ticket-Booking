package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.to.movietimingTO;

public class movietimingDAO {

    private String errormessage;
    int movieid;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(movietimingTO data) {
        try {
            String query = "insert into movietiming(movieID, screenID, starttime,"
                    + "endtime) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getMovieID());
            stmt.setString(2, data.getScreenID());
            stmt.setTime(3, data.getStarttime());
            stmt.setTime(4, data.getEndtime());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "This screen is already assigned a movie at the same time";
            }
            return false;
        }
    }

    public boolean updateRecord(movietimingTO data) {
        try {
            String query = "update movietiming set movieID=?, screenID=?, starttime=?"
                    + ",endtime=? where timingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setInt(1, data.getMovieID());
            stmt.setString(2, data.getScreenID());
            stmt.setTime(3, data.getStarttime());
            stmt.setTime(4, data.getEndtime());
            stmt.setInt(5, data.getTimingID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "This screen is already assigned a movie at the same time";
            }
            return false;
        }
    }

    public boolean deleteRecord(String timingID) {
        try {
            String query = "delete from movietiming where timingID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, timingID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public movietimingTO getRecord(String timingID) {
        try {
            String query = "select mi.moviename,si.screenname, a.starttime,a.endtime from movietiming a "
                    + "INNER JOIN movieinfo mi ON a.movieID = mi.movieID INNER JOIN screeninfo si "
                    + "ON a.screenID = si.screenID where screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, timingID);
            movietimingTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new movietimingTO();
                result.setTimingID(rs.getInt("timingID"));
                result.setMovieID(rs.getInt("movieID"));
                result.setScreenID(rs.getString("screenID"));
                result.setScreenname(rs.getString("moviename"));
                result.setScreenname(rs.getString("screenname"));
                result.setStarttime(rs.getTime("starttime"));
                result.setEndtime(rs.getTime("endtime"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<movietimingTO> getAllRecord() {
        try {
            String query = "select a.timingID, a.movieID, a.screenID, mi.moviename,si.screenname, a.starttime,a.endtime from "
                    + "movietiming a INNER JOIN movieinfo mi ON a.movieID = mi.movieID INNER JOIN "
                    + "screeninfo si ON a.screenID = si.screenID";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<movietimingTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    movietimingTO res = new movietimingTO();
                    res.setTimingID(rs.getInt("timingID"));
                    res.setMovieID(rs.getInt("movieID"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setMoviename(rs.getString("moviename"));
                    res.setScreenname(rs.getString("screenname"));
                    res.setStarttime(rs.getTime("starttime"));
                    res.setEndtime(rs.getTime("endtime"));
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

    public List<movietimingTO> getCurrentRecord(String movieID, Time timing) {
        try {
            String query = "select mt.timingid, mt.movieid, mt.screenid, si.screenname from movietiming mt "
                    + "inner join screeninfo si on mt.screenid = si.screenid where mt.movieid = ? and mt.starttime = ? order by screenname";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, movieID);
            stmt.setTime(2,timing);
            List<movietimingTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    movietimingTO res = new movietimingTO();
                    res.setTimingID(rs.getInt("timingID"));
                    res.setMovieID(rs.getInt("movieID"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setScreenname(rs.getString("screenname"));
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

    public List<movietimingTO> getCurrentTimes(String movieID) {
        try {
            String query = "select timingID, movieID, screenID, starttime from movietiming where movieid = ? order by starttime";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, movieID);
            List<movietimingTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    movietimingTO res = new movietimingTO();
                    res.setTimingID(rs.getInt("timingID"));
                    res.setMovieID(rs.getInt("movieID"));
                    res.setScreenID(rs.getString("screenID"));
                    res.setStarttime(rs.getTime("starttime"));
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
