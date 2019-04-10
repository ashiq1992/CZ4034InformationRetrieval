package Control;

import java.util.ArrayList;
import java.util.Collections;

import Model.twitter;

public class filterQueryTwitter {

	
	
	
	public ArrayList<twitter>filterbyAirline(ArrayList<twitter> reviews){
		
		Collections.sort(reviews, twitter.twitterComparatorAirline);
		return reviews;

		
	}
	
	public ArrayList<twitter>filterbyDate(ArrayList<twitter> reviews){
		ArrayList<twitter>temp=new ArrayList<twitter>();
		
		Collections.sort(reviews, twitter.twitterComparatorDate);
		for(int i=reviews.size()-1;i>=0;i--) {
			
			temp.add(reviews.get(i));
		}
		return temp;

		
	}
	
}
