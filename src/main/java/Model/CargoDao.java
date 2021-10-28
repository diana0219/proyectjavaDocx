package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class CargoDao {

	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
public List listarCargo() throws SQLException {
		
		List<CargoVo> cargo=new ArrayList<>();
		sql="select * from cargo";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				CargoVo cr=new CargoVo();
				cr.setIdCargo(rs.getInt("idCargo"));
				cr.setNombre_cargo(rs.getString("nombreCargo"));
				
				cargo.add(cr);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		}
		
		finally {
			con.close();
		}
				
		return cargo;
				
	}
public int registrar(CargoVo cr) throws SQLException {
	sql="insert into tipo_novedad(descripcion) VALUES (?)";
	
	try {
		con=c.conexion(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1,cr.getNombre_cargo());
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se registró un cargo");
		
	}catch(Exception e) {
		System.out.println("Error al registrar un cargo" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}



public int eliminar(int id) throws SQLException {
	sql="delete from cargo WHERE id="+id;
	
	try {
		con=c.conexion(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia	
		ps.close();
		System.out.println("Se eliminó cargo");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el cargo" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}




}
