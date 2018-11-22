package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Via {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVia;

    private String tipo_via;

    private String red_carretera;
    
    private String tipo_interseccion;

    /*@Embedded
    private Direccion direccion;*/

    public Via() {
		// TODO Auto-generated constructor stub
	}

    public Via(String tipo_via, String red_carretera, String tipo_interseccion) {
        this.tipo_via = tipo_via;
        this.red_carretera = red_carretera;
        this.tipo_interseccion = tipo_interseccion;
    }

	public int getIdVia() {
		return idVia;
	}

	public void setIdVia(int idVia) {
		this.idVia = idVia;
	}

	public String getTipo_via() {
		return tipo_via;
	}

	public void setTipo_via(String tipo_via) {
		this.tipo_via = tipo_via;
	}

	public String getRed_carretera() {
		return red_carretera;
	}

	public void setRed_carretera(String red_carretera) {
		this.red_carretera = red_carretera;
	}

	public String getTipo_interseccion() {
		return tipo_interseccion;
	}

	public void setTipo_interseccion(String tipo_interseccion) {
		this.tipo_interseccion = tipo_interseccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVia;
		result = prime * result + ((red_carretera == null) ? 0 : red_carretera.hashCode());
		result = prime * result + ((tipo_interseccion == null) ? 0 : tipo_interseccion.hashCode());
		result = prime * result + ((tipo_via == null) ? 0 : tipo_via.hashCode());
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
		Via other = (Via) obj;
		if (idVia != other.idVia)
			return false;
		if (red_carretera == null) {
			if (other.red_carretera != null)
				return false;
		} else if (!red_carretera.equals(other.red_carretera))
			return false;
		if (tipo_interseccion == null) {
			if (other.tipo_interseccion != null)
				return false;
		} else if (!tipo_interseccion.equals(other.tipo_interseccion))
			return false;
		if (tipo_via == null) {
			if (other.tipo_via != null)
				return false;
		} else if (!tipo_via.equals(other.tipo_via))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Via [idVia=" + idVia + ", tipo_via=" + tipo_via + ", red_carretera=" + red_carretera
				+ ", tipo_interseccion=" + tipo_interseccion + "]";
	}

}
