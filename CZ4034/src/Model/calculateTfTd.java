package Model;

import java.util.ArrayList;
import java.util.Comparator;

public class calculateTfTd implements Comparable<calculateTfTd>{
	

	
	int index;
	String bagOfwords[];
	double tfScore=0;
	double idfScore=0;
	double tfidfScore=0;
	

	
	public double getTfScore() {
		return tfScore;
	}
	public void setTfScore(double tfScore) {
		this.tfScore = tfScore;
	}
	public double getIdfScore() {
		return idfScore;
	}
	public void setIdfScore(double idfScore) {
		this.idfScore = idfScore;
	}
	public double getTfidfScore() {
		return tfidfScore;
	}
	public void setTfidfScore(double tfidfScore) {
		this.tfidfScore = tfidfScore;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String[] getBagOfwords() {
		return bagOfwords;
	}
	public void setBagOfwords(String[] bagOfwords) {
		this.bagOfwords = bagOfwords;
	}
	public double computetfIdfScore() {
		this.tfidfScore=this.tfScore*this.idfScore;
		return this.tfidfScore;
	}
	
	
	public static Comparator<calculateTfTd> calculateTfTdComparator = new Comparator<calculateTfTd>()
	{
		public int compare(calculateTfTd i1,calculateTfTd i2)
		{
			
			return Double.compare(i1.getTfidfScore(), i2.getTfidfScore());
		}
	};

	@Override
	public int compareTo(calculateTfTd o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
