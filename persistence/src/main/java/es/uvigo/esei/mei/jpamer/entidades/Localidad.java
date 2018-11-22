package es.uvigo.esei.mei.jpamer.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Localidad {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idlocalidad;
	
	private String nombre;

    private String provincia;

    private String comunidad;

    /*@Embedded
    private Direccion direccion;*/

    public Localidad() {
		// TODO Auto-generated constructor stub
	}

    public Localidad(String nombre, String provincia, String comunidad) {
    	this.nombre = nombre;
        this.provincia = provincia;
        this.comunidad = comunidad;
    }

	public long getIdlocalidad() {
		return idlocalidad;
	}

	public void setIdlocalidad(long idlocalidad) {
		this.idlocalidad = idlocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		result = prime * result + (int) (idlocalidad ^ (idlocalidad >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
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
		return "Localidad [idlocalidad=" + idlocalidad + ", nombre=" + nombre + ", provincia=" + provincia
				+ ", comunidad=" + comunidad + "]";
	}

}
