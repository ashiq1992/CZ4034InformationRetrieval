package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.amarjeet.spellcorrect.SpellCorrector;

/**
 * Servlet implementation class SpellCheck
 */
@WebServlet("/SpellCheck")
public class SpellCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpellCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchInput=request.getParameter("search").toLowerCase();
		String correctedWord="";
		 String wrongWords=null;
		boolean flag=false;
		
		Scanner sc = new Scanner(searchInput);
		sc.useDelimiter(" ");
		ArrayList<String> tokenisedInput = new ArrayList<String>();
		while(sc.hasNext())
		{
			tokenisedInput.add(sc.next().trim());
		}
		
		if(tokenisedInput.get(tokenisedInput.size()-1).isEmpty())
		{
			tokenisedInput.remove(tokenisedInput.size()-1);
		}
		
				
		try{
			  
		    SpellCorrector spellCorrector = new SpellCorrector();
		    spellCorrector.setEditLimit(5); //[optional]
		    spellCorrector.setSuggestedWordListLimit(10); //[optional]
//		    for(int i=0;i<tokenisedInput.size();i++) {
//		    	
//		    	 LinkedHashMap<String, Integer> wordList = wordList = spellCorrector.correct(searchInput);
//		    
//		  
//
//
//		    System.out.println("Word\t\tDistance");
//		    for (String word : wordList.keySet()) {
//		    	if(wordList.get(word).equals(0)) {
//		    		correctedWord="";
//		    		break;
//		    	}
//		    	else {
//		    		correctedWord=word;
//		    		break;
//		    	}
//		    	//System.out.println(word +"\t\t"+wordList.get(word));
//		    }
//		    }
		   
			
		    for(int i=0;i<tokenisedInput.size();i++) {
		    	System.out.println("Input string"+tokenisedInput.get(i));
		    	 LinkedHashMap<String, Integer> wordList = wordList = spellCorrector.correct(tokenisedInput.get(i));
		    	 
		  //  	 System.out.println("Word\t\tDistance");
		    for (String word : wordList.keySet()) {
		    	if(wordList.get(word).equals(0)) {
		    		correctedWord+=word+" ";
		    		break;
		    	}
		    	else {
		    		wrongWords=word;
		  //  		 System.out.println(word +"\t\t"+wordList.get(word));
		    		break;
		    	}
		  
		    }
		    
		    
		    if(wrongWords!=null) {
		    	flag=true;
				   correctedWord=correctedWord+wrongWords+" ";
				 
				   wrongWords="";
			   }
		    }
		   

		}
		catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		
	
		response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8");
	response.getWriter().write(correctedWord+','+flag);
		
	}

}
