/*
||  Program name:     JDBCLibrary.java
||  Created by:       Michael McLaughlin | Copyright 2002
||  Creation date:    04/09/02
||  History:
|| ----------------------------------------------------------------------
||  Date       Author                   Purpose
||  --------   ----------------------   ---------------------------------
||  dd/mm/yy   {Name}                   {Brief statement of change.}
|| ----------------------------------------------------------------------
||  Execution method: Instantiated as a class within a class.
||  Program purpose:  Designed as a user defined Exception.
*/



// Class imports.
import java.awt.*;            // Required for AWT widgets.
import java.awt.event.*;      // Required for AWT events.
import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// ------------------------------ Begin Class --------------------------------/

// Class definition.
public class JDBCLibrary
{
  // -------------------------- Class Variables ------------------------------/
// JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://byuirocketdynamics.org:3306/byuirock_jmessenger";
   static final String USER = "byuirock_DBAcces";
   static final String PASS = "{-~gi0fgcI^c";
   
  // ------------------------- Begin Constructor -----------------------------/

  /*
  || The constructors of the class are:
  || =========================================================================
  ||  Access     Constructor Type  Constructor
  ||  ---------  ----------------  -------------------------------------------
  ||  public     Default           JDBCLibrary()
  */

  // -------------------------------------------------------------------------/

  // Default constructor extends RuntimeException.
  public JDBCLibrary(){
  
  }

  // --------------------------- Begin Methods -------------------------------/

  /*
  || The class must be instantiated from another class instance:
  || =========================================================================
  ||  Return Type  Method Name                    Access     Parameter List
  ||  -----------  -----------------------------  ---------  -----------------
  */

  // ---------------------------- End Methods --------------------------------/

  // ------------------------- Begin Inner Class -----------------------------/

  // -------------------------- End Inner Class ------------------------------/

  // ------------------------- Begin Static Main -----------------------------/
public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
  try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
       try {
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }
        System.out.println("Creating statement...");
       try {
           stmt = conn.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       String sql;
      sql = "select * from Users;";
      ResultSet rs = null;
       try {
           rs = stmt.executeQuery(sql);
           //stmt.executeQuery(sql);
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       System.out.println(rs.toString());
/*
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
       try {
           stmt = conn.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }
      String sql;
      sql = "SELECT id, first, last, age FROM Employees";
      ResultSet rs = null;
       try {
           rs = stmt.executeQuery(sql);
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }

       try {
           //STEP 5: Extract data from result set
           while(rs.next()){
               //Retrieve by column name
               int id  = rs.getInt("id");
               int age = rs.getInt("age");
               String first = rs.getString("first");
               String last = rs.getString("last");
               
               //Display values
               System.out.print("ID: " + id);
               System.out.print(", Age: " + age);
               System.out.print(", First: " + first);
               System.out.println(", Last: " + last);
           }
           // -------------------------- End Static Main ------------------------------/
       } catch (SQLException ex) {
           Logger.getLogger(JDBCLibrary.class.getName()).log(Level.SEVERE, null, ex);
       }
*/
   } 
}

// End of JDBCLibrary class.

// ------------------------------- End Class ---------------------------------/