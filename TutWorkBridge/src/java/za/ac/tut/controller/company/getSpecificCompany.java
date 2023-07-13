/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.controller.company;

import Entity.Company;
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
public class getSpecificCompany extends HttpServlet {

 
   
 
   
    @EJB
    JobPostFacadeLocal jpfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        
         Company company = (Company) session.getAttribute("company");
          
        List<JobPost> jobPostsGlobal = jpfl.findAll();
      List<JobPost> jobPosts = filter(jobPostsGlobal,company);
        
        
      
       session.setAttribute("jobPostsAdmin", jobPosts); 
        RequestDispatcher rd = request.getRequestDispatcher("getSpecificCompany.jsp");
        rd.forward(request, response); 
    }

    private List<JobPost> filter(List<JobPost> jobPostsGlobal, Company company) {
        List<JobPost> refinedJobPostList = new ArrayList<>();

        for (int i = 0; i < jobPostsGlobal.size(); i++) {
            JobPost tempJobPost = jobPostsGlobal.get(i);
            if (tempJobPost.getCompanyCode().equalsIgnoreCase(company.getCode())) {
                refinedJobPostList.add(tempJobPost);
            }
        }

        return refinedJobPostList;
    }
     



}
