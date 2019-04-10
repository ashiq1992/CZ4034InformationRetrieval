package Control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import Model.airlineReview;
import Model.twitter;

public class filterQueryAirlineReview {

	
	
	public ArrayList<airlineReview> filterByRating(ArrayList<airlineReview> reviews) {
		Collections.sort(reviews, airlineReview.airlineReviewComparatorRating);
		ArrayList<airlineReview> temp= new ArrayList<airlineReview>();
		
		for(int i=reviews.size()-1;i>=0;i--) {
			temp.add(reviews.get(i));
		}
		return temp;
	}
	
	public ArrayList<airlineReview> filterByAirline(ArrayList<airlineReview> reviews) {
		Collections.sort(reviews, airlineReview.airlineReviewComparatorAirline);
	
		return reviews;
	}
	
	public ArrayList<airlineReview> filterByDate(ArrayList<airlineReview> reviews) {
		
		Collections.sort(reviews, airlineReview.airlineReviewComparatorDate);
		return reviews;
	}

	
	
	
}
