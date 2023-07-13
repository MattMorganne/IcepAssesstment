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
public class AdminSeeList extends HttpServlet {

     

    @EJB
    private StudentAplicationFacadeLocal safl;

        @EJB
    private StudentFacadeLocal sfl;

    @EJB
    private JobPostFacadeLocal jpfl;

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
       
        
        Long jobId = Long.parseLong(request.getParameter("jobId"));
        
        List<StudentAplication> applications = safl.findAll();
        List<StudentAplication> filteredApplications = filterApplications(applications,jobId);
        List<JobPost> filteredJobPosts2 = getFilteredJobPosts(filteredApplications);
        
         List<Student> studs = getStudentList(filteredApplications);
        
        session.setAttribute("filteredApplications", filteredApplications);
        session.setAttribute("filteredJobPosts", filteredJobPosts2);
        session.setAttribute("studs", studs);
        
        RequestDispatcher rd = request.getRequestDispatcher("AdminSeeList.jsp");
        rd.forward(request, response);
    }

    private List<StudentAplication> filterApplications(List<StudentAplication> applications, Long jobId) {
        List<StudentAplication> filteredApplications = new ArrayList<>();
        
        for (int i = 0; i < applications.size(); i++) {
            StudentAplication tempApplication = applications.get(i);
            JobPost jp = jpfl.find(tempApplication.getJobPostId());
            if (jp.getCompanyCode().equalsIgnoreCase("001") && jp.getId().equals(jobId)) {
                filteredApplications.add(tempApplication);
                
            }
            
        }
        
        return filteredApplications;
    }

    private List<JobPost> getFilteredJobPosts(List<StudentAplication> filteredApplications) {
        List<JobPost> filteredJobPosts = new ArrayList<>();
        
        for (StudentAplication application : filteredApplications) {
            JobPost jobPost = jpfl.find(application.getJobPostId());
            if (jobPost != null) {
                filteredJobPosts.add(jobPost);
            }
        }
        
        return filteredJobPosts;
    }

    private List<Student> getStudentList(List<StudentAplication> applications) {
         List<Student> studs = new ArrayList<>();
          for (int i = 0; i < applications.size(); i++) {
              Student stud = sfl.find(applications.get(i).getStudentid());
              studs.add(stud);
        }
        return studs;
    }
}
