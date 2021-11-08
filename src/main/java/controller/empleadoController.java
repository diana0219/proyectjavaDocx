package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.empleadoDao;
import Model.empleadoVo;

/**
 * Servlet implementation class empleadoController
 */
@WebServlet("/empleadoController")
public class empleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	empleadoVo e=new empleadoVo();
	empleadoDao edao=new empleadoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String accion=request.getParameter("accion");
		System.out.println("Entró al controlador"+accion);
		try {
			if(accion!=null) {
				switch(accion) {
				
				case "listar":
					System.out.println("Entró a la opción listar");
					listar(request,response);
				break;
				default:
					response.sendRedirect("index.jsp");
				}
			}
			
			else {
				response.sendRedirect("index.jsp");
			}
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Entramos al método listar");
		
		try {
			List emp=edao.listar();
			request.setAttribute("empleado",emp);
			request.getRequestDispatcher("views/empleados.jsp").forward(request, response);
			System.out.println("Empleados encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Empleados no encontrados "+e.getMessage());
		}
		finally {
			
		}
		
	}

}
