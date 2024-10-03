package persistencia;

import jakarta.persistence.*;
import logica.Paciente;

import java.util.List;

public class PacienteJpaController {

    private EntityManagerFactory emf = null;

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PacienteJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Paciente paciente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Paciente paciente) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            paciente = em.merge(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Paciente paciente = em.getReference(Paciente.class, id);
            if (paciente == null) {
                throw new EntityNotFoundException("El paciente con id " + id + " no existe.");
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public List<Paciente> findPacienteEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Paciente p");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
