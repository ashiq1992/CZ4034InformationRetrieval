<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.Webhose,Model.twitter,Model.airlineReview" %>

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
         <!-- For type ahead -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src ="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<!-- end of config -->
  </head>
 
   <script type="text/javascript">
  

  
  function myFunction(data)
  {
	  
	  
	 
	  $("#searchInputId").val(data);
	  $('#suggestions').hide();
  }
  </script>
 
      <script type="text/javascript">
function wireEvent()
{
	 $("#loadingScreen").hide();
	  $("#loadingScreenMidBody").hide();
	
}
</script>



  
   <script type="text/javascript">
  $(document).ready(function() {  
	  
	  //document.getElementById("suggestions").style.visibility = "hidden";
	   $('#submitcategory').click(function(event) { 
		   var finalSearch= $("#searchInputId").val();
		   var category= $("#category").val();
		//   alert(category);
		   if(category!="Category"){
			
			   $.ajax({
				    type: "post",
				    url: "SearchServlet", //this is my servlet
					data: {finalSearch:finalSearch,category:category},
				   beforeSend: function() {
					   
					   $("#midBodyContent").hide();
						$("#loadingScreenMidBody").show();
			      },
			      complete: function(data) {
			    	  
			    	  window.location.href = "search_results_2.jsp";	          
			          
			      },
			      success: function(data) {
			    	 // alert("success");
	  	                $("#midBodyContent").show();
						  $("#loadingScreenMidBody").hide();
		                $("#refreshContent").load(location.href + " #refreshContent");
		             
		      	
		   	        	 window.scrollTo(0,0);
		   	        	
		                }
				});

		   }
		   else{
			
		   }
		   

	  		
	   });
	  
	  
	  
	  
	  $('#suggestions').hide();
	  //document.getElementById("suggestions").style.visibility = "hidden";
      $('#submitQuery').click(function(event) { 
  var search= $("#searchInputId").val();
 
  $.ajax({
	    type: "post",
	    url: "SpellCheck", //this is my servlet
		data: {search:search},
	   beforeSend: function() {
		   $('#suggestions').hide();
      },
      complete: function(data) {
    	  var split=data.responseText.split(',');
    	
    	  
    	if(split[1]=="false")
    		{
    		//window.location.href = "SearchServlet.java";
    		  var finalSearch= $("#searchInputId").val();
    		
    		  $.ajax({
    			    type: "post",
    			    url: "SearchServlet", //this is my servlet
    				data: {finalSearch:finalSearch},
    			   beforeSend: function() {
    				   $("#midBodyContent").hide();
						$("#loadingScreenMidBody").show();
    		      },
    		      complete: function(data) {
    		    	  
    		    	  window.location.href = "search_results_2.jsp";
    		          
    		          
    		      },
    		      success: function(data) {
  	                $("#midBodyContent").show();
					  $("#loadingScreenMidBody").hide();
	                $("#refreshContent").load(location.href + " #refreshContent");
	             
	      	
	   	        	 window.scrollTo(0,0);
	   	        	
	                }
    		                 
    		     

    			});
    		
    		}
    	
    	else
    		{
    		$("#correctedWord").val(split[0]);
  		  $('#suggestions').show();
  		  $('#suggestedText').text(split[0]);
    		
    		}
    	  
		
		  
		 
          
          
      },
                 
     

	});
  
      });
      
      

      
      
      
      
  });
  </script>

   <body onload="wireEvent()";>

    <div id="indexBody">
    <% 
    ArrayList<twitter> twitter=(ArrayList<twitter>)session.getAttribute("twitterResults");
    ArrayList<airlineReview> airlineReview=(ArrayList<airlineReview>)session.getAttribute("airlineReviewResults");
    session.setAttribute("airlineReview", airlineReview);
    session.setAttribute("twitterResults", twitter);
    String query= (String)session.getAttribute("query");
    %>
    
    
    
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
              <li class="">
               

              </li>
          
        </ul>
         
          </div>
          
        </div>
      </div>
    </nav>
 <div class="theme-hero-area front">
      <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url('https://mivelezmalaga.com/wp-content/uploads/2017/02/aircraft-herobanner-for-tourism-1500x800.jpg');" id="hero-banner"></div>
        <div class="theme-hero-area-mask theme-hero-area-mask-strong"></div>
      </div>
      <div class="theme-hero-area-body">
        <div class="container">
          <div class="row _pv-100">
            <div class="col-md-10 col-md-offset-1">
              <div class="theme-search-area  theme-search-area-stacked">
                <div class="theme-search-area-header _mb-30 _ta-c _c-w">
                  <h1 class="theme-search-area-title theme-search-area-title-sm">Search airline</h1>
                  <p class="theme-search-area-subtitle"></p>
                </div>
                <div class="theme-search-area-form _bsh-xxl _bsh-light" id="hero-search-form">
                  <div class="row" data-gutter="none">
                    <div class="col-md-10 ">

                          <div class="theme-search-area-section first theme-search-area-section-curved theme-search-area-section-sm theme-search-area-section-bg-white theme-search-area-section-no-border theme-search-area-section-mr">
                            <div class="theme-search-area-section-inner">
                             
                               <div class="ui-widget">
                              <input  name="searchInput" id="searchInputId" class="theme-search-area-section-input" type="text" value= "<%=query.replaceAll("/", "") %>"/>
                           </div>
                            </div>
                          </div>

                    </div> 
                    <div class="col-md-2 ">
                      <input     type="submit" id="submitQuery" class="theme-search-area-submit _mt-0 theme-search-area-submit-curved theme-search-area-submit-sm theme-search-area-submit-no-border"  value="Search"></input>
                    </div>
                    
                        <div id="suggestions" class="btn-group theme-search-area-options-list  _mb-30 _ta-c _c-w" data-toggle="buttons">
                          <h4>Did you mean?</h4>
                              <label id="suggestedText" onclick="myFunction($(this).text());" class="btn btn-primary  _mb-30 _ta-c _c-w">
                                <input id="suggestedOption" type="radio"  name="flight-options" id="flight-option-1" >Round Trip</label>
                                
                              
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
  </body>
</html>


<div class="theme-page-section _pt-0 _pb-60 front theme-page-section-gray">
  <div class="container">
    <div class="row">
      <div class="col-md-10 col-md-offset-1">
        <div class="theme-item-page-tabs _mt--90 _mt-mob--60">

       
       
               <div id="midBodyContent">
       
         <div id="refreshContent">
          <div class="tabbable">
          
            <ul class="nav nav-tabs nav-white nav-no-br nav-sqr nav-center nav-mob-inline" role="tablist">
              <li class="active" role="presentation">
                 <a class="_ph-30" aria-controls="airline_review" role="tab" data-toggle="tab" href="#airline_review_tab">Airline reviews</a>
              </li>
              <li role="presentation">
                <a class="_ph-30" aria-controls="twitter" role="tab" data-toggle="tab" href="#twitter_tab">Twitter</a>
              </li>
          
        
            </ul>
            <div class="tab-content _p-30 _bg-w _bsh-xl">
            

              <div class="tab-pane active" id="airline_review_tab" role="tab-panel">
               <div class="theme-reviews">
               <div class="row" data-gutter="60">
               <div class="col-md-">
            <div class="theme-search-results-sort clearfix">
              <h5 class="theme-search-results-sort-title">Sort by:</h5>
              <ul class="theme-search-results-sort-list">
                <li class="">
                  <a class="" id="rating" onclick="sort('rating','null')">Rating
                    <span>High &rarr; Low</span>
                  </a>
                </li>
                <li class="" >
                  <a class=""  id="airline" onclick="sort('airline','null')">Airline
                    <span>alphabetical order</span>
                  </a>
                </li>
           
                <li>
                	
                </li>
                <li>
             
                
                </li>
              </ul>
        
            </div>
          
            </div>
            </div>
                  <div class="row" data-gutter="60">
                   
                    <div class="col-md-12 ">
                    <div class="row">
                    <div class="col-md-4">
                     <h5>Total results found: <%= airlineReview.size()%></h5>
                    </div>
                    <div class="col-md-8">
                           <div class="row">
               <div class="col-md-2">
               <h5>Sort by category</h5>
               </div>
              			         <div class="col-md-6">
                      <div class="theme-payment-page-form-item form-group">
                        <i class="fa fa-angle-down"></i>
                        <select id="category" class="form-control">
                          <option>Category</option>
                          <option>In-Flight Services</option>
                          <option>Crew courtesy And Helpfulness</option>
                          <option>Check-In/Boarding Process</option>
                          <option>Flight On-Time Performance</option>
                        
                     
                        </select>
                          </div>
                          </div>
                            <div class="  col-md-2">
                              <input type="button" id="submitcategory"    style="background: coral;color: white;" class="theme-search-area-submit _mt-0 theme-search-area-submit-no-border theme-search-area-submit-white theme-search-area-submit-sm theme-search-area-submit-curved" value="Sort">                           
                              </div>
                              </div>
                    </div>
                    </div>
                  
                      <div class="theme-reviews-list theme-reviews-list-scored">
                       <%for(int review=0;review<airlineReview.size();review++){ %>
                        <article class="theme-reviews-item">
                          <div class="row" data-gutter="10">
                            <div class="col-md-3 ">
                           
                              <div class="theme-reviews-item-info">
                              
                               
                               <h5 class="theme-search-results-item-title _fw-b _mb-20 _fs theme-search-results-item-title-lg"><%=  airlineReview.get(review).getAirline()%></h5>
                                 <p class="theme-reviews-item-author"><%= airlineReview.get(review).getAuthor() %></p>
                               
                               
                               <%if(airlineReview.get(review).getClassification().equalsIgnoreCase("In-Flight Services")){
                            	   %>
                            	     <p style=" background: bisque;">In flight Services</p>
                            	   <%}
                               
                               else if (airlineReview.get(review).getClassification().equalsIgnoreCase("Crew courtesy And Helpfulness")){
                               %>
                                 <p style="background: lightsalmon;">Crew courtesy And Helpfulness</p>
                               <%}
                               else if(airlineReview.get(review).getClassification().equalsIgnoreCase("Check-In/Boarding Process")){
                            	   %>
                            	     <p style="background: lightskyblue;">Check-In/Boarding Process</p>
                               <% }else if(airlineReview.get(review).getClassification().equalsIgnoreCase("Flight On-Time Performance")){
                            	   %>
                            	     <p style="background: palevioletred;">Flight On-Time Performance</p>
                               <%}
                         
                               %>
                              
                                
                                   
                            
                            
                             
                           
                           
                           
                             
                              </div>
                            </div>
                            <div class="col-md-9 ">
                              <div class="theme-reviews-rating">
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
                  </div>
                </div>
              </div>
           
              <div class="tab-pane" id="twitter_tab" role="tab-panel">
                <div class="theme-reviews">
                
               <div class="row"  data-gutter="60">
               <div class="col-md-12">
            <div class="theme-search-results-sort  clearfix">
              <h5 class="theme-search-results-sort-title">Sort by:</h5>
              <ul class="theme-search-results-sort-list">
              
                <li class="">
                  <a class="" id="airline" onclick="sort('null','airline')">Airline
                    <span>High &rarr; Low</span>
                  </a>
                </li>
                <li class="" >
                  <a class=""  id="date" onclick="sort('null','date')">Date
                    <span>latest &rarr; oldest</span>
                  </a>
                </li>
             
                <li>
              
                </li>
              </ul>
          
            </div>
            </div>
            </div>
                
                
                
                  <div class="row" data-gutter="60">
               
                    <div class="col-md-12 ">
                    <h5>Total results found: <%= twitter.size()%></h5>
                      <div class="theme-reviews-list theme-reviews-list-scored">
                       <%for(int tweet=0;tweet<twitter.size();tweet++){ %>
                        <article class="theme-reviews-item">
                          <div class="row" data-gutter="10">
                            <div class="col-md-3 ">
                              <div class="theme-reviews-item-info">
                                <img class="theme-reviews-item-avatar" src="./img/twitterLogo.png" alt="Image Alternative text" title="Image Title"/>
                                <p class="theme-reviews-item-date">created on:<%= twitter.get(tweet).getPublishedDate() %></p>
                                <p class="theme-reviews-item-author">by <%=twitter.get(tweet).getTwitterHandleName() %></p>
                              </div>
                            </div>
                            <div class="col-md-9 ">
                              <div class="theme-reviews-rating">
                                <div class="theme-reviews-rating-header">
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
                        
                        <div class="row">
                          <div class="col-md-9 col-md-offset-3">
                            <a class="theme-reviews-more" href="#">&#x2b; More Reviews</a>
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
       
       
           <div id="loadingScreenMidBody" style="margin-top: 100px;">

      <div class="">
        <div class="">
          <div class="theme-loading">
            <div class="row">
              <div class="">
                <div class="spinner theme-loading-spinner">
                  <div class="spinner-grid-dots" ">
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                    <div style="background-color:black;"></div>
                  </div>
                </div>
                <div class="theme-loading-body"style="color: black;">
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
      </div>
    </div>
  </div>
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
<<script type="text/javascript">
<!--

//-->

function sort(airlinefilter,twitterfilter){
	//var filterairline=e.id.val();
	//alert(airlinefilter);
	if(airlinefilter!='null'){
    $.ajax({
		    type: "post",
		    url: "filterServlet", //this is my servlet
			data: {airlinefilter:airlinefilter,twitterfilter:twitterfilter},
		   beforeSend: function() {
				
			   $("#midBodyContent").hide();
				$("#loadingScreenMidBody").show();
	      },
	      complete: function(data) {
	    	  
	    	  $("#midBodyContent").show();
			  $("#loadingScreenMidBody").hide();
           $("#refreshContent").load(location.href + " #refreshContent");

	      },    	                success: function(data) {
	    	  window.location.href = "search_results_2.jsp";	    
	        	 window.scrollTo(0,0);   	
        }


		});
	}
	
	else{
		
		 $.ajax({
			    type: "post",
			    url: "filterServlet", //this is my servlet
				data: {airlinefilter:airlinefilter,twitterfilter:twitterfilter},
			   beforeSend: function() {
					
					
				   $("#midBodyContent").hide();
					$("#loadingScreenMidBody").show();
		      },
		      complete: function(data) {
		    	  
		    	  $("#midBodyContent").show();
				  $("#loadingScreenMidBody").hide();
	           $("#refreshContent").load(location.href + " #refreshContent");

		      },    	                success: function(data) {
	      
		        	 window.scrollTo(0,0);   	
	        }


			});
		
	}
    
    
    
    
    }

</script>
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