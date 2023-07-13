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
public class UpdateApplication extends HttpServlet {

    @EJB
    private StudentAplicationFacadeLocal safl;

    @EJB
    private JobPostFacadeLocal jpfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");

        List<Student> studs = (List<Student>) session.getAttribute("studs");
        List<JobPost> jobPosts = (List<JobPost>) session.getAttribute("filteredJobPosts");
        Long studId = Long.parseLong(request.getParameter("studId"));
        Long jid = jobPosts.get(0).getId();
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        List<StudentAplication> applications = safl.findAll();
        List<StudentAplication> filteredApplications = filterApplications(applications, student);
        
                updateStatus(studId,jid,filteredApplications, status);
      //  List<JobPost> filteredJobPosts = getFilteredJobPosts(filteredApplications);

     /*   session.setAttribute("filteredApplications", filteredApplications);
        session.setAttribute("filteredJobPosts", filteredJobPosts);*/

        RequestDispatcher rd = request.getRequestDispatcher("getSpecific.jsp");
        rd.forward(request, response);
    }

    private List<StudentAplication> filterApplications(List<StudentAplication> applications, Student student) {
        List<StudentAplication> filteredApplications = new ArrayList<>();

        for (StudentAplication application : applications) {
            if (application.getStudentid().equals(student.getId())) {
                filteredApplications.add(application);
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

private void updateStatus(Long studId, Long jid, List<StudentAplication> filteredApplications, boolean status) {
    StudentAplication studApp = filteredApplications.stream()
            .filter(application -> application.getJobPostId().equals(jid) && application.getStudentid().equals(studId))
            .findFirst()
            .orElse(null);

    if (studApp != null) {
        if (status) {
            studApp.setStatus("Congratulations! Your application has been selected to proceed to the next stage. You will soon be contacted through the provided contact information to provide further details and discuss the next steps.");
        } else {
            studApp.setStatus("We regret to inform you that your application has not been selected for further consideration at this time. We appreciate your interest and encourage you to continue exploring other opportunities. Best of luck in your future endeavors.");
        }
    }
    safl.edit(studApp);
}

}
