package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DocumentosDao;
import Model.DocumentosVo;

/**
 * Servlet implementation class DocumentosController
 */
@WebServlet("/DocumentosController")
public class DocumentosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DocumentosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DocumentosDao docdao = null;
		try {
			docdao = new DocumentosDao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String accion;
		RequestDispatcher dispatcher = null;
		
		accion = request.getParameter("accion");
		
		if(accion == null || accion.isEmpty()) {
			dispatcher = request.getRequestDispatcher("views/documentos.jsp");
			
			List<DocumentosVo> listaDocumentos =docdao.listarDocumentos();
			request.setAttribute("lista", listaDocumentos);
			
		}else if ("nuevo".equals(accion)) {
			dispatcher =request.getRequestDispatcher("views/doc-agreg.jsp");
			
		}else if ("insertar".equals(accion)) {	
			
			String  nombre_documento =request.getParameter("nombre_documento");
			String  obligatorio_s_n =request.getParameter(" obligatorio_s_n ");
			int existencia= Integer.parseInt(request.getParameter("existencia"));
			
			DocumentosVo docvo =new DocumentosVo (0, nombre_documento, obligatorio_s_n);
			
			docdao.insertar(docvo);
			dispatcher = request.getRequestDispatcher("views/documentos.jsp");
			List<DocumentosVo> listaDocumentos =docdao.listarDocumentos();
			request.setAttribute("lista", listaDocumentos);
			
		}
		
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
