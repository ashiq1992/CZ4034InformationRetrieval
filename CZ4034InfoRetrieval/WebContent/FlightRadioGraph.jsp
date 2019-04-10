<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*,Model.radarGraphParam" %>
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
    	 

  /**
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
    				   $("#indexBody").hide();
					   $("#loadingScreen").show();
    		      },
    		      complete: function(data) {
    		    	  
    		    	  window.location.href = "search_results_2.jsp";
    		          
    		          
    		      },
    		                 
    		     

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
    	   **/
  
      });
   
      
  });
  </script>
  
  
  <body onload="wireEvent()">
<div id="indexBody" >
    <div class="theme-hero-area">
       <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url(./img/airplane.jpg);" id="hero-banner"></div>
        <div class="theme-hero-area-mask theme-hero-area-mask-strong"></div>
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
              <img src="img/logo.png" alt="Image Alternative text" title="Image Title"style="max-width: 200%;max-height: 190%;"/>
            </a>
          </div>
          <div class="collapse navbar-collapse" id="navbar-main">
            <ul class="nav navbar-nav">
              <li class="">
                <a class="" href="/HighFlyer/index.jsp"  role="button" >Booking Page</a>

              </li>
          
        </ul>
         
          </div>
          
        </div>
      </div>
    </nav>
      
      
      
        <div class="theme-page-section _pt-150 _pb-100 _pv-mob-50">
          <div class="container">
            <div class="row">
              <div class="col-md-10 col-md-offset-1">
                <div class="theme-search-area-tabs">
                  <div class="theme-search-area-tabs-header _c-w _ta-c _mb-20">
                  <% String airline=(String)session.getAttribute("Airlines"); %>
                    <h1 class="theme-search-area-tabs-title theme-search-area-tabs-title-sm">Reviews of <%=airline %> in pictorial form </h1>
                  </div>
                  <div class="tabbable">
              
                    <div class="tab-content _pt-10">
                      <div class="tab-pane active" id="SearchAreaTabs-1" role="tab-panel">
                        <div class="theme-search-area theme-search-area-stacked theme-search-area-white">
                          <div class="theme-search-area-form">
                      
                            <div class="row" data-gutter="">
                              <div class="col-md-12 ">
                                <div class="theme-search-area-section first theme-search-area-section-fade-white theme-search-area-section-no-border theme-search-area-section-mr theme-search-area-section-sm theme-search-area-section-curved">
                                  <div class="theme-search-area-section-inner">
                      				<canvas id="myChart" style="display: block;height: 500px;width: 500px;background: white;"></canvas>
                                    
                                  </div>
                                </div>
                                
                              </div>
                              
                                <div class="col-md-12">
                                <div class="theme-search-area-section first theme-search-area-section-fade-white theme-search-area-section-no-border theme-search-area-section-mr theme-search-area-section-sm theme-search-area-section-curved">
                                  <div class="theme-search-area-section-inner">
                      				<canvas id="myChart2" style="display: block;height: 500px;width: 500px;background: white;"></canvas>
                                    
                                  </div>
                                </div>
                                
                              </div>
                              
                                  <div class="col-md-12">
                                <div class="theme-search-area-section first theme-search-area-section-fade-white theme-search-area-section-no-border theme-search-area-section-mr theme-search-area-section-sm theme-search-area-section-curved">
                                  <div class="theme-search-area-section-inner">
                      				<canvas id="myChart3" style="display: block;height: 500px;width: 500px;background: white;"></canvas>
                                    
                                  </div>
                                </div>
                                
                              </div>
                              
                              
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
            <p class="theme-copyright-text">Copyright &copy; 2018
              <a href="#">HighFlyer</a>. All rights reserved.
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
        
        </div>
        
          <div id="loadingScreen" >
  	<div class="theme-hero-area theme-hero-area-full">
      <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url('http://s1.1zoom.me/b5050/475/Passenger_Airplanes_501163_3840x2160.jpg');"></div>
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
  
    <script >
  <% ArrayList<radarGraphParam> results=(ArrayList<radarGraphParam>)session.getAttribute("GraphParams");
  radarGraphParam twitter=(radarGraphParam)session.getAttribute("Twitter");
%>

new Chart(document.getElementById("myChart"),
		{"type":"bar","data":{"labels":["<%= results.get(0).getClassification() %>","<%= results.get(1).getClassification() %>","<%= results.get(2).getClassification() %>","<%= results.get(3).getClassification() %>"],
			"datasets":[{"label":"airline review Positive reviews","data":[<%= results.get(0).getPositive() %>,<%= results.get(1).getPositive() %>,<%= results.get(2).getPositive() %>,<%= results.get(3).getPositive() %>],"fill":false,
			"backgroundColor":["rgba(255, 99, 132, 0.2)","rgba(255, 159, 64, 0.2)","rgba(255, 205, 86, 0.2)",
			"rgba(75, 192, 192, 0.2)","rgba(54, 162, 235, 0.2)","rgba(153, 102, 255, 0.2)","rgba(201, 203, 207, 0.2)"],
			"borderColor":["rgb(255, 99, 132)","rgb(255, 159, 64)","rgb(255, 205, 86)","rgb(75, 192, 192)","rgb(54, 162, 235)",
			"rgb(153, 102, 255)","rgb(201, 203, 207)"],"borderWidth":1}]},"options":{"scales":{"yAxes":[{"ticks":{"beginAtZero":true}}]}}});


  new Chart(document.getElementById("myChart2"),
		  {"type":"bar","data":{"labels":["<%= results.get(0).getClassification() %>","<%= results.get(1).getClassification() %>","<%= results.get(2).getClassification() %>","<%= results.get(3).getClassification() %>"],
				"datasets":[{"label":"airline review Negative reviews","data":[<%= results.get(0).getNegative() %>,<%= results.get(1).getNegative() %>,<%= results.get(2).getNegative() %>,<%= results.get(3).getNegative() %>],"fill":false,
				"backgroundColor":["rgba(255, 99, 132, 0.2)","rgba(255, 159, 64, 0.2)","rgba(255, 205, 86, 0.2)",
				"rgba(75, 192, 192, 0.2)","rgba(54, 162, 235, 0.2)","rgba(153, 102, 255, 0.2)","rgba(201, 203, 207, 0.2)"],
				"borderColor":["rgb(255, 99, 132)","rgb(255, 159, 64)","rgb(255, 205, 86)","rgb(75, 192, 192)","rgb(54, 162, 235)",
				"rgb(153, 102, 255)","rgb(201, 203, 207)"],"borderWidth":1}]},"options":{"scales":{"yAxes":[{"ticks":{"beginAtZero":true}}]}}});
  
  
  new Chart(document.getElementById("myChart3"),
		  
		  {"type":"doughnut","data":{"labels":["Positive","Negative"],
			"datasets":[{"label":"Twitter Review ","data":[<%= twitter.getPositive() %>,<%= twitter.getNegative() %>],
			 "backgroundColor":["rgb(255, 99, 132)","rgb(54, 162, 235)"]}]}});
  
  
  
  
  
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
    

    
    
    
  </body>
</html>