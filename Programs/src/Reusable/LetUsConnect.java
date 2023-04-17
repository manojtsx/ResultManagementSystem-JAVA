package Reusable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LetUsConnect {
    String db_driver, db_url, db_user,db_pass;
    
    public LetUsConnect(){
        this.db_driver = "com.mysql.cj.jdbc.Driver";
        this.db_url = "jdbc:mysql://localhost:3306/rms";
        this.db_user = "root";
        this.db_pass = "admin";
    }
    public Connection getConnection(){
        Connection conn = null;
     try{
         Class.forName(db_driver);
         conn = DriverManager.getConnection(db_url,db_user,db_pass);
     } catch (ClassNotFoundException e) {
         System.out.println(e);
     }catch(SQLException err){
         System.out.println(err);
     }
     return conn;
    }
}
