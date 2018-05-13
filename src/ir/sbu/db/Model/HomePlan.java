package ir.sbu.db.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomePlan {

    public static String getPlan1(long value){
        Connection dbCon = MysqlHelper.connect();
        String plan1 = "";
        long cat = 0;
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String findCatQuery  = "SELECT * FROM User where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findCatQuery);
            preparedStatement.setLong(1, value);
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                cat = res.getLong("category");
            }
            String query = "SELECT * FROM homePlan Where id = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, cat);

            res = preparedStatement.executeQuery();
            if(res.next()){
                plan1 = res.getString("plan1");
            }
            dbCon.close();

            return plan1;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return plan1;
    }

    public static String getPlan2(long value){
        Connection dbCon = MysqlHelper.connect();
        String plan2 = "";
        long cat = 0;
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String findCatQuery  = "SELECT * FROM User where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findCatQuery);
            preparedStatement.setLong(1, value);
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                cat = res.getLong("category");
            }
            String query = "SELECT * FROM homePlan Where id = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, cat);

            res = preparedStatement.executeQuery();
            if(res.next()){
                plan2 = res.getString("plan2");
            }
            dbCon.close();

            return plan2;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return plan2;
    }

    public static String getPlan3(long value){
        Connection dbCon = MysqlHelper.connect();
        String plan3 = "";
        long cat = 0;
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String findCatQuery  = "SELECT * FROM User where id = ?";
            PreparedStatement preparedStatement = dbCon.prepareStatement(findCatQuery);
            preparedStatement.setLong(1, value);
            ResultSet res = preparedStatement.executeQuery();
            if(res.next()){
                cat = res.getLong("category");
            }
            String query = "SELECT * FROM homePlan Where id = ?";
            preparedStatement = dbCon.prepareStatement(query);
            preparedStatement.setLong(1, cat);

            res = preparedStatement.executeQuery();
            if(res.next()){
                plan3 = res.getString("plan3");
            }
            dbCon.close();

            return plan3;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return plan3;
    }
}
