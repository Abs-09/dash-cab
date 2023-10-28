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
        <style>
            /* Style for full-width map as background */
            #map1 {
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: -1; /* Send the map to the background */
            }

            /* Style for container of textboxes and buttons */
            .text-container {
                position: absolute;
                z-index: 1;
                background-color: rgba(255, 255, 255, 0.85);
                padding: 5px;
                display: none; /* Initially hidden */

                /* Center horizontally and vertically */
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);

            }
            .searchField {
                width:250px;
                background-color:#fff;
                height: 30px;
                margin-bottom: 10px;
                border: 1px solid #000;
                border-radius: 5px;
                font-size: 16px;
            }

            /* Add more specific styling as needed */
        </style>
    </head>
    <body onload="navigateside()">
        <%
        if (session.getAttribute("user") == null) {
            response.sendRedirect("../index.jsp");
        }   
        %>

        <div id="map1" class="map">Map1</div>
        <%@include file = "/components/header_customer.jsp"%>

        <div class="mainArea">
            <input class="searchField" type="text" id="pick_up_search" placeholder="Search for pickup location" />
            <br>
            <input class="searchField" type="text" id="destination_search" placeholder="Search for destination location" />
            <br>
            <button id="showTextButton" class="btn">Confirm</button>
            <div class="text-container">

                <form action="/dash-cab/RequestBookingServlet" method="POST" onsubmit="return validateForm()"> 

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
                        <input type="hidden" placeholder="from" name="pick_up_address" id="pick_up_address" required>
                        <i class='bx bxs-lock-open-alt'></i>
                    </div>
                    <div class="input-box">
                        <input type="hidden" placeholder="To" name="destination_address" id="destination_address" required>
                        <i class='bx bxs-lock-open-alt'></i>
                    </div>

                    <div class="remember-forgot">
                        <span id="error" style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
                    </div>

                    <button type="submit" class="btn">Make Booking Request</button>
                    <button class="btn" id="backbtn" style="margin-left: 50px;">Back</button>

                </form>
            </div>
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

            const fromIcon = {
                url: 'http://maps.google.com/mapfiles/ms/icons/green-dot.png',
            };

            const toIcon = {
                url: 'http://maps.google.com/mapfiles/ms/icons/red-dot.png',
            };

//            let map2 = new google.maps.Map(document.getElementById('map2'), {
//                center: maleCity,
//                zoom: 15
//            });

            let marker1 = new google.maps.Marker({
                map: map1,
                position: maleCity,
                draggable: true,
                label: {
                    text: 'From',
                    color: 'black',
                    fontSize: '15px',
                    fontWeight: 'bold'
                },
                icon: fromIcon
            });

            let marker2 = new google.maps.Marker({
                map: map1,
                position: maleCity,
                draggable: true,
                label: {
                    text: 'To',
                    color: 'white',
                    fontSize: '15px',
                    fontWeight: 'bold'
                },
                icon: toIcon
            });

            // Add a listener to update marker position when dragged
            google.maps.event.addListener(marker1, 'dragend', function (evt) {
                let latlng = evt.latLng.lat().toFixed(3) + ',' + evt.latLng.lng().toFixed(3);
                getPlaceName(latlng, 'pick_up_address');
            });

            google.maps.event.addListener(marker2, 'dragend', function (evt) {
                let latlng = evt.latLng.lat().toFixed(3) + ',' + evt.latLng.lng().toFixed(3);
                getPlaceName(latlng, 'destination_address');
            });

            // Autocomplete for search inputs
            initializeAutocomplete('pick_up_search', map1, marker1, 'pick_up_address');
            initializeAutocomplete('destination_search', map1, marker2, 'destination_address');

        }

        initializeMaps();

        function initializeAutocomplete(inputId, map, marker, output) {
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

//                document.getElementById(output).value = lat + ',' + lng;
                let latlng = lat + ',' + lng;
                getPlaceName(latlng, output);


            });
        }

        function navigateside() {
            document.getElementById("bookRide").classList.toggle('active');
        }

        const showTextButton = document.getElementById("showTextButton");
        const backbtn = document.getElementById("backbtn");
        const textContainer = document.querySelector(".text-container");

        backbtn.addEventListener("click", function () {
            textContainer.style.display = "none"; // Show the text container
        });

        function getPlaceName(latlng, output) {
            const apiUrl = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + latlng + "&key=AIzaSyAd3T6I7teyv_qI3Dy6nJf4sSw93vYb_Dk";

            fetch(apiUrl)
                    .then(response => response.json())
                    .then(data => {
                        if (data.status === "OK" && data.results.length > 0) {
                            const placeName = data.results[0].formatted_address;
                            document.getElementById(output).value = placeName;
//                            window.alert("Location found:"+ placeName+latlng);
                        } else {
                            window.alert("Location not found");
                        }
                    })
                    .catch(error => {
                        window.alert("Error:", error);
                    });
        }

        const confirmButton = document.getElementById("showTextButton");
        const pickUpField = document.getElementById("pick_up_address");
        const destinationField = document.getElementById("destination_address");

        confirmButton.addEventListener("click", function () {
            if (pickUpField.value.trim() === "" || destinationField.value.trim() === "") {
                alert("Please search or mark with marker the pickup and destination");
                return;
                textContainer.style.display = "none";
            } else {
                textContainer.style.display = "block";
            }

        });

// Add an onsubmit event handler to the form
        function validateForm() {
            const pickUpDate = document.getElementById("pick_up_date");
            const pickUpTime = document.getElementById("pick_up_time");
            const currentDate = new Date();
            const selectedDate = new Date(pickUpDate.value + " " + pickUpTime.value);

            if (selectedDate <= currentDate) {
                document.getElementById('error').textContent = "Please select a future date and time.";
                return false;
            }
            // If the form is valid, clear any previous error message and allow submission
                document.getElementById('error').textContent = "";
                return true;
        };
    </script>
</html>
