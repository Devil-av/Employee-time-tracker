<%@ page import="java.sql.*"%>
<html>
 <head>
  <script src='/employee-time-tracker/JS/script.js'></script>
  <link href='/employee-time-tracker/CSS/style.css' rel='stylesheet'>
  <link href='/employee-time-tracker/CSS/bootstrap.min.css' rel='stylesheet'>
 </head>
 <body bgcolor='cyan'>
   <hr style='border:2px solid green'>
    <nav class='navbar navbar-expand navbar-light bg-light'>
    <label style='font-size:2vw'>Hi, ${sessionScope.name}</label>
     <ul class='nav nav-pills mx-auto'>
      <li><a id="home1" class='nav-link lau' href='/employee-time-tracker/timetracker'>Home</a>
      <li><a id='out' class='nav-link lau' href='/employee-time-tracker/timetracker/timeout'>Time Out</a>
      <li><a id='in' class='nav-link lau' href='/employee-time-tracker/timetracker/timein'>Time In</a>
      <li><a id='date' class='nav-link lau' href='/employee-time-tracker/timetracker/report/datewise'>Date wise report</a>
      <li><a id='emp' class='nav-link lau' href='/employee-time-tracker/timetracker/report/empwise'>Employee wise report</a>
      <li><a id='emp' class='nav-link lau' href='timetracker/logout'>Logout</a>
     </ul>
    </nav>
   <hr style='border:2px solid green'>
 </body>
</html>