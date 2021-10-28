package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ControlUsuarioDao;
import Model.ControlUsuarioVo;

/**
 * Servlet implementation class ControlUsuarioController
 */
@WebServlet("/Login")

public class ControlUsuarioController extends HttpServlet {

	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		String html = "<html><h3>Please login</h3></html>";
		resp.getWriter().write(html+" ");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/html/login.jsp");
		dispatcher.include(req, resp);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String usuario = req.getParameter("idUsuario");
		String clave = req.getParameter("clave");
		
		// dao
		
		ControlUsuarioDao controldao = new ControlUsuarioDao();
		boolean isValidUser = controldao.validateUser(usuario,clave);
		if (isValidUser) {
			
			HttpSession session = req.getSession();
			
			
			session.setAttribute("idUsuario", usuario);
			
			req.getRequestDispatcher("/html/home.jsp").forward(req, resp);
			
			
		}
		else{
			String errorMessage="Invalid Credentials, please login again!";
			req.setAttribute("error", errorMessage);
			req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
			
		
		
		
	}



}










}
