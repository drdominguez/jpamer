package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.AccidenteDAO;
import es.uvigo.esei.mei.jpamer.entidades.Accidente;

public class AccidenteVM {
	private List<Accidente> accidentes;
	private Accidente accidenteActual;
	private String textoBusqueda;
	private boolean edicionNuevoAccidente;

	private AccidenteDAO accidenteDAO;

	@Init
	public void inicializar() {
		accidenteDAO = new AccidenteDAO(JpaUtil.getEntityManager());
		
		recargarAccidente();
		accidenteActual = null;
		edicionNuevoAccidente = false;
		
		accidenteDAO = new AccidenteDAO(JpaUtil.getEntityManager());
	}
	
	private void recargarAccidente() {
		accidentes = accidenteDAO.buscarTodos();
	}
	
	
	public List<Accidente> getAccidentes() {
		return accidentes;
	}

	public void setAccidentes(List<Accidente> accidentes) {
		this.accidentes = accidentes;
	}

	public Accidente getAccidenteActual() {
		return accidenteActual;
	}

	public void setAccidenteActual(Accidente accidenteActual) {
		this.accidenteActual = accidenteActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevoAccidente() {
		return edicionNuevoAccidente;
	}

	public void setEdicionNuevoAccidente(boolean edicionNuevoAccidente) {
		this.edicionNuevoAccidente = edicionNuevoAccidente;
	}
	
	
	@Command
	@NotifyChange("accidentes")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			accidentes = new ArrayList<>();
			accidentes.add(accidenteDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			accidenteActual = null;
		}
	}

	@Command
	@NotifyChange("accidentes")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			accidentes = accidenteDAO.buscarPorNombre(textoBusqueda);
			accidenteActual = null;
		}
	}
	@Command
	@NotifyChange("accidentes")
	public void buscarTodos() {
		accidentes = accidenteDAO.buscarTodos();
		accidenteActual = null;
	}

	@Command
	@NotifyChange("accidenteActual")
	public void editar(@BindingParam("accidenteEditar") Accidente accidente) {
		if (accidente != null) {
			accidenteActual = accidente;
			edicionNuevoAccidente = false;
		}
	}

	@Command
	@NotifyChange("accidentes")
	public void eliminar(@BindingParam("accidenteEliminar") Accidente accidente) {
		if (accidente != null) {
			accidenteDAO.eliminar(accidente);
			accidentes.remove(accidente);
		}
	}

	@Command
	@NotifyChange("accidenteActual")
	public void nuevoAccidente() {
		accidenteActual = new Accidente();
		edicionNuevoAccidente = true;
	}

	@Command
	@NotifyChange({"accidenteActual", "accidentes"})
	public void guardarAccidente() {
		if (edicionNuevoAccidente) {
			accidenteDAO.crear(accidenteActual);
		} else {
			accidenteDAO.actualizar(accidenteActual);
		}
		accidenteActual = null;
		edicionNuevoAccidente = false;
		recargarAccidente();
	}

	@Command
	@NotifyChange("accidenteActual")
	public void cancelarEdicion() {
		accidenteActual = null;
		edicionNuevoAccidente = false;
	}
}
