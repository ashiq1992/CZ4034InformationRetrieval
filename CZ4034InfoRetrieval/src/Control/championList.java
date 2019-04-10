package Control;

import java.util.ArrayList;

import Model.airlineReview;

public class championList {
	
	public  ArrayList<airlineReview>retriveData(String query){
		
		
	ArrayList<ArrayList<airlineReview>>	compareData=new ArrayList<>();
	airlineReviewManger retriveData=new airlineReviewManger();
	ArrayList<airlineReview>china=new ArrayList<>();
	ArrayList<airlineReview>india=new ArrayList<>();
	ArrayList<airlineReview>canada=new ArrayList<>();
	ArrayList<airlineReview>eva=new ArrayList<>();
	ArrayList<airlineReview>sq=new ArrayList<>();
	ArrayList<airlineReview>united=new ArrayList<>();
	ArrayList<airlineReview>lufthansa=new ArrayList<>();
	
	
	ArrayList<airlineReview>customer=new ArrayList<>();
	ArrayList<airlineReview>food=new ArrayList<>();
	ArrayList<airlineReview>delayed=new ArrayList<>();
	ArrayList<airlineReview>courtesy=new ArrayList<>();
	ArrayList<airlineReview>worst=new ArrayList<>();
	ArrayList<airlineReview>boarding=new ArrayList<>();
	
	
	ArrayList<airlineReview>inflightservices=new ArrayList<>();
	ArrayList<airlineReview>checkin=new ArrayList<>();
	ArrayList<airlineReview>flightontime=new ArrayList<>();
	ArrayList<airlineReview>crewcourtesy=new ArrayList<>();
	
	
	
	china=retriveData.getAirlineReviewByAirChina();
	india=retriveData.getAirlineReviewByAirIndia();
	canada=retriveData.getAirlineReviewByCanada();
	eva=retriveData.getAirlineReviewByEvaAir();
	lufthansa=retriveData.getAirlineReviewByLufthansa();
	sq=retriveData.getAirlineReviewBySingapore();
	united=retriveData.getAirlineReviewByunitedAir();
	
	delayed=retriveData.getAirlineReviewBydelayed();
	courtesy=retriveData.getAirlineReviewBycourtesy();
	customer=retriveData.getAirlineReviewBycustomerService();
	food=retriveData.getAirlineReviewByfood();
	worst=retriveData.getAirlineReviewByworst();
	boarding=retriveData.getAirlineReviewByBoarding();
	
	
	inflightservices=retriveData.getAirlineReviewByInFlightService();
	checkin=retriveData.getAirlineReviewByCheckIn();
	flightontime=retriveData.getAirlineReviewByFlightOnTime();
	crewcourtesy=retriveData.getAirlineReviewByCrewCourtesyAndHelpfulness();
	
	
	
	
	if(query.contains("sia")||query.contains("Singapore")||query.contains("sq")) {
		compareData.add(sq);
	}
	if(query.contains("eva")) {
			compareData.add(eva);
		}
	if(query.contains("lufthansa")) {
		compareData.add(lufthansa);
		
	}
	if(query.contains("united")) {
		compareData.add(united);
	}
	if(query.contains("india")) {
		compareData.add(india);
	}
	if(query.contains("china")) {
		compareData.add(china);
	}
	if(query.contains("canada")) {
		compareData.contains(canada);
	}
	if(query.contains("services")||query.contains("service") ) {
		compareData.add(customer);
	}
	if(query.contains("helpful")||query.contains("helpfulness")||query.contains("help") ) {
		compareData.add(courtesy);
	}
	if(query.contains("worst") ) {
		compareData.add(worst);
	}
	if(query.contains("courtesy")||query.contains("manners")|| query.contains("crew") ) {
		compareData.add(courtesy);
		compareData.add(crewcourtesy);
	}
	if(query.contains("boarding")||query.contains("check-in") ) {
		compareData.add(boarding);
	}
	if(query.contains("delay")||query.contains("slow") || query.contains("delayed") || query.contains("cancelled")) {
		compareData.add(delayed);
	}
	if(query.contains("food")) {
		compareData.add(food);
	}
	if(query.contains("flight service")) {
		compareData.add(inflightservices);
	}

	///need to find a way to intersect the data to come up with the relevant data to be output
	
	
	
	
	
	
	
	
	return null;
	}

}
