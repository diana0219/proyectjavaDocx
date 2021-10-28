package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class TipoContDao {
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
public List listartpContrato() throws SQLException {
		
		List<TipoContVo> contrato=new ArrayList<>();
		sql="select * from tipo_contrato";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				TipoContVo cont=new TipoContVo();
				cont.setIdTipoContrato(rs.getInt("idTipoContrato"));
				cont.setNombreContrato(rs.getString("nombreContrato"));
				
				contrato.add(cont);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		}
		
		finally {
			con.close();
		}
				
		return contrato;		
				
	}
public int registrar(TipoContVo cont) throws SQLException {
	sql="insert into tipo_contrato(nombreContrato) VALUES (?)";
	
	try {
		con=c.conexion(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1,cont.getNombreContrato());
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró un tipo de contrato");
		
	}catch(Exception e) {
		System.out.println("Error al registrar tipo contrato" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int eliminar(int id) throws SQLException {
	sql="delete from tipo_contrato WHERE id="+id;
	
	try {
		con=c.conexion(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se eliminó el tipo de contrato");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el tpo de contrato" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
	
	

}
