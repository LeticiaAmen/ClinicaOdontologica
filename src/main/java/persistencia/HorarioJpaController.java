package persistencia;

import jakarta.persistence.*;
import logica.Horario;

import java.util.List;

public class HorarioJpaController {
    private EntityManagerFactory emf = null;

    public HorarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public HorarioJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Horario horario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(horario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Horario horario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            horario = em.merge(horario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Horario horario;
            try {
                horario = em.getReference(Horario.class, id);
                horario.getIdHorario();
            } catch (EntityNotFoundException enfe) {
                throw new EntityNotFoundException("El horario con id " + id + " no existe.");
            }
            em.remove(horario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Horario findHorario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Horario.class, id);
        } finally {
            em.close();
        }
    }

    public List<Horario> findHorarioEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT h FROM Horario h");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
