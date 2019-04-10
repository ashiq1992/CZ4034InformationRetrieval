package miscellaneous;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
Connection con;
//Connection mariaDb;
    
    // Database configuration
    
    public static String dbdriver = "com.mysql.cj.jdbc.Driver";
 //   static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";


//    public static String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12263095";
//    public static String username = "sql12263095";
//    public static String password = "Hj1rhPPZlE";
    
//  public static String url = "jdbc:mysql://propsearchntu1.mysql.database.azure.com:3306/sql12257812?useSSL=true&requireSSL=false&serverTimezone=UTC";
//  public static String username = "propsearch@propsearchntu1";
//  public static String password = "softwareEngineering@ntu";
//  
 // public static String url = "jdbc:mysql://localhost:3306/highflyer?user=root&password=admin&serverTimezone=UTC";

  
  
    
 // String url1 ="jdbc:mysql://propsearchntu1.mysql.database.azure.com:3306/sql12257812?useSSL=true&requireSSL=false";
 // myDbConn = DriverManager.getConnection(url, "propsearch@propsearchntu1",password);
  
  //String url1 ="jdbc:mysql://propsearchntu1.mysql.database.azure.com:3306/sql12257812?useSSL=true&requireSSL=false"
  //myDbConn = DriverManager.getConnection(url, "propsearch@propsearchntu1","softwareEngineering@ntu");
    
    
//    public static String url = "jdbc:mysql://localhost/FileHaven";
//    public static String username = "root";
//    public static String password = "password";
    
  	public static String url="jdbc:mysql://highflyer.cvr6mv2gdrpl.us-east-2.rds.amazonaws.com:3306/highflyer";
  	public static String username="highflyer";
  	public static String password="scsentu2016";
    
    
    
//  	
  
//   public static String url = "jdbc:mysql://adeeldb.ch30tsalfl52.ap-southeast-1.rds.amazonaws.com:3306/filehaven";
//   public static String username = "adeeldb";
//    public static String password = "Iamtheking";
    //public static String url = "jdbc:mysql://localhost/FileHaven";
  //  public static String username = "root";
  //  public static String password = "";

//    public static String url = "jdbc:mysql://localhost:3306/highflyer?useLegacyDatetimeCode=false&serverTimezone=Asia/Singapore";
//    public static String username = "root";
//    public static String password = "admin";
    
    
    public DB()  {
    	
        
    }

    public Connection getMYSQLConnection() throws Exception {
    	try {
            Class.forName(dbdriver);
         
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception ex) {
            System.out.println("Exception in HighFlyer: " + ex);
            throw new Exception("Couldn't open connection to database: " +
                    ex.getMessage());
        }
    	return con;
    }
  
    
    public static void main(String args[]){
    	try{
//    		InetAddress inetAddress = InetAddress.getLocalHost();
//            System.out.println("IP Address:- " + inetAddress.getHostAddress());
//            System.out.println("Host Name:- " + inetAddress.getHostName());
    		new DB().getMYSQLConnection();
    	}
    	
    	
    	catch(Exception ex){ex.printStackTrace();}
    }

}
