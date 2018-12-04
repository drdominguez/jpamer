package es.uvigo.esei.mei.jpamer.entidades;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Via {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVia;

    private String nombre;

    private enum TipoVia{CONVENCIONAL,AUTOVIA,AUTOPISTA,NACIONAL,SECUNDARIA};

    @Enumerated(EnumType.STRING)
    TipoVia tipoVia;
    /*@Embedded
    private Direccion direccion;*/

    public Via() {
		// TODO Auto-generated constructor stub
	}

    public Via(String nombre, TipoVia tipoVia) {
        this.nombre = nombre;
        this.tipoVia = tipoVia;
    }

	public long getIdVia() {
		return idVia;
	}

	public void setIdVia(long idVia) {
		this.idVia = idVia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoVia getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(TipoVia tipoVia) {
		this.tipoVia = tipoVia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idVia ^ (idVia >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((tipoVia == null) ? 0 : tipoVia.hashCode());
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
		Via other = (Via) obj;
		if (idVia != other.idVia)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipoVia != other.tipoVia)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Via [idVia=" + idVia + ", nombre=" + nombre + ", tipoVia=" + tipoVia + "]";
	}

}
