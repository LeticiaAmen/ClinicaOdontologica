package persistencia;

import jakarta.persistence.*;
import logica.Persona;

import java.util.List;

public class PersonaJpaController {
    private EntityManagerFactory emf;

    public PersonaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public PersonaJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Persona persona) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Persona persona) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            persona = em.merge(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Persona persona = em.getReference(Persona.class, id);
            if (persona == null) {
                throw new EntityNotFoundException("La persona con id " + id + " no existe.");
            }
            em.remove(persona);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Persona findPersona(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Persona.class, id);
        } finally {
            em.close();
        }
    }

    public List<Persona> findPersonaEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Persona p");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
