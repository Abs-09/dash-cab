<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Booking Success</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/succsess_style.css" />
    </head>
    <body>
        <div class="container">
            <h1>Booking Successful</h1>
            <div class="success-info">
                <p>User: <span>${user.name}</span></p>
                <p>Pick Up: <span>${bookingrequest.pick_up_address}</span></p>
                <p>Destination: <span>${bookingrequest.destination_address}</span></p>
                <p>Date & Time: <span>${bookingrequest.scheduled_date_time}</span></p>
                <p>Total (MVR): <span>${cost}</span></p>
                <p>Total with GST(MVR): <span>${totalCost}</span></p>
            </div>
            <a class="back-button" href="BookingRequestsServlet">Go Back</a>
        </div>
    </body>
</html>
