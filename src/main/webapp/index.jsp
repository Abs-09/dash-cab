<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dash Cab Login Form</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>

<body>

    <!-- login -->
    <div class="wrapper">
        <!--<form action="">-->
         <form action="userservelet" method="POST"> 
            <div class="logo-area">
                <img src="${pageContext.request.contextPath}/img/logo.PNG" alt="logo" width="150px">
            </div>
            <h1>Login to Dash Cab</h1>
            <div class="input-box">
                <input type="text" placeholder="username" name="email" required>
                <i class='bx bxs-user'></i>
            </div>
            <div class="input-box">
                <input type="password" placeholder="Password" name="password" required>
                <i class='bx bxs-lock-open-alt'></i>
            </div>

            <div class="remember-forgot">
<!--                <label><input type="checkbox">Remember me</label>
                <a href="#">Forgot password?</a>-->

                <!--showing the error message in here-->
                <span style="color: red; margin-left: 22px; font-weight: bold">${error}</span>
            </div>

            <button type="submit" class="btn">Login</button>

        </form>
    </div>
    
</body>

</html>