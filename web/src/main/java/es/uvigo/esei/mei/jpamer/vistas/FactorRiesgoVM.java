package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.FactorRiesgoDAO;
import es.uvigo.esei.mei.jpamer.entidades.FactorRiesgo;

public class FactorRiesgoVM {
	private List<FactorRiesgo> factorRiesgos;
	private FactorRiesgo factorRiesgoActual;
	private String textoBusqueda;
	private boolean edicionNuevoFactorRiesgo;
	
	private FactorRiesgoDAO factorRiesgoDAO;

	
	public List<FactorRiesgo> getFactorRiesgos() {
		return factorRiesgos;
	}

	public void setFactorRiesgos(List<FactorRiesgo> factorRiesgos) {
		this.factorRiesgos = factorRiesgos;
	}

	public FactorRiesgo getFactorRiesgoActual() {
		return factorRiesgoActual;
	}

	public void setFactorRiesgoActual(FactorRiesgo factorRiesgoActual) {
		this.factorRiesgoActual = factorRiesgoActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevoFactorRiesgo() {
		return edicionNuevoFactorRiesgo;
	}

	public void setEdicionNuevoFactorRiesgo(boolean edicionNuevoFactorRiesgo) {
		this.edicionNuevoFactorRiesgo = edicionNuevoFactorRiesgo;
	}
	@Init
	public void inicializar() {
		factorRiesgoDAO = new FactorRiesgoDAO(JpaUtil.getEntityManager());
		
		recargarFactorRiesgos();
		factorRiesgoActual = null;
		edicionNuevoFactorRiesgo = false;
		
		factorRiesgoDAO = new FactorRiesgoDAO(JpaUtil.getEntityManager());
	}
	
	private void recargarFactorRiesgos() {
		factorRiesgos = factorRiesgoDAO.buscarTodos();
	}
	
	
	@Command
	@NotifyChange("factorRiesgos")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			factorRiesgos = new ArrayList<>();
			factorRiesgos.add(factorRiesgoDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			factorRiesgoActual = null;
		}
	}

	@Command
	@NotifyChange("factorRiesgos")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			factorRiesgos = factorRiesgoDAO.buscarPorNombre(textoBusqueda);
			factorRiesgoActual = null;
		}
	}
	@Command
	@NotifyChange("factorRiesgos")
	public void buscarTodos() {
		factorRiesgos = factorRiesgoDAO.buscarTodos();
		factorRiesgoActual = null;
	}
	
	@Command
	@NotifyChange("factorRiesgos")
	public void eliminar(@BindingParam("factorRiesgoEliminar") FactorRiesgo factorRiesgo) {
		if (factorRiesgo != null) {
			factorRiesgoDAO.eliminar(factorRiesgo);
			recargarFactorRiesgos();
		}
	}
	
	@Command
	@NotifyChange("factorRiesgoActual")
	public void editar(@BindingParam("factorRiesgoEditar") FactorRiesgo factorRiesgo) {
		if (factorRiesgo != null) {
			factorRiesgoActual = factorRiesgo;
			edicionNuevoFactorRiesgo = false;
		}
	}


	@Command
	@NotifyChange("factorRiesgoActual")
	public void nuevoFactorRiesgo() {
		factorRiesgoActual = new FactorRiesgo();
		edicionNuevoFactorRiesgo = true;
	}

	@Command
	@NotifyChange({"factorRiesgoActual", "factorRiesgos"})
	public void guardarFactorRiesgo() {
		if (edicionNuevoFactorRiesgo) {
			factorRiesgoDAO.crear(factorRiesgoActual);
		} else {
			factorRiesgoDAO.actualizar(factorRiesgoActual);
		}
		factorRiesgoActual = null;
		edicionNuevoFactorRiesgo = false;
		recargarFactorRiesgos();
	}

	@Command
	@NotifyChange("factorRiesgoActual")
	public void cancelarEdicion() {
		factorRiesgoActual = null;
		edicionNuevoFactorRiesgo = false;
	}
}
