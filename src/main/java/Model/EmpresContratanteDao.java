package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class EmpresContratanteDao {

	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
	
	public List listarempresas()  throws SQLException{
		
		List<EmpresaContratanteVo> empresas=new ArrayList<>();
		sql="select * from empresa_contratante";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				EmpresaContratanteVo em=new EmpresaContratanteVo();
				em.setIdEmpresaCont(rs.getInt("idEmpresaCont"));
				em.setNombre_empresa(rs.getString("nombre_empresa"));
				em.setTelefono(rs.getString("telefono"));
				em.setDireccion(rs.getString("direccion"));
				em.setCorreoEmpresarial(rs.getString("correoEmpresarial"));
				em.setInformacionContacto(rs.getString("informacionContacto"));
				em.setNombreContacto(rs.getString("nombreContacto"));
				em.setTelefonoContacto(rs.getString("telefonoContacto"));
				
				empresas.add(em);
				System.out.println("Consulta exitosa");
				}
			
				ps.close();
				
			}catch(Exception e) {
				System.out.println("Consulta no exitosa" + e.getMessage());
			}
			finally {
				con.close();
			}
			
			return empresas;
	}
		
	
	
	public int registrar(EmpresaContratanteVo em) throws SQLException {
		sql="insert into empresa_contratante(nombre_empresa,telefono,direccion,correoEmpresarial,informacionContacto,nombreContacto,telefonoContacto) VALUES (?,?,?,?,?,?,?)";
		try {
			con=c.conexion(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			ps.setString(1,em.getNombre_empresa());
			ps.setString(2,em.getTelefono());
			ps.setString(3, em.getDireccion());
			ps.setString(4, em.getCorreoEmpresarial());
			ps.setString(5, em.getInformacionContacto());
			ps.setString(6, em.getNombreContacto());
			ps.setString(7, em.getTelefonoContacto());
			
			System.out.println(ps);
			ps.executeUpdate();//Ejeución de la sentencia	
			ps.close();
			System.out.println("Se registró una empresa");
		
			
			
		}catch(Exception e) {
			System.out.println("Error al registrar empresa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return row;
	}
	
	public int eliminar(int id) throws SQLException {
		sql="delete from empresa_contratante WHERE id="+id;
		
		try {
			con=c.conexion(); //Abriendo la conexión a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			
			System.out.println(ps);
			ps.executeUpdate();//Ejeución de la sentencia	
			ps.close();
			System.out.println("Se eliminó una empresa");
			
		}catch(Exception e) {
			System.out.println("Error al eliminar empresa" +e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//Retorna cantidad de filas afectadas
	}
	
	
}
