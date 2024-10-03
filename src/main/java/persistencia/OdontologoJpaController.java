package persistencia;

import jakarta.persistence.*;
import logica.Odontologo;

import java.util.List;

public class OdontologoJpaController {
    private EntityManagerFactory emf = null;

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public OdontologoJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Odontologo odontologo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(odontologo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Odontologo odontologo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            odontologo = em.merge(odontologo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Odontologo odontologo = em.getReference(Odontologo.class, id);
            if (odontologo == null) {
                throw new EntityNotFoundException("El odontólogo con id " + id + " no existe.");
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Odontologo findOdontologo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM Odontologo o");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
