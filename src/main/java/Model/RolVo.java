package Model;

public class RolVo {

	
	//Atributos encapsulados
	 
	private int idRol;
	private String rol;
	private String usuario;
	private ControlUsuarioVo conU;
	
	
	//Constructores
	
	public RolVo() {
		
		
	}



	public RolVo(int idRol, String rol, String usuario, ControlUsuarioVo conU) {
		super();
		this.idRol = idRol;
		this.rol = rol;
		this.usuario = usuario;
		this.conU = conU;
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



	public ControlUsuarioVo getConU() {
		return conU;
	}



	public void setConU(ControlUsuarioVo conU) {
		this.conU = conU;
	}


	
	
	
	
	
	
	
}
