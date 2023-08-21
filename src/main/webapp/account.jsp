<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account</title>
<style>

div{background-color:coral;width: 400px;border: 6px solid green;
padding: 50px;margin: 20px;display:block; border-radius: 10px;margin-left:30%;margin-top:10%; }
tr,td{padding:10px;}
table{padding:10px;}

.form{background-color:#f2f2f2;border-radius: 20px;
    box-sizing: border-box;border:1px solid black;
    padding: 30px;
    width: 400px;float:left;}

caption{font-size:20px;font-weight:bold;}

</style>


</head>
<body>

<%
Cookie ck[]=request.getCookies(); 
if(!ck[0].getName().equals("name"))
	response.sendRedirect("login.jsp");
%>

<div >
<table><caption>Profile Information</caption> 
<tr><td>Name</td>  <td>:<%=ck[0].getValue() %></td> </tr> 
<tr><td>Phone Number</td>  <td>:<%=ck[1].getValue() %></td></tr>
<tr><td>Email Id</td>  <td>:<%=ck[3].getValue() %></td></tr> 

</table>

<button onclick="edit()">Edit Profile</button>  <button onclick="passChange()">Password Change</button> 
<button onclick="logoutConfirm()">Log Out</button> <button onclick="deleteConfirm()">Delete Account</button>

<br><br>

</div>
    <form action="EditProfile" method="post" id="edit" class="form"  style="display:none;" >
        <h2 class="title">Profile Update</h2>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Name"  value="<%= ck[0].getValue() %>" /><br><br>

        <label for="mn">Mobile Number</label>
        <input type="tel" id="mn" name="mn" placeholder="Mobile Number" value="<%= ck[1].getValue() %>" /><br><br>

        <input type="submit" value="Submit" name="submit" /> 
        <input type="reset" value="Hide" onclick="document.getElementById('edit').style.display='none';" /> <br><br>
               <span style=" color: red;">${error}</span>
    </form>
    
    <form action="UpdatePassword" method="post" id="change" class="form" style="display:none;" >
            <h2 class="title">Update Password</h2>
            <label for="oldpass">Old Password</label>
            <input type="password" id="oldpass" name="oldpass" placeholder="Old Password" /><br><br>
    
            <label for="pass">New Password</label>
            <input type="password" id="pass" name="pass" placeholder="New Password" /><br>
            <input type="checkbox" onclick="passToggle()">Show Password <br><br>
            
            <input type="submit" value="submit" name="submit" /> 
            <input type="reset" value="Hide" onclick="document.getElementById('change').style.display='none';" /><br>
               <span style=" color: red;">${error}</span>

        </form>
    

<script>
function logoutConfirm(){
	if (confirm("log out, confirm?!")) {
		window.location.replace("http://localhost:8010/final_project/LogOut");
	  } 
}

function deleteConfirm(){
	if (confirm("delete account, confirm?!")) {
		window.location.replace("http://localhost:8010/final_project/DeleteAccount");
	  } 
}

function edit(){
	
	document.getElementById('change').style.display='none';
	document.getElementById('edit').style.display='block';
}

function passChange(){
	document.getElementById('edit').style.display='none';
	document.getElementById('change').style.display='block';
}

function passToggle(){
    var x=document.getElementById("pass");
    if(x.type =="password")
        x.type="text";
    else
        x.type="password";
}


</script>

</body>
</html>