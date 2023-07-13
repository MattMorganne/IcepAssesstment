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
        
        <h1 class="display-4">Please add a list of student to  the system</h1>
        <form style="width:40vw; margin-left: 20%; margin-top: 120px" method="POST" action="addStudent.do">
  <!-- Name input -->
  <div class="form-outline mb-4">
      <input type="text" id="form4Example1" class="form-control"  name="fname"/>
    <label class="form-label" for="form4Example1">Full Name</label>
  </div>

  <!-- Student input -->
  <div class="form-outline mb-4">
    <input type="num" id="form4Example2" class="form-control" name="snumber"/>
    <label class="form-label" for="num">Student number</label>
  </div>
  
    <!-- Student input -->
  <div class="form-outline mb-4">
    <input type="id" id="form4Example2" class="form-control" name="sid"/>
    <label class="form-label" for="id">ID/passport</label>
  </div>

  <!-- Message input -->
  <div class="form-outline mb-4">
    <select  class="form-control" id="form4Example3" rows="4" type="id" id="form4Example2" class="form-control" name="course">
        <option>Computer science</option>
        <option>Multimedia</option>
        <option>Informatics</option>
    </select>
    <label class="form-label" for="form4Example3">Course</label>
  </div>
  
    <!-- Message input -->
  <div class="form-outline mb-4">
      <input  class="form-control" id="form4Example3" rows="4" type="id" id="form4Example2" class="form-control" type="number" name="avg"/>
    <label class="form-label" for="form4Example3">Course average mark</label>
  </div>
    
        <!-- Message input -->
  <div class="form-outline mb-4">
      <input  class="form-control"   rows="4" type="id" id="form4Example7" class="form-control" type="text" name="phone"/>
    <label class="form-label" for="phone number">Phone number</label>
  </div>

                <!-- Message input -->
  <div class="form-outline mb-4">
      <input  class="form-control"   rows="4" type="id" id="form4Example7" class="form-control" type="email" name="mail"/>
    <label class="form-label" for="phone number">Email</label>
  </div>
 
  <button type="submit" class="btn btn-primary btn-block mb-4">add</button>
</form>
        
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdyyelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
