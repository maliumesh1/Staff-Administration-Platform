package employee.management.system

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   /*mysql driver connected */
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "9527"); ////////////❤️❤️❤️❤️❤️❤️❤️❤️
            s = c.createStatement(); /* */
            
            
        } catch (Exception e) { /* mysql is ext. entity therefore comes error */
            e.printStackTrace();
        }
    }
}
