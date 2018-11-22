package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class AccidenteFactorRiesgo implements Serializable {

    @Id
    private Accidente accidente;

    @ManyToMany
    List<FactorRiesgo> factoresRiesgo;

    public AccidenteFactorRiesgo() {
    }

    public AccidenteFactorRiesgo(Accidente accidente, List factorRiesgo) {
        this.accidente = accidente;
        this.factoresRiesgo = factorRiesgo;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((factoresRiesgo == null) ? 0 : factoresRiesgo.hashCode());
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
		AccidenteFactorRiesgo other = (AccidenteFactorRiesgo) obj;
		if (accidente == null) {
			if (other.accidente != null)
				return false;
		} else if (!accidente.equals(other.accidente))
			return false;
		if (factoresRiesgo == null) {
			if (other.factoresRiesgo != null)
				return false;
		} else if (!factoresRiesgo.equals(other.factoresRiesgo))
			return false;
		return true;
	}


}