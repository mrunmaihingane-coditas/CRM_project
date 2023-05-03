package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
@WebServlet("/saveIssue")
public class saveIssue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Configuration configuration= new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();

        String complain = req.getParameter("complain");
        String dateOfComplain = req.getParameter("date");

        HttpSession session1=req.getSession(false);
        int userfetchid = (int) session1.getAttribute("userId");

        User userfetach = session.get(User.class,userfetchid);


        Issues newisuues= new Issues(complain,dateOfComplain,userfetach);


        session.save(newisuues);

        resp.sendRedirect("Userlogin");

        transaction.commit();
        session.close();
        sf.close();


    }
}
