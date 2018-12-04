package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.Vehiculo;;

public class VehiculoDAO {
	private EntityManager em;

	public VehiculoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Vehiculo crear(Vehiculo nuevoVehiculo) throws RollbackException {
		Vehiculo vehiculoCreado = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevoVehiculo);
			vehiculoCreado = nuevoVehiculo;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return vehiculoCreado;
	}

	public Vehiculo actualizar(Vehiculo vehiculo) {
		Vehiculo vehiculoModificado = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			vehiculoModificado = em.merge(vehiculo);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return vehiculoModificado;
	}

	public void eliminar(Vehiculo vehiculo) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(vehiculo);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public Vehiculo buscarPorId(Long id) {

		return em.find(Vehiculo.class, id);
	}

	public List<Vehiculo> buscarTodos() {
		TypedQuery<Vehiculo> q = em.createQuery("SELECT ve FROM Vehiculo AS ve", Vehiculo.class);
		return q.getResultList();
	}

	public List<Vehiculo> buscarPorNombre(String patron) {
		TypedQuery<Vehiculo> q = em.createQuery("SELECT v FROM Vehiculo AS ve WHERE ve.nombre LIKE :patron",
				Vehiculo.class);
		q.setParameter("patron", "%" + patron + "%");
		return q.getResultList();
	}
}
