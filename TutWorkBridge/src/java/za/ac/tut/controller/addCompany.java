/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import Entity.Company;
import Entity.CompanyFacadeLocal;
import Entity.Student;
import Entity.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class addCompany extends HttpServlet {
     @EJB
     CompanyFacadeLocal cfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           /*
  <div class="form-outline mb-4">
      <input type="text" id="form4Example1" class="form-control"  name="fname"/>
    <label class="form-label" for="form4Example1">Company name</label>
  </div>

  <!-- Student input -->
  <div class="form-outline mb-4">
    <input type="num" id="form4Example2" class="form-control" name="code"/>
    <label class="form-label" for="num">code</label>
  </div>
  
    <!-- Student input -->
  <div class="form-outline mb-4">
    <input type="id" id="form4Example2" class="form-control" name="description"/>
    <label class="form-label" for="id">Description</label>
  </div>

        */
           
           String fname = request.getParameter("fname");
           String code  =  request.getParameter("code");
           String description = request.getParameter("description");
           Company  company = new Company(fname, code, description);
           cfl.create(company);
           
           
           //   public Student(int studentNumber, String identification, String name, String Status, double avgMark, String course, double finalWocMark) {
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
           rd.forward(request, response);
        
        
    }
 

}
