package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Model.airlineReview;

public class WordCount {

	public ArrayList<airlineReview> getAirlineReviewWordcount() {
		Map <String, Integer> wordCount = new HashMap <String, Integer>();	
		
		
		
	String urlString = "http://localhost:8983/solr/airlineReviewClassification";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	
	SolrQuery query = new SolrQuery();
	

	query.set("q","*:*");
	

	query.setRows(4000);
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
		if(!(docList.get(i).getFieldValue("rating").toString().equalsIgnoreCase("na"))) {
    		airlineReviewModel.setRating(docList.get(i).getFieldValue("rating").toString());
    		//System.out.println(score[0]+" "+i);
    		}
    		else {
    			airlineReviewModel.setRating("0/10");
    		}
		
		
		
		
		
		airlineReviewModel.setText(docList.get(i).getFieldValue("text").toString());
		StringTokenizer sentenceBreaker = new StringTokenizer(airlineReviewModel.getText());
		String str="";
		while(sentenceBreaker.hasMoreElements())
		{ 
			
			str = (String) sentenceBreaker.nextElement();
			str = str.trim();
			str = str.toLowerCase();
			Integer count = wordCount.get(str);
			
			if (count == null) {
				wordCount.put(str, 1);
			}
			else {
				wordCount.put(str, count + 1);
			}
		}
		
		
		
		//System.out.println((docList.get(i).getFieldValue("tweetText")));
		//webhoseModel.setAuthor("Test");
		airlineReview.add(airlineReviewModel);
	}
	System.out.println(airlineReview.size());
	
	MyComparator comp = new MyComparator(wordCount);

    Map<String, Integer> newMap = new TreeMap(comp);
    newMap.putAll(wordCount);
    
    
    
    //System.out.println(newMap);
	
	
	System.out.println(wordCount.size());
	
	return airlineReview;
	}
	
	public static void main(String args[]) {
		
		WordCount test=new WordCount();
		test.getAirlineReviewWordcount();
	}
	
}



class MyComparator implements Comparator {
    Map map;

        public MyComparator(Map map) {
        this.map = map;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return (o2.toString()).compareTo(o1.toString());
    }
}


