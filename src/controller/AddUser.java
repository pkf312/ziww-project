package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(
		description = "Create new user Servlet", 
		urlPatterns = { 
				"/AddUser", 
				"/CreateUser.do"
		})
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(User.class);
		ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(servReg);
		
		Session session = factory.openSession();
		session.beginTransaction();
		User u = new User(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("country"));
		session.save(u);
		session.getTransaction().commit();
		session.close();
		
		request.setAttribute("user", u);
		
		RequestDispatcher view = request.getRequestDispatcher("useradd.jsp");
		view.forward(request, response);
	}

}
