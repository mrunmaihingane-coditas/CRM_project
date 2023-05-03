package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //servalet
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        //hibernet
        Configuration configuration= new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();

        out.println("ADMIN LOGIN");
        out.println("<br>");
        out.println("<a href ='crmregestrtion.jsp'>Register CRM</a>");
        out.println("<a href ='regestrtion.jsp'>Register User</a>");
        out.println("<br>");

        out.println("*********************************USER LIST*********************************************");


        List<User>userlist = session.createQuery("from User").getResultList();
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Delete</th><th>Edit</th></tr>");
        for (User user : userlist) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td><a href='deleteUser?id3=" + user.getId() + "'>Delete</a></td>");
            out.println("<td><a href='edit.jsp?id3=" + user.getId() + "'>Edit</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");

        out.println("********************************CRMList**********************************************");


        List<CRM>crmslist = session.createQuery("from CRM").getResultList();
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>User </th><th>  Avaiable_date</th></tr>");
        for (CRM crm : crmslist) {
            out.println("<tr>");
            out.println("<td>" + crm.getId() + "</td>");
            out.println("<td>" + crm.getName() + "</td>");
            out.println("<td>" + crm.getUsername() + "</td>");
            out.println("<td>" + crm.getAvaible_date() + "</td>");

            out.println("</tr>");
        }
        out.println("</table>");

        out.println("********************************IssuesList**********************************************");


        List<Issues>Issueslist = session.createQuery("from Issues").getResultList();
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Date</th><th>Action</th></tr>");
        for (Issues issues : Issueslist) {
            out.println("<tr>");
            out.println("<td>" + issues.getCompleteId() + "</td>");
            out.println("<td>" + issues.getComplain() + "</td>");
            out.println("<td>" + issues.getComplain_date() + "</td>");
            out.println("<td><a href='addcrm.jsp?issues_id=" + issues.getComplainId() + "'>AddCrm</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");




        transaction.commit();
        session.close();
        sf.close();
    }
}
