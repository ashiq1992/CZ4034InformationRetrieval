<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	      <script type="text/javascript">
function wireEvent()
{
	 $("#loadingScreen").hide();
	 
	
}
</script>
  </head>
  

  
  
  <script type="text/javascript">
  

  
  function myFunction(data)
  {
	  
	  
	 
	  $("#searchInputId").val(data);
	  $('#suggestions').hide();
  }
  </script>
  
  <script type="text/javascript">
  $(document).ready(function() {  
	  $('#suggestions').hide();
	  //document.getElementById("suggestions").style.visibility = "hidden";
	   $('#submitQueryGraph').click(function(event) { 
		   var search= $("#airlineOptions").val();
		  // alert(search);
		   if(search!="State/Region"){
			
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
      
      
      
        <div class="theme-page-section _pt-150 _pb-100 _pv-mob-50">
          <div class="container">
            <div class="row">
              <div class="col-md-10 col-md-offset-1">
                <div class="theme-search-area-tabs">
                  <div class="theme-search-area-tabs-header _c-w _ta-c _mb-20">
                    <h1 class="theme-search-area-tabs-title theme-search-area-tabs-title-sm">Search for Travel News</h1>
                  </div>
                  <div class="tabbable">
              
                    <div class="tab-content _pt-10">
                      <div class="tab-pane active" id="SearchAreaTabs-1" role="tab-panel">
                        <div class="theme-search-area theme-search-area-stacked theme-search-area-white">
                          <div class="theme-search-area-form">
                      
                            <div class="row" data-gutter="none">
                              <div class="col-md-10 ">
                                <div class="theme-search-area-section first theme-search-area-section-fade-white theme-search-area-section-no-border theme-search-area-section-mr theme-search-area-section-sm theme-search-area-section-curved">
                                  <div class="theme-search-area-section-inner">
                                   
                                   <div class="ui-widget">
                                    <input id="searchInputId" name="searchInput" class="theme-search-area-section-input" type="text" placeholder="E.g airlines" />
                                    </div>
                                    
                                  </div>
                                </div>
                              </div>
                       
                              <div class="col-md-2 ">
                            
                              
                              <input type="submit" id="submitQuery"    style="color: black;" class="theme-search-area-submit _mt-0 theme-search-area-submit-no-border theme-search-area-submit-white theme-search-area-submit-sm theme-search-area-submit-curved" value="Search">
                               
                              </div>
                            </div>
                           
                           
                          <div id="suggestions" class="btn-group theme-search-area-options-list" data-toggle="buttons">
                          <h4>Did you mean?</h4>
                              <label id="suggestedText" onclick="myFunction($(this).text());" class="btn btn-primary">
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
             <div class="row">
                      	
                      	<div class=" col-md-10 col-md-offset-1">
                      		
           
            
                
                  <button class="collapsed btn-info btn-md _mt-20 " href="#collapseOne" data-toggle="collapse" aria-expanded="false" aria-controls="">More Options <i class="lin lin-arrow-down "></i></button>
             
              </div>
            
            	
								  
			</div>
          <div class="row">
          <div class="col-md-10 col-md-offset-1">
          <div id="collapseOne" class=" collapse">
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
                              <input type="submit" id="submitQueryGraph"    style="color: black;" class="theme-search-area-submit _mt-0 theme-search-area-submit-no-border theme-search-area-submit-white theme-search-area-submit-sm theme-search-area-submit-curved" value="Search">                           
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