package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TipoContDao;
import Model.TipoContVo;
import Model.TipoNovDao;
import Model.TipoNovVo;

/**
 * Servlet implementation class TipoContratoController
 */
@WebServlet("/TipoContratoController")
public class TipoContratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	TipoContDao tcontdao=new TipoContDao();
	TipoContVo cont =new TipoContVo();
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoContratoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
	
		String acciontc=request.getParameter("acciontc");
		
		try {
			if (acciontc !=null) {
				switch(acciontc) {
				
				case "listartpContrato":
					listartpContrato(request,response);
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
	
	private  void listartpContrato (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 
		 try {
			List tipo_contrato= tcontdao.listartpContrato();
			request.setAttribute("tipo_contrato",tipo_contrato);
			request.getRequestDispatcher("views/tpContrato.jsp").forward(request, response);
			System.out.println("Tipo Contrato encontrada");
			 
		 }catch(Exception e) {
			 System.out.println("Tipo Contrato no encontrada"+e.getMessage());
			 
		 }
		 finally {
			 tcontdao=null;
			 
		 }
		
	}
	
private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("contrato") !=null) {
			cont.setNombreContrato(request.getParameter("nombreContrato"));
		}
		

		
		try {
			tcontdao.registrar(cont);
			response.sendRedirect("TipoContController?acciontc=listartpContrato");
			System.out.println("Tipo contrato registrado");
		}catch(Exception e) {
			
			System.out.println("Error al registrar tipo de contrato");
		}
	}

private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("idTipoContrato") !=null) {
		cont.setIdTipoContrato(Integer.parseInt(request.getParameter("idTipoContrato")));
	}
	
	try {
	tcontdao.eliminar(cont.getIdTipoContrato());
		response.sendRedirect("TipoContController?acciontc=listartpContrato");
		System.out.println("Tipo Contrato  eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el Tipo Contrato");
	}
}
	
	
	

}
