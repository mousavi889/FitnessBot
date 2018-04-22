package ir.sbu.db.Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlHelper {

    public static Connection connect(){
        Connection dbCon = null;

        try
        {
            String username ="root";
            String password = "root";
            Class.forName("com.mysql.jdbc.Driver");
            dbCon = DriverManager.getConnection("jdbc:mysql://localhost:8889/annotator?useUnicode=true&characterEncoding=utf-8", username, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return dbCon;
    }

}