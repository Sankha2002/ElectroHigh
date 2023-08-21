<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="http://localhost:8090/final_project/form.css">
<script src="http://localhost:8090/final_project/jspage.js"> </script>
</head>

<body>

    <div class="container">
    <form action="Register" method="post" class="form" >
        <h2 class="title">Create Your Account</h2>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Name" required /><br><br>

        <label for="mn">Mobile Number</label>
        <input type="tel" id="mn" name="mn" placeholder="Mobile Number" required /><br><br>

        <label for="pass">Password</label>
        <input type="password" id="pass" name="pass" placeholder="Password" required /><br>
        <input type="checkbox" onclick="passToggle()">Show Password <br><br>

        <label for="email">Email-id</label>
        <input type="email" id="email" name="email" placeholder="Email-id" required /><br><br>

        <input type="submit" value="Create" name="submit" /> 
        <input type="reset" value="Reset" /> <br><br>
        Already have an account? <a href="login.jsp">Login</a><br> <br>
               <span style=" color: red;">${error}</span>

    </form>
</div>
</body>
</html>