package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RolDao;
import Model.RolVo;

/**
 * Servlet implementation class RolController
 */
@WebServlet("/RolController")
public class RolController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	RolDao rdao=new RolDao();
	RolVo r=new RolVo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolController() {
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
		try {
			if (accion !=null) {
				switch(accion) {
				
				case "listarRoles":
					listarRoles(request,response);
				break;
				
				case "abrirForm":
					
					abrirForm(request,response);
					break;
					
				case "add":
					add(request,response);
					break;
					
				case "delete":
					delete(request,response);
					
					
					default:
						response.sendRedirect("login.jsp");
						
				}
				
			}else {
					response.sendRedirect("login.jsp");
				}
				
			
		}catch (Exception e) {
			
				
			}
			
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	 private  void listarRoles (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 
		 try {
			List rol= rdao.listarRoles();
			request.setAttribute("roles",rol);
			request.getRequestDispatcher("views/Rol.jsp").forward(request, response);
			System.out.println("Roles encontrados");
			 
		 }catch(Exception e) {
			 System.out.println("Roles no encontrados"+e.getMessage());
			 
		 }
		 finally {
			 rdao=null;
			 
		 }
		
	}
	 
	 private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			request.getRequestDispatcher("views/rol-add.jsp").forward(request, response);
			System.out.println("Formulario Rol abierto");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario Rol");
			}
		}
		
		private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("rol") !=null) {
				r.setRol(request.getParameter("rol"));
			}
			

			
			try {
				rdao.registrar(r);
				response.sendRedirect("RolController?accion=listarRoles");
				System.out.println("Rol registrado");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario Rol");
			}
		}
	 
		
		private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				if(request.getParameter("idRol") !=null) {
					r.setIdRol(Integer.parseInt(request.getParameter("idRol")));
				}
				
				try {
					rdao.eliminar(r.getIdRol());
					response.sendRedirect("RolController?accion=listarRoles");
					System.out.println("Rol eliminado");
				}catch(Exception e) {
					
					System.out.println("Error al eliminar el Rol");
				}
			}

		

}
