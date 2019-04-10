package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Model.airlineReview;
import Model.twitter;

public class airlineReviewManger {
	
	
	
	//Create ChampionList airline
public ArrayList<airlineReview>getAirlineReviewBySingapore(){
		
		String urlString = "http://localhost:8983/solr/airlineClassificationFinal";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());
		SolrQuery query = new SolrQuery();
		query.set("q","airline:(Singapore) ");
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
			airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
			if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
	    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
	    		//System.out.println(score[0]+" "+i);
	    		}
	    		else {
	    			airlineReviewModel.setRating("0/10");
	    		}
			
			
			
			
			
			airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
			
			//System.out.println((docList.get(i).getFieldValue("tweetText")));
			//webhoseModel.setAuthor("Test");
			airlineReview.add(airlineReviewModel);
			
		}
		return airlineReview;

	}
	
public ArrayList<airlineReview>getAirlineReviewByCanada(){
		
		String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());
		SolrQuery query = new SolrQuery();
		query.set("q","airline:(Canada) ");
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
			airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
			if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
	    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
	    		//System.out.println(score[0]+" "+i);
	    		}
	    		else {
	    			airlineReviewModel.setRating("0/10");
	    		}
			
			
			
			
			
			airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
			
			//System.out.println((docList.get(i).getFieldValue("tweetText")));
			//webhoseModel.setAuthor("Test");
			airlineReview.add(airlineReviewModel);
			
		}
		return airlineReview;

	}
public ArrayList<airlineReview>getAirlineReviewByunitedAir(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(United) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByLufthansa(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(Lufthansa) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByAirIndia(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(India) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByAirChina(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(China) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByEvaAir(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(Eva) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
	
	//create champion list for services

public ArrayList<airlineReview>getAirlineReviewBycustomerService(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","text:(customer service) ");
	query.set("{!func}mul(tf(text,customer service),idf(text,customer service))","");
	query.addSort("score", ORDER.desc);
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByfood(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","text:(food) ");
	query.set("{!func}mul(tf(text,food),idf(text,food))","");
	query.addSort("score", ORDER.desc);
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}	
public ArrayList<airlineReview>getAirlineReviewBydelayed(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","airline:(delayed) ");
	query.set("{!func}mul(tf(text,delayed),idf(text,delayed))","");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}	
public ArrayList<airlineReview>getAirlineReviewBycourtesy(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","text:(courtesy) ");
	query.set("{!func}mul(tf(text,courtesy),idf(text,courtesy))","");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByworst(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","text:(worst) ");
	query.set("{!func}mul(tf(text,worst),idf(text,worst))","");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}	
public ArrayList<airlineReview>getAirlineReviewByBoarding(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","text:(boarding) ");
	query.set("{!func}mul(tf(text,boarding),idf(text,boarding))","");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}	


//create champion list based on category
public ArrayList<airlineReview>getAirlineReviewByInFlightService(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","classification:(In-Flight) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByCheckIn(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","classification:(check-in) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByFlightOnTime(){
	
	String urlString = "http://localhost:8983/solr/airlineReviewClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","classification:(On-Time) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}
public ArrayList<airlineReview>getAirlineReviewByCrewCourtesyAndHelpfulness(){
	
	String urlString = "http://localhost:8983/solr/airlineClassificationFinal";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	SolrQuery query = new SolrQuery();
	query.set("q","classification:(Helpfulness) ");
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
		airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
		
	}
	return airlineReview;

}








//get the searched results and passess it to the servlet
		public ArrayList<airlineReview> getAirlineReviewResult(String searchInput ,String queryParameters) {
		String urlString = "http://localhost:8983/solr/airlineClassificationFinal";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());
		
		SolrQuery query = new SolrQuery();
		String airlinequery="";
		
		if(searchInput.toLowerCase().contains("singapore"))
		{
			airlinequery="AND airline:Singapore";
		}
		else if(searchInput.toLowerCase().contains("lufthansa")) {
			airlinequery="AND airline:Lufthansa";
		}else if(searchInput.toLowerCase().contains("china")) {
			airlinequery="AND airline:China";
		}
		else if(searchInput.toLowerCase().contains("canada")) {
			airlinequery="AND airline:Eanada";
		}
		else if(searchInput.toLowerCase().contains("eva")) {
			airlinequery="AND airline:Eva";
		}
		else if(searchInput.toLowerCase().contains("india")) {
			airlinequery="AND airline:India";
		}
		else if(searchInput.toLowerCase().contains("united")) {
			airlinequery="AND airline:United";
		}
//	System.out.println("queryy"+queryParameters);
		if(!queryParameters.equalsIgnoreCase("success")) {
		
			if(queryParameters.equalsIgnoreCase("In-Flight Services")) {
				query.set("q","text:("+searchInput+") AND classification: In-Flight "+airlinequery);
			}
			else if(queryParameters.equalsIgnoreCase("Crew courtesy And Helpfulness"+airlinequery)) {
				query.set("q","text:("+searchInput+") AND classification: Crew "+airlinequery);
			}
			else if(queryParameters.equalsIgnoreCase("Check-In/Boarding Process")) {
				query.set("q","text:("+searchInput+") AND classification: Check-In "+airlinequery);
			}
			else if(queryParameters.equalsIgnoreCase("Flight On-Time Performance")) {
				query.set("q","text:("+searchInput+") AND classification: On-Time "+airlinequery);
	}
			
		}
		else {
			query.set("q","text:("+searchInput+") "+airlinequery);
		}
		System.out.println("test"+query);
		query.set("{!func}mul(tf(text,"+searchInput+"),idf(text,"+searchInput+"))","");
		query.addSort("score", ORDER.desc);
	
		query.setRows(800);
		QueryResponse qResponse = null;
		try {
			qResponse = solr.query(query);
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
			airlineReviewModel.setName(docList.get(i).getFieldValue("name").toString());
			airlineReviewModel.setClassification(docList.get(i).getFieldValue("classification").toString());
			if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
	    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
	    		}
	    		else {
	    			airlineReviewModel.setRating("0/10");
	    		}
			
			
			
			
			
			airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
			
			//System.out.println((docList.get(i).getFieldValue("tweetText")));
			//webhoseModel.setAuthor("Test");
			airlineReview.add(airlineReviewModel);
		}
		
		return airlineReview;
		}
		
		
	
		
		
		
		protected class QESXMLResponseParser extends XMLResponseParser {
		    public QESXMLResponseParser() {
		        super();
		    }

		    @Override
		    public String getContentType() {
		        return "text/xml; charset=UTF-8";
		    }
		}
		

		public static void main(String args[]) {
			//String test="K Johnson (United States) 2nd August 2017";
			ArrayList<airlineReview> test=new ArrayList<airlineReview>();
			filterQueryAirlineReview filter= new filterQueryAirlineReview();
			
			airlineReviewManger temp= new airlineReviewManger();
			//test=temp.getAirlineReviewWordcount();
			
		}
		
		
		
		
}