package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.to.LoginInfoTO;

public class LoginInfoDAO {
    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }
    
    public LoginInfoTO getRecord(String username){
        try{
            String query = "select username , password , rolename , lastlogin from logininfo where username = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,username);
            LoginInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = new LoginInfoTO();
                result.setUsername(rs.getString("username"));
                result.setPassword(rs.getString("password"));
                result.setRolename(rs.getString("rolename"));
                result.setLastlogin(rs.getTimestamp("lastlogin"));
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage = ex.toString();
            return null;
        }
    }
    
    public boolean updateLastLogin(String username){
        try{
            String query = "update logininfo set lastlogin = sysdate() where username = ?";
            PreparedStatement stmt = DataConnection.getConnection().prepareStatement(query);
            stmt.setString(1,username);
            boolean result = stmt.executeUpdate()>0;
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage = ex.toString();
            return false;
        }
    }
}