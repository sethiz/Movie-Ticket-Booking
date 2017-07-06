package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.to.movieinfoTO;

public class movieinfoDAO {

    private String errormessage;

    public String getErrormessgae() {
        return errormessage;
    }

    public boolean insertRecord(movieinfoTO data) {
        try {
            String query = "insert into movieinfo(moviename,description,releasedate,enddate) values(?,?,?,?)";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getMoviename());
            stmt.setString(2, data.getDescription());
            stmt.setDate(3, data.getReleasedate());
            stmt.setDate(4, data.getEnddate());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("Duplicate")) {
                errormessage = "A movie with same desciption is already inserted.";
            }
            return false;
        }
    }

    public boolean updateRecord(movieinfoTO data) {
        try {
            String query = "update movieinfo set moviename=?, description=?, releasedate=?"
                    + ",enddate=? where movieID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, data.getMoviename());
            stmt.setString(2, data.getDescription());
            stmt.setDate(3, data.getReleasedate());
            stmt.setDate(4, data.getEnddate());
            stmt.setInt(5, data.getMovieID());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return false;
        }
    }

    public boolean deleteRecord(String movieID) {
        try {
            String query = "delete from movieinfo where movieID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, movieID);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            if (errormessage.contains("foreign")) {
                errormessage = "This Movie is currently in use.";
            }
            return false;
        }
    }

    public movieinfoTO getRecord(String movieID) {
        try {
            String query = "select movieID , moviename , description, releasedate,"
                    + "enddate from screeninfo where screenID = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1, movieID);
            movieinfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new movieinfoTO();
                result.setMovieID(rs.getInt("movieID"));
                result.setMoviename(rs.getString("moviename"));
                result.setDescription(rs.getString("description"));
                result.setReleasedate(rs.getDate("releasedate"));
                result.setEnddate(rs.getDate("enddate"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            return null;
        }
    }

    public List<movieinfoTO> getAllRecord() {
        try {
            String query = "select movieID , moviename , description, releasedate, enddate from movieinfo";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<movieinfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    movieinfoTO res = new movieinfoTO();
                    res.setMovieID(rs.getInt("movieID"));
                    res.setMoviename(rs.getString("moviename"));
                    res.setDescription(rs.getString("description"));
                    res.setReleasedate(rs.getDate("releasedate"));
                    res.setEnddate(rs.getDate("enddate"));
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
    
    public List<movieinfoTO> getCurrentRecord() {
        try {
            String query = "select movieid,moviename,description,releasedate,enddate from movieinfo where curdate() <= enddate";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            List<movieinfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    movieinfoTO res = new movieinfoTO();
                    res.setMovieID(rs.getInt("movieID"));
                    res.setMoviename(rs.getString("moviename"));
                    res.setDescription(rs.getString("description"));
                    res.setReleasedate(rs.getDate("releasedate"));
                    res.setEnddate(rs.getDate("enddate"));
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