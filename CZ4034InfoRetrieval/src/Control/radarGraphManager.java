package Control;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Model.airlineReview;
import Model.radarGraphParam;
import Model.twitter;

public class radarGraphManager {
	
	
	//get the searched results and passess it to the servlet
	public ArrayList<airlineReview> getFlightServicesResult(String searchInput ,String queryParameters) throws ParseException {
		//only focus on 7 airline therefore can hard code to show proof of concept
		if(searchInput.equalsIgnoreCase("Air Canada")) {
			searchInput="Canada";
		}
		else if(searchInput.equalsIgnoreCase("Air India")) {
			searchInput="India";
		}
		else if(searchInput.equalsIgnoreCase("Singapore Airlines")) {
			searchInput="Singapore";
		}
		else if(searchInput.equalsIgnoreCase("Air Eva")) {
			searchInput="Eva";
		}
		else if(searchInput.equalsIgnoreCase("Lufthansa")) {
			searchInput="Lufthansa";
		}
		else if(searchInput.equalsIgnoreCase("United Airlines")) {
			searchInput="United";
		}
		else if(searchInput.equalsIgnoreCase("Air China")) {
			searchInput="China";
		}

	String urlString = "http://localhost:8983/solr/airlineClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:("+searchInput+") ");
	  System.out.println(query.getQuery());
	query.setRows(1000);
	QueryResponse qResponse = null;
	
	try {
		qResponse = solr.query(query);
		System.out.println(qResponse.getResults().size());
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	SolrDocumentList docList = qResponse.getResults();
	ArrayList<airlineReview> airlineReview = new ArrayList<airlineReview>();
	for(int i=0;i<docList.size();i++)
	{
		airlineReview airlineReviewModel = new airlineReview();
		airlineReviewModel.setAirline(docList.get(i).getFieldValue("airline").toString());
		airlineReviewModel.setAuthor(docList.get(i).getFieldValue("author").toString());
		//get the date out
		String reverse = new StringBuffer(airlineReviewModel.getAuthor()).reverse().toString();
		String arr[]=reverse.split(" ");
		arr[2]=arr[2].replaceAll("ht", "");
		arr[2]=arr[2].replaceAll("ts", "");
		arr[2]=arr[2].replaceAll("dn", "");
		arr[2]=arr[2].replaceAll("dr", "");
		String build=arr[0]+" "+arr[1]+" "+arr[2];
		String reverseDate = new StringBuffer(build).reverse().toString();
		//System.out.println("Date "+reverseDate);
		
		airlineReviewModel.setDateTime(reverseDate);
		
		
		//System.out.println(airlineReviewModel.getDateTime());
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		airlineReviewModel.setClassification(docList.get(i).getFieldValue("classification").toString());
		airlineReviewModel.setType(docList.get(i).getFieldValue("type").toString());
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		airlineReviewModel.setScore(Double.parseDouble(docList.get(i).getFieldValue("score").toString()));
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

	}
	
	
	
	
	
	public ArrayList<radarGraphParam> getFlightServicesScore(String searchInput ,String queryParameters) throws ParseException {
		//only focus on 7 airline therefore can hard code to show proof of concept
		if(searchInput.equalsIgnoreCase("Air Canada")) {
			searchInput="Canada";
		}
		else if(searchInput.equalsIgnoreCase("Air India")) {
			searchInput="India";
		}
		else if(searchInput.equalsIgnoreCase("Singapore Airlines")) {
			searchInput="Singapore";
		}
		else if(searchInput.equalsIgnoreCase("Air Eva")) {
			searchInput="Eva";
		}
		else if(searchInput.equalsIgnoreCase("Lufthansa")) {
			searchInput="Lufthansa";
		}
		else if(searchInput.equalsIgnoreCase("United Airlines")) {
			searchInput="United";
		}
		else if(searchInput.equalsIgnoreCase("Air China")) {
			searchInput="China";
		}
		
		
		 int InflightServices=0;
		 int CrewcourtesyAndHelpfulness=0;
		 int  FlightOnTimePerformance =0;
		 int CheckInBoardingProcess=0;
		 int inFlightPos=0;
		 int inFlightNeg=0;
		 int crewPos=0;
		 int crewNeg=0;
		 int flightOnPos=0;
		 int flightOnNeg=0;
		 int checkInPos=0;
		 int checkInNeg=0;
		 double crewScore=0;
		 double flightOntimeScore=0;
		 double checkInScore=0;
		 double inflightScore=0;

		 
	String urlString = "http://localhost:8983/solr/airlineClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:("+searchInput+") ");
	 // System.out.println(query.getQuery());
	query.setRows(1000);
	QueryResponse qResponse = null;
	
	try {
		qResponse = solr.query(query);
		//System.out.println(qResponse.getResults().size());
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	SolrDocumentList docList = qResponse.getResults();
	ArrayList<radarGraphParam> params=new ArrayList<>();
	radarGraphParam paramObjInflight=new radarGraphParam();
	radarGraphParam paramObjCrew=new radarGraphParam();
	radarGraphParam paramObjCheckIn=new radarGraphParam();
	radarGraphParam paramObjFlightOnTime=new radarGraphParam();
	
	//Inflight Services    Crew courtesy And Helpfulness  Flight On-Time Performance   Check-In/Boarding Process  
	paramObjInflight.setClassification("Inflight Services");
	paramObjCrew.setClassification("Crew courtesy And Helpfulness");
	paramObjCheckIn.setClassification("Check-In/Boarding Process");
	paramObjFlightOnTime.setClassification("Flight On-Time Performance");
	
	for(int i=0;i<docList.size();i++)
	{
		airlineReview airlineReviewModel = new airlineReview();
	
		airlineReviewModel.setAirline(docList.get(i).getFieldValue("airline").toString());
		airlineReviewModel.setAuthor(docList.get(i).getFieldValue("author").toString());
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		airlineReviewModel.setType(docList.get(i).getFieldValue("type").toString());
		airlineReviewModel.setClassification(docList.get(i).getFieldValue("classification").toString());
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		airlineReviewModel.setScore(Double.parseDouble(docList.get(i).getFieldValue("score").toString()));
		//System.out.println("airline score raw "+i+": "+docList.get(i).getFieldValue("score"));
		//System.out.println("airline score "+i+": "+airlineReviewModel.getScore());
	
		if(airlineReviewModel.getClassification().equalsIgnoreCase("In-Flight Services")) {
			InflightServices++;
			
			inflightScore+=airlineReviewModel.getScore();
			
			if(airlineReviewModel.getType().equalsIgnoreCase("positive")||airlineReviewModel.getType().equalsIgnoreCase("neutral")) {
				inFlightPos++;
				
			}
			else if (airlineReviewModel.getType().equalsIgnoreCase("negative")){
				inFlightNeg++;
					}
			
		}
		else if(airlineReviewModel.getClassification().equalsIgnoreCase("Crew courtesy And Helpfulness")) {
			CrewcourtesyAndHelpfulness++;
			
			crewScore+=airlineReviewModel.getScore();
			
			if(airlineReviewModel.getType().equalsIgnoreCase("positive")||airlineReviewModel.getType().equalsIgnoreCase("neutral")) {
				crewPos++;
				
			}
			else if (airlineReviewModel.getType().equalsIgnoreCase("negative")){
				crewNeg++;
			}
		}
		else if(airlineReviewModel.getClassification().equalsIgnoreCase("Flight On-Time Performance")) {
			FlightOnTimePerformance++;
			
			flightOntimeScore+=airlineReviewModel.getScore();
			
			if(airlineReviewModel.getType().equalsIgnoreCase("positive")||airlineReviewModel.getType().equalsIgnoreCase("neutral")) {
				flightOnPos++;
				
			}
			else if (airlineReviewModel.getType().equalsIgnoreCase("negative")) {
				flightOnNeg++;
			}
		}
			
		else if(airlineReviewModel.getClassification().equalsIgnoreCase("Check-In/Boarding Process")) {
			
			CheckInBoardingProcess++;
			
			checkInScore+=airlineReviewModel.getScore();
			
			if(airlineReviewModel.getType().equalsIgnoreCase("positive")||airlineReviewModel.getType().equalsIgnoreCase("neutral")) {
				checkInPos++;
				
			}
			else if (airlineReviewModel.getType().equalsIgnoreCase("negative")) {
				checkInNeg++;
			}
		
		}
		
		
		
		}
	

	
	paramObjInflight.addContent(inflightScore, inFlightPos, inFlightNeg,InflightServices);
	paramObjCrew.addContent(crewScore, crewPos, crewNeg,CrewcourtesyAndHelpfulness);
	paramObjCheckIn.addContent(checkInScore, checkInPos, checkInNeg,CheckInBoardingProcess);
	paramObjFlightOnTime.addContent(flightOntimeScore, flightOnPos, flightOnNeg,FlightOnTimePerformance);
	params.add(paramObjFlightOnTime);
	params.add(paramObjCheckIn);
	params.add(paramObjCrew);
	params.add(paramObjInflight);
	return params;
	
		
	}
	
	public ArrayList<radarGraphParam> getFlightServicesScoreByQuaterMonth(String searchInput ,String queryParameters,String startDate,String EndDate) throws ParseException {
		//for graph data
		ArrayList<radarGraphParam> params=new ArrayList<>();
		radarGraphParam paramObjInflight=new radarGraphParam();
		radarGraphParam paramObjCrew=new radarGraphParam();
		radarGraphParam paramObjCheckIn=new radarGraphParam();
		radarGraphParam paramObjFlightOnTime=new radarGraphParam();
		
		 int InflightServices=0;
		 int CrewcourtesyAndHelpfulness=0;
		 int  FlightOnTimePerformance =0;
		 int CheckInBoardingProcess=0;
		 int inFlightPos=0;
		 int inFlightNeg=0;
		 int crewPos=0;
		 int crewNeg=0;
		 int flightOnPos=0;
		 int flightOnNeg=0;
		 int checkInPos=0;
		 int checkInNeg=0;
		 double crewScore=0;
		 double flightOntimeScore=0;
		 double checkInScore=0;
		 double inflightScore=0;
		
		
		
		
		//Inflight Services    Crew courtesy And Helpfulness  Flight On-Time Performance   Check-In/Boarding Process  
		paramObjInflight.setClassification("Inflight Services");
		paramObjCrew.setClassification("Crew courtesy And Helpfulness");
		paramObjCheckIn.setClassification("Check-In/Boarding Process");
		paramObjFlightOnTime.setClassification("Flight On-Time Performance");
		
		
		
		
		//only focus on 7 airline therefore can hard code to show proof of concept
		ArrayList<airlineReview> airlineReview =this.getFlightServicesResult(searchInput, queryParameters);
		ArrayList<airlineReview> airlineReviewbyQuater =new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat comparatoreDate = new SimpleDateFormat("dd MMM yyyy");
		String dateCompareStart=startDate;
		String dateCompareEnd=EndDate;
		Date datebenchMarkStart=comparatoreDate.parse(dateCompareStart);
		Date datebenchMarkEnd=comparatoreDate.parse(dateCompareEnd);
			//System.out.println("Stored2 :"+formatter.format(airlineReview.get(0).getDateTime()));
			//System.out.println("Stored2 :"+datebenchMarkStart);
			//System.out.println("Stored2 :"+datebenchMarkEnd);

		
		for(int i=0;i<airlineReview.size();i++) {
			
		      // make 3 comparisons with them
		      int comparisonStart = airlineReview.get(i).getDateTime().compareTo(datebenchMarkStart);
		      int comparisonEnd = airlineReview.get(i).getDateTime().compareTo(datebenchMarkEnd);
		      if(comparisonStart==1 && comparisonEnd==-1) {
		    	 //System.out.println(airlineReview.get(i).getDateTime());
		    	  airlineReviewbyQuater.add(airlineReview.get(i));
		    	  
		      }
		}
		      
		      for(int k=0;k<airlineReviewbyQuater.size();k++) {
		    	 // System.out.println("individual Score "+airlineReviewbyQuater.get(k).getScore());
		  		if(airlineReviewbyQuater.get(k).getClassification().equalsIgnoreCase("In-Flight Services")) {
		  			InflightServices++;
		  			
		  			inflightScore+=airlineReviewbyQuater.get(k).getScore();
		  			
		  			if(airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("positive")||airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("neutral")) {
		  				inFlightPos++;
		  				
		  			}
		  			else if (airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("negative")){
		  				inFlightNeg++;
		  					}
		  			
		  		}
		  		else if(airlineReviewbyQuater.get(k).getClassification().equalsIgnoreCase("Crew courtesy And Helpfulness")) {
		  			CrewcourtesyAndHelpfulness++;
		  			
		  			crewScore+=airlineReviewbyQuater.get(k).getScore();
		  			
		  			if(airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("positive")||airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("neutral")) {
		  				crewPos++;
		  				
		  			}
		  			else if (airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("negative")){
		  				crewNeg++;
		  			}
		  		}
		  		else if(airlineReviewbyQuater.get(k).getClassification().equalsIgnoreCase("Flight On-Time Performance")) {
		  			FlightOnTimePerformance++;
		  			
		  			flightOntimeScore+=airlineReviewbyQuater.get(k).getScore();
		  			
		  			if(airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("positive")||airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("neutral")) {
		  				flightOnPos++;
		  				
		  			}
		  			else if (airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("negative")) {
		  				flightOnNeg++;
		  			}
		  		}
		  			
		  		else if(airlineReviewbyQuater.get(k).getClassification().equalsIgnoreCase("Check-In/Boarding Process")) {
		  			
		  			CheckInBoardingProcess++;
		  			
		  			checkInScore+=airlineReviewbyQuater.get(k).getScore();
		  			
		  			if(airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("positive")||airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("neutral")) {
		  				checkInPos++;
		  				
		  			}
		  			else if (airlineReviewbyQuater.get(k).getType().equalsIgnoreCase("negative")) {
		  				checkInNeg++;
		  			}
		  		
		  		}
		    	  
		    	  
		      }


		      
		
		
		
		paramObjInflight.addContent(inflightScore, inFlightPos, inFlightNeg,InflightServices);
		paramObjCrew.addContent(crewScore, crewPos, crewNeg,CrewcourtesyAndHelpfulness);
		paramObjCheckIn.addContent(checkInScore, checkInPos, checkInNeg,CheckInBoardingProcess);
		paramObjFlightOnTime.addContent(flightOntimeScore, flightOnPos, flightOnNeg,FlightOnTimePerformance);
		params.add(paramObjFlightOnTime);
		params.add(paramObjCheckIn);
		params.add(paramObjCrew);
		params.add(paramObjInflight);
		return params;
		
		
	
		
	}
	
	public radarGraphParam getTwitterScoreByQuaterMonth(String searchInput ,String queryParameters,String startDate,String EndDate) throws ParseException {
		//for graph data
		ArrayList<radarGraphParam> params=new ArrayList<>();


		int neu=0;
		int pos=0;
		int neg=0;
		int total=0;
		radarGraphParam paramTwitter=new radarGraphParam();
		//only focus on 7 airline therefore can hard code to show proof of concept
		ArrayList<twitter> twiterScore =this.getTwitterResult(searchInput, queryParameters);
		ArrayList<twitter> twitterbyQuater =new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		SimpleDateFormat comparatoreDate = new SimpleDateFormat("dd MMM yyyy");
		String dateCompareStart=startDate;
		String dateCompareEnd=EndDate;
		Date datebenchMarkStart=comparatoreDate.parse(dateCompareStart);
		Date datebenchMarkEnd=comparatoreDate.parse(dateCompareEnd);
			//System.out.println("Stored2 :"+formatter.format(airlineReview.get(0).getDateTime()));
			//System.out.println("Stored2 :"+datebenchMarkStart);
			//System.out.println("Stored2 :"+datebenchMarkEnd);

		
		for(int i=0;i<twiterScore.size();i++) {
			
		      // make 3 comparisons with them
		      int comparisonStart = twiterScore.get(i).getDate().compareTo(datebenchMarkStart);
		      int comparisonEnd = twiterScore.get(i).getDate().compareTo(datebenchMarkEnd);
		      if(comparisonStart==1 && comparisonEnd==-1) {
		    	
		    	  twitterbyQuater.add(twiterScore.get(i));
		    		total++;
		    		if( twiterScore.get(i).getType().equalsIgnoreCase("Positive")) {
		    			pos++;
		    		}
		    		else if(twiterScore.get(i).getType().equalsIgnoreCase("Negative")) {
		    			neg++;
		    		}
		    		else if(twiterScore.get(i).getType().equalsIgnoreCase("Neutral")){
		    			neu++;
		    		}
		    		else {
		    			 System.out.println(twiterScore.get(i).getDate()+" "+twiterScore.get(i).getType());
		    		}
		    	  
		      }
		}
		
		      
		      

		
		paramTwitter.setPositive(pos);
		paramTwitter.setNegative(neg);
		paramTwitter.setSize(total);
		paramTwitter.setNeutral(neu);
		      pos=0;
		      neg=0;
		      total=0;
		      neu=0;

		return paramTwitter;
		
		
	
		
	}
	
	
	
	
	public radarGraphParam getTwitterScore(String searchInput ,String queryParameters) throws ParseException {
		//only focus on 7 airline therefore can hard code to show proof of concept
		if(searchInput.equalsIgnoreCase("Air Canada")) {
			searchInput="Canada";
		}
		else if(searchInput.equalsIgnoreCase("Air India")) {
			searchInput="India";
		}
		else if(searchInput.equalsIgnoreCase("Singapore Airlines")) {
			searchInput="Singapore";
		}
		else if(searchInput.equalsIgnoreCase("Air Eva")) {
			searchInput="Eva";
		}
		else if(searchInput.equalsIgnoreCase("Lufthansa")) {
			searchInput="Lufthansa";
		}
		else if(searchInput.equalsIgnoreCase("United Airlines")) {
			searchInput="United";
		}
		else if(searchInput.equalsIgnoreCase("Air China")) {
			searchInput="China";
		}
		
		int neu=0;
		int pos=0;
		int neg=0;
		int total=0;
	String urlString = "http://localhost:8983/solr/twitterClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:("+searchInput+") ");
	  System.out.println(query.getQuery());
	query.setRows(10000);
	QueryResponse qResponse = null;
	
	try {
		qResponse = solr.query(query);
		System.out.println(qResponse.getResults().size());
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	SolrDocumentList docList = qResponse.getResults();
	radarGraphParam paramTwitter=new radarGraphParam();

	
	//Inflight Services    Crew courtesy And Helpfulness  Flight On-Time Performance   Check-In/Boarding Process  

	
	for(int i=0;i<docList.size();i++)
	{
		twitter twitterModel = new twitter();
		twitterModel.setTwitterHandleName(docList.get(i).getFieldValue("twitterHandleName").toString());
		twitterModel.setContent(docList.get(i).getFieldValue("content").toString());
		twitterModel.setAirline(docList.get(i).getFieldValue("airline").toString());
		if(docList.get(i).getFieldValue("favourites")==null) {
			twitterModel.setFavourites("0");
		}
		else {
			twitterModel.setFavourites(docList.get(i).getFieldValue("favourites").toString());
		}
		
		twitterModel.setName(docList.get(i).getFieldValue("name").toString());
	String val=docList.get(i).getFieldValue("publishedDate").toString();
		twitterModel.setPublishedDate(docList.get(i).getFieldValue("publishedDate").toString());
		
		twitterModel.setUrl(docList.get(i).getFieldValue("url").toString());
		if(docList.get(i).getFieldValue("retweets")==null) {
			twitterModel.setRetweets("0");
		}
		else {
			twitterModel.setRetweets(docList.get(i).getFieldValue("retweets").toString());
		}
		if(docList.get(i).getFieldValue("type")==null) {
		}
		else {
		twitterModel.setType(docList.get(i).getFieldValue("type").toString());
		total++;
		if( twitterModel.getType().equalsIgnoreCase("positive")) {
			pos++;
		}
		else if(twitterModel.getType().equalsIgnoreCase("negative")) {
			neg++;
		}
		else if(twitterModel.getType().equalsIgnoreCase("neutral")){
			neu++;
		}
		}
		
		
		
		
		}
		
	paramTwitter.setPositive(pos);
	paramTwitter.setNegative(neg);
	paramTwitter.setScore(total);
	paramTwitter.setNeutral(neu);
	

	return paramTwitter;
	}
	
	
	public ArrayList<twitter> getTwitterResult(String searchInput ,String queryParameters) throws ParseException {
		//only focus on 7 airline therefore can hard code to show proof of concept
		if(searchInput.equalsIgnoreCase("Air Canada")) {
			searchInput="Canada";
		}
		else if(searchInput.equalsIgnoreCase("Air India")) {
			searchInput="India";
		}
		else if(searchInput.equalsIgnoreCase("Singapore Airlines")) {
			searchInput="Singapore";
		}
		else if(searchInput.equalsIgnoreCase("Air Eva")) {
			searchInput="Eva";
		}
		else if(searchInput.equalsIgnoreCase("Lufthansa")) {
			searchInput="Lufthansa";
		}
		else if(searchInput.equalsIgnoreCase("United Airlines")) {
			searchInput="United";
		}
		else if(searchInput.equalsIgnoreCase("Air China")) {
			searchInput="China";
		}
		
		
		int pos=0;
		int neg=0;
		
	String urlString = "http://localhost:8983/solr/twitterClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:("+searchInput+") ");
	  System.out.println(query.getQuery());
	query.setRows(10000);
	QueryResponse qResponse = null;
	
	try {
		qResponse = solr.query(query);
		System.out.println(qResponse.getResults().size());
	} catch (SolrServerException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	SolrDocumentList docList = qResponse.getResults();

	
	//Inflight Services    Crew courtesy And Helpfulness  Flight On-Time Performance   Check-In/Boarding Process  

	ArrayList<twitter> twitter = new ArrayList<twitter>();
	for(int i=0;i<docList.size();i++)
	{
		twitter twitterModel = new twitter();
		twitterModel.setTwitterHandleName(docList.get(i).getFieldValue("twitterHandleName").toString());
		twitterModel.setContent(docList.get(i).getFieldValue("content").toString());
		twitterModel.setAirline(docList.get(i).getFieldValue("airline").toString());
		if(docList.get(i).getFieldValue("favourites")==null) {
			twitterModel.setFavourites("0");
		}
		else {
			twitterModel.setFavourites(docList.get(i).getFieldValue("favourites").toString());
		}
		
		twitterModel.setName(docList.get(i).getFieldValue("name").toString());
		twitterModel.setPublishedDate(docList.get(i).getFieldValue("publishedDate").toString());
//		//get the date out
//		String reverse = new StringBuffer(twitterModel.getPublishedDate()).reverse().toString();
//		System.out.println(reverse);
//		String arr[]=reverse.split(" ");
//		String build=arr[0]+" "+arr[1]+" "+arr[2];
//		String reverseDate = new StringBuffer(build).reverse().toString();
//		//System.out.println("Date "+reverseDate);
//		twitterModel.setDate(reverseDate);
//		
		twitterModel.setType(docList.get(i).getFieldValue("type").toString());
		
		//System.out.println("test"+twitterModel.getPublishedDate());
		twitterModel.setUrl(docList.get(i).getFieldValue("url").toString());
		if(docList.get(i).getFieldValue("retweets")==null) {
			twitterModel.setRetweets("0");
		}
		else {
			twitterModel.setRetweets(docList.get(i).getFieldValue("retweets").toString());
		}
		
		
//		System.out.println((docList.get(i).getFieldValue("content")));
		//webhoseModel.setAuthor("Test");
		
		twitter.add(twitterModel);
		
		
		
		}
		

	return twitter;
	}
	
	public ArrayList<radarGraphParam> calculateTwitterScoreByQuaterly(String airline){
		
		radarGraphManager test=new radarGraphManager();
		radarGraphParam result=new radarGraphParam();
		ArrayList<radarGraphParam> resultFinal=new ArrayList<radarGraphParam>();
		String[] StartDate= {"1 March 2019","1 January 2019","1 November 2018","1 September 2018","1 July 2018"};
		String[] endDate= {"30 April 2019","28 February 2019","31 December 2018","31 October 2018","31 August 2018"};
		double score=0;
		double size=0;
		double[] scoreFinal=new double[7];
		
		for(int k=0;k<StartDate.length;k++) {
		System.out.println(" "+StartDate[k] +" "+endDate[k]);
		try {
			result=test.getTwitterScoreByQuaterMonth(airline, "",StartDate[k],endDate[k]);
			resultFinal.add(result);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return resultFinal;
	
	}
	
	
	
	public ArrayList<Double> calculateScoreByquaterly(String airline) {
	//	System.out.println(airline);
		radarGraphManager test=new radarGraphManager();
		ArrayList<Double> scoreFinal= new ArrayList<Double>();
		ArrayList<radarGraphParam>result=new ArrayList<radarGraphParam>();
		String[] StartDate= {"1 January 2019","1 September 2018","1 May 2018","1 January 2018","1 September 2017","1 May 2017","1 January 2017"};
		String[] endDate= {"30 April 2019","31 December 2018","31 August 2018","30 April 2018","31 December 2017","31 August 2017","30 April 2017"};
		double score=0;
		double size=0;
		try {
			//result=test.getFlightServicesScore("Singapore airline", "");
			for(int k=0;k<StartDate.length;k++) {
				System.out.println(" "+StartDate[k] +" "+endDate[k]);
				result=test.getFlightServicesScoreByQuaterMonth(airline ,"",StartDate[k],endDate[k]);
				for (int i=0;i<result.size();i++) {
					score+=result.get(i).getScore();
					size+=result.get(i).getSize();
				//	System.out.println(result.get(i).getClassification()+" "+result.get(i).getScore()+" "+result.get(i).getPositive()+" "+result.get(i).getNegative()+" "+result.get(i).getSize());
//					System.out.println(result.get(i).getScore());
//					System.out.println(result.get(i).getPositive());
//					System.out.println(result.get(i).getNegative());
				}
					double val=score/size;
					//System.out.println("Val "+score);
					//System.out.println("size"+size);
					   DecimalFormat df2 = new DecimalFormat("###.##");
					   scoreFinal.add(Double.parseDouble(df2.format(val)));
			//	System.out.println("Final score for 3 months worth of data :"+(score/size));
				//System.out.println("====================================");
				score=0;
				size=0;
			
			//result=test.getFlightServicesScoreByQuaterMonth("Singapore airline", "","1 January 2018","30 April 2018");
		} 
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return scoreFinal;
		
		
		
	}

	public static void main(String args[]) {
		
		radarGraphManager test=new radarGraphManager();
		radarGraphParam result=new radarGraphParam();
		String[] StartDate= {"1 March 2019","1 January 2019","1 November 2018","1 September 2018","1 July 2018"};
		String[] endDate= {"30 April 2019","28 February 2019","31 December 2018","31 October 2018","31 August 2018"};
//		String[] StartDate= {"1 January 2019","1 September 2018","1 May 2018","1 January 2018","1 September 2017","1 May 2017","1 January 2017"};
//		String[] endDate= {"30 April 2019","31 December 2018","31 August 2018","30 April 2018","31 December 2017","31 August 2017","30 April 2017"};
		double score=0;
		double size=0;
		double[] scoreFinal=new double[7];
		
		for(int k=0;k<StartDate.length;k++) {
		System.out.println(" "+StartDate[k] +" "+endDate[k]);
		try {
			result=test.getTwitterScoreByQuaterMonth("Canada", "",StartDate[k],endDate[k]);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
			System.out.println(result.getPositive()+" "+result.getNegative()+" "+result.getNeutral()+" "+result.getSize());
//			System.out.println(result.get(i).getScore());
//			System.out.println(result.get(i).getPositive());
//			System.out.println(result.get(i).getNegative());

	double total=result.getPositive()+result.getNegative()+result.getNeutral();
		
		System.out.println(size);
		  
			System.out.println("Final score for 3 months worth of data :");
			System.out.println("====================================");
			score=0;
			size=0;
	//result=test.getFlightServicesScoreByQuaterMonth("Singapore airline", "","1 January 2018","30 April 2018");
} 
		
		
//		try {
//		test.getTwitterScoreByQuaterMonth("Canada", "", "1 January 2019", "30 April 2019");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		double scoreFinal[]=new double [7];
//		ArrayList<radarGraphParam>result=new ArrayList<radarGraphParam>();
//		String[] StartDate= {"1 January 2019","1 September 2018","1 May 2018","1 January 2018","1 September 2017","1 May 2017","1 January 2017"};
//		String[] endDate= {"30 April 2019","31 December 2018","31 August 2018","30 April 2018","31 December 2017","31 August 2017","30 April 2017"};
//		double score=0;
//		double size=0;
//		try {
//			//result=test.getFlightServicesScore("Singapore airline", "");
//			for(int k=0;k<StartDate.length;k++) {
//				System.out.println(" "+StartDate[k] +" "+endDate[k]);
//				result=test.getFlightServicesScoreByQuaterMonth("Air Eva", "",StartDate[k],endDate[k]);
//				for (int i=0;i<result.size();i++) {
//					score+=result.get(i).getScore();
//					size+=result.get(i).getSize();
//					System.out.println(result.get(i).getClassification()+" "+result.get(i).getScore()+" "+result.get(i).getPositive()+" "+result.get(i).getNegative()+" "+result.get(i).getSize());
////					System.out.println(result.get(i).getScore());
////					System.out.println(result.get(i).getPositive());
////					System.out.println(result.get(i).getNegative());
//		
//			}
//				
//				System.out.println(size);
//				   DecimalFormat df2 = new DecimalFormat("###.##");
//					scoreFinal[k]=Double.parseDouble(df2.format((score/size)));
//					System.out.println("Final score for 3 months worth of data :"+(score/size));
//					System.out.println("====================================");
//					score=0;
//					size=0;
//			//result=test.getFlightServicesScoreByQuaterMonth("Singapore airline", "","1 January 2018","30 April 2018");
//		} 
//		}catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		
//		for (int i=0;i<result.size();i++) {
//			score+=result.get(i).getScore();
//			size+=result.get(i).getSize();
//			//System.out.println(result.get(i).getClassification()+" "+result.get(i).getScore()+" "+result.get(i).getPositive()+" "+result.get(i).getNegative()+" "+result.get(i).getSize());
////			System.out.println(result.get(i).getScore());
////			System.out.println(result.get(i).getPositive());
////			System.out.println(result.get(i).getNegative());
//		}
		
		//System.out.print("Final score for 3 months worth of data :"+(score/size));
		
	}
}
