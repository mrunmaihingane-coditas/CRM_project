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

@WebServlet("/deleteUser")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Configuration configuration= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class).addAnnotatedClass(Adminlogin.class).addAnnotatedClass(Adminlogin.class);
        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction =session.beginTransaction();
        int id3 = Integer.parseInt(req.getParameter("id3"));
        User user=session.get(User.class,id3);
            if(user!=null){
                session.delete(user);
                transaction.commit();
                session.close();
                resp.sendRedirect("Adminlogin");
                sf.close();

            }


        }








    }

