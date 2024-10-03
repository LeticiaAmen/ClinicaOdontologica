package persistencia;

import jakarta.persistence.*;
import logica.Turno;

import java.util.List;

public class TurnoJpaController {
    private EntityManagerFactory emf = null;

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public TurnoJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Turno turno) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Turno turno) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            turno = em.merge(turno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getIdTurno();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("El turno con id " + id + " no existe.");
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Turno findTurno(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public List<Turno> findTurnoEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT t FROM Turno t");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
