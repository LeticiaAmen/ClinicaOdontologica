package persistencia;

import jakarta.persistence.*;
import logica.Secretario;

import java.util.List;

public class SecretarioJpaController {
    private EntityManagerFactory emf = null;

    public SecretarioJpaController(EntityManagerFactory emf) {this.emf = emf;}

    public EntityManager getEntityManager() {return emf.createEntityManager();}

    public SecretarioJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Secretario secretario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(secretario);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void edit(Secretario secretario) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            secretario = em.merge(secretario);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Secretario secretario = em.find(Secretario.class, id);
            if(secretario == null){
                throw new EntityNotFoundException("El secretario con id " + id + " no existe.");
            }
            em.remove(secretario);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }

    public Secretario findSecretario(int id) {
        EntityManager em = getEntityManager();
        try{
            return em.find(Secretario.class, id);
        }finally {
            em.close();
        }
    }

    public List<Secretario> findSecretarioEntities() {
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("select s from Secretario s");
            return query.getResultList();
        }finally {
            em.close();
        }
    }


}
