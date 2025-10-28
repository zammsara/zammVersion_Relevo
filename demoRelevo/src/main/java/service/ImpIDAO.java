package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ImpIDAO<T> implements IDAO<T> {

    private Class<T> classz;

    public ImpIDAO(Class<T> classz) {
        this.classz = classz;
    }

    @Override
    public List<T> findAll(String nameQuery) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            TypedQuery<T> query = em.createNamedQuery(nameQuery, classz);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void insertar(T entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(T entity) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminarById(int id) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            T entidad = em.find(classz, id);  //Buscamos la entidad a eliminar
            if (entidad != null) {
                em.remove(entidad);
            } else {
                System.out.println("No se encontró la entidad con ID " + id);
            }
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public T buscarById(int id) {
        EntityManager em = EntityManagerAdmin.getEntityManager();
        try {
            return em.find(classz, id);
        } finally {
            em.close();
        }
    }
}
