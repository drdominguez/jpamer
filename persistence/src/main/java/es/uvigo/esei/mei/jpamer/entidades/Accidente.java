package es.uvigo.esei.mei.jpamer.entidades;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Accidente {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAccidente;

    private String nombre;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    Set<FactorRiesgo> factoresRiesgo;
    
    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Vehiculo> vehiculos;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="accidente")
    private Set<AccidenteVictima> victimas;
    
    @ManyToOne
    private Localidad localidad;
    
    @ManyToOne
    private Via via;
    
	public Accidente() {
		// TODO Auto-generated constructor stub
	}
	 public Accidente(String nombre) {
	        this.nombre = nombre;
	    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getIdAccidente() {
		return idAccidente;
	}
	public void setIdAccidente(long idAccidente) {
		this.idAccidente = idAccidente;
	}
	public Set<FactorRiesgo> getFactoresRiesgo() {
		return factoresRiesgo;
	}
	public void setFactoresRiesgo(Set<FactorRiesgo> factoresRiesgo) {
		this.factoresRiesgo = factoresRiesgo;
	}
	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public Set<AccidenteVictima> getVictimas() {
		return victimas;
	}
	public void setVictimas(Set<AccidenteVictima> victimas) {
		this.victimas = victimas;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public Via getVia() {
		return via;
	}
	public void setVia(Via via) {
		this.via = via;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + (int) (idAccidente ^ (idAccidente >>> 32));
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
		Accidente other = (Accidente) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (idAccidente != other.idAccidente)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Accidente [idAccidente=" + idAccidente + ", nombre=" + nombre + "]";
	}

}
