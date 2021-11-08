package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class DocumentosDao {
	
	Connection con;
	
	public DocumentosDao() throws ClassNotFoundException{
		Conexion c=new Conexion();
		con=c.conexion();
		
		
	}
	
	public List<DocumentosVo> listarDocumentos(){
		
		PreparedStatement ps;
		ResultSet rs;
		
		List<DocumentosVo>lista = new ArrayList<>();
		
		try {
			ps= con.prepareStatement("Select idDocumentos,nombre_documento, obligatorio_s_n from documentos");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("idDocumentos");
				String nombre_documento =rs.getString("nombre_documento");
				String obligatorio_s_n =rs.getString("obligatorio_s_n");
				
				DocumentosVo docvo = new DocumentosVo(id,nombre_documento,obligatorio_s_n);
				lista.add(docvo);
				
			}
			
			return lista;
			
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
		
	}

	
	
	public DocumentosVo mostrarDocumentos(int _id){
		
		PreparedStatement ps;
		ResultSet rs;
		
		DocumentosVo documento = null;
		
		try {
			ps= con.prepareStatement("Select idDocumentos,nombre_documento, obligatorio_s_n from documentos where id=?");
			ps.setInt(1, _id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("idDocumentos");
				String nombre_documento =rs.getString("nombre_documento");
				String obligatorio_s_n =rs.getString("obligatorio_s_n");
				
				documento = new DocumentosVo(id,nombre_documento,obligatorio_s_n);
				
			}
			
			return documento;
			
		}catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
		
		
	}
	
	
	
	public boolean insertar (DocumentosVo docvo){
		
		PreparedStatement ps;
		
	
		
		try {
			ps= con.prepareStatement("insert into documentos (nombre_documento, obligatorio_s_n) values (?,?)");
			ps.setString(1, docvo.getNombre_documento());
			ps.setString(2, docvo.getObligatorio_s_n());
			 ps.execute();
			 return true;
			 
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		
	}

	
	
	public boolean actualizar (DocumentosVo docvo){

		
		PreparedStatement ps;
		
		
		
		
		try {
			ps= con.prepareStatement("update documentos set nombre_documento=?, obligatorio_s_n=? where id=?");
			ps.setString(1, docvo.getNombre_documento());
			ps.setString(2, docvo.getObligatorio_s_n());
			ps.setInt(3, docvo.getIdDocumentos());
			ps.execute();
			 return true;
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		
	}
	
	

	public boolean eliminar (int _id){
		
		PreparedStatement ps;
		
		
		
		
		try {
			ps= con.prepareStatement("delete from  documentos where id=?");
			ps.setInt(1, _id());
			ps.execute();
			 return true;
			
			
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		
	}

	private int _id() {
		// TODO Auto-generated method stub
		return 0;
	}
}
