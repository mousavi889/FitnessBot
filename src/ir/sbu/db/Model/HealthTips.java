package ir.sbu.db.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HealthTips {

    public static String getTip(){
        Connection dbCon = MysqlHelper.connect();
        String tip ="";
        List<UserModel> userModelList = new ArrayList<UserModel>();
        try {
            String findLastIDQuery = "SELECT MAX(`id`) AS maxid FROM `healthTips`";
            PreparedStatement pr = dbCon.prepareStatement(findLastIDQuery);
            long lastID = 0;
            ResultSet resultSet = pr.executeQuery();
            if (resultSet.next()){
                lastID = resultSet.getLong("maxid");
            }
            long rand = (long)(Math.random() * lastID) + 1;
            String query = "SELECT tip FROM healthTips WHERE id = ?";
            pr = dbCon.prepareStatement(query);
            pr.setLong(1, rand);
            resultSet = pr.executeQuery();
            if (resultSet.next()){
                tip = resultSet.getString("tip");
            }
            dbCon.close();

            return tip;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return tip;
    }

}
