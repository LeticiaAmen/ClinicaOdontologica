package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Secretario extends Persona {
   // private int idSecretario;
    private String sector;

    @OneToOne
    private Usuario unUsuario;

    public Secretario() {
    }

    public Secretario(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String sector, Usuario unUsuario) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.sector = sector;
        this.unUsuario = unUsuario;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }
}
