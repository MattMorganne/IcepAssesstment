<%-- 
    Document   : newjsp
    Created on : 08-Jul-2023, 01:10:31
    Author     : Morganne
--%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Landing Page</title>
        <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<style>
    #container{
       background-image: url("land.jpg");
       background-repeat: no-repeat;
 
       background-size: cover;
       height: 200px;
       display: flex;
       margin-bottom: 100px;
       
    }
       .card img{
        width: 100%;
    }
        .card {
        width: 100%;
    }
    
    #sub-menu{
         display:flex;
         justify-content: space-between;
         margin-bottom: 100px;
         padding: 100px;
    }
        #sub-menu div{
         margin: 40px;
    }
</style>
    </head>
    <body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">TUT WIL Services platform</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="admin.jsp">Admin</a>
      </li>
            <li class="nav-item">
        <a class="nav-link" href="company.jsp">Company</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="student.html">Student</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About us</a>
      </li>
    </ul>
  </div>
</nav>
 
        <div id="container">
            
         
        </div>
        <section id="sub-menu">
  <div class="card">
  <img src="https://environmental-humanities.utah.edu/_resources/images/graphics/index/Jobs%20Internship%20Opportunities-01.jpg" class="card-img-top" alt="Fissure in Sandstone"/>
  <div class="card-body">
    <h5 class="card-title">Add a internship post for student</h5>
    <p class="card-text">Click here to create a new  will offer for students.</p>
    <a href="addpostCompany.jsp" class="btn btn-primary">add</a>
  </div>
</div>
            
  <div class="card">
  <img src="https://th.bing.com/th/id/OIP.T_F7TgAkmJtatycNJ0kGdwHaEr?pid=ImgDet&rs=1" class="card-img-top" alt="Fissure in Sandstone"/>
  <div class="card-body">
    <h5 class="card-title">See applicant list for students </h5>
    <p class="card-text">Click to see a specific applications post and applicant details.</p>
    <a href="getSpecificCompany.do" class="btn btn-primary">add</a>
  </div>
</div>       
<!--
 <div class="card">
  <img src="https://mdbcdn.b-cdn.net/img/new/standard/nature/184.webp" class="card-img-top" alt="Fissure in Sandstone"/>
  <div class="card-body">
    <h5 class="card-title">Remove an application </h5>
    <p class="card-text">Remove a post.</p>
    <a href="managewill.jsp" class="btn btn-primary">delete.</a>
  </div>
</div>-->         
        </section>
        
        
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>






