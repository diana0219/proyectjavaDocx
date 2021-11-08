package Model;

public class empleadoVo {
private int idEmpleado,telefono_fijo,telefono_movil,numero_documento;
private String nombres,apellidos,estado_civil,direccion,correo_electronico,tipo_documento;
private ControlUsuarioVo conUs;

public empleadoVo() {
	
}



public empleadoVo(int idEmpleado, int telefono_fijo, int telefono_movil, int numero_documento,
		String nombres, String apellidos, String estado_civil, String direccion, String correo_electronico,
		String tipo_documento,ControlUsuarioVo conUs) {
	super();
	this.idEmpleado = idEmpleado;
	this.telefono_fijo = telefono_fijo;
	this.telefono_movil = telefono_movil;
	this.tipo_documento = tipo_documento;
	this.numero_documento = numero_documento;
	this.nombres = nombres;
	this.apellidos = apellidos;
	this.estado_civil = estado_civil;
	this.direccion = direccion;
	this.correo_electronico = correo_electronico;
	this.conUs = conUs;
}




public int getIdEmpleado() {
	return idEmpleado;
}




public void setIdEmpleado(int idEmpleado) {
	this.idEmpleado = idEmpleado;
}




public int getTelefono_fijo() {
	return telefono_fijo;
}




public void setTelefono_fijo(int telefono_fijo) {
	this.telefono_fijo = telefono_fijo;
}




public int getTelefono_movil() {
	return telefono_movil;
}




public void setTelefono_movil(int telefono_movil) {
	this.telefono_movil = telefono_movil;
}




public String getTipo_documento() {
	return tipo_documento;
}




public void setTipo_documento(String tipo_documento) {
	this.tipo_documento = tipo_documento;
}




public int getNumero_documento() {
	return numero_documento;
}




public void setNumero_documento(int numero_documento) {
	this.numero_documento = numero_documento;
}




public String getNombres() {
	return nombres;
}




public void setNombres(String nombres) {
	this.nombres = nombres;
}




public String getApellidos() {
	return apellidos;
}




public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}




public String getEstado_civil() {
	return estado_civil;
}




public void setEstado_civil(String estado_civil) {
	this.estado_civil = estado_civil;
}




public String getDireccion() {
	return direccion;
}




public void setDireccion(String direccion) {
	this.direccion = direccion;
}




public String getCorreo_electronico() {
	return correo_electronico;
}




public void setCorreo_electronico(String correo_electronico) {
	this.correo_electronico = correo_electronico;
}




public ControlUsuarioVo getConUs() {
	return conUs;
}




public void setConUs(ControlUsuarioVo conUs) {
	this.conUs = conUs;
}



}

