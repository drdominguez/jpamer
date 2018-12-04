package es.uvigo.esei.mei.jpamer.vistas;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zkplus.jpa.JpaUtil;

import es.uvigo.esei.mei.jpamer.daos.VehiculoDAO;
import es.uvigo.esei.mei.jpamer.entidades.Vehiculo;

public class VehiculoVM {
	private List<Vehiculo> vehiculos;
	private Vehiculo vehiculoActual;
	private String textoBusqueda;
	private boolean edicionNuevoVehiculo;
	
	private VehiculoDAO vehiculoDAO;

	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo getVehiculoActual() {
		return vehiculoActual;
	}

	public void setVehiculoActual(Vehiculo vehiculoActual) {
		this.vehiculoActual = vehiculoActual;
	}

	public String getTextoBusqueda() {
		return textoBusqueda;
	}

	public void setTextoBusqueda(String textoBusqueda) {
		this.textoBusqueda = textoBusqueda;
	}

	public boolean isEdicionNuevoVehiculo() {
		return edicionNuevoVehiculo;
	}

	public void setEdicionNuevoVehiculo(boolean edicionNuevoVehiculo) {
		this.edicionNuevoVehiculo = edicionNuevoVehiculo;
	}
	@Init
	public void inicializar() {
		vehiculoDAO = new VehiculoDAO(JpaUtil.getEntityManager());
		
		recargarVehiculos();
		vehiculoActual = null;
		edicionNuevoVehiculo = false;
		
	}
	
	private void recargarVehiculos() {
		vehiculos = vehiculoDAO.buscarTodos();
	}
	
	
	@Command
	@NotifyChange("vehiculos")
	public void buscarID() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			vehiculos = new ArrayList<>();
			vehiculos.add(vehiculoDAO.buscarPorId(Long.parseLong(textoBusqueda)));
			vehiculoActual = null;
		}
	}

	@Command
	@NotifyChange("vehiculos")
	public void buscarNombre() {
		if ((textoBusqueda != null) && !textoBusqueda.isEmpty()) {
			vehiculos = vehiculoDAO.buscarPorNombre(textoBusqueda);
			vehiculoActual = null;
		}
	}
	@Command
	@NotifyChange("vehiculos")
	public void buscarTodos() {
		vehiculos = vehiculoDAO.buscarTodos();
		vehiculoActual = null;
	}
	
	@Command
	@NotifyChange("vehiculos")
	public void eliminar(@BindingParam("vehiculoEliminar") Vehiculo vehiculo) {
		if (vehiculo != null) {
			vehiculoDAO.eliminar(vehiculo);
			recargarVehiculos();
		}
	}
	
	@Command
	@NotifyChange("vehiculoActual")
	public void editar(@BindingParam("vehiculoEditar") Vehiculo vehiculo) {
		if (vehiculo != null) {
			vehiculoActual = vehiculo;
			edicionNuevoVehiculo = false;
		}
	}


	@Command
	@NotifyChange("vehiculoActual")
	public void nuevoVehiculo() {
		vehiculoActual = new Vehiculo();
		edicionNuevoVehiculo = true;
	}

	@Command
	@NotifyChange({"vehiculoActual", "vehiculos"})
	public void guardarVehiculo() {
		if (edicionNuevoVehiculo) {
			vehiculoDAO.crear(vehiculoActual);
		} else {
			vehiculoDAO.actualizar(vehiculoActual);
		}
		vehiculoActual = null;
		edicionNuevoVehiculo = false;
		recargarVehiculos();
	}

	@Command
	@NotifyChange("vehiculoActual")
	public void cancelarEdicion() {
		vehiculoActual = null;
		edicionNuevoVehiculo = false;
	}
}
