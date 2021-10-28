package Model;

public class ControlUsuarioVo {
	
	private int idUsuario;
	private String usuario;
	private String clave;
	
	
	public ControlUsuarioVo() {
		
	}


	public ControlUsuarioVo(int idUsuario, String usuario, String clave) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.clave = clave;
	}

	//Getters and Setters
	
	
	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	

}
