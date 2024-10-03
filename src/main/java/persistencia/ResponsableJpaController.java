package persistencia;

import jakarta.persistence.*;
import logica.Responsable;

import java.util.List;

public class ResponsableJpaController {
    private EntityManagerFactory emf = null;

    public ResponsableJpaController(EntityManagerFactory emf) {this.emf = emf;}
    public EntityManager getEntityManager() {return emf.createEntityManager();}

    public ResponsableJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Responsable responsable) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(responsable);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Responsable responsable) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            responsable = em.merge(responsable);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void destroy(int id){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Responsable responsable = em.find(Responsable.class, id);
            if(responsable == null){
                throw new EntityNotFoundException("El responsable con id " + id + " no existe");
            }
            em.remove(responsable);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public Responsable findResponsable(int id) {
        EntityManager em = getEntityManager();
        try{
            return em.find(Responsable.class, id);
        }finally {
            em.close();
        }
    }
    public List<Responsable> findResponsableEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select r from Responsable r");
            return query.getResultList();
        }finally {
            em.close();
        }
    }


}
