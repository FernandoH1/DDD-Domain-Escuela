package domain.salon.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.salon.value.Capacidad;

public class CapacidadModificada extends DomainEvent {
    private final Capacidad capacidad;

    public CapacidadModificada(Capacidad capacidad) {
        super("domain.salon.capacidadmodificada");
        this.capacidad = capacidad;
    }

    public Capacidad getCapacidad() {
        return capacidad;
    }
}
