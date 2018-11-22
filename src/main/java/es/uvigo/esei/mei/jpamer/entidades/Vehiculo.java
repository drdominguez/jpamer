package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String matricula;

    private int año;

    private enum TipoVehiculo{TURISMO,BICICLETA,CICLOMOTOR,QUAD,AUTOBÚS,CAMIÓN,ESPECIAL};

    TipoVehiculo tipoVehiculo;
    
    /*@Embedded
    private Direccion direccion;*/

    public Vehiculo() {
    }

    public Vehiculo(int año, TipoVehiculo tipoVehiculo) {
        this.año = año;
        this.tipoVehiculo = tipoVehiculo;
    }

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + año;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((tipoVehiculo == null) ? 0 : tipoVehiculo.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (año != other.año)
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (tipoVehiculo != other.tipoVehiculo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", año=" + año + ", tipoVehiculo=" + tipoVehiculo + "]";
	}

}
