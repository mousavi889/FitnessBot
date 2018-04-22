package ir.sbu.db.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class User {

    public static Boolean insert(UserModel userModel){
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "INSERT INTO `User` (`id`,`aliasName`, `state`, `email`) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, userModel.getId());
            preparedStatement.setString(2, userModel.getAliasName());
            preparedStatement.setString(3, userModel.getState());
            preparedStatement.setString(4, userModel.getEmail());

            result = preparedStatement.execute();
            dbCon.close();

            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean update(UserModel userModel, String findaliasName){
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try{
            String query = "UPDATE User SET aliasName=?, state=?, email=? WHERE aliasName=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setString(1, userModel.getAliasName());
            preparedStatement.setString(2, userModel.getState());
            preparedStatement.setString(3, userModel.getEmail());
            preparedStatement.setString(4, findaliasName);

            result = (preparedStatement.executeUpdate()>0);
            dbCon.close();
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean remove(String findaliasName){
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;

        try{
            String query = "DELETE FROM User WHERE aliasName=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setString(1, findaliasName);

            result = (preparedStatement.executeUpdate()>0);
            dbCon.close();
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public static List<UserModel> getAll(){
        Connection dbCon = MysqlHelper.connect();
        ResultSet result = null;
        List<UserModel> userModelList = new ArrayList<UserModel>();

        try {
            String query = "SELECT * FROM User";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            result = preparedStatement.executeQuery(query);

            while (result.next()) {
                userModelList.add(new UserModel(result.getLong("id"), result.getString("aliasName"), result.getString("state"), result.getString("email")));
            }

            result.close();
            dbCon.close();
            return userModelList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return userModelList;
    }


    public static String getState(long value){
        Connection dbCon = MysqlHelper.connect();
        String state = "";

        List<UserModel> userModelList = new ArrayList<UserModel>();

        try {
            String query = "SELECT * FROM User Where  id = ?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, value);

            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                state = res.getString("state").toString();
            }
            dbCon.close();

            return state;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return state;
    }

    public static Boolean isExist(String field, long value){
        Connection dbCon = MysqlHelper.connect();
        boolean result = false;

        List<UserModel> userModelList = new ArrayList<UserModel>();

        try {
            String query = "SELECT * FROM User Where " + field + "= ?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, value);

            ResultSet res = preparedStatement.executeQuery();
            result = res.next();

            dbCon.close();
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public static Boolean updateState(long id, String newState){
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try{
            String query = "UPDATE User SET state=?  WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setString(1, newState);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate()>0);
            dbCon.close();
            return result;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }


}
