package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miscellaneous.DB;

public class ScoreDBAO {
	static Connection con;
	
	public	ScoreDBAO() throws Exception{
	DB db = new DB();
	 con=db.getMYSQLConnection();

	}
	public void remove() {
		try {
			con.close();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public boolean insertRecord(String airline,double score)
	{
		
			try {
				String createStatement="INSERT INTO AirlineScore (airline,score) VALUES(?,?)";
				PreparedStatement prepStmt = con.prepareStatement(createStatement);
				prepStmt.setString(1, airline);
				prepStmt.setDouble(2, score);
				prepStmt.executeUpdate();
				prepStmt.close();
				return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		return false;
	}
	
	
//	private boolean createTable(String tableName) throws Exception {
//	
//
//		
//		try {
//			String query="CREATE TABLE 'highflyer'.'AirlineScore' (\r\n" + 
//					"  'id' INT NOT NULL AUTO_INCREMENT,\r\n" + 
//					"  'airline' VARCHAR(45) NOT NULL,\r\n" + 
//					"  'score' DOUBLE NOT NULL,\r\n" + 
//					"  PRIMARY KEY ('id'));\r\n" + 
//					"";
//			
//			System.out.println(query);
//			PreparedStatement prepStmt = con.prepareStatement(query);
//			
//				
//			prepStmt.executeUpdate();
//			
//		
//			prepStmt.close();
//			return true;
//		} catch (SQLException ex) {
//			throw new Exception("create table : " + ex.getMessage());
//		}
//
//	
//	}
//	
	
	public static void main(String args[]) {
		try {
			ScoreDBAO test=new ScoreDBAO();
			test.insertRecord("SQ", 20.650);
			//test.createTable("AirlineScore");
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
