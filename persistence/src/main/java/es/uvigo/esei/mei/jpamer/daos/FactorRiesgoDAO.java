package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.FactorRiesgo;


public class FactorRiesgoDAO {
	private EntityManager em;

	public FactorRiesgoDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public FactorRiesgo crear(FactorRiesgo nuevoFactorRiesgo) throws RollbackException {
		FactorRiesgo factorRiesgoCreado = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevoFactorRiesgo);
			factorRiesgoCreado = nuevoFactorRiesgo;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return factorRiesgoCreado;
	}

	public FactorRiesgo actualizar(FactorRiesgo factorRiesgo) {
		FactorRiesgo factorRiesgoModificado = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			factorRiesgoModificado = em.merge(factorRiesgo);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return factorRiesgoModificado;
	}

	public void eliminar(FactorRiesgo factorRiesgo) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(factorRiesgo);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public FactorRiesgo buscarPorId(Long id) {
		return em.find(FactorRiesgo.class, id);
	}

	public List<FactorRiesgo> buscarTodos() {
		TypedQuery<FactorRiesgo> q = em.createQuery("SELECT f FROM FactorRiesgo AS f", FactorRiesgo.class);
		return q.getResultList();
	}

	public List<FactorRiesgo> buscarPorNombre(String patron) {
		TypedQuery<FactorRiesgo> q = em.createQuery("SELECT f FROM FactorRiesgo AS f WHERE f.nombre LIKE :patron", FactorRiesgo.class);
		q.setParameter("patron", "%" + patron + "%");
		return q.getResultList();
	}
}
