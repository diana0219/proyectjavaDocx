package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class TipoNovDao {
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
public List listarNovedad() throws SQLException {
		
		List<TipoNovVo> novedad=new ArrayList<>();
		sql="select * from tipo_novedad";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				TipoNovVo nov=new TipoNovVo();
				nov.setIdTipoNovedad(rs.getInt("idTipoNovedad"));
				nov.setDescripcion(rs.getString("descripcion"));
				
				novedad.add(nov);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		}
		
		finally {
			con.close();
		}
				
		return novedad;		
				
	}


		public int registrar(TipoNovVo nov) throws SQLException {
			sql="insert into tipo_novedad(descripcion) VALUES (?)";
			
			try {
				con=c.conexion(); //Abriendo la conexión a la BD
				ps=con.prepareStatement(sql); //preparar sentencia
				ps.setString(1,nov.getDescripcion());
				
				
				System.out.println(ps);
				ps.executeUpdate();//Ejeución de la sentencia	
				ps.close();
				System.out.println("Se registró una novedad");
				
			}catch(Exception e) {
				System.out.println("Error al registrar la novedad" +e.getMessage());
			}
			finally {
				con.close();
			}
			return row;//Retorna cantidad de filas afectadas
		}
		
		public int eliminar(int id) throws SQLException {
			sql="delete from tipo_novedad WHERE id="+id;
			
			try {
				con=c.conexion(); //Abriendo la conexión a la BD
				ps=con.prepareStatement(sql); //preparar sentencia
				
				System.out.println(ps);
				ps.executeUpdate();//Ejeución de la sentencia	
				ps.close();
				System.out.println("Se eliminó novedad");
				
			}catch(Exception e) {
				System.out.println("Error al eliminar novedad" +e.getMessage());
			}
			finally {
				con.close();
			}
			return row;//Retorna cantidad de filas afectadas
		}
	

	
	

}
