package Model;

public class radarGraphParam {
	String classification;
	double score;
	double positive;
	double negative;
	double neutral=0;
	public double getNeutral() {
		return neutral;
	}
	public void setNeutral(double neutral) {
		this.neutral = neutral;
	}
	String rating;
	int size=0;
	public void addContent(double score,int pos,int neg,int size) {
		this.score=score;
		this.positive=pos;
		this.negative=neg;
		this.size=size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public double getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public double getPositive() {
		return positive;
	}
	public void setPositive(int positive) {
		this.positive = positive;
	}
	public double getNegative() {
		return negative;
	}
	public void setNegative(int negative) {
		this.negative = negative;
	}

	
	

}
