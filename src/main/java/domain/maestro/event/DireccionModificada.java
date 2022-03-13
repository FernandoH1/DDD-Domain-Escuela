package domain.maestro.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;

public class DireccionModificada extends DomainEvent {
    private final Direccion direccion;


    public DireccionModificada(Direccion direccion) {
        super("domain.maestro.direccionmodificada");
        this.direccion = direccion;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
