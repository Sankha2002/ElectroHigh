<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>Password Update</title>
<link rel="stylesheet" href="http://localhost:8010/final_project/form.css">
<script src="http://localhost:8010/final_project/jspage.js"> </script>
</head>
<body>

<div class="container">
        <form action="ForgetPass" method="post" id="form">
            <h2 class="title">Create Password</h2>
            <label for="email">Email-id</label>
            <input type="email" id="email" name="email" placeholder="Email-id" /><br><br>
    
            <label for="pass">New Password</label>
            <input type="password" id="pass" name="pass" placeholder="Password" /><br>
            <input type="checkbox" onclick="passToggle()">Show Password <br><br>
            
            <input type="submit" value="submit" name="submit" /> <br><br>
               <span style=" color: red;">${error}</span>

        </form>
    </div>

</body>
</html>