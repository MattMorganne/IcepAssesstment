<%@page import="Entity.StudentAplication"%>
<%@ page import="java.util.List" %>
<%@ page import="Entity.JobPost" %>
<%@ page import="Entity.Student" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Zone</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            #container {
                background-image: url("land.jpg");
                background-repeat: no-repeat;
                background-size: cover;
                height: 200px;
                display: flex;
            }

            .container2 {
                margin-top: 100px;
                display: flex;
                width: 80%;
                flex-flow: row wrap;
                background-color: burlywood;
                border-radius: 20px;
                justify-content: center;
                margin-left: 10%;
            }

            .row{
                padding: 40px;
                width: 90vw;
                align-self: center;

            }
        </style>
    </head>
    <body>
        <%
            List<Student> studs = (List<Student>) session.getAttribute("studs");
            List<JobPost> jobPosts = (List<JobPost>) session.getAttribute("filteredJobPosts");
              List<StudentAplication> filteredApplications = (List<StudentAplication>) session.getAttribute("filteredApplications");
        %>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">TUT WIL Services platform</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

        <div id="container"></div>


        <div class="container2">
            <h1>List of applicants for <%= jobPosts.get(0).getTitle()%></h1>
            <div class="row">
                <% for (int i = 0; i < jobPosts.size(); i++) {


                %>

                <div class="col-md-6">
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5 class="card-title"><%= studs.get(i).getName()%></h5>
                            <p class="card-text"><b>Course average mark </b> <br><%= studs.get(i).getAvgMark()%></p>
                            <p class="card-text"><b>Email </b> <br><%= studs.get(i).getEmail()%></p>
                            <p class="card-text"><b>phone number </b> <br><%= studs.get(i).getPhoneNumber()%></p>
                            <p class="card-text"><b>Application status </b> <br><%= filteredApplications.get(i).getStatus() %></p>
                            <a href="UpdateApplicationCompany.do?status=false&studId=<%= studs.get(i).getId()%>" class="btn btn-primary">reject</a>
                            <a href="UpdateApplicationCompany.do?status=true&studId=<%= studs.get(i).getId()%>" class="btn btn-primary">add to next stage</a>
                        </div>
                    </div>
                </div>

                <% }%>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
    </body>
</html>
