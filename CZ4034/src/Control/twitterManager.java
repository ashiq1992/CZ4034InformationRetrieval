package Control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Model.twitter;

public class twitterManager {

public twitterManager(){
		
	}
	
	//get the searched results and passess it to the servlet
	public ArrayList<twitter> getTwitterResult(String searchInput ,String queryParameters) throws ParseException {
	String urlString = "http://localhost:8983/solr/twitterClassificationFinal";
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
	query.set("q","content:("+searchInput+") "+airlinequery);
	query.set("{!func}mul(tf(content,"+searchInput+"),idf(content,"+searchInput+"))","");

	query.addSort("score", ORDER.desc);
	  System.out.println(query.getQuery());
	query.setRows(800);
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
	protected class QESXMLResponseParser extends XMLResponseParser {
	    public QESXMLResponseParser() {
	        super();
	    }

	    @Override
	    public String getContentType() {
	        return "text/xml; charset=UTF-8";
	    }
	}
	
	public static void main (String args[]) {
//		twitterManager test=new twitterManager();
//		ArrayList<twitter>tweetModel=new ArrayList<twitter>();
//		filterQueryTwitter temp=new filterQueryTwitter();
//		
//		try {
//			tweetModel=test.getTwitterResult("customer", "");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		tweetModel=temp.filterbyDate(tweetModel);
//		for(int k=0;k<5;k++) {
//		System.out.println(tweetModel.get(k).getPublishedDate());
//		}
		
//		Date date = null;
//		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//	     String dateInString = " 14 Mar 2019";
//	     String temp[]=dateInString.split(" ");
//	      try {
//			date=formatter.parse(temp[1]+"-"+temp[2]+"-"+temp[3]);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	      System.out.println(date);
	}
	
}
