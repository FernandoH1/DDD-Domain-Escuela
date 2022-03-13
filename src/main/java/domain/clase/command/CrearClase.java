package domain.clase.command;

import co.com.sofka.domain.generic.Command;
import domain.clase.value.Puntaje;
import domain.clase.value.Turno;
import domain.generic.ClaseId;
import domain.generic.EstudianteId;
import domain.generic.MaestroId;

import java.util.Set;

public class CrearClase extends Command {
    private final ClaseId claseId;
    private final Set<MaestroId> maestroId;
    private final Set<EstudianteId> estudianteId;
    private final Puntaje puntaje;
    private final Turno turno;

    public CrearClase(ClaseId claseId, Set<MaestroId> maestroId, Set<EstudianteId> estudianteId, Puntaje puntaje, Turno turno) {
        this.claseId = claseId;
        this.maestroId = maestroId;
        this.estudianteId = estudianteId;
        this.puntaje = puntaje;
        this.turno = turno;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public Set<MaestroId> getMaestroId() {
        return maestroId;
    }

    public Set<EstudianteId> getEstudianteId() {
        return estudianteId;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }

    public Turno getTurno() {
        return turno;
    }
}
