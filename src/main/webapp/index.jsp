<!DOCTYPE html>
<!-- Coding by CodingLab || www.codinglabweb.com -->
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Website with Login & Registration Form</title>
    <!--<link rel="stylesheet" type="text/css" href="http://localhost:8080/Dash-Cab/css/style.css" />-->
     <!--Unicons--> 
    <!--<link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />-->
  </head>
  <body>
    <!-- Header -->
    <header class="header">
      <nav class="nav">
        <a href="#" class="nav_logo">DASH CAB</a>

        <button class="button" id="form-open">Login</button>
      </nav>
    </header>

    <!-- Home -->
    <section class="home">
      <div class="form_container">
        <i class="uil uil-times form_close"></i>
        <!-- Login From -->
        <div class="form login_form">
          <form action="userservelet" method="POST">
            <h2>Login</h2>

            <div class="input_box">
              <input type="text" placeholder="user_id" name="id" required />
              <i class="uil uil-envelope-alt email"></i>
            </div>
<!--            <div class="input_box">
              <input type="password" placeholder="Enter your password" required />
              <i class="uil uil-lock password"></i>
              <i class="uil uil-eye-slash pw_hide"></i>
            </div>-->

            <button class="button">Login Now</button>
          </form>
        </div>
    </section>

    <!--<script src="script.js"></script>-->
  </body>
</html>
