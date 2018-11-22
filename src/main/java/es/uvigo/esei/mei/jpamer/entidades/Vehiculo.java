package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
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

    private String tipo_vehiculo;

    /*@Embedded
    private Direccion direccion;*/

    public Vehiculo() {
    }

    public Vehiculo(int año, String tipo_vehiculo) {
        this.año = año;
        this.tipo_vehiculo = tipo_vehiculo;
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

    public String tipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + año;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((tipo_vehiculo == null) ? 0 : tipo_vehiculo.hashCode());
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
		if (tipo_vehiculo == null) {
			if (other.tipo_vehiculo != null)
				return false;
		} else if (!tipo_vehiculo.equals(other.tipo_vehiculo))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", año=" + año + ", tipo de vehiculo=" + tipo_vehiculo + '}';
    }

}
