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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morganne
 */
public class companyLog extends HttpServlet {

    @EJB
    CompanyFacadeLocal cfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String fname =  request.getParameter("fname");
        String code = request.getParameter("code");

         Company company = cfl.getCompanny(code, fname);
          session.setAttribute("company", company);
        RequestDispatcher rd = request.getRequestDispatcher("companyZone.jsp");
        rd.forward(request, response);
    }
}
