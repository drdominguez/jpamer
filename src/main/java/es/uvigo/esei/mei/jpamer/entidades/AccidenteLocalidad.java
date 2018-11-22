package es.uvigo.esei.mei.jpamer.entidades;


import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AccidenteLocalidad {

    @Id
    @ManyToOne
    private Accidente accidente;

    @Id
    @ManyToOne
    private Localidad localidad;

	public AccidenteLocalidad() {
	}
	public AccidenteLocalidad(Accidente accidente, Localidad localidad) {
		this.accidente = accidente;
		this.localidad = localidad;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
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
		AccidenteLocalidad other = (AccidenteLocalidad) obj;
		if (accidente == null) {
			if (other.accidente != null)
				return false;
		} else if (!accidente.equals(other.accidente))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		return true;
	}
}