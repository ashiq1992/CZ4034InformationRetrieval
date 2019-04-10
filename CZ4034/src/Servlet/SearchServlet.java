package Servlet;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import Control.airlineReviewManger;
import Control.twitterManager;
import Control.webhoseManager;
import Model.Webhose;
import Model.airlineReview;
import Model.twitter;

import org.apache.catalina.Session;
import org.apache.commons.httpclient.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		
		HttpSession session=request.getSession();  
		String category;
		String searchInput=request.getParameter("finalSearch");
		if(request.getParameter("category")!=null) {
			category=request.getParameter("category");
		}
		else {
			category="success";
		}
		
		
		System.out.println("My search input"+searchInput);
		System.out.println("My search input"+category);
		
		
		twitterManager twitter=new twitterManager();
		airlineReviewManger airlineReview=new airlineReviewManger();
		
		ArrayList<twitter> twitterResults=new ArrayList<twitter>();
		ArrayList<airlineReview> airlineReviewResults = new ArrayList<airlineReview>();
		
		try {
			twitterResults=twitter.getTwitterResult(searchInput, "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(category.equalsIgnoreCase("sucess")) {
		airlineReviewResults=airlineReview.getAirlineReviewResult(searchInput, "");
		}
		else {
			airlineReviewResults=airlineReview.getAirlineReviewResult(searchInput, category);
		}
		
		session.setAttribute("twitterResults", twitterResults);
		session.setAttribute("airlineReviewResults", airlineReviewResults);
		session.setAttribute("query", searchInput);
		//response.sendRedirect("searchResult.jsp");
		doGet(request, response);
	}

}
