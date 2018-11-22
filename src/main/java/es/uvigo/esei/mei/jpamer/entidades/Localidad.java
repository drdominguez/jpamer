package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Localidad {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocalidad;

    private String provincia;

    private String comunidad;

    /*@Embedded
    private Direccion direccion;*/

    public Localidad() {
		// TODO Auto-generated constructor stub
	}

    public Localidad(String provincia, String comunidad) {
        this.provincia = provincia;
        this.comunidad = comunidad;
    }

	public int getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(int idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comunidad == null) ? 0 : comunidad.hashCode());
		result = prime * result + idlocalidad;
		result = prime * result + ((provincia == null) ? 0 : provincia.hashCode());
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
		Localidad other = (Localidad) obj;
		if (comunidad == null) {
			if (other.comunidad != null)
				return false;
		} else if (!comunidad.equals(other.comunidad))
			return false;
		if (idlocalidad != other.idlocalidad)
			return false;
		if (provincia == null) {
			if (other.provincia != null)
				return false;
		} else if (!provincia.equals(other.provincia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Localidad [idlocalidad=" + idlocalidad + ", provincia=" + provincia + ", comunidad=" + comunidad + "]";
	}

}
