package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.EmpresContratanteDao;
import Model.EmpresaContratanteVo;
import Model.RolDao;

/**
 * Servlet implementation class EmpresaContratanteController
 */
@WebServlet("/EmpresaContratanteController")
public class EmpresaContratanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmpresContratanteDao ecdao=new EmpresContratanteDao();
	EmpresaContratanteVo em=new EmpresaContratanteVo();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaContratanteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accionemp=request.getParameter("accionemp");
		try {
			if (accionemp !=null) {
				switch(accionemp) {
				
				case "listarempresas":
					listarempresas(request,response);
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
	
	private  void listarempresas (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		 
		 try {
			List empresa_contratante= ecdao.listarempresas();
			request.setAttribute("empresas",empresa_contratante);
			request.getRequestDispatcher("views/EmpresaContratante.jsp").forward(request, response);
			System.out.println("Empresas encontradas");
			 
		 }catch(Exception e) {
			 System.out.println("Empresas no encontrados"+e.getMessage());
			 
		 }
		 finally {
			 ecdao=null;
			 
		 }
		
	}
	
	private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.getRequestDispatcher("views/empc-add.jsp").forward(request, response);
		System.out.println("Formulario Empresa abierto");
		}catch(Exception e) {
			
			System.out.println("Error al abrir el formulario Empresa");
		}
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("empresa_contratante") !=null) {
			em.setNombre_empresa(request.getParameter("empresa_contratante"));
		}
		

		
		try {
			ecdao.registrar(em);
			response.sendRedirect("EmpresContratanteController?accionem=listarempresas");
			System.out.println("Empresa registrada");
		}catch(Exception e) {
			
			System.out.println("Error al registrar Empresa");
		}
	}
 
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("idEmpresaCont") !=null) {
			em.setIdEmpresaCont(Integer.parseInt(request.getParameter("idEmpresaCont")));
		}
		
		try {
			ecdao.eliminar(em.getIdEmpresaCont());
			response.sendRedirect("EmpresaContratanteController?accionem=listarempresas");
			System.out.println("Empresa eliminada");
		}catch(Exception e) {
			
			System.out.println("Error al eliminar la empresa");
		}
	}


	

}
