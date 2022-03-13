package domain.clase.command;

import co.com.sofka.domain.generic.Command;
import domain.clase.value.Puntaje;
import domain.generic.ClaseId;

public class ModificarPuntaje extends Command {
    private final ClaseId claseId;
    private final Puntaje puntaje;

    public ModificarPuntaje(ClaseId claseId, Puntaje puntaje) {
        this.claseId = claseId;
        this.puntaje = puntaje;
    }

    public ClaseId getClaseId() {
        return claseId;
    }

    public Puntaje getPuntaje() {
        return puntaje;
    }
}
