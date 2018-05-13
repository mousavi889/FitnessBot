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
            String query = "INSERT INTO `User` (`id`, `weight`, `height`, `age`, `gender`, `bloodType`, `state`, `category`, `email` , `aliasName` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, userModel.getId());
            preparedStatement.setLong(2, userModel.getWeight());
            preparedStatement.setLong(3, userModel.getHeight());
            preparedStatement.setLong(4, userModel.getAge());
            preparedStatement.setString(5, userModel.getGender());
            preparedStatement.setString(6, userModel.getBloodType());
            preparedStatement.setString(7, userModel.getState());
            preparedStatement.setLong(8, userModel.getCategory());
            preparedStatement.setString(9, userModel.getEmail());
            preparedStatement.setString(10, userModel.getAliasName());


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

    public static Boolean updateColumnGender( String colValue, long id){
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try{
            String query = "UPDATE User SET gender=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setString(1, colValue);
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
                                   //long id, long weight, long height, long age, String gender, String state, long category
            while (result.next()) {
                userModelList.add(new UserModel(result.getLong("id"), result.getLong("weight"), result.getLong("height"), result.getLong("age"), result.getString("gender"), result.getString("bloodType"), result.getString("state"),  result.getLong("height"), result.getString("aliasname"), result.getString("email")));
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

    public static Boolean updateColumnAge( long colValue, long id) {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "UPDATE User SET age=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setLong(1, colValue);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate() > 0);
            dbCon.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean updateColumnWeight( long colValue, long id) {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "UPDATE User SET weight=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setLong(1, colValue);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate() > 0);
            dbCon.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean updateColumnHeight( long colValue, long id) {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "UPDATE User SET height=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setLong(1, colValue);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate() > 0);
            dbCon.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean updateColumnBloodType(String bloodType, long id) {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "UPDATE User SET bloodType=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setString(1, bloodType);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate() > 0);
            dbCon.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Boolean updateColumnCategory(long category, long id) {
        Connection dbCon = MysqlHelper.connect();
        Boolean result = false;
        try {
            String query = "UPDATE User SET category=? WHERE id=?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);

            preparedStatement.setLong(1, category);
            preparedStatement.setLong(2, id);

            result = (preparedStatement.executeUpdate() > 0);
            dbCon.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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

    public static long getWeight(long value){
        Connection dbCon = MysqlHelper.connect();
        long weight = 0;
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String query = "SELECT * FROM User Where  id = ?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, value);

            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                weight = res.getLong("weight");
            }
            dbCon.close();

            return weight;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return weight;
    }

    public static long getHeight(long value){
        Connection dbCon = MysqlHelper.connect();
        long weight = 0;
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String query = "SELECT * FROM User Where  id = ?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, value);

            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                weight = res.getLong("height");
            }
            dbCon.close();

            return weight;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return weight;
    }

    public static String getGender(long value){
        Connection dbCon = MysqlHelper.connect();
        String state = "";
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String query = "SELECT * FROM User Where  id = ?";

            PreparedStatement preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, value);

            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                state = res.getString("gender").toString();
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
