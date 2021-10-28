package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;


public class RolDao {
	
	//Definir variables necesarias
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
	
	
	
	//Metodos
	
	public List listarRoles() throws SQLException {
		
		List<RolVo> roles=new ArrayList<>();
		sql="select * from rol";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				RolVo r=new RolVo();
				r.setIdRol(rs.getInt("idRol"));
				r.setRol(rs.getString("rol"));
				
				roles.add(r);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		}
		
		finally {
			con.close();
		}
				
		return roles;		
				
	}
	



	public int registrar(RolVo r) throws SQLException {
		sql="insert into rol(rol,idUsuario) VALUES (?)";
		
		try {
			con=c.conexion(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			ps.setString(1,r.getRol());
			
			
			System.out.println(ps);
			ps.executeUpdate();//Ejeución de la sentencia	
			ps.close();
			System.out.println("Se registró un rol");
			
		}catch(Exception e) {
			System.out.println("Error al registrar el rol" +e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//Retorna cantidad de filas afectadas
	}
		


public int eliminar(int id) throws SQLException {
	sql="delete from rol WHERE id="+id;
	
	try {
		con=c.conexion(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se eliminó un rol");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
	
}