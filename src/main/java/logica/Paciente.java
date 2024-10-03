package logica;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.List;

@Entity
public class Paciente extends Persona{
  //  private int idPaciente;
    private boolean tieneOS;
    private String tipoSangre;

    @OneToOne
    private Responsable unResponsable;

    @OneToMany(mappedBy = "pacien")
    private List<Turno> listaTurnos;

    public Paciente(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, boolean tieneOS, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos) {
        super(id, dni, nombre, apellido, telefono, direccion, fechaNac);
        this.tieneOS = tieneOS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Paciente() {
    }


    public boolean isTieneOS() {
        return tieneOS;
    }

    public void setTieneOS(boolean tieneOS) {
        this.tieneOS = tieneOS;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
