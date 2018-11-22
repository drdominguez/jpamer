package es.uvigo.esei.mei.jpamer.entidades;

public class AccidenteVictimaID {
	private long accidente;
	private long victima;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accidente ^ (accidente >>> 32));
		result = prime * result + (int) (victima ^ (victima >>> 32));
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
		AccidenteVictimaID other = (AccidenteVictimaID) obj;
		if (accidente != other.accidente)
			return false;
		if (victima != other.victima)
			return false;
		return true;
	}
	
}
