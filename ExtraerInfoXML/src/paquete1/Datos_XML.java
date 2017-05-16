package paquete1;

import java.util.ArrayList;

public class Datos_XML {

	private String sublote;
	private boolean unico;
	private ArrayList<String> ejemplar;
	
	public Datos_XML(){
		this.ejemplar = new ArrayList<>();
	}
	
	public Datos_XML(String sublote, boolean unico, ArrayList<String> ejemplar) {
		super();
		this.sublote = sublote;
		this.unico = unico;
		this.ejemplar = ejemplar;
	}

	public String getSublote() {
		return sublote;
	}
	public void setSublote(String sublote) {
		this.sublote = sublote;
	}
	public boolean isUnico() {
		return unico;
	}
	public void setUnico(boolean unico) {
		this.unico = unico;
	}
	public ArrayList<String> getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(ArrayList<String> ejemplar) {
		this.ejemplar = ejemplar;
	}
	
}
