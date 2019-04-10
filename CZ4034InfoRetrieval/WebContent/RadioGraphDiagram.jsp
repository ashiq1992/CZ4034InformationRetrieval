<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*,Model.Webhose,Model.twitter,Model.airlineReview" %>
    <%@ page import="java.util.*,Model.radarGraphParam,java.text.DecimalFormat" %>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>Airline Search Engine</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet"/>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <link rel="stylesheet" href="css/lineicons.css"/>
    <link rel="stylesheet" href="css/weather-icons.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/styles.css"/>
     <script src="js/jquery.js">   </script>
<script src="js/Chart.min.js"></script>
	
	      <script type="text/javascript">
function wireEvent()
{
	 $("#loadingScreen").hide();
	 
	
}
</script>

  </head>

  
  <script type="text/javascript">
  $(document).ready(function() {  

      $('#submitQuery').click(function(event) { 

    	  window.location.href = "index.jsp";
    	 
  
      });
      $('#submitQueryGraph').click(function(event) { 
    	  //alert("inside");
      
		   var search= $("#airlineOptions").val();
		  // alert(search);
		   if(search!="Select Airline"){
			
			   $.ajax({
				    type: "post",
				    url: "RadarGraphServlet", //this is my servlet
					data: {search:search},
				   beforeSend: function() {
					   
					   $("#indexBody").hide();
					   $("#loadingScreen").show();
			      },
			      complete: function(data) {
			    	  
			    	  window.location.href = "RadioGraphDiagram.jsp";	          
			          
			      },
				});

		   }
		   else{
			 //  alert("success");
		   }
  });
  });
  </script>
     <% 
    ArrayList<twitter> twitter=(ArrayList<twitter>)session.getAttribute("twitterResults");
    ArrayList<airlineReview> airlineReview=(ArrayList<airlineReview>)session.getAttribute("airlineReviewResults");
    session.setAttribute("airlineReview", airlineReview);
    session.setAttribute("twitterResults", twitter);
    ArrayList<radarGraphParam> results=(ArrayList<radarGraphParam>)session.getAttribute("GraphParams");
    radarGraphParam twitter1=(radarGraphParam)session.getAttribute("Twitter");
    String airline=(String)session.getAttribute("Airlines");
    ArrayList<Double> scatterGraphScore=(ArrayList<Double>)session.getAttribute("scatterGraphScore");
    ArrayList<radarGraphParam> twitterPlot=(ArrayList<radarGraphParam>)session.getAttribute("TwitterPlot");
   
    
    %>
  
  <body onload="wireEvent()">
<div id="indexBody" >
    <div class="theme-hero-area">
       <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url();" id="hero-banner"></div>
        <div class="theme-hero-area-mask theme-hero-area-mask-strong" style="background: #878484;"></div>
      </div>
      
     
      <div class="theme-hero-area-body">
         <nav class="navbar navbar-default navbar-inverse navbar-theme navbar-theme-abs navbar-theme-transparent navbar-theme-border" id="main-nav">
      <div class="container">
        <div class="navbar-inner nav">
          <div class="navbar-header">
            <button class="navbar-toggle collapsed" data-target="#navbar-main" data-toggle="collapse" type="button" area-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">
              <p style="color:white;">Home Page</p>
            </a>
          </div>
          <div class="collapse navbar-collapse" id="navbar-main">
            <ul class="nav navbar-nav">
           
          
        </ul>
         
          </div>
          
        </div>
      </div>
    </nav>
      
        <% double flightScore=0,checkinScore=0,crewScore=0,flightOnTimeScore=0,tweetScore=0,totalScore1=0;
        double flightSize,checkinSize,crewSize,flightOnTimeSize=0;
        double divide=0;
        DecimalFormat df2 = new DecimalFormat("###.#");
 
        if(results.get(0).getScore()!=0){
        	 flightOnTimeScore=(results.get(0).getScore()/results.get(0).getSize());
        }
        else{
        	flightOnTimeScore=0;
        }
   if(results.get(1).getScore()!=0){
		 checkinScore=(results.get(1).getScore()/results.get(1).getSize());
        }
        else{
        	checkinScore=0;
        }
   if(results.get(2).getScore()!=0){
	   crewScore=(results.get(2).getScore()/results.get(2).getSize());
   }
   else{
	   crewScore=0;
   }
   if(results.get(3).getScore()!=0){
	   flightScore=(results.get(3).getScore()/results.get(3).getSize());
   }
   else{
	   flightScore=0;
   }
        //need to add the twitter sentiments to the score
       // tweetScore=(twitter1.getPositive()/(twitter1.getPositive()+twitter1.getNegative()))*10;
       // divide++;
  for(int i=0;i<results.size();i++){
	  System.out.println(results.get(i).getScore()+" "+results.get(i).getPositive()+" "+results.get(i).getNegative()+" "+results.get(i).getSize());
  }
  
  divide=results.get(0).getSize()+results.get(1).getSize()+results.get(2).getSize()+results.get(3).getSize();
  System.out.println("total score: " +(flightScore+checkinScore+crewScore+flightOnTimeScore)+" divide "+divide);
  
  double totalScore=(results.get(0).getScore()+results.get(1).getScore()+results.get(2).getScore()+results.get(3).getScore())/divide;//+tweetScore)/divide;
  double totalReview=results.get(0).getSize()+results.get(1).getSize()+results.get(2).getSize()+results.get(3).getSize();//+twitter1.getScore();
  %>
      
        <div class="theme-page-section _pt-150 _pb-100 _pv-mob-50" style="background: steelblue;">
           <div class=" theme-search-area-options-center theme-search-area-options-dot-white clearfix">
                        <div class="row">  
                           <div class="theme-search-area-tabs-header _c-w _ta-c _mb-20">
                    <h4 class="theme-search-area-tabs-title theme-search-area-tabs-title-sm">Graphical reviews on Airline</h4>
                  </div>
                        <div class="col-md-4 col-md-offset-3">
                      <div class="theme-payment-page-form-item form-group">
                        <i class="fa fa-angle-down"></i>
                        <select id="airlineOptions" class="form-control">
                          <option>Select Airline</option>
                          <option>Singapore Airline</option>
                          <option>Air India</option>
                          <option>Air canada</option>
                          <option>Lufthansa</option>
                          <option>United Airlines</option>
                          <option>Air China</option>
                          <option>Air Eva</option>
                     
                        </select>
                          </div>
                          </div>
                           <div class="  col-md-2">
                              <input type="submit" id="submitQueryGraph"    style="color: black;" class="theme-search-area-submit _mt-0 theme-search-area-submit-no-border theme-search-area-submit-white theme-search-area-submit-sm theme-search-area-submit-curved" value="update">                           
                              </div>
                          </div>    
                         
            </div>
        
        
        
        
          <div class="container">
          

            <div class="row">

              <div class="col-md-12 ">
                <div class="theme-search-area-tabs">
                  <div class="theme-search-area-tabs-header _c-w _ta-c _mb-20">
                  <div class="row">
           <h4 class="theme-search-area-tabs-title theme-search-area-tabs-title-sm" style="margin-Top: 50px;"><%=airline %> Statistics</h4>
          </div>
                  </div>
                  <div class="tabbable">
              
                    <div class="tab-content _pt-10">
                    
                    
                    
                      <div class="tab-pane active" id="SearchAreaTabs-1" role="tab-panel">
                        <div class="theme-search-area theme-search-area-stacked theme-search-area-white">
                          <div class="theme-search-area-form">
                                                <div class="row">
         <div class="col-md-4">
         
         <div class="col-md-8">
            <div class="theme-reviews-score-header">
                              <h5 class="theme-reviews-score-title" >Latest Review score from Jan to Apr 2019 </h5>
                               <p class="theme-reviews-score-subtitle" style="color:white;"> Based on reviews </p>
                              <p class="theme-reviews-score-subtitle" style="color:white;"></p>
                            </div>
                            <div class="theme-reviews-score-total"style="background: skyblue;">
                              <p><%=df2.format( scatterGraphScore.get(0)) %></p>
                            </div>
                            </div>
                            <div class="col-md-4">
         </div>
         </div>
         
          <div class="col-md-4">
           <div class="col-md-2">
          </div>
          <div class="col-md-8">
          <div class="theme-reviews-score-header">
                              <h5 class="theme-reviews-score-title" >Average Review Score from 2016 - 2019 </h5>
                              <p class="theme-reviews-score-subtitle" style="color:white;">Based on reviews</p>
                            </div>
                            <div class="theme-reviews-score-total"style="background: lightsalmon;">
                            <%  %>
                              <p><%=df2.format( totalScore) %></p>
                            </div>
         </div>
          <div class="col-md-2">
          </div>
         </div>
         
          <div class="col-md-4">
          <div class="col-md-4">
          </div>
          <div class="col-md-8">
          <div class="theme-reviews-score-header">
                              <h5 class="theme-reviews-score-title" >Average twitter Score from Mar to Apr 2019</h5>
                              <p class="theme-reviews-score-subtitle" style="color:white;">Based on Positive tweets</p>
                            </div>
                            <div class="theme-reviews-score-total"style="background: palevioletred;">
                            <%
                          double score= ( twitterPlot.get(0).getPositive()/(twitterPlot.get(0).getPositive()+twitterPlot.get(0).getNegative()+twitterPlot.get(0).getNeutral()))*100;
                            %>
                              <p><%=df2.format( score) %>%</p>
                            </div>
         </div>
         
         </div>
          </div>
                          
                          
                          
                          <div class="row" data-gutter="60">
                          <div class="col-md-12 ">
                            <div class="theme-reviews-score-list">
                            <div class="row">
                                 <div class="col-md-12 ">
                                 <canvas id="scatterGraph" class="chartjs" width="1925" height="962" style="display: block; height: 100px; width: 200px;"></canvas>
                                 <script>new Chart(document.getElementById("scatterGraph"),
                                		 {"type":"line","data":{"labels":["January - April (2017) ","May - August (2017)","September - December (2017)","January - April (2018) ","May - August (2018)","September - December (2018)","January - April (2019) "],
                                			 "datasets":[{"label":"Airline Score Form 2017 to 2019","data":[<%= scatterGraphScore.get(6)%>,<%= scatterGraphScore.get(5)%>,<%= scatterGraphScore.get(4)%>,<%= scatterGraphScore.get(3)%>,<%= scatterGraphScore.get(2)%>,<%= scatterGraphScore.get(1)%>,<%= scatterGraphScore.get(0)%>],"fill":false,
                                				 "borderColor":"#FFD36E","lineTension":0.1}]},"options":{}});</script>
                                </div>
                            </div>
                            
                            
                              <div class="row">
                                <div class="col-md-6 ">
                                  <div class="theme-reviews-score-item">
  <canvas id="chartjs-0" class="chartjs" width="1925" height="962" style="display: block; height: 500px; width: 770px;"></canvas>
<script>
Chart.defaults.global.defaultFontColor = 'white';
new Chart(document.getElementById("chartjs-0"),{"type":"doughnut","data":
{"labels":["positive","negative"],"datasets":[{"label":"","data":[<%= results.get(3).getPositive() %>,<%= results.get(3).getNegative() %>],
	"backgroundColor":["#00FF00","#FF5C3E"]}]}});</script>                         

                                    <div class="theme-reviews-score-item-header">
                                      <p class="theme-reviews-score-item-title">Inflight Services</p>
                                      <p class="theme-reviews-score-item-num"><%=df2.format( flightScore)%></p>
                                    </div>
                                    <div class="theme-reviews-score-item-bar">
                                      <div style="width:<%=df2.format( flightScore*10)%>%;"></div>
                                    </div>

                                  </div>
                                  <div class="theme-reviews-score-item">
  <canvas id="chartjs-1" class="chartjs" width="1925" height="962" style="display: block; height: 500px; width: 770px;"></canvas>
<script>new Chart(document.getElementById("chartjs-1"),{"type":"doughnut","data":
{"labels":["positive","negative"],"datasets":[{"label":"","data":[<%= results.get(1).getPositive() %>,<%= results.get(1).getNegative() %>],
	"backgroundColor":["#00FF00","#FF5C3E"]}]}});</script>                         
 
                                    <div class="theme-reviews-score-item-header">
                                      <p class="theme-reviews-score-item-title">Check-In/Boarding Process</p>
                                      <p class="theme-reviews-score-item-num"><%=df2.format( checkinScore)%> </p>
                                    </div>
                                    <div class="theme-reviews-score-item-bar">
                                      <div style="width:<%=df2.format( checkinScore*10)%>%;"></div>
                                    </div>
   
                                    
                                    
                                  </div>
                              
                              
                                </div>
                           
                                <div class="col-md-6 ">
                             
                                 <div class="theme-reviews-score-item">
                                                                                                     <canvas id="chartjs-2" class="chartjs" width="1925" height="962" style="display: block; height: 500px; width: 770px;"></canvas>


				<script>new Chart(document.getElementById("chartjs-2"),{"type":"doughnut","data":
{"labels":["positive","negative"],"datasets":[{"label":"","data":[<%= results.get(0).getPositive() %>,<%= results.get(0).getNegative() %>],
	"backgroundColor":["#00FF00","#FF5C3E"]}]}});</script>                       
 
                                    <div class="theme-reviews-score-item-header">
                                      <p class="theme-reviews-score-item-title">Flight On-Time Performance</p>
                                      <p class="theme-reviews-score-item-num"><%=df2.format( flightOnTimeScore) %></p>
                                    </div>
                                    <div class="theme-reviews-score-item-bar">
                                      <div style="width:<%=df2.format( flightOnTimeScore*10)%>%;"></div>
                                    </div>

                                  </div>
                                  <div class="theme-reviews-score-item">
                                                                  <canvas id="chartjs-3" class="chartjs" width="1925" height="962" style="display: block; height: 500px; width: 770px;"></canvas>
                          <script>new Chart(document.getElementById("chartjs-3"),{"type":"doughnut","data":
                          {"labels":["positive","negative"],"datasets":[{"label":"","data":[<%= results.get(2).getPositive() %>,<%= results.get(2).getNegative() %>],
                        	  "backgroundColor":["#00FF00","#FF5C3E"]}]}});</script>
                         
                                    <div class="theme-reviews-score-item-header">
                                      <p class="theme-reviews-score-item-title">Crew courtesy And Helpfulness</p>
                                      <p class="theme-reviews-score-item-num"><%=df2.format( crewScore) %></p>
                                    </div>
                                    <div class="theme-reviews-score-item-bar">
                                      <div style="width:<%=df2.format( crewScore*10)%>%;"></div>
                                    </div>
                           
                                  </div>
                               
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="row " >
                      <div class="col-md-12">
                       <div class="theme-reviews-list theme-reviews-list-scored _bg-w pre-scrollable" >
                       <div class="" style="margin-top: 10px; margin-left: 10px; margin-right: 10px;">
                       <%for(int review=0;review<airlineReview.size();review++){ %>
                        <article class="theme-reviews-item">
                          <div class="row" data-gutter="10">
                            <div class="col-md-3 ">
                              <div class="theme-reviews-item-info">
                               <h5 class="theme-search-results-item-title _fw-b _mb-20 _fs theme-search-results-item-title-lg"><%=  airlineReview.get(review).getAirline()%></h5>
                               
                               
                               
                                <p class="theme-reviews-item-author"style="color: black;"><%= airlineReview.get(review).getAuthor() %></p>
                                    
                               <%if(airlineReview.get(review).getClassification().equalsIgnoreCase("In-Flight Services")){
                            	   %>
                            	     <p style=" background: bisque;color: black;">In flight Services</p>
                            	   <%}
                               
                               else if (airlineReview.get(review).getClassification().equalsIgnoreCase("Crew courtesy And Helpfulness")){
                               %>
                                 <p style="background: lightsalmon;color: black;">Crew courtesy And Helpfulness</p>
                               <%}
                               else if(airlineReview.get(review).getClassification().equalsIgnoreCase("Check-In/Boarding Process")){
                            	   %>
                            	     <p style="background: lightskyblue;color: black;">Check-In/Boarding Process</p>
                               <% }else if(airlineReview.get(review).getClassification().equalsIgnoreCase("Flight On-Time Performance")){
                            	   %>
                            	     <p style="background: palevioletred;color: black;">Check-In/Boarding Process</p>
                               <%}
                         
                               %>
                              
                                
                                   
                            
                            
                             
                                
                              </div>
                            </div>
                            <div class="col-md-9 ">
                              <div class="theme-reviews-rating"style="color: black;">
                                <div class="theme-reviews-rating-header">
                                  <span class="theme-reviews-rating-num"><%= airlineReview.get(review).getRating() %></span>
                                  <span class="theme-reviews-rating-title"></span>
                                </div>
                                <div class="theme-reviews-rating-bar">
                                <%
                                if(!airlineReview.get(review).getRating().contains("na")){
                                String ratingStr[]=airlineReview.get(review).getRating().split("/");
                                int rating=Integer.parseInt(ratingStr[0])*10; %>
                                  <div style="width:<%=rating%>%;"></div>
                                  <%}
                                else{%>
                                
                                <div style="width:0%;"></div>
                                <%} %>
                                </div>
                              </div>
                               <h5 class="theme-search-results-item-title _fw-b _mb-20 _fs theme-search-results-item-title-lg"><%= airlineReview.get(review).getName() %></h5>
                              <div class="theme-reviews-item-body">
                                <p class="theme-reviews-item-text"><%= airlineReview.get(review).getText().replace("?", "") %></p>
                              </div>
                            </div>
                          </div>
                        </article>
               				 <%} %>
                     </div>
                      </div>
                      

                        
                             <div class="row "style="margin-top: 20px;">
                                 <div class="col-md-12 ">
                          <h4 class="theme-search-area-tabs-title theme-search-area-tabs-title-sm" style="margin-Top: 50px;">Twitter Sentiment Graph (Tweets vs Date)</h4>
                                
                                 <canvas id="scatterGraphTwitter" class="chartjs" width="1925" height="962" style="display: block; height: 100px; width: 200px;"></canvas>
                                 <script>new Chart(document.getElementById("scatterGraphTwitter"),
                                		 {"type":"line","data":{"labels":["July - August (2018)","September - October (2018) ","November - December (2018)","January - Febuary (2019)","March - April (2019) "],
                                			 "datasets":[{"label":"POSITIVE","data":[<%= twitterPlot.get(4).getPositive() %>,<%= twitterPlot.get(3).getPositive()%>,<%= twitterPlot.get(2).getPositive()%>,
                                			 <%= twitterPlot.get(1).getPositive()%>,<%= twitterPlot.get(0).getPositive()%>],"fill":false,
                                				 "borderColor":"#50C878","lineTension":0.1},
                                			 {"label":"Neutral","data":[<%= twitterPlot.get(4).getNeutral() %>,<%= twitterPlot.get(3).getNeutral()%>,<%= twitterPlot.get(2).getNeutral()%>,
                                    			 <%= twitterPlot.get(1).getNeutral()%>,<%= twitterPlot.get(0).getNeutral()%>],"fill":false,
                                    				 "borderColor":"#E4DAC2","lineTension":0.1},
                                			 
                                			 {"label":"Negative","data":[<%= twitterPlot.get(4).getNegative() %>,<%= twitterPlot.get(3).getNegative()%>,<%= twitterPlot.get(2).getNegative()%>,
                                    			 <%= twitterPlot.get(1).getNegative()%>,<%= twitterPlot.get(0).getNegative()%>],"fill":false,
                                    				 "borderColor":"#E23D28","lineTension":0.1}
                                			 
                                			 
                                			 ]},"options":{}});</script>
                                </div>
                            </div>
                        
                        
                        
                         <div class="theme-reviews-list theme-reviews-list-scored _bg-w pre-scrollable">
                       <div class="" style=" margin-left: 10px; margin-right: 10px;">
                       <%for(int tweet=0;tweet<twitter.size();tweet++){ %>
                        <article class="theme-reviews-item">
                          <div class="row" data-gutter="10">
                            <div class="col-md-3 ">
                              <div class="theme-reviews-item-info">
                                <img class="theme-reviews-item-avatar" src="./img/twitterLogo.png" alt="Image Alternative text" title="Image Title"/>
                                <p class="theme-reviews-item-date"style="color: black;">created on:<%= twitter.get(tweet).getPublishedDate() %></p>
                                <p class="theme-reviews-item-author"style="color: black;">by <%=twitter.get(tweet).getTwitterHandleName() %></p>
                              </div>
                            </div>
                            <div class="col-md-9 ">
                              <div class="theme-reviews-rating">
                                <div class="theme-reviews-rating-header" style="color: black;">
                                  <span class="theme-reviews-rating-num"><%= twitter.get(tweet).getRetweets() %></span>
                                  <span class="theme-reviews-rating-title">Retweets</span>
                                                   <span class="theme-reviews-rating-num"><%= twitter.get(tweet).getFavourites() %></span>
                                  <span class="theme-reviews-rating-title">favourites</span>
                                </div>
                            
                              </div>
                              <div class="theme-reviews-item-body">
                              <h5 class="theme-search-results-item-title _fw-b _mb-20 _fs theme-search-results-item-title-lg"><%= twitter.get(tweet).getAirline()  %></h5>
                                <p class="theme-reviews-item-text"><%= twitter.get(tweet).getContent() %></p>
                                
                                     <div class="theme-search-results-item-book">
                      <%String twitterLink="https://twitter.com/"; %>
                        <a class="btn btn-primary-inverse btn-block theme-search-results-item-price-btn" href=<%=twitterLink+twitter.get(tweet).getUrl() %>>twitter Redirect</a>
                          
                        </div>
                                
                              
                              
                              </div>
                            </div>
                          </div>
                        </article>
              			  <%} %>
                        </div>
                       
                      </div>
                            </div>
                            
                          </div>
                          
                          
                          
                          
                            <div class="row" data-gutter="">
                        	
                              
                     
                          
                              
                              
                       			<div class="col-md-12">
                       					    <div class="col-md-4 ">
                            
                              
                               
                              </div>
                       			
                       			    <div class="col-md-4 ">
                            
                              
                              <input type="button" id="submitQuery"    style="color: black;" class="theme-search-area-submit  theme-search-area-submit-no-border theme-search-area-submit-white theme-search-area-submit-sm theme-search-area-submit-curved" value="Back Home">
                               
                              </div>
                              		    <div class="col-md-4 ">
                            
                              
                               
                              </div>
                       			
                       			</div>
                       
                            </div>
                   
                        
                          </div>
              
                      </div>
               
                    
                    
                    
                    </div>
                  </div>
                
                </div>
              </div>
              
              
              
            </div>
          </div>



      </div>
    </div>
    
   
    <div class="theme-page-section theme-page-section-xxl theme-page-section-gray">

    </div>


    <div class="theme-copyright">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <p class="theme-copyright-text">Airline Travel News
            </p>
          </div>
          <div class="col-md-6">
            <ul class="theme-copyright-social">
              <li>
                <a class="fa fa-facebook" href="#"></a>
              </li>
              <li>
                <a class="fa fa-google" href="#"></a>
              </li>
              <li>
                <a class="fa fa-twitter" href="#"></a>
              </li>
              <li>
                <a class="fa fa-youtube-play" href="#"></a>
              </li>
              <li>
                <a class="fa fa-instagram" href="#"></a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    </div>
    </div>
        
      
        
          <div id="loadingScreen" >
  	<div class="theme-hero-area theme-hero-area-full">
      <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url('https://www.tripsavvy.com/thmb/MYp3ZNtnA90fAy2RkknlKl9ts1I=/960x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-544355433-5a999b3c04d1cf0038ba9716.jpg');"></div>
        <div class="theme-hero-area-mask theme-hero-area-mask-strong"></div>
        <div class="theme-hero-area-inner-shadow"></div>
      </div>
      <div class="theme-hero-area-body theme-hero-area-body-vert-center">
        <div class="container">
          <div class="theme-loading">
            <div class="row">
              <div class="col-md-8 col-md-offset-2">
                <div class="spinner theme-loading-spinner">
                  <div class="spinner-grid-dots">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                  </div>
                </div>
                <div class="theme-loading-body">
                  <h2 class="theme-loading-title">Just a moment</h2>
                  <p class="theme-loading-subtitle">We are looking at your request
                   
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <a class="theme-abs-logo" href="index.html">
        <img src="img/logo.png" alt="Image Alternative text" title="Image Title"/>
      </a>
    </div>
  </div>
  

  

        
        <script src="js/autoSearch.js"></script>
    
    <script src="js/moment.js"></script>
    <script src="js/bootstrap.js"></script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDYeBBmgAkyAN_QKjAVOiP_kWZ_eQdadeI&callback=initMap&libraries=places"></script>
    <script src="js/owl-carousel.js"></script>
    <script src="js/blur-area.js"></script>
    <script src="js/icheck.js"></script>
    <script src="js/gmap.js"></script>
    <script src="js/magnific-popup.js"></script>
    <script src="js/ion-range-slider.js"></script>
    <script src="js/sticky-kit.js"></script>
    <script src="js/smooth-scroll.js"></script>
    <script src="js/fotorama.js"></script>
    <script src="js/bs-datepicker.js"></script>
   
    <script src="js/quantity-selector.js"></script>
    <script src="js/countdown.js"></script>
    <script src="js/window-scroll-action.js"></script>
    <script src="js/fitvid.js"></script>
    <script src="js/youtube-bg.js"></script>
    <script src="js/custom.js"></script>
    

    
    
    
  </body>
</html>