<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <title>DevBridge Autocomplete Demo</title>
   
     <script src="js/jquery.js">   </script>
     <link href="http://code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css" rel="Stylesheet"></link>
<script src='https://cdn.rawgit.com/pguso/jquery-plugin-circliful/master/js/jquery.circliful.min.js'></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>

</head>
<body>

<div class="row">
<div class="ui-widget">
<label for="tags">Tag programming languages: </label>
<input id="tags" size="50" />
</div>

</div>

</body>
    <script type="text/javascript">
    var availableTags = [
        "ActionScript",
        "AppleScript",
        "Asp",
        "BASIC",
        "C",
        "C++",
        "Clojure",
        "COBOL",
        "ColdFusion",
        "Erlang",
        "Fortran",
        "Groovy",
        "Haskell",
        "Java",
        "JavaScript",
        "Lisp",
        "Perl",
        "PHP",
        "Python",
        "Ruby",
        "Scala",
        "Singapore",
        "airline",
        "malaysia",
        "customer",
        "service",
        "flight",
        "food"
    ];
    function split( val ) {
        return val.split( " " );
    }
    function extractLast( term ) {
        return split( term ).pop();
    }
    $( "#tags" )
        // don't navigate away from the field on tab when selecting an item
        .bind( "keydown", function( event ) {
            if ( event.keyCode === $.ui.keyCode.TAB &&
                $( this ).data( "autocomplete" ).menu.active ) {
                event.preventDefault();
            }
        })
        .autocomplete({
            minLength: 0,
            source: function( request, response ) {
                // delegate back to autocomplete, but extract the last term
                response( $.ui.autocomplete.filter(
                    availableTags, extractLast( request.term ) ) );
            },
            focus: function() {
                // prevent value inserted on focus
                return false;
            },
            select: function( event, ui ) {
                var terms = split( this.value );
                // remove the current input
                terms.pop();
                // add the selected item
                terms.push( ui.item.value );
                // add placeholder to get the comma-and-space at the end
                terms.push( "" );
                this.value = terms.join( " " );
                return false;
            },
            open: function( event, ui ) {
                var input = $( event.target ),
                    widget = input.autocomplete( "widget" ),
                    style = $.extend( input.css( [
                        "font",
                        "border-left",
                        "padding-left"
                    ] ), {
                        position: "absolute",
                        visibility: "hidden",
                        "padding-right": 0,
                        "border-right": 0,
                        "white-space": "pre"
                    } ),
                    div = $( "<div/>" ),
                    pos = {
                        my: "left top",
                        collision: "none"
                    },
                    offset = -7; // magic number to align the first letter
                                 // in the text field with the first letter
                                 // of suggestions
                                 // depends on how you style the autocomplete box

                widget.css( "width", "" );

                div
                    .text( input.val().replace( /\S*$/, " " ) )
                    .css( style )
                    .insertAfter( input );
                offset = Math.min(
                    Math.max( offset + div.width(), 0 ),
                    input.width() - widget.width()
                );
                div.remove();

                pos.at = "left+" + offset + " bottom";
                input.autocomplete( "option", "position", pos );

                widget.position( $.extend( { of: input }, pos ) );
            }
        });

    </script>
</html>
    