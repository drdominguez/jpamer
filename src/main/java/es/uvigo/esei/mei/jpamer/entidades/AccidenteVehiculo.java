package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

public class AccidenteVehiculo implements Serializable {

    @Id
    @ManyToOne
    private Accidente accidente;

    @Id
    @ManyToOne
    private Vehiculo vehiculo;

    public AccidenteVehiculo() {
    }

    public AccidenteVehiculo(Accidente accidente, Vehiculo vehiculo) {
        this.accidente = accidente;
        this.vehiculo = vehiculo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		AccidenteVehiculo other = (AccidenteVehiculo) obj;
		if (accidente == null) {
			if (other.accidente != null)
				return false;
		} else if (!accidente.equals(other.accidente))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

}
