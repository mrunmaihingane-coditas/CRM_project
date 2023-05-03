package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/login")
public class login extends HttpServlet {
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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if(role.equalsIgnoreCase("User")) {
            List<User> users = session.createQuery("from User").list();

            for (User user:users){
                if (username.equals(user.getUsername())&&password.equals(user.getPassword())){
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("userId", user.getId());
                    resp.sendRedirect("Userlogin");

                }

            }



        }
        else if(role.equalsIgnoreCase("admin")){
            if(username.equals("admin")&&password.equals("root")) {
                resp.sendRedirect("Adminlogin");
            }
            out.println("<p style='color: red;'>Invalid admin </p>");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
            requestDispatcher.include(req,resp);



        }
        else {
            String hql = "from CRM a where a.username = :username and a.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List results = query.list();

            if(results.isEmpty()){
                out.println("<p style='color: red;'>Invalid username or password. Please try again.</p>");
                RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.jsp");
                requestDispatcher.include(req,resp);
            }
            out.println("SUCCESSFUL CRM LOGIN");


        }
        transaction.commit();
        session.close();
        sf.close();

    }
}
