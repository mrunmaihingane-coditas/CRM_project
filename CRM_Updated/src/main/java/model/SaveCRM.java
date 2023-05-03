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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/saveCrm")
public class SaveCRM extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Configuration configuration= new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();

        String username = req.getParameter("crm-username");

        String name=req.getParameter("crm-name");

        String data_crm = req.getParameter("date_crm");

        CRM crm = new CRM();
        crm.setName(name);
        crm.setUsername(username);
        crm.setAvaible_date(data_crm);

        session.save(crm);


        resp.sendRedirect("Adminlogin");

        transaction.commit();
        session.close();
        sf.close();






    }
}
