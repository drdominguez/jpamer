package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.LocalidadDAO;
import es.uvigo.esei.mei.jpamer.entidades.Localidad;

public class LocalidadVM {
	private List<Localidad> localidades;
	private Localidad localidadActual;
	private String textoBusqueda;
	private boolean edicionNuevaLocalidad;
	
	private LocalidadDAO localidadDAO;

	
	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	public Localidad getLocalidadActual() {
		return localidadActual;
	}

	public void setLocalidadActual(Localidad localidadActual) {
		this.localidadActual = localidadActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevaLocalidad() {
		return edicionNuevaLocalidad;
	}

	public void setEdicionNuevaLocalidad(boolean edicionNuevaLocalidad) {
		this.edicionNuevaLocalidad = edicionNuevaLocalidad;
	}
	@Init
	public void inicializar() {
		localidadDAO = new LocalidadDAO(JpaUtil.getEntityManager());
		
		recargarLocalidades();
		localidadActual = null;
		edicionNuevaLocalidad = false;
		
		localidadDAO = new LocalidadDAO(JpaUtil.getEntityManager());
	}
	
	private void recargarLocalidades() {
		localidades = localidadDAO.buscarTodos();
	}
	
	
	@Command
	@NotifyChange("localidades")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			localidades = new ArrayList<>();
			localidades.add(localidadDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			localidadActual = null;
		}
	}

	@Command
	@NotifyChange("localidades")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			localidades = localidadDAO.buscarPorNombre(textoBusqueda);
			localidadActual = null;
		}
	}
	@Command
	@NotifyChange("localidades")
	public void buscarTodos() {
		localidades = localidadDAO.buscarTodos();
		localidadActual = null;
	}
	
	@Command
	@NotifyChange("localidades")
	public void eliminar(@BindingParam("localidadEliminar") Localidad localidad) {
		if (localidad != null) {
			localidadDAO.eliminar(localidad);
			recargarLocalidades();
		}
	}
	
	@Command
	@NotifyChange("localidadActual")
	public void editar(@BindingParam("localidadEditar") Localidad localidad) {
		if (localidad != null) {
			localidadActual = localidad;
			edicionNuevaLocalidad = false;
		}
	}


	@Command
	@NotifyChange("localidadActual")
	public void nuevaLocalidad() {
		localidadActual = new Localidad();
		edicionNuevaLocalidad = true;
	}

	@Command
	@NotifyChange({"localidadActual", "localidades"})
	public void guardarLocalidad() {
		if (edicionNuevaLocalidad) {
			localidadDAO.crear(localidadActual);
		} else {
			localidadDAO.actualizar(localidadActual);
		}
		localidadActual = null;
		edicionNuevaLocalidad = false;
		recargarLocalidades();
	}

	@Command
	@NotifyChange("localidadActual")
	public void cancelarEdicion() {
		localidadActual = null;
		edicionNuevaLocalidad = false;
	}
}
