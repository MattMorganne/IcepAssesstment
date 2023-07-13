/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller;

import Entity.JobPost;
import Entity.JobPostFacadeLocal;
import Entity.Student;
import Entity.StudentAplication;
import Entity.StudentAplicationFacadeLocal;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morganne
 */
public class apply extends HttpServlet {

    
    @EJB
    StudentAplicationFacadeLocal safl;
    
      @EJB
      JobPostFacadeLocal jpfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        Student student = (Student) session.getAttribute("student");
        List<JobPost> jobPosts = (List<JobPost>) session.getAttribute("jobPosts");
        
        JobPost jobPost = getJobAppliedFor(jobPosts,title,description);
         List<StudentAplication> studapps = (List<StudentAplication>) session.getAttribute("studapps");
           RequestDispatcher rd ;
         if (checkStudentAppjobPost(jobPost, studapps)) {
            
     
 
        
        if (jobPost.getStudentId() ==null ) {
             List<Long> studentId = new ArrayList<>();
             studentId.add(student.getId());
              jobPost.setStudentId(studentId);
        }else{
        jobPost.getStudentId().add(student.getId());
        }
        jpfl.edit(jobPost);
        
        StudentAplication studentAplication = new StudentAplication(student.getId(), "Application still being processed", "", jobPost.getId());
         safl.create(studentAplication);
    
         session.setAttribute("jobPosts", jobPosts);
           
          
          studapps.add(studentAplication);
           session.setAttribute("studapps",studapps); 
         rd = request.getRequestDispatcher("studentZone.jsp");

              }else{

                   rd = request.getRequestDispatcher("studapplyError.jsp");
         }
                 rd.forward(request, response);

    }
 
    private JobPost getJobAppliedFor(List<JobPost> jobPosts, String title, String description) {
        JobPost application=new JobPost();
         
        for (int i = 0; i < jobPosts.size(); i++) {
              if (jobPosts.get(i).getTitle().equalsIgnoreCase(title) && jobPosts.get(i).getDescription().equalsIgnoreCase(description) ) {
                application = jobPosts.get(i);
            }
        }
       
        return application;
    }

    private boolean checkStudentAppjobPost(JobPost jobPost, List<StudentAplication> studapps) {
        boolean check = true;
         for (int i = 0; i < studapps.size(); i++) {
             if ( studapps.get(i).getJobPostId().equals(jobPost.getId())) {
                 check = false;
             }
        }
         return check;
    }

}
