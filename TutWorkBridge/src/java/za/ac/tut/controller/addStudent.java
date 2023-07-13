/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

 
import Entity.Student;
import Entity.StudentFacadeLocal;
import java.io.IOException;
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
public class addStudent extends HttpServlet {

    @EJB
    StudentFacadeLocal sfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String fname = request.getParameter("fname");
           int snumber  = Integer.parseInt(request.getParameter("snumber"));
           String identification = request.getParameter("sid");
           String scourse = request.getParameter("course");
           String mail = request.getParameter("mail");
           String phone = request.getParameter("phone");
           double avgMark = Double.parseDouble(request.getParameter("avg"));
           
           Student student = new Student(snumber, identification, fname, "looking for intern", avgMark, scourse, 0);
           student.setEmail(mail);
           student.setPhoneNumber(phone);
           sfl.create(student);
           //   public Student(int studentNumber, String identification, String name, String Status, double avgMark, String course, double finalWocMark) {
           RequestDispatcher rd = request.getRequestDispatcher("index.html");
           rd.forward(request, response);
        
        
    }
 

}
