package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.Localidad;


public class LocalidadDAO {
	private EntityManager em;

	public LocalidadDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Localidad crear(Localidad nuevaLocalidad) throws RollbackException {
		Localidad localidadCreada = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevaLocalidad);
			localidadCreada = nuevaLocalidad;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return localidadCreada;
	}

	public Localidad actualizar(Localidad localidad) {
		Localidad localidadModificada = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			localidadModificada = em.merge(localidad);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return localidadModificada;
	}

	public void eliminar(Localidad localidad) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(localidad);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public Localidad buscarPorId(Long id) {
		return em.find(Localidad.class, id);
	}

	public List<Localidad> buscarTodos() {
		TypedQuery<Localidad> q = em.createQuery("SELECT l FROM Localidad AS l", Localidad.class);
		return q.getResultList();
	}

	public List<Localidad> buscarPorNombre(String patron) {
		TypedQuery<Localidad> q = em.createQuery("SELECT l FROM Localida AS l WHERE l.nombre LIKE :patron", Localidad.class);
		q.setParameter("patron", "%" + patron + "%");
		return q.getResultList();
	}
}
