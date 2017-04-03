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

import model.Product;

/**
 * Servlet implementation class AddUser
 */
@WebServlet(
		description = "Create new user Servlet", 
		urlPatterns = { 
				"/PrintProduct", 
				"/printProduct.do"
		})
public class PrintProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Configuration config = new Configuration().configure();
		config.addAnnotatedClass(Product.class);
		ServiceRegistry servReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(servReg);
		
		Session session = factory.openSession();
		session.beginTransaction();
		Product p=new Product("cotoletta ", "www.google.it");
		//User u = new User(request.getParameter("firstname"), request.getParameter("lastname"), request.getParameter("country"));
		session.save(p);
		session.getTransaction().commit();
		session.close();
		
		request.setAttribute("product", p);
		
		RequestDispatcher view = request.getRequestDispatcher("prova.jsp");
		view.forward(request, response);
	}

}
