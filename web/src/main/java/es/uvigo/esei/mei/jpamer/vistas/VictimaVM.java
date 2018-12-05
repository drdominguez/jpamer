package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.VictimaDAO;
import es.uvigo.esei.mei.jpamer.entidades.Victima;

public class VictimaVM {
	private List<Victima> victimas;
	private Victima victimaActual;
	private String textoBusqueda;
	private boolean edicionNuevaVictima;
	
	private VictimaDAO victimaDAO;

	
	public List<Victima> getVictima() {
		return victimas;
	}

	public void setVictimas(List<Victima> victimas) {
		this.victimas = victimas;
	}

	public Victima getVictimaActual() {
		return victimaActual;
	}

	public void setVictimaActual(Victima victimaActual) {
		this.victimaActual = victimaActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevaVictima() {
		return edicionNuevaVictima;
	}

	public void setEdicionNuevaVictima(boolean edicionNuevaVictima) {
		this.edicionNuevaVictima = edicionNuevaVictima;
	}
	@Init
	public void inicializar() {
		victimaDAO = new VictimaDAO(JpaUtil.getEntityManager());
		
		recargarVictimas();
		victimaActual = null;
		edicionNuevaVictima = false;
		
		victimaDAO = new VictimaDAO(JpaUtil.getEntityManager());
	}
	
	private void recargarVictimas() {
		victimas = victimaDAO.buscarTodos();
	}
	
	
	@Command
	@NotifyChange("victimas")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			victimas = new ArrayList<>();
			victimas.add(victimaDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			victimaActual = null;
		}
	}

	@Command
	@NotifyChange("victimas")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			victimas = victimaDAO.buscarPorNombre(textoBusqueda);
			victimaActual = null;
		}
	}
	@Command
	@NotifyChange("victimas")
	public void buscarTodos() {
		victimas = victimaDAO.buscarTodos();
		victimaActual = null;
	}
	
	@Command
	@NotifyChange("victimas")
	public void eliminar(@BindingParam("victimaEliminar") Victima victima) {
		if (victima != null) {
			victimaDAO.eliminar(victima);
			recargarVictimas();
		}
	}
	
	@Command
	@NotifyChange("victimaActual")
	public void editar(@BindingParam("victimaEditar") Victima victima) {
		if (victima != null) {
			victimaActual = victima;
			edicionNuevaVictima = false;
		}
	}


	@Command
	@NotifyChange("victimaActual")
	public void nuevaVictima() {
		victimaActual = new Victima();
		edicionNuevaVictima = true;
	}

	@Command
	@NotifyChange({"victimaActual", "victimas"})
	public void guardarVictima() {
		if (edicionNuevaVictima) {
			victimaDAO.crear(victimaActual);
		} else {
			victimaDAO.actualizar(victimaActual);
		}
		victimaActual = null;
		edicionNuevaVictima = false;
		recargarVictimas();
	}

	@Command
	@NotifyChange("victimaActual")
	public void cancelarEdicion() {
		victimaActual = null;
		edicionNuevaVictima = false;
	}
}
