package logica;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona{
    private int idPaciente;
    private boolean tieneOS;
    private String tipoSangre;
    private Responsable unResponsable;
    private List<Turno> listaTurnos;

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

    public Paciente(String dni, String nombre, String apellido, String telefono, String direccion, Date fechaNac, int idPaciente, boolean tieneOS, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos) {
        super(dni, nombre, apellido, telefono, direccion, fechaNac);
        this.idPaciente = idPaciente;
        this.tieneOS = tieneOS;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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
