package Model;

import java.sql.Connection;

public class CargoVo {
	
	private int idCargo;
	private String nombre_cargo;
	
	public CargoVo() {
		
	}

	public CargoVo(int idCargo, String nombre_cargo) {
		super();
		this.idCargo = idCargo;
		this.nombre_cargo = nombre_cargo;
	}

	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNombre_cargo() {
		return nombre_cargo;
	}

	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}

	
	
	

}
