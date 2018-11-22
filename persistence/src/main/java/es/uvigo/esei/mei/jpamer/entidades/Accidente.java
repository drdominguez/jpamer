package es.uvigo.esei.mei.jpamer.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


public class Accidente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccidente;

    private String descripcion;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    List<FactorRiesgo> factoresRiesgo;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehiculo> vehiculos;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccidenteVictima> victimas;
    
    @ManyToOne
    private Localidad localidad;
    
    @ManyToOne
    private Via via;
    
	public Accidente() {
		// TODO Auto-generated constructor stub
	}
	 public Accidente(String descripcion) {
	        this.descripcion = descripcion;
	    }
	public long getIdAccidente() {
		return idAccidente;
	}
	public void setIdAccidente(long idAccidente) {
		this.idAccidente = idAccidente;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (idAccidente ^ (idAccidente >>> 32));
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
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idAccidente != other.idAccidente)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", descripcion=" + descripcion + "]";
	}

}
