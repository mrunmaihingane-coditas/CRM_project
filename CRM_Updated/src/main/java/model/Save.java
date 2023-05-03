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

@WebServlet("/save")
public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Configuration configuration= new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name=req.getParameter("name");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        session.save(user);
        transaction.commit();

        out.println("Resgistrtion Successful");

        out.println("<a href ='login.jsp'>LoginButton</a>");


        session.save(user);
        transaction.commit();
        session.close();
        sf.close();

    }
}