package persistencia;

import logica.Controladora;
import logica.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {



    HorarioJpaController horaJPA = new HorarioJpaController();
    OdontologoJpaController odontoJPA = new OdontologoJpaController();
    PacienteJpaController pacJPA = new PacienteJpaController();
    PersonaJpaController personaJPA = new PersonaJpaController();
    ResponsableJpaController responsableJPA = new ResponsableJpaController();
    SecretarioJpaController secretarioJPA = new SecretarioJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    public void crearUsuario(Usuario usuario) {
        usuarioJPA.create(usuario);
    }

    public ControladoraPersistencia() {
    }

    public List<Usuario> getUsuarios(){
        return  usuarioJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuarioJPA.destroy(id);
        }catch( Exception e) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
