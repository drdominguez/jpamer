package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.ViaDAO;
import es.uvigo.esei.mei.jpamer.entidades.Via;

public class ViaVM {
	private List<Via> vias;
	private Via viaActual;
	private String textoBusqueda;
	private boolean edicionNuevaVia;
	
	private ViaDAO viaDAO;

	@Init
	public void inicializar() {
		viaDAO = new ViaDAO(JpaUtil.getEntityManager());
		
		recargarVia();
		viaActual = null;
		edicionNuevaVia = false;
		
		viaDAO = new ViaDAO(JpaUtil.getEntityManager());
	}
	
	private void recargarVia() {
		vias = viaDAO.buscarTodos();
	}
	
	
	public List<Via> getVias() {
		return vias;
	}

	public void setVias(List<Via> vias) {
		this.vias = vias;
	}

	public Via getViaActual() {
		return viaActual;
	}

	public void setViaActual(Via viaActual) {
		this.viaActual = viaActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevaVia() {
		return edicionNuevaVia;
	}

	public void setEdicionNuevaVia(boolean edicionNuevaVia) {
		this.edicionNuevaVia = edicionNuevaVia;
	}
	
	
	@Command
	@NotifyChange("vias")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			vias = new ArrayList<>();
			vias.add(viaDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			viaActual = null;
		}
	}

	@Command
	@NotifyChange("vias")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			vias = viaDAO.buscarPorNombre(textoBusqueda);
			viaActual = null;
		}
	}
	@Command
	@NotifyChange("vias")
	public void buscarTodos() {
		vias = viaDAO.buscarTodos();
		viaActual = null;
	}

	@Command
	@NotifyChange("viaActual")
	public void editar(@BindingParam("viaEditar") Via via) {
		if (via != null) {
			viaActual = via;
			edicionNuevaVia = false;
		}
	}

	@Command
	@NotifyChange("vias")
	public void eliminar(@BindingParam("viaEliminar") Via via) {
		if (via != null) {
			viaDAO.eliminar(via);
			vias.remove(via);
		}
	}

	@Command
	@NotifyChange("viaActual")
	public void nuevaVia() {
		viaActual = new Via();
		edicionNuevaVia = true;
	}

	@Command
	@NotifyChange({"viaActual", "vias"})
	public void guardarVia() {
		if (edicionNuevaVia) {
			viaDAO.crear(viaActual);
		} else {
			viaDAO.actualizar(viaActual);
		}
		viaActual = null;
		edicionNuevaVia = false;
		recargarVia();
	}

	@Command
	@NotifyChange("viaActual")
	public void cancelarEdicion() {
		viaActual = null;
		edicionNuevaVia = false;
	}
}
