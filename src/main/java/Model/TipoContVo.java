package Model;

public class TipoContVo {
	
	private int idTipoContrato;
	private String nombreContrato;
	
	
	public TipoContVo() {
		
	}


	public TipoContVo(int idTipoContrato, String nombreContrato) {
		super();
		this.idTipoContrato = idTipoContrato;
		this.nombreContrato = nombreContrato;
	}


	public int getIdTipoContrato() {
		return idTipoContrato;
	}


	public void setIdTipoContrato(int idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}


	public String getNombreContrato() {
		return nombreContrato;
	}


	public void setNombreContrato(String nombreContrato) {
		this.nombreContrato = nombreContrato;
	}
	
	
	

}
