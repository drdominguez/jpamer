package es.uvigo.esei.mei.jpamer.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import es.uvigo.esei.mei.jpamer.entidades.Via;


public class ViaDAO {
	private EntityManager em;

	public ViaDAO(EntityManager em) {
		super();
		this.em = em;
	}

	public Via crear(Via nuevaVia) throws RollbackException {
		Via viaCreada = null;
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nuevaVia);
			viaCreada = nuevaVia;
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return viaCreada;
	}

	public Via actualizar(Via via) {
		Via viaModificada = null;

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			viaModificada = em.merge(via);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
		return viaModificada;
	}

	public void eliminar(Via via) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(via);
			tx.commit();
		} catch (Exception ex) {
			if ((tx != null) && (tx.isActive())) {
				tx.rollback();
				throw new RollbackException(ex);
			}
		}
	}

	public Via buscarPorId(Long id) {
		return em.find(Via.class, id);
	}

	public List<Via> buscarTodos() {
		TypedQuery<Via> q = em.createQuery("SELECT v FROM Via AS v", Via.class);
		return q.getResultList();
	}

	public List<Via> buscarPorNombre(String patron) {
		TypedQuery<Via> q = em.createQuery("SELECT v FROM Via AS v WHERE v.nombre LIKE :patron", Via.class);
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
