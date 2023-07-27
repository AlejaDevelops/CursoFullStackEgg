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
import libreria.entidades.Libro;
import libreria.persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author AlejaDevelops
 */
public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public LibroJpaController() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
            System.out.println("Libro registrado exitosamente");
        } catch (RollbackException e) { //CATCH QUE SE ACTIVAN CUANDO SE INTENTA INGRESAR UN LIBRO QUE YA ESTÁ EN LA BD
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

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            libro = em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libro.getId();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
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
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            em.remove(libro);
            em.getTransaction().commit();
            System.out.println("Libro eliminado exitosamente");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    //Método para búsqueda de libro por ISBN o ID
    public Libro findLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    //Método adicional para búsqueda de libro por título
    public List<Libro> findLibroByTitulo(String titulo) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.titulo like :titulo", Libro.class);
            query.setParameter("titulo", "%" + titulo + "%");
            List<Libro> listaLibro = query.getResultList();
            return listaLibro;
        } finally {
            em.close();
        }
    }

    //Método adicional para búsqueda de libro por NOMBRE DE AUTOR
    public List<Libro> findLibrosByAutorName(String nombreAutor) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombreAutor", Libro.class);
            query.setParameter("nombreAutor", "%" + nombreAutor + "%");
            List<Libro> listaLibro = query.getResultList();

            return listaLibro;
        } finally {
            em.close();
        }

    }

    //Método adicional para búsqueda de libro por NOMBRE EDITORIAL
    public List<Libro> findLibrosByEditorialName(String nombreEditorial) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nombreEditorial", Libro.class);
            query.setParameter("nombreEditorial", "%" + nombreEditorial + "%");
            List<Libro> listaLibro = query.getResultList();

            return listaLibro;
        } finally {
            em.close();
        }

    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
