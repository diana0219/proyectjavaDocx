package Model;

public class TipoNovVo {
	
	private int idTipoNovedad;
	private String descripcion;

	
	public TipoNovVo() {
		
	}


	public TipoNovVo(int idTipoNovedad, String descripcion) {
		super();
		this.idTipoNovedad = idTipoNovedad;
		this.descripcion = descripcion;
	}


	public int getIdTipoNovedad() {
		return idTipoNovedad;
	}


	public void setIdTipoNovedad(int idTipoNovedad) {
		this.idTipoNovedad = idTipoNovedad;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
