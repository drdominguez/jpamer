package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(AccidenteVictimaID.class)
public class AccidenteVictima implements Serializable {

    @Id
    @ManyToOne
    private Accidente accidente;

    @Id
    @ManyToOne
    private Victima victima;

    private Integer cuenta;

    public AccidenteVictima() {
    }

    public AccidenteVictima(Accidente accidente, Victima victima, Integer cuenta) {
        this.accidente = accidente;
        this.victima = victima;
        this.cuenta = cuenta;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((victima == null) ? 0 : victima.hashCode());
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
		AccidenteVictima other = (AccidenteVictima) obj;
		if (accidente == null) {
			if (other.accidente != null)
				return false;
		} else if (!accidente.equals(other.accidente))
			return false;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (victima == null) {
			if (other.victima != null)
				return false;
		} else if (!victima.equals(other.victima))
			return false;
		return true;
	}

}