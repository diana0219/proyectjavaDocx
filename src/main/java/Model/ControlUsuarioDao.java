package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import util.Conexion;

public class ControlUsuarioDao {
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c=new Conexion();
	
	public List listarUsuarios() throws SQLException {
		List<ControlUsuarioVo> usuarios=new ArrayList<>();
		sql="select * from control_usuario";
		try {
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
				while(rs.next()) {
				ControlUsuarioVo u=new ControlUsuarioVo();
				u.setIdUsuario(rs.getInt("idUsuario"));
				u.setUsuario(rs.getString("usuario"));
				u.setClave(rs.getString("clave"));
				
				usuarios.add(u);
				System.out.println("Consulta exitosa");
			
				}
				ps.close();
			}catch(Exception e) {
				System.out.println("Consulta no exitosa" + e.getMessage());
			}
			finally {
				con.close();
			}
		return usuarios;
		
	}
	
	//Validacion
	
	public boolean validateUser(String usuario, String clave) {
		boolean isValidUser = false;
		try {

			// get the connection for the database
			con=c.conexion();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			ResultSet set = ps.executeQuery();
			// write the select query
			sql="select * from control_usuario where usuario=? and clave=?";
			// set parameters with PreparedStatement
			
			
			
			ps.setString(1, usuario);
			ps.setString(2, clave);

			// execute the statement and check whether user exists

			while (set.next()) {
				isValidUser = true;
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return isValidUser;
	}

	
	

}
