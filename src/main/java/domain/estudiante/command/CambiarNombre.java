package domain.estudiante.command;

import co.com.sofka.domain.generic.Command;
import domain.generic.EstudianteId;
import domain.generic.Nombre;

public class CambiarNombre extends Command {
    private final EstudianteId estudianteId;
    private final Nombre nombre;

    public CambiarNombre(EstudianteId estudianteId, Nombre nombre) {
        this.estudianteId = estudianteId;
        this.nombre = nombre;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
