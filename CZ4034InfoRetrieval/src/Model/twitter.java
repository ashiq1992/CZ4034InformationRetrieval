package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class twitter implements Comparable<twitter>{

	private String twitterHandleName;
	private String name;
	private String content;
	private String retweets;
	private String favourites;
	private String publishedDate;
	private String url;
	private String airline;
	private Date date;
	private String type;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTwitterHandleName() {
		return twitterHandleName;
	}
	public void setTwitterHandleName(String twitterHandleName) {
		this.twitterHandleName = twitterHandleName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRetweets() {
		return retweets;
	}
	public void setRetweets(String retweets) {
		this.retweets = retweets;
	}
	public String getFavourites() {
		return favourites;
	}
	public void setFavourites(String favourites) {
		this.favourites = favourites;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) throws ParseException {
		this.publishedDate = publishedDate;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
       // String dateInString = "14 Mar 2019";
        if(this.publishedDate.contains("/")) {
        	//System.out.println("hello");
        	String[] temp=this.publishedDate.split("/");
        	
        	temp[2]=temp[2].split(" ")[0];
    		String dateFormat[]=temp[0].split(" ");
    		for(int i=0;i<dateFormat.length;i++)
    		{
    			//System.out.println("dateeeee: "+dateFormat[i]);
    		}
    		if(dateFormat[0].equals("1"))
    		{
    			dateFormat[0]="JAN";
    		}
    		
    		else if(dateFormat[0].equals("2"))
    		{
    			dateFormat[0]="FEB";
    		}
    		
    		else if(dateFormat[0].equals("3"))
    		{
    			dateFormat[0]="MAR";
    		}
    		
    		else if(dateFormat[0].equals("4"))
    		{
    			dateFormat[0]="APR";
    		}
    		
    		else if(dateFormat[0].equals("5"))
    		{
    			dateFormat[0]="MAY";
    		}
    		   		
    		else if(dateFormat[0].equals("6"))
    		{
    			dateFormat[0]="JUN";
    		}
    		
    		else if(dateFormat[0].equals("7"))
    		{
    			dateFormat[0]="JUL";
    		}
    		
    		else if(dateFormat[0].equals("8"))
    		{
    			dateFormat[0]="AUG";
    		}
    		
    		else if(dateFormat[0].equals("9"))
    		{
    			dateFormat[0]="SEP";
    		}
    		
    		else if(dateFormat[0].equals("10"))
    		{
    			dateFormat[0]="OCT";
    		}
    		
    		else if(dateFormat[0].equals("11"))
    		{
    			
    			dateFormat[0]="NOV";
    		}
    		
    		else if (dateFormat[0].equals("12"))
    		{
    			dateFormat[0]="DEC";
    		}
    		this.date=formatter.parse(temp[1]+"-"+dateFormat[0]+"-"+temp[2]);
    		//System.out.println("date   "+this.date);
        }
        else{
        	String temp[]=this.publishedDate.split("-");
    		String dateFormat[]=temp[1].split(" ");
//    		System.out.println(dateFormat[1]);
//    		System.out.println(dateFormat[2]);
//    		System.out.println(dateFormat[3]);
    		this.date=formatter.parse(dateFormat[1]+"-"+dateFormat[2]+"-"+dateFormat[3]);
        }
		
		
	}
	public static Comparator<twitter> getTwitterComparatorDate() {
		return twitterComparatorDate;
	}
	public static void setTwitterComparatorDate(Comparator<twitter> twitterComparatorDate) {
		twitter.twitterComparatorDate = twitterComparatorDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	
	
	public static Comparator<twitter> twitterComparatorAirline = new Comparator<twitter>()
	{
		public int compare(twitter i1,twitter i2)
		{
				
			return i1.getAirline().toLowerCase().compareToIgnoreCase(i2.getAirline().toLowerCase());
		}
	};
	public static Comparator<twitter> twitterComparatorDate = new Comparator<twitter>()
	{
		public int compare(twitter i1,twitter i2)
		{

			 return i1.getDate().compareTo(i2.getDate());
		}
	};

	

	@Override
	public int compareTo(twitter o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String dateInString =date;
            Date datenew;
			try {
				datenew = formatter.parse(dateInString);
				  //System.out.println("Stored "+datenew);
		          //  System.out.println("Stored2 :"+formatter.format(datenew));
		    		this.date =datenew;
		    		//System.out.println("Stored"+this.date);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}
