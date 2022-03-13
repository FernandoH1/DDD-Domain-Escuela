package domain.clase.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.clase.value.Puntaje;
import domain.clase.value.Turno;
import domain.generic.EstudianteId;
import domain.generic.MaestroId;

import java.util.Set;

public class ClaseCreada extends DomainEvent {
    private final Set<MaestroId> maestroId;
    private final Set<EstudianteId> estudianteId;
    private final Puntaje puntaje;
    private final Turno turno;

    public ClaseCreada(Set<MaestroId> maestroId, Set<EstudianteId> estudianteId, Puntaje puntaje, Turno turno) {
        super("domain.clase.clasecreada");
        this.maestroId = maestroId;
        this.estudianteId = estudianteId;
        this.puntaje = puntaje;
        this.turno = turno;
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
