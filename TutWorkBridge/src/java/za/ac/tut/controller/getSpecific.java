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
import Entity.StudentFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
public class getSpecific extends HttpServlet {

   
 
   
    @EJB
    JobPostFacadeLocal jpfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        
 
          
        List<JobPost> jobPostsGlobal = jpfl.findAll();
      List<JobPost> jobPosts = filter(jobPostsGlobal);
        
        
      
       session.setAttribute("jobPostsAdmin", jobPosts); 
        RequestDispatcher rd = request.getRequestDispatcher("getSpecific.jsp");
        rd.forward(request, response); 
    }

    private List<JobPost> filter(List<JobPost> jobPostsGlobal) {
        List<JobPost> refinedJobPostList = new ArrayList<>();

        for (int i = 0; i < jobPostsGlobal.size(); i++) {
            JobPost tempJobPost = jobPostsGlobal.get(i);
            if (tempJobPost.getCompanyCode().equalsIgnoreCase("001")) {
                refinedJobPostList.add(tempJobPost);
            }
        }

        return refinedJobPostList;
    }
     



}
