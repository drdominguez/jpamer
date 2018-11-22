package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FactorRiesgo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRiesgo;
    
	private String nombre;
    
	private String descripcion;
    
    private enum Tipo{CALZADA,ATOMOSFERICO,PUBLICO,PERSONAL};
    

    public FactorRiesgo() {
		// TODO Auto-generated constructor stub
	}
    
    Tipo tipo;
    
    public FactorRiesgo(String nombre, String descripcion,Tipo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

	public long getIdRiesgo() {
		return idRiesgo;
	}

	public void setIdRiesgo(long idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (idRiesgo ^ (idRiesgo >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		FactorRiesgo other = (FactorRiesgo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idRiesgo != other.idRiesgo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FactorRiesgo [idRiesgo=" + idRiesgo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo="
				+ tipo + "]";
	}


}
