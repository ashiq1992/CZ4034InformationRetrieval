package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Control.airlineReviewManger;

import Model.airlineReview;
import Model.calculateTfTd;

public class indexer {
	
	/**
	 * every term has a Tf and idf for each document and idf is caculated across all document
	 * 
	 * 
	 * 
	 */
	
	/**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
//    public double tf(List<String> doc, String term) {
//        double result = 0;
//        for (String word : doc) {
//            if (term.equalsIgnoreCase(word))
//                result++;
//        }
//        return result / doc.size();
//    }
    
    public void tf(ArrayList<calculateTfTd> doc, String term) {
    	 //calculate TF for each review/twitter
        double result = 0;
        for(int k=0;k<doc.size();k++) {
        	
        for (int j=0;j<doc.get(k).getBagOfwords().length;j++) {
            if (term.equalsIgnoreCase(doc.get(k).getBagOfwords()[j]))
                result++;
        }
        doc.get(k).setTfScore(result/doc.get(k).getBagOfwords().length);
      
        }
        
       //return result / doc.size();
    }
    
    
    
    

    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
//    public double idf(List<List<String>> docs, String term) {
//        double n = 0;
//        for (List<String> doc : docs) {
//            for (String word : doc) {
//                if (term.equalsIgnoreCase(word)) {
//                    n++;
//                    break;
//                }
//            }
//        }
//        return Math.log(docs.size() / n);
//    }
    
    public void idf(ArrayList<calculateTfTd> doc, String term) {
  
      //calculate IDF for each review/twitter
        
        double result = 0;
        for(int k=0;k<doc.size();k++) {
        	
        for (int j=0;j<doc.get(k).getBagOfwords().length;j++) {
            if (term.equalsIgnoreCase(doc.get(k).getBagOfwords()[j]))
                result++;
            break;
        }
    
        //System.out.println(doc.get(k).getIdfScore());
        }
        System.out.println(Math.log(doc.size()/result));
        for(int y=0;y<doc.size();y++) {
        	doc.get(y).setIdfScore(Math.log(doc.size()/result));
        }
       
    }
    

    public static void main(String[] args) {
    	ArrayList<calculateTfTd> arrayOfText=new ArrayList<calculateTfTd>();
    	
    	airlineReviewManger review=new airlineReviewManger();
    	ArrayList<airlineReview> airlineReviewResults = new ArrayList<airlineReview>();
    	
    	airlineReviewResults=review.getAirlineReviewResult("United Airlines", "");
    	
    	for(int i=0;i<airlineReviewResults.size();i++) {
    		String word[];
    		calculateTfTd temp=new calculateTfTd();
    		word=airlineReviewResults.get(i).getText().split(" ");
    		temp.setBagOfwords(word);
    		temp.setIndex(i);
    		arrayOfText.add(temp);
    		
    	}
    	
    	 indexer calculator = new indexer();
    	 String term="united";
    	 calculator.tf(arrayOfText, term);
    	 calculator.idf(arrayOfText, term);
    		Collections.sort(arrayOfText, calculateTfTd.calculateTfTdComparator);
    	 
    	 
    	 for(int u=0;u<arrayOfText.size();u++) {
    		 System.out.println("index= "+u+" id= "+arrayOfText.get(u).getIndex()+" TF-IDF score: "+arrayOfText.get(u).computetfIdfScore());
    	 }
    	 Collections.sort(arrayOfText, calculateTfTd.calculateTfTdComparator);
    	System.out.println("=====================================================================");
    	 for(int u=arrayOfText.size()-1;u>0;u--) {
    		 System.out.println("index= "+u+" id= "+arrayOfText.get(u).getIndex()+" TF-IDF score: "+arrayOfText.get(u).computetfIdfScore());
    	
    	 }
    	 
    	 
    	//print the values out 
    	System.out.println(airlineReviewResults.get(arrayOfText.get(arrayOfText.size()-2).getIndex()).getText());
    	
//        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3);
//
//        indexer calculator = new indexer();
//        double tfidf = calculator.tfIdf(doc1, documents, "ipsum");
//        System.out.println("TF-IDF (ipsum) = " + tfidf);


    }
	
	

}
