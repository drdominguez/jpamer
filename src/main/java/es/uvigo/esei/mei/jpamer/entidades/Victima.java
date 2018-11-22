package es.uvigo.esei.mei.jpamer.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Victima {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVictima;

    private int herido;

    private int heridoLeve;
    
    private int heridoGrave;

    /*@Embedded
    private Direccion direccion;*/

    public Victima() {
		// TODO Auto-generated constructor stub
	}

    public Victima(int herido, int heridoLeve, int heridoGrave) {
        this.herido = herido;
        this.heridoLeve = heridoLeve;
        this.heridoGrave = heridoGrave;
    }

	public int getIdVictima() {
		return idVictima;
	}

	public void setIdVictima(int idVictima) {
		this.idVictima = idVictima;
	}

	public int getHerido() {
		return herido;
	}

	public void setHerido(int herido) {
		this.herido = herido;
	}

	public int getHeridoLeve() {
		return heridoLeve;
	}

	public void setHeridoLeve(int heridoLeve) {
		this.heridoLeve = heridoLeve;
	}

	public int getHeridoGrave() {
		return heridoGrave;
	}

	public void setHeridoGrave(int heridoGrave) {
		this.heridoGrave = heridoGrave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + herido;
		result = prime * result + heridoGrave;
		result = prime * result + heridoLeve;
		result = prime * result + idVictima;
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
		if (herido != other.herido)
			return false;
		if (heridoGrave != other.heridoGrave)
			return false;
		if (heridoLeve != other.heridoLeve)
			return false;
		if (idVictima != other.idVictima)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Victima [idVictima=" + idVictima + ", herido=" + herido + ", heridoLeve=" + heridoLeve
				+ ", heridoGrave=" + heridoGrave + "]";
	}
	
}
