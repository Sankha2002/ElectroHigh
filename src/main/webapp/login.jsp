<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="http://localhost:8010/final_project/form.css">
<script src="http://localhost:8010/final_project/jspage.js"> </script>
</head>

<body>


 <div class="container">
        <form action="Login" method="post" id="form">
            <h2 class="title">Login</h2>
            <label for="email">Email-id</label>
            <input type="email" id="email" name="email" placeholder="Email-id" /><br><br>
    
            <label for="pass">Password</label>
            <input type="password" id="pass" name="pass" placeholder="Password" /><br>
            <input type="checkbox" onclick="passToggle()">Show Password <br><br>
            
            <input type="submit" value="login" name="submit" /> <br><br>

           <a href="http://localhost:8010/final_project/forgetpass.jsp" > forgot password? </a> <br> <br>
               <span style=" color: red;">${error}</span>

        </form>
    </div>

</body>
</html>