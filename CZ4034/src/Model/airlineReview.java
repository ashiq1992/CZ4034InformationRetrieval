package Model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class airlineReview implements Comparable<airlineReview>{

	private String name;
	private String rating;
	private String author;
	private String type;
	private String classification;
	private double score=0;
	  public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}

	private Date dateTime;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String dateInString =date;
            Date datenew;
			try {
				datenew = formatter.parse(dateInString);
				  //System.out.println("Stored "+datenew);
		          //  System.out.println("Stored2 :"+formatter.format(datenew));
		    		this.dateTime =datenew;
		    	//	System.out.println(this.dateTime);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          

     
		

	}

	private String airline;
	private String text;
	
	public static Comparator<airlineReview> airlineReviewComparatorRating = new Comparator<airlineReview>()
	{
		public int compare(airlineReview i1,airlineReview i2)
		{
			String strRate1[];
			String strRate2[];
		
			strRate1=i1.getRating().split("/");
			strRate2=i2.getRating().split("/");
//			System.out.println(strRate1[0]);
//			System.out.println(strRate2[0]);
			double rating1 = Double.parseDouble(strRate1[0]);
			double rating2 = Double.parseDouble(strRate2[0]);
			
			return Double.compare(rating1, rating2);
		}
	};
	
	public static Comparator<airlineReview> airlineReviewComparatorAirline = new Comparator<airlineReview>()
	{
		public int compare(airlineReview i1,airlineReview i2)
		{
				
			return i1.getAirline().toLowerCase().compareToIgnoreCase(i2.getAirline().toLowerCase());
		}
	};
	public static Comparator<airlineReview> airlineReviewComparatorDate = new Comparator<airlineReview>()
	{
		public int compare(airlineReview i1,airlineReview i2)
		{

			 return i1.getDateTime().compareTo(i2.getDateTime());
		}
	};
	
	
	
	@Override
	public int compareTo(airlineReview o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	
	
}
