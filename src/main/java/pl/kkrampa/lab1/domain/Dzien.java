package pl.kkrampa.lab1.domain;

import java.util.Date;

public class Dzien {
	
	private Date data;
	private Pogoda pogoda;
	private String imieniny;
	
	public Dzien(Date data, Pogoda pogoda, String imieniny) {
		super();
		this.data = data;
		this.pogoda = pogoda;
		this.imieniny = imieniny;
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Pogoda getPogoda() {
		return pogoda;
	}
	
	public void setPogoda(Pogoda pogoda) {
		this.pogoda = pogoda;
	}
	
	public String getImieniny() {
		return imieniny;
	}
	
	public void setImieniny(String imieniny) {
		this.imieniny = imieniny;
	}
	
	
	
}
