<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.Webhose" %>

<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>Travel Mate - Car results 2</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet"/>
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet"/>
    <link rel="stylesheet" href="css/font-awesome.css"/>
    <link rel="stylesheet" href="css/lineicons.css"/>
    <link rel="stylesheet" href="css/weather-icons.css"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/styles.css"/>
  </head>
  <body>
 
    <% ArrayList<Webhose> webhose=(ArrayList<Webhose>)session.getAttribute("queryResults");%>
    <div class="theme-hero-area front">
      <div class="theme-hero-area-bg-wrap">
        <div class="theme-hero-area-bg" style="background-image:url(./img/1500x800.png);" id="hero-banner"></div>
        <div class="theme-hero-area-mask theme-hero-area-mask-strong"></div>
      </div>
      <div class="theme-hero-area-body">
        <div class="container">
          <div class="row _pv-100">
            <div class="col-md-10 col-md-offset-1">
              <div class="theme-search-area _mob-h theme-search-area-stacked">
                <div class="theme-search-area-header _mb-30 _ta-c _c-w">
                  <h1 class="theme-search-area-title theme-search-area-title-sm">253 Car Deals in New York</h1>
                  <p class="theme-search-area-subtitle"></p>
                </div>
                <div class="theme-search-area-form _bsh-xxl _bsh-light" id="hero-search-form">
                  <div class="row" data-gutter="none">
                    <div class="col-md-10 ">

                          <div class="theme-search-area-section first theme-search-area-section-curved theme-search-area-section-sm theme-search-area-section-bg-white theme-search-area-section-no-border theme-search-area-section-mr">
                            <div class="theme-search-area-section-inner">
                              <i class="theme-search-area-section-icon lin lin-location-pin"></i>
                              <input class="theme-search-area-section-input typeahead" value="New York" type="text" placeholder="Pick up location" data-provide="typeahead"/>
                            </div>
                          </div>

                    </div> 
                    <div class="col-md-2 ">
                      <button class="theme-search-area-submit _mt-0 theme-search-area-submit-curved theme-search-area-submit-sm theme-search-area-submit-no-border">Change</button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="theme-search-area-inline _desk-h theme-search-area-inline-white">
                <h4 class="theme-search-area-inline-title">New York Cars</h4>
                <p class="theme-search-area-inline-details">June 27 &rarr; July 02</p>
                <a class="theme-search-area-inline-link magnific-inline" href="#searchEditModal">
                  <i class="fa fa-pencil"></i>Edit
                </a>
                <div class="magnific-popup magnific-popup-sm mfp-hide" id="searchEditModal">
                  <div class="theme-search-area theme-search-area-vert">
                    <div class="theme-search-area-header">
                      <h1 class="theme-search-area-title theme-search-area-title-sm">Edit your Search</h1>
                      <p class="theme-search-area-subtitle">Prices might be different from current results</p>
                    </div>
                    <div class="theme-search-area-form">
                      <div class="theme-search-area-section first theme-search-area-section-curved">
                        <label class="theme-search-area-section-label">Pick Up</label>
                        <div class="theme-search-area-section-inner">
                          <i class="theme-search-area-section-icon lin lin-location-pin"></i>
                          <input class="theme-search-area-section-input typeahead" value="New York" type="text" placeholder="Pick up location" data-provide="typeahead"/>
                        </div>
                      </div>
                      <div class="theme-search-area-section theme-search-area-section-curved">
                        <label class="theme-search-area-section-label">Drop Off</label>
                        <div class="theme-search-area-section-inner">
                          <i class="theme-search-area-section-icon lin lin-location-pin"></i>
                          <input class="theme-search-area-section-input typeahead" value="New York" type="text" placeholder="Drop off location" data-provide="typeahead"/>
                        </div>
                      </div>
                      <div class="row" data-gutter="10">
                        <div class="col-md-6 ">
                          <div class="theme-search-area-section theme-search-area-section-curved">
                            <label class="theme-search-area-section-label">Check In</label>
                            <div class="theme-search-area-section-inner">
                              <i class="theme-search-area-section-icon lin lin-calendar"></i>
                              <input class="theme-search-area-section-input datePickerStart _mob-h" value="Wed 06/27" type="text" placeholder="Check-in"/>
                              <input class="theme-search-area-section-input _desk-h mobile-picker" value="2018-06-27" type="date"/>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-6 ">
                          <div class="theme-search-area-section theme-search-area-section-curved">
                            <label class="theme-search-area-section-label">Check Out</label>
                            <div class="theme-search-area-section-inner">
                              <i class="theme-search-area-section-icon lin lin-calendar"></i>
                              <input class="theme-search-area-section-input datePickerEnd _mob-h" value="Mon 07/02" type="text" placeholder="Check-out"/>
                              <input class="theme-search-area-section-input _desk-h mobile-picker" value="2018-07-02" type="date"/>
                            </div>
                          </div>
                        </div>
                      </div>
                      <button class="theme-search-area-submit _mt-0 _tt-uc theme-search-area-submit-curved">Change</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
   
    <div class="theme-page-section theme-page-section-dark theme-page-section-lg">
      <div class="container">
        <div class="row row-col-static" id="sticky-parent" data-gutter="20">
          <div class="col-md-3 ">
       
          </div>
          <div class="col-md-12 ">
           
          
            <div class="theme-search-results">
              <div class="_mob-h">
              <blockquote class="twitter-tweet"><p lang="en" dir="ltr">Happy 50th anniversary to the Wilderness Act! Here&#39;s a great wilderness photo from <a href="https://twitter.com/YosemiteNPS">@YosemiteNPS</a>. <a href="https://twitter.com/hashtag/Wilderness50?src=hash">#Wilderness50</a> <a href="http://t.co/HMhbyTg18X">pic.twitter.com/HMhbyTg18X</a></p>&mdash; US Dept of Interior (@Interior) <a href="https://twitter.com/Interior/status/507185938620219395">September 3, 2014</a></blockquote>n<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
              <%for(int i=0;i<webhose.size();i++){ %>
                <div class="theme-search-results-item _mb-10 _b-n theme-search-results-item-rounded theme-search-results-item-">
                  <div class="theme-search-results-item-preview">
                    <a class="theme-search-results-item-mask-link" href="#"></a>
                    <div class="row" data-gutter="20">
              
                      <div class="col-md-10 ">
                        <h5 class="theme-search-results-item-title _fw-b _mb-20 _fs theme-search-results-item-title-lg"><%=webhose.get(i).getTitle() %></h5>
                        <div class="theme-search-results-item-car-location">
                          
                          <div class="theme-search-results-item-car-location-body">
                            <p class="theme-search-results-item-car-location-title"><%= webhose.get(i).getAuthor() %></p>
                            <p class="theme-search-results-item-car-location-subtitle">Description</p>
                          </div>
                        </div>
                
                      </div>
                      <div class="col-md-2 ">
                        <div class="theme-search-results-item-book">
                        <% System.out.println(webhose.get(i).getUrl()); %>
                        <a class="btn btn-primary-inverse btn-block theme-search-results-item-price-btn" href=<%=webhose.get(i).getUrl() %>>Read Now</a>
                          
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
               <%} %>
         
              </div>
       
              <div class="theme-search-results-mobile-filters" id="mobileFilters">
                <a class="theme-search-results-mobile-filters-btn magnific-inline" href="#MobileFilters">
                  <i class="fa fa-filter"></i>Filters
                </a>
                <div class="magnific-popup mfp-hide" id="MobileFilters">
                  <div class="theme-search-results-sidebar">
                    <div class="theme-search-results-sidebar-sections">
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Price</h5>
                        <div class="theme-search-results-sidebar-section-price">
                          <input id="price-slider-mob" name="price-slider" data-min="100" data-max="500"/>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Pickup Location</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">LGA: LaGuardia</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">452</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">EWR: Newark</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">135</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">JFK: John F. Ken...</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">198</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Non-airport</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">200</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Passengers</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">1 to 2 passengers</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">411</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">3 to 5 passengers</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">190</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">6 or more</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">450</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Bags</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">1 to 2 bags</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">365</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">3 to 4 bags</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">498</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">5 or more</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">350</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Car Type</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Small</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">405</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Large</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">101</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Medium</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">486</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">SUV</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">295</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Van</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">435</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Commercial</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">278</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Luxury</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">260</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Pickup truck</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">450</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Convertable</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">355</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Payment Type</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Pay now</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">440</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Pay at counter</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">157</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="theme-search-results-sidebar-section">
                        <h5 class="theme-search-results-sidebar-section-title">Rental Agency</h5>
                        <div class="theme-search-results-sidebar-section-checkbox-list">
                          <div class="theme-search-results-sidebar-section-checkbox-list-items">
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Ace</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">453</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Action</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">393</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Advantage</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">463</span>
                            </div>
                            <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                              <label class="icheck-label">
                                <input class="icheck" type="checkbox"/>
                                <span class="icheck-title">Alamo</span>
                              </label>
                              <span class="theme-search-results-sidebar-section-checkbox-list-amount">157</span>
                            </div>
                          </div>
                          <div class="collapse" id="mobile-SearchResultsCheckboxRentalAgency">
                            <div class="theme-search-results-sidebar-section-checkbox-list-items theme-search-results-sidebar-section-checkbox-list-items-expand">
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Avis</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">291</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Budget</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">408</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Dollar</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">378</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Enterprise</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">200</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Hertz</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">168</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">National</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">121</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Payless</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">413</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Prestige Car Rental</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">382</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Special rate</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">129</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">Thrifty</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">301</span>
                              </div>
                              <div class="checkbox theme-search-results-sidebar-section-checkbox-list-item">
                                <label class="icheck-label">
                                  <input class="icheck" type="checkbox"/>
                                  <span class="icheck-title">U-Save</span>
                                </label>
                                <span class="theme-search-results-sidebar-section-checkbox-list-amount">136</span>
                              </div>
                            </div>
                          </div>
                          <a class="theme-search-results-sidebar-section-checkbox-list-expand-link" role="button" data-toggle="collapse" href="#mobile-SearchResultsCheckboxRentalAgency" aria-expanded="false">Show more
                            <i class="fa fa-angle-down"></i>
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <a class="btn _tt-uc _fs-sm btn-white btn-block btn-lg" href="#">Load More Results</a>
          </div>
  
        </div>
      </div>
    </div>

    <div class="theme-copyright">
      <div class="container">
        <div class="row">
          <div class="col-md-6">
            <p class="theme-copyright-text">Copyright &copy; 2018
              <a href="#">Bookify</a>. All rights reserved.
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
    <script src="js/jquery.js"></script>
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
    <script src="js/typeahead.js"></script>
    <script src="js/quantity-selector.js"></script>
    <script src="js/countdown.js"></script>
    <script src="js/window-scroll-action.js"></script>
    <script src="js/fitvid.js"></script>
    <script src="js/youtube-bg.js"></script>
    <script src="js/custom.js"></script>
  </body>
</html>