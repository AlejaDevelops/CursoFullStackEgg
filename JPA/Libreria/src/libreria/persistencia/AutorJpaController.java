/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import libreria.entidades.Autor;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class AutorJpaController implements Serializable {

    public AutorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public AutorJpaController() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Autor autor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
            System.out.println("Autor registrado exitosamente");
        } catch (RollbackException e) { //CATCH QUE SE ACTIVAN CUANDO SE INTENTA INGRESAR UN AUTOR QUE YA ESTÁ EN LA BD
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error al realizar el commit de la transacción: " + e.getMessage());
        } catch (EntityExistsException | TransactionRequiredException | IllegalStateException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Autor autor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            autor = em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autor.getId();
                if (findAutor(id) == null) {
                    throw new NonexistentEntityException("The autor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor autor;
            try {
                autor = em.getReference(Autor.class, id);
                autor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The autor with id " + id + " no longer exists.", enfe);
            }
            em.remove(autor);
            em.getTransaction().commit();
            System.out.println("Autor eliminado exitosamente");
        } catch (NonexistentEntityException e) {
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Autor> findAutorEntities() {
        return findAutorEntities(true, -1, -1);
    }

    public List<Autor> findAutorEntities(int maxResults, int firstResult) {
        return findAutorEntities(false, maxResults, firstResult);
    }

    private List<Autor> findAutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Autor findAutor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autor.class, id);
        } finally {
            em.close();
        }
    }

    //Método adicional para búsqueda de autor por nombre
    public List<Autor> findAutorByName(String nombre) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Autor> query = em.createQuery("SELECT a FROM Autor a WHERE a.nombre like :nombre", Autor.class);
            query.setParameter("nombre", "%" + nombre + "%");
            List<Autor> listaAutor = query.getResultList();
            return listaAutor;
        } finally {
            em.close();
        }
    }

    public int getAutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autor> rt = cq.from(Autor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
