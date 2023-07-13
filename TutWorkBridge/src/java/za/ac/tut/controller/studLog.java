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
import Entity.StudentAplicationFacade;
import Entity.StudentAplicationFacadeLocal;
import Entity.StudentFacadeLocal;
import java.io.IOException;
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
public class studLog extends HttpServlet {

    @EJB
    StudentFacadeLocal sfl;
    
    @EJB
    StudentAplicationFacadeLocal studentAplicationFacade;

    @EJB
    JobPostFacadeLocal jpfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int snumber = Integer.parseInt(request.getParameter("snumber"));
        String identification = request.getParameter("sid");
        Student student = sfl.logIn(identification, snumber);
        session.setAttribute("student", student);
        
          List<StudentAplication> studappToFilter = studentAplicationFacade.findAll();
          List<StudentAplication> studapps = filterApplication(studappToFilter,student);
          
          
        List<JobPost> jobPostsGlobal = jpfl.findAll();
        List<JobPost> jobPosts = filter(jobPostsGlobal, student.getCourse());
        
        
        session.setAttribute("studapps", studapps); 
        session.setAttribute("jobPosts", jobPosts); 
        RequestDispatcher rd = request.getRequestDispatcher("studentZone.jsp");
        rd.forward(request, response);
    }

    private List<JobPost> filter(List<JobPost> jobPostsGlobal, String course) {
        List<JobPost> refinedJobPostList = new ArrayList<>();
        Date currentDate = new Date();

        for (int i = 0; i < jobPostsGlobal.size(); i++) {
            JobPost tempJobPost = jobPostsGlobal.get(i);
            if (tempJobPost.getCourse().equalsIgnoreCase(course) && tempJobPost.getExpDate().after(currentDate)) {
                refinedJobPostList.add(tempJobPost);
            }
        }

        return refinedJobPostList;
    }
private List<StudentAplication> filterApplication(List<StudentAplication> studappToFilter, Student student) {
    List<StudentAplication> application = new ArrayList<>();
    for (int i = 0; i < studappToFilter.size(); i++) {
        StudentAplication tempAplication = studappToFilter.get(i);
        if (tempAplication.getStudentid().equals(student.getId())) {
            application.add(tempAplication); // Add the filtered application to the list
        }
    }

    return application;
}



}
