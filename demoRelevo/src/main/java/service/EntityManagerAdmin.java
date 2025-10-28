package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerAdmin {
    private static final String UNIDAD_PERSISTENCIA = "demoRelevo";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
