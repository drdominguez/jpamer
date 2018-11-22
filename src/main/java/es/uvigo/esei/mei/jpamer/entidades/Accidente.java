package es.uvigo.esei.mei.jpamer.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Accidente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccidente;

    private String descripcion;

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
