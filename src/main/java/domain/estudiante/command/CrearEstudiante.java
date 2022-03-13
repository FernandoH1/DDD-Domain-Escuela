package domain.estudiante.command;

import co.com.sofka.domain.generic.Command;
import domain.estudiante.entity.Falta;
import domain.estudiante.entity.Nota;
import domain.estudiante.entity.Utiles;
import domain.generic.Direccion;
import domain.generic.EstudianteId;
import domain.generic.Nombre;

public class CrearEstudiante extends Command {
    private final EstudianteId estudianteId;
    private final Nombre nombre;
    private final Direccion direccion;
    private final Utiles utiles;
    private final Nota nota;
    private final Falta falta;


    public CrearEstudiante(EstudianteId estudianteId, Nombre nombre, Direccion direccion, Utiles utiles, Nota nota, Falta falta) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.utiles = utiles;
        this.nota = nota;
        this.falta = falta;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Utiles getUtiles() {
        return utiles;
    }

    public Nota getNota() {
        return nota;
    }

    public Falta getFalta() {
        return falta;
    }
}
