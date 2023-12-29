
package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBconect {
    
    
    public static Connection connect(){
    
    Connection conn = null;
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1" , "root","");
            
            
        } catch (ClassNotFoundException  e) {
            
            JOptionPane.showMessageDialog(null, e);
        } catch (SQLException ex) {
            Logger.getLogger(DBconect.class.getName()).log(Level.SEVERE, null, ex);
        }
    return conn;  
    }
}
    
