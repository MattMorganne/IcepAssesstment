/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import Entity.CompanyFacadeLocal;
import Entity.JobPost;
import Entity.JobPostFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Morganne
 */
public class AddPostAdmin extends HttpServlet {

    /*

  <form style="width:40vw; margin-left: 20%; margin-top: 120px" method="POST" action="AddPostAdmin.do">
  <!-- Name input -->
  <div class="form-outline mb-4">
      <input type="text" id="form4Example1" class="form-control"  name="title"/>
    <label class="form-label" for="form4Example1">Post title</label>
  </div>

  <!-- Student input -->
  <div class="form-outline mb-4">
    <input type="text" id="form4Example2" class="form-control" name="desc"/>
    <label class="form-label" for="form4Example2">Add a description</label>
  </div>
  

  <!-- Message input -->
  <div class="form-outline mb-4">
    <select  class="form-control" id="form4Example3" rows="4" type="id" id="form4Example2" class="form-control" name="course">
        <option>Computer science</option>
        <option>Multimedia</option>
        <option>Informatics</option>
    </select>
    <label class="form-label" for="form4Example3">required course</label>
  </div>

                <!-- Message input -->
  <div class="form-outline mb-4">
      <input  class="form-control"   rows="4" type="text" id="form4Example7" class="form-control" type="date" name="adate"/>
    <label class="form-label" for="phone number">Post application deadline</label>
  </div>
 
  <button type="submit" class="btn btn-primary btn-block mb-4">create</button>
</form>
        */
         @EJB
         JobPostFacadeLocal jfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
           String title = request.getParameter("title");
           String description  =  request.getParameter("desc");
           String course = request.getParameter("course");
           String dateString = request.getParameter("adate");
           SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
           Date expDate;
             try {
                 expDate = sdf.parse(dateString);
               JobPost jobPost = new JobPost(title, description, course, expDate, "001");
               //  public JobPost(String title, String description, String course, Date expDate, String CompanyCode) {
                jfl.create(jobPost);
               
                 RequestDispatcher rd = request.getRequestDispatcher("addpostAdmin.jsp");
                 rd.forward(request, response);
               
             } catch (ParseException ex) {
                 Logger.getLogger(AddPostAdmin.class.getName()).log(Level.SEVERE, null, ex);
             }

    }
 

}
