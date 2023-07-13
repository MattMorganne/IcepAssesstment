package za.ac.tut.controller;

import Entity.JobPost;
import Entity.JobPostFacadeLocal;
import Entity.Student;
import Entity.StudentAplication;
import Entity.StudentAplicationFacadeLocal;
import java.io.IOException;
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
 * Servlet implementation class AppicationList
 */
public class AppicationList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private StudentAplicationFacadeLocal safl;

    @EJB
    private JobPostFacadeLocal jpfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
       
        Student student = (Student) session.getAttribute("student");
        
        List<StudentAplication> applications = safl.findAll();
        List<StudentAplication> filteredApplications = filterApplications(applications, student);
        List<JobPost> filteredJobPosts = getFilteredJobPosts(filteredApplications);
        
        session.setAttribute("filteredApplications", filteredApplications);
        session.setAttribute("filteredJobPosts", filteredJobPosts);
        
        RequestDispatcher rd = request.getRequestDispatcher("appliststud.jsp");
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
}
