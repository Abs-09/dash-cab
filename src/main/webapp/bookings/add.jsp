<%-- 
    Document   : addServlet
    Created on : Oct 6, 2023, 12:49:14 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customer_style.css" />
        <title>JSP Page</title>
    </head>
    <body onload="navigateside()">
        <%
        if (session.getAttribute("user") == null) {
            response.sendRedirect("../index.jsp");
        }   
        %>
        <%@include file = "/components/header_customer.jsp"%>

        <div class="mainArea">
            <form action="/dash-cab/RequestBookingServlet" method="POST"> 

                <div class="map-container left">
                    <div class="map-heading">Pick Up</div>
                    <div id="map1" class="map">Map1</div>
                    <input type="text" id="pick_up_search" placeholder="Search for pickup location" />
                </div>
                <div class="map-container right">
                    <div class="map-heading">Destination</div>
                    <div id="map2" class="map">Map2</div>
                    <input type="text" id="destination_search" placeholder="Search for destination location" />
                </div>

                <div class="input-box">
                    <input type="hidden" name="user_id" value="${user.id}" required>
                    <i class='bx bxs-user'></i>
                </div>
                <div class="date-time-container">
                    <div class="input-box">
                        <label for="pick_up_date">Pick Up Date</label>
                        <input type="date" name="date" id="pick_up_date" required>
                        <i class='bx bxs-calendar'></i>
                    </div>
                    <div class="input-box">
                        <label for="pick_up_time">Pick Up Time</label>
                        <input type="time" name="time" id="pick_up_time" required>
                        <i class='bx bxs-time'></i>   
                    </div>
                </div>
                <div class="input-box">
                    <input type="text" placeholder="from" name="pick_up_address" id="pick_up_address" required>
                    <i class='bx bxs-lock-open-alt'></i>
                </div>
                <div class="input-box">
                    <input type="hidden" placeholder="To" name="destination_address" id="destination_address" required>
                    <i class='bx bxs-lock-open-alt'></i>
                </div>

                <div class="remember-forgot">
                    <span style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                </div>

                <button type="submit" class="btn">Make Booking Request</button>
            </form>
        </div>
    </body>
    <script>
        function initializeMaps() {
            // Load the Maps JavaScript API using the recommended method
            const script = document.createElement('script');
            script.src = `https://maps.googleapis.com/maps/api/js?key=AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk&libraries=places&callback=initMap`;
            script.defer = true;
            script.async = true;

            // Set up a global initMap function
            window.initMap = initMap;

            document.body.appendChild(script);
        }

        function initMap() {
            let maleCity = {lat: 4.215580, lng: 73.541625};
            let map1 = new google.maps.Map(document.getElementById('map1'), {
                center: maleCity,
                zoom: 15
            });

            let map2 = new google.maps.Map(document.getElementById('map2'), {
                center: maleCity,
                zoom: 15
            });

            let marker1 = new google.maps.Marker({
                map: map1,
                position: maleCity,
                draggable: true
            });

            let marker2 = new google.maps.Marker({
                map: map2,
                position: maleCity,
                draggable: true
            });

            // Add a listener to update marker position when dragged
            google.maps.event.addListener(marker1, 'dragend', function (evt) {
                document.getElementById('pick_up_address').value = evt.latLng.lat().toFixed(3) + ',' + evt.latLng.lng().toFixed(3);
            });

            google.maps.event.addListener(marker2, 'dragend', function (evt) {
                document.getElementById('destination_address').value = evt.latLng.lat().toFixed(3) + ',' + evt.latLng.lng().toFixed(3);
            });

            // Autocomplete for search inputs
            initializeAutocomplete('pick_up_search', map1, marker1,'pick_up_address');
            initializeAutocomplete('destination_search', map2, marker2,'destination_address');
        }

        initializeMaps();

        function initializeAutocomplete(inputId, map, marker,output) {
            let input = document.getElementById(inputId);
            let autocomplete = new google.maps.places.Autocomplete(input);

            autocomplete.bindTo('bounds', map);

            // Listen for the 'place_changed' event when a place is selected
            autocomplete.addListener('place_changed', function () {
                let place = autocomplete.getPlace();
                if (!place.geometry) {
                    window.alert("No details available for input: '" + place.name + "'");
                    return;
                }

                map.setCenter(place.geometry.location);
                marker.setPosition(place.geometry.location);

                let lat = place.geometry.location.lat().toFixed(3);
                let lng = place.geometry.location.lng().toFixed(3);

                document.getElementById(output).value = lat + ',' + lng;
            });
        }

        function navigateside() {
            document.getElementById("bookRide").classList.toggle('active');
        }
    </script>
</html>
