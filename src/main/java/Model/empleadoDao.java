package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;


public class empleadoDao {
	
	//Definir variables necesarias
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
	
	
	
	//Metodos
	
	public List listar() throws SQLException {
		
		List<empleadoVo> empleados=new ArrayList<>();
		sql="select idElmpleado,nombres,apellidos,telefono_fijo,telefono_movil,direccion,estado_civil,correo_electronico,tipo_documento,numero_documento,usuario * from empleado join control_usuario on control_usuario.idUsuario = empleado.usuario_idFK ";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				empleadoVo e=new empleadoVo();
				e.setIdEmpleado(rs.getInt("idEmpleado"));
				e.setNombres(rs.getString("nombres"));
				e.setApellidos(rs.getString("apellidos"));
				e.setTelefono_fijo(rs.getInt("telefono_fijo"));
				e.setTelefono_movil(rs.getInt("telefono_movil"));
				e.setDireccion(rs.getString("direccion"));
				e.setEstado_civil(rs.getString("estado_civil"));
				e.setCorreo_electronico(rs.getString("correo_electronico"));
				e.setTipo_documento(rs.getString("tipo_documento"));
				e.setNumero_documento(rs.getInt("numero_documento"));
				e.setConUs(new ControlUsuarioVo());
				
				
				empleados.add(e);
				System.out.println("Consulta exitosa");
				
			}
			
			ps.close();
			
		}catch(Exception e) {
			System.out.println("Consulta no exitosa" + e.getMessage());
		}
		
		finally {
			con.close();
		}
				
		return empleados;		
				
	}
}