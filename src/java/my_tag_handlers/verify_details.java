package my_tag_handlers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
/**
 *
 * @author We_creATe_ThE_WoRLd
 */
public class verify_details extends SimpleTagSupport {
     
    
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        
        
        
        
        
        String JDBC_driver="com.mysql.jdbc.Driver";
        String DB_url="jdbc:mysql://localhost/kb_db";
        String DB_user="root";
        String DB_pass="";
        Connection conn=null;
        Statement stmt=null;
        try
        {
            Class.forName(JDBC_driver);
            conn=DriverManager.getConnection(DB_url,DB_user,DB_pass);
        }
        catch(SQLException se)
        {
            se.printStackTrace();
            System.out.println(se);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
