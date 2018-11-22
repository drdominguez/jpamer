package es.uvigo.esei.mei.jpamer.entidades;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class AccidenteVia {

	@Id
    @ManyToOne
    private Accidente accidente;

    @Id
    @ManyToOne
    private Via via;
    
	public AccidenteVia() {
		// TODO Auto-generated constructor stub
	}
	
	public AccidenteVia(Accidente accidente, Via via) {
		this.accidente = accidente;
		this.via = via;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accidente == null) ? 0 : accidente.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
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
		AccidenteVia other = (AccidenteVia) obj;
		if (accidente == null) {
			if (other.accidente != null)
				return false;
		} else if (!accidente.equals(other.accidente))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
	}

}
