package Control;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import Model.airlineReview;
import Model.radarGraphParam;
import Model.twitter;

public class CalculateScore {

	public static void main(String args[]) {
		
		
		
		radarGraphManager query= new radarGraphManager();
		ArrayList<radarGraphParam> results=new  ArrayList<radarGraphParam>();
		radarGraphParam twitter1=new radarGraphParam();
		String[] airline= {"Canada","India","Singapore","Eva","Lufthansa","United","China"};
		for(int i=0;i<airline.length;i++) {
		try {
			results=query.getFlightServicesScore(airline[i], "");
			twitter1=query.getTwitterScore(airline[i], "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Calculate Score
		 double flightScore=0,checkinScore=0,crewScore=0,flightOnTimeScore=0,tweetScore=0;
	        double divide=0;
	        DecimalFormat df2 = new DecimalFormat("###.##");
	        if(results.get(0).getScore()!=0){
	        	 flightOnTimeScore=(results.get(0).getPositive()/(results.get(0).getPositive()+results.get(0).getNegative()))*10;
	        	 divide++;
	        }
	        else{
	        	flightOnTimeScore=0;
	        }
	   if(results.get(1).getScore()!=0){
			 checkinScore=(results.get(1).getPositive()/(results.get(1).getPositive()+results.get(1).getNegative()))*10;
			 divide++;
	        }
	        else{
	        	checkinScore=0;
	        }
	   if(results.get(2).getScore()!=0){
		   crewScore=(results.get(2).getPositive()/(results.get(2).getPositive()+results.get(2).getNegative()))*10;
		   divide++;
	   }
	   else{
		   crewScore=0;
	   }
	   if(results.get(3).getScore()!=0){
		   flightScore=(results.get(3).getPositive()/(results.get(3).getPositive()+results.get(3).getNegative()))*10;
		   divide++;
	   }
	   else{
		   flightScore=0;
	   }
	        
	        tweetScore=(twitter1.getPositive()/(twitter1.getPositive()+twitter1.getNegative()))*10;
	        divide++;

	  double totalScore=(flightScore+checkinScore+crewScore+flightOnTimeScore+tweetScore)/divide;
		
		try {
			ScoreDBAO score = new ScoreDBAO();
			score.insertRecord(airline[i], Double.parseDouble(df2.format(totalScore)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		}
	}
	
	
}
