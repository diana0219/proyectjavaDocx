package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.CargoDao;
import Model.CargoVo;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/CargoController")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CargoDao crdao= new CargoDao();
	CargoVo cr=new CargoVo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accioncr=request.getParameter("accioncr");
		try {
			if (accioncr !=null) {
				switch(accioncr) {
				
				case "listarCargo":
					listarCargo(request,response);
				break;
				
					
				case "add":
					add(request,response);
					break;
					
				case "delete":
					delete(request,response);
					
					
					default:
						response.sendRedirect("index.jsp");
						
				}
				
			}else {
					response.sendRedirect("index.jsp");
				}
				
			
		}catch (Exception e) {
			
				
			}
			
		}
	
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private  void listarCargo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 
		 try {
			List cargos= crdao.listarCargo();
			request.setAttribute("cargo",cargos);
			request.getRequestDispatcher("views/cargo.jsp").forward(request, response);
			System.out.println("Cargo encontrado");
			 
		 }catch(Exception e) {
			 System.out.println("Cargo no encontrado"+e.getMessage());
			 
		 }
		 finally {
			 crdao=null;
			 
		 }
		
	}
	
	
private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("cargo") !=null) {
			cr.setNombre_cargo(request.getParameter("nombreCargo"));
		}
		

		
		try {
			crdao.registrar(cr);
			response.sendRedirect("CargoController?accioncr=listarcargo");
			System.out.println("Cargo registrado");
		}catch(Exception e) {
			
			System.out.println("Error al registrar el cargo");
		}
	}

private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("idCargo") !=null) {
		cr.setIdCargo(Integer.parseInt(request.getParameter("idCargo")));
	}
	
	try {
	crdao.eliminar(cr.getIdCargo());
		response.sendRedirect("CargoController?accioncr=listarCargo");
		System.out.println("Cargo eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el cargo");
	}
}
	
	

}
