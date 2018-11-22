package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

public class AccidenteFactorRiesgo implements Serializable {

    @Id
    @ManyToOne
    private Accidente accidente;

    @Id
    @ManyToOne
    private FactorRiesgo factorRiesgo;

    private Integer peso;

    public AccidenteFactorRiesgo() {
    }

    public AccidenteFactorRiesgo(Accidente accidente, FactorRiesgo factorRiesgo, Integer peso) {
        this.accidente = accidente;
        this.factorRiesgo = factorRiesgo;
        this.peso = peso;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((factorRiesgo == null) ? 0 : factorRiesgo.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
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
		if (factorRiesgo == null) {
			if (other.factorRiesgo != null)
				return false;
		} else if (!factorRiesgo.equals(other.factorRiesgo))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}

}