package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {

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

        HttpSession httpSession=req.getSession(false);
        int userfetchid = (int) httpSession.getAttribute("userId");
        System.out.println(userfetchid+"fetchid");
        out.println("WELCOME  USER ID : "+userfetchid);

        out.println("<br>");
        out.println("*************************MYDATA*********************************");
        out.println("<br>");

        Query q =session.createQuery("from User u where u.id=:id ");
        q.setParameter("id",userfetchid);
        List<User> userlist = q.getResultList();

        out.println("<table>");
        out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
        for (User user : userlist) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");

            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<a href ='isssue.jsp'>AddIssues</a>");

        out.println("<br>");
        out.println("****************************************************************");
        out.println("<br>");

        out.println("<br>");
        out.println("**********************Issues****************************************");
        out.println("<br>");

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root<Issues> issues = query.from(Issues.class);
        Join<Issues, User> userJoin = issues.join("user");

        query.multiselect(
                issues.get("complainId"),
                issues.get("complain")
        ).where(
                builder.equal(userJoin.get("id"), userfetchid)
        );

        List<Object[]> results = session.createQuery(query).getResultList();

        // Printing the results as a table
        out.println("<table>");
        out.println("<tr><th>Complain ID</th><th>Complain</th></tr>");
        for (Object[] result : results) {
            out.println("<tr>");
            out.println("<td>" + result[0] + "</td>");
            out.println("<td>" + result[1] + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");



        transaction.commit();
        session.close();
        sf.close();



    }

}
