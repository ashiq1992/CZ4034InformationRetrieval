package Servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Control.radarGraphManager;
import Model.airlineReview;
import Model.radarGraphParam;
import Model.twitter;

/**
 * Servlet implementation class RadarGraphServlet
 */
@WebServlet("/RadarGraphServlet")
public class RadarGraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadarGraphServlet() {
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
		// TODO Auto-generated method stub
		
		
		HttpSession session=request.getSession();  
		
		String searchInput=request.getParameter("search");
		
		System.out.println("My search input"+searchInput);
		radarGraphManager query= new radarGraphManager();
		ArrayList<radarGraphParam> results=new  ArrayList<radarGraphParam>();
		ArrayList<radarGraphParam>TwitterPlot=new  ArrayList<radarGraphParam>();
		ArrayList<twitter> twitterResults=new ArrayList<twitter>();
		ArrayList<airlineReview> airlineReviewResults = new ArrayList<airlineReview>();
		radarGraphParam twitter=new radarGraphParam();
		 ArrayList<Double> ScatterGraphScore= new ArrayList<Double>();
		
		try {
			
			results=query.getFlightServicesScore(searchInput, "");
			twitter=query.getTwitterScore(searchInput, "");
			airlineReviewResults=query.getFlightServicesResult(searchInput, "");
			twitterResults=query.getTwitterResult(searchInput, "");
			ScatterGraphScore=query.calculateScoreByquaterly(searchInput);
			TwitterPlot=query.calculateTwitterScoreByQuaterly(searchInput);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(results.size());
		
		session.setAttribute("GraphParams", results);
		session.setAttribute("Twitter", twitter);
		session.setAttribute("Airlines", searchInput);
		session.setAttribute("twitterResults", twitterResults);
		session.setAttribute("airlineReviewResults", airlineReviewResults);
		session.setAttribute("scatterGraphScore", ScatterGraphScore);
		session.setAttribute("TwitterPlot", TwitterPlot);
		
		 DecimalFormat df2 = new DecimalFormat("###.##");
		doGet(request, response);
		
	}

}
