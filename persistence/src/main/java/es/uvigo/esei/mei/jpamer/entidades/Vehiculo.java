package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String matricula;

	private int anho;

	private enum TipoVehiculo {
		TURISMO, BICICLETA, CICLOMOTOR, QUAD, AUTOBÚS, CAMIÓN, ESPECIAL
	};

	@Enumerated(EnumType.STRING)
	TipoVehiculo tipoVehiculo;

	/*
	 * @Embedded private Direccion direccion;
	 */

	public Vehiculo() {
	}

	public Vehiculo(String matricula, int anho, TipoVehiculo tipoVehiculo) {
		this.anho = anho;
		this.matricula = matricula;
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnho() {
		return anho;
	}

	public void setAnho(int anho) {
		this.anho = anho;
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
		result = prime * result + anho;
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
		if (anho != other.anho)
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
		return "Vehiculo [matricula=" + matricula + ", año=" + anho + ", tipoVehiculo=" + tipoVehiculo + "]";
	}

}
