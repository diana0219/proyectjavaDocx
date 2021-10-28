package Model;

public class EmpresaContratanteVo {
	
	private int idEmpresaCont;
	private String nombre_empresa;
	private String telefono;
	private String direccion;
	private String correoEmpresarial;
	private String informacionContacto;
	private String nombreContacto;
	private String telefonoContacto;
	
	public EmpresaContratanteVo() {
		
	}

	public EmpresaContratanteVo(int idEmpresaCont, String nombre_empresa, String telefono, String direccion,
			String correoEmpresarial, String informacionContacto, String nombreContacto, String telefonoContacto) {
		super();
		this.idEmpresaCont = idEmpresaCont;
		this.nombre_empresa = nombre_empresa;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correoEmpresarial = correoEmpresarial;
		this.informacionContacto = informacionContacto;
		this.nombreContacto = nombreContacto;
		this.telefonoContacto = telefonoContacto;
	}

	
	//Getters and Setters
	
	
	public int getIdEmpresaCont() {
		return idEmpresaCont;
	}

	public void setIdEmpresaCont(int idEmpresaCont) {
		this.idEmpresaCont = idEmpresaCont;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoEmpresarial() {
		return correoEmpresarial;
	}

	public void setCorreoEmpresarial(String correoEmpresarial) {
		this.correoEmpresarial = correoEmpresarial;
	}

	public String getInformacionContacto() {
		return informacionContacto;
	}

	public void setInformacionContacto(String informacionContacto) {
		this.informacionContacto = informacionContacto;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}
	
	
	
	
	

}
