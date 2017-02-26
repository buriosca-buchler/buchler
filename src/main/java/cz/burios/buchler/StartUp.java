package cz.burios.buchler;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StartUp
 */
//@WebServlet("/StartUp")
public class StartUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartUp() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("StartUp.init(config)");
		try {
			Context initContext = new InitialContext();
			DataSource ds = null;
			boolean ok = false;
			try {
				Context envContext  = (Context) initContext.lookup("java:jboss/datasources");	
				ds = (DataSource) envContext.lookup("BuchlerDS");
			} catch (Exception e) {
				try {
					Context envContext  = (Context) initContext.lookup("java:/comp/env");
					ds = (DataSource) envContext.lookup("jboss/datasources/BuchlerDS");
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
			System.out.println("StartUp.init().ds: " + ds);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
