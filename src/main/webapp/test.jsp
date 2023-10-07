<%-- 
    Document   : test
    Created on : Sep 27, 2023, 8:30:47 PM
    Author     : Absal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! This is test JSP: ${error}</h1>
    </body>
    <div id="map" style="height:400px; width:50%;">Helolo</div>
    <input type="text" id="myInput">
    <script type='text/javascript' src='https://www.google.com/jsapi'></script>
    <script>
        //API Loading
        google.load("maps", "3.exp", {
            "callback": initMap,
            "key": "AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk",
            "libraries": "places,visualization"
        });

        function initMap() {
            let maleCity = {lat: 4.215580, lng: 73.541625};
            let map = new google.maps.Map(document.getElementById('map'), {
                center: maleCity,
                zoom: 15
            });

            let marker = new google.maps.Marker({
                map: map,
                position: maleCity,
                draggable: true
            });

            // Add a listener to update marker position when dragged
            google.maps.event.addListener(marker, 'dragend', function (evt) {
                document.getElementById('myInput').value = evt.latLng.lat().toFixed(3) + ',' + evt.latLng.lng().toFixed(3) + '</p>';
            });

//            google.maps.event.addListener(marker, 'dragstart', function (evt) {
//                document.getElementById('current').innerHTML = '<p>Currently dragging marker...</p>';
//            });
        }
    </script>
</html>
