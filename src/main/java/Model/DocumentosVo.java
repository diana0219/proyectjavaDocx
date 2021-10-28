package Model;

public class DocumentosVo {

	private int idDocumentos;
	private String nombre_documento;
	private String obligatorio_s_n;
	
	
	//constructor
	public DocumentosVo(int idDocumentos, String nombre_documento, String obligatorio_s_n) {
		super();
		this.idDocumentos = idDocumentos;
		this.nombre_documento = nombre_documento;
		this.obligatorio_s_n = obligatorio_s_n;
	}
	
	
	//getters and setters
	public int getIdDocumentos() {
		return idDocumentos;
	}
	public void setIdDocumentos(int idDocumentos) {
		this.idDocumentos = idDocumentos;
	}
	public String getNombre_documento() {
		return nombre_documento;
	}
	public void setNombre_documento(String nombre_documento) {
		this.nombre_documento = nombre_documento;
	}
	public String getObligatorio_s_n() {
		return obligatorio_s_n;
	}
	public void setObligatorio_s_n(String obligatorio_s_n) {
		this.obligatorio_s_n = obligatorio_s_n;
	}
	
	
	
}
