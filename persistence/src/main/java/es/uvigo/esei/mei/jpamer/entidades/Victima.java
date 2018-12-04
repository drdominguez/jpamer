package es.uvigo.esei.mei.jpamer.entidades;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Victima {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVictima;

    private String nombre;

    private enum Estado{LEVE,GRAVE,FALLECIDO}
    
    @Enumerated(EnumType.STRING)
    Estado estado;

    /*@Embedded
    private Direccion direccion;*/

    public Victima() {
		// TODO Auto-generated constructor stub
	}

    public Victima(String nombre, Estado estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

	public long getIdVictima() {
		return idVictima;
	}

	public void setIdVictima(long idVictima) {
		this.idVictima = idVictima;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (idVictima ^ (idVictima >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Victima other = (Victima) obj;
		if (estado != other.estado)
			return false;
		if (idVictima != other.idVictima)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Victima [idVictima=" + idVictima + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
}
