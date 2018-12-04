package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.Accidente;


public class AccidenteDAO {
	private EntityManager em;

	public AccidenteDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Accidente crear(Accidente nuevoAccidente) throws RollbackException {
		Accidente accidenteCreado = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevoAccidente);
			accidenteCreado = nuevoAccidente;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return accidenteCreado;
	}

	public Accidente actualizar(Accidente accidente) {
		Accidente accidenteModificado = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			accidenteModificado = em.merge(accidente);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return accidenteModificado;
	}

	public void eliminar(Accidente accidente) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(accidente);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public Accidente buscarPorId(Long id) {
		return em.find(Accidente.class, id);
	}

	public List<Accidente> buscarTodos() {
		TypedQuery<Accidente> q = em.createQuery("SELECT a FROM Accidente AS a", Accidente.class);
		return q.getResultList();
	}

	public List<Accidente> buscarPorNombre(String patron) {
		TypedQuery<Accidente> q = em.createQuery("SELECT a FROM Accidente AS a WHERE a.nombre LIKE :patron", Accidente.class);
		q.setParameter("patron", "%" + patron + "%");
		return q.getResultList();
	}

	/*public List<Almacen> buscarPorLocalidad(String localidad) {
		TypedQuery<Almacen> q = em.createQuery("SELECT a FROM Almacen AS a WHERE a.direccion.localidad LIKE :localidad",
				Almacen.class);
		q.setParameter("localidad", "%" + localidad + "%");
		return q.getResultList();
	}
*
	public List<ArticuloAlmacen> buscarStockArticulos(Almacen almacen) {
		TypedQuery<ArticuloAlmacen> q = em.createQuery(
				"SELECT aa FROM ArticuloAlmacen AS aa WHERE aa.almacen.id = :idAlmacen", ArticuloAlmacen.class);
		q.setParameter("idAlmacen", almacen.getId());
		return q.getResultList();
	}

	public ArticuloAlmacen actualizarStockArticulo(Articulo articulo, Almacen almacen, int nuevoStock) {
		ArticuloAlmacen stockArticuloModificado = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ArticuloAlmacen stockArticulo = em.find(ArticuloAlmacen.class,
					new ArticuloAlmacenId(articulo.getId(), almacen.getId()));
			if (stockArticulo != null) {
				stockArticulo.setStock(nuevoStock);
				stockArticuloModificado = em.merge(stockArticulo);
			}
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return stockArticuloModificado;
	}

	public ArticuloAlmacen crearStockArticulo(Articulo articulo, Almacen almacen, int stock) {
		ArticuloAlmacen stockArticuloCreado = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ArticuloAlmacen stockArticulo = em.find(ArticuloAlmacen.class,
					new ArticuloAlmacenId(articulo.getId(), almacen.getId()));
			if (stockArticulo == null) {
				// No exite stock del producto en el almacen
				stockArticulo = new ArticuloAlmacen(articulo, almacen, stock);
				em.persist(stockArticulo);
				stockArticuloCreado = stockArticulo;
			} else {
				actualizarStockArticulo(articulo, almacen, stock);
			}
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return stockArticuloCreado;
	}

	public void eliminarStockArticulo(Articulo articulo, Almacen almacen) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			ArticuloAlmacen stockArticulo = em.find(ArticuloAlmacen.class,
					new ArticuloAlmacenId(articulo.getId(), almacen.getId()));
			if (stockArticulo != null) {
				em.remove(stockArticulo);
			}
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}*/
}
