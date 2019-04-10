package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Control.filterQueryAirlineReview;
import Control.filterQueryTwitter;
import Model.airlineReview;
import Model.twitter;

/**
 * Servlet implementation class filterServlet
 */
@WebServlet("/filterServlet")
public class filterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filterServlet() {
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
		HttpSession session = request.getSession(true);

		filterQueryAirlineReview airline=new filterQueryAirlineReview();
		filterQueryTwitter tweet=new filterQueryTwitter();
		ArrayList<airlineReview> airlineReview=(ArrayList<airlineReview>)session.getAttribute("airlineReview");
		ArrayList<twitter>twitter=(ArrayList<twitter>)session.getAttribute("twitterResults");
		String sortParamsAirline=(String)request.getParameter("airlinefilter");
		String sortParamsTwitter=(String)request.getParameter("twitterfilter");
		System.out.println(sortParamsAirline);
		
		
		if(sortParamsAirline.equalsIgnoreCase("rating")) {
			airlineReview=airline.filterByRating(airlineReview);
		}
		if(sortParamsAirline.equalsIgnoreCase("airline")) {
			airlineReview=airline.filterByAirline(airlineReview);
		}
		if(sortParamsTwitter.equalsIgnoreCase("airline")) {
			twitter=tweet.filterbyAirline(twitter);
		}
		if(sortParamsTwitter.equalsIgnoreCase("date")) {
			twitter=tweet.filterbyDate(twitter);
		}
		//System.out.println(operation);
		
		session.setAttribute("airlineReviewResults", airlineReview);
		session.setAttribute("twitterResults", twitter);
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
