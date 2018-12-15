package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.Accidente;
import es.uvigo.esei.mei.jpamer.entidades.Victima;


public class VictimaDAO {
	private EntityManager em;

	public VictimaDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Victima crear(Victima nuevaVictima) throws RollbackException {
		Victima victimaCreada = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevaVictima);
			victimaCreada = nuevaVictima;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return victimaCreada;
	}

	public Victima actualizar(Victima victima) {
		Victima victimaModificada = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			victimaModificada = em.merge(victima);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return victimaModificada;
	}

	public void eliminar(Victima victima) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(em.merge(victima));
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public Victima buscarPorId(Long id) {
		return em.find(Victima.class, id);
	}

	public List<Victima> buscarTodos() {
		TypedQuery<Victima> q = em.createQuery("SELECT vic FROM Victima AS vic", Victima.class);
		return q.getResultList();
	}

	public List<Victima> buscarPorNombre(String patron) {
		TypedQuery<Victima> q = em.createQuery("SELECT vic FROM Victima AS vic WHERE vic.nombre LIKE :patron", Victima.class);
		q.setParameter("patron", "%" + patron + "%");
		return q.getResultList();
	}
}

