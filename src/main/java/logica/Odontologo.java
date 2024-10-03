package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;

@Entity
public class Odontologo extends Persona{

    private String especialidad;

    @OneToMany(mappedBy = "odonto")
    private List<Turno> listaTurnos;

    @OneToOne
    private Usuario unUsuario;

    @OneToOne
    private Horario unHorario;

    public Odontologo() {
    }

    public Odontologo(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
}
