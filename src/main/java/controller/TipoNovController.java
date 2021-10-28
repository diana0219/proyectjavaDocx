package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TipoNovDao;
import Model.TipoNovVo;

/**
 * Servlet implementation class TipoNovController
 */
@WebServlet("/TipoNovController")
public class TipoNovController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TipoNovDao tnovdao=new TipoNovDao();
	TipoNovVo nov =new TipoNovVo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoNovController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accionnov=request.getParameter("accionnov");
		
		try {
			if (accionnov !=null) {
				switch(accionnov) {
				
				case "listarNovedad":
					listarNovedad(request,response);
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
	
	private  void listarNovedad (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 
		 try {
			List novedades= tnovdao.listarNovedad();
			request.setAttribute("novedades",novedades);
			request.getRequestDispatcher("views/tpnovedad.jsp").forward(request, response);
			System.out.println("Tipo Novedad encontrada");
			 
		 }catch(Exception e) {
			 System.out.println("Tipo Novedad no encontrada"+e.getMessage());
			 
		 }
		 finally {
			 tnovdao=null;
			 
		 }
		
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("novedad") !=null) {
			nov.setDescripcion(request.getParameter("descripcion"));
		}
		

		
		try {
			tnovdao.registrar(nov);
			response.sendRedirect("TipoNovController?accionnov=listarNovedad");
			System.out.println("Novedad registrada");
		}catch(Exception e) {
			
			System.out.println("Error al registrar novedad");
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idTipoNovedad") !=null) {
			nov.setIdTipoNovedad(Integer.parseInt(request.getParameter("idTipoNovedad")));
		}
		
		try {
		tnovdao.eliminar(nov.getIdTipoNovedad());
			response.sendRedirect("TipoNovController?accionnov=listarNovedad");
			System.out.println("Novedad eliminada");
		}catch(Exception e) {
			
			System.out.println("Error al eliminar la novedad");
		}
	}

	
	

}
