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

@WebServlet("/addcrm")
public class addcrm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Configuration configuration= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class).addAnnotatedClass(Adminlogin.class).addAnnotatedClass(Adminlogin.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();


        int issues_id = Integer.parseInt(req.getParameter("issues_id"));
        Issues user=session.get(Issues.class,issues_id);

        int crm_id = Integer.parseInt(req.getParameter("crm_id"));
        user.setCrm(session.get(CRM.class,crm_id));



        session.save(user);
        transaction.commit();
        resp.sendRedirect("Adminlogin");
        sf.close();
    }
}
