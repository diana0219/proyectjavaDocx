package Model;

public class RolVo {

	
	//Atributos encapsulados
	 
	private int idRol;
	private String rol;
	private String usuario;
	
	
	//Constructores
	
	public RolVo() {
		
		
	}


	

	public RolVo(int idRol, String rol, String usuario) {
		super();
		this.idRol = idRol;
		this.rol = rol;
		this.usuario = usuario;
	}




	//Getters and Setters

	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}




	public String getUsuario() {
		return usuario;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	
	
	
	
	
	
	
}
