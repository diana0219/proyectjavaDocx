package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	private static final String db="jdbc:mysql://localhost:3306/docx";
	
	private static final String usuario="root";
	private static final String clave="sebasguzman2796@";
	
	private static Connection con;
	
	
	//metodo de conexion
	
	public static Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection( db,usuario, clave);
			System.out.println("Conexion exitosa");
			
		}catch(Exception e) {
			System.out.println("Error en la conexión"+e.getMessage().toString());
			
			}
		return con;
	}

}
