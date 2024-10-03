package persistencia;

import jakarta.persistence.*;
import logica.Usuario;

import java.util.List;

public class UsuarioJpaController {
    private EntityManagerFactory emf = null;

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public UsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("ClinicaOdontologica_PU");
    }

    public void create(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void edit(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void destroy(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Usuario usuario = em.getReference(Usuario.class, id);
            if (usuario == null) {
                throw new EntityNotFoundException("El usuario con id " + id + " no existe.");
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public List<Usuario> findUsuarioEntities() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
