package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Accidente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccidente;

    private String descripcion;

    private int total_muertos;
    
    private int total_heridos;

    /*@Embedded
    private Direccion direccion;*/
	public Accidente() {
		// TODO Auto-generated constructor stub
	}
	 public Accidente(int total_victimas, int total_muertos, int total_heridos) {
	        this.total_victimas = total_victimas;
	        this.total_muertos = total_muertos;
	        this.total_heridos = total_heridos;
	    }
	public int getIdAccidente() {
		return idAccidente;
	}
	public void setIdAccidente(int idAccidente) {
		this.idAccidente = idAccidente;
	}
	public int getTotal_victimas() {
		return total_victimas;
	}
	public void setTotal_victimas(int total_victimas) {
		this.total_victimas = total_victimas;
	}
	public int getTotal_muertos() {
		return total_muertos;
	}
	public void setTotal_muertos(int total_muertos) {
		this.total_muertos = total_muertos;
	}
	public int getTotal_heridos() {
		return total_heridos;
	}
	public void setTotal_heridos(int total_heridos) {
		this.total_heridos = total_heridos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAccidente;
		result = prime * result + total_heridos;
		result = prime * result + total_muertos;
		result = prime * result + total_victimas;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accidente other = (Accidente) obj;
		if (idAccidente != other.idAccidente)
			return false;
		if (total_heridos != other.total_heridos)
			return false;
		if (total_muertos != other.total_muertos)
			return false;
		if (total_victimas != other.total_victimas)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", total_victimas=" + total_victimas + ", total_muertos="
				+ total_muertos + ", total_heridos=" + total_heridos + "]";
	}

}
