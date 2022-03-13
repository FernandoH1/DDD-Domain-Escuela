package domain.estudiante.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Nombre;

public class NombreModificado extends DomainEvent {
    private final Nombre nombre;


    public NombreModificado(Nombre nombre) {
        super("domain.estudiante.nombremodificado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
