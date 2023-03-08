/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author andres
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world";
    private static final String JDBC_USERNAME = "server";
    private static final String JDBC_PASSWORD = "DBPassword123@";
    private static final String JDBC_DBNAME = "world";
    
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USERNAME);
        ds.setPassword(JDBC_PASSWORD);
        ds.setInitialSize(50);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static String ayuda(){
        try{
            return getDataSource().getConnection().getClass().getName();
        }
        catch(Exception e){
            return "ha dado una excepcion mas";
        }
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
