package domain.estudiante.entity;

import co.com.sofka.domain.generic.Entity;
import domain.estudiante.value.Cantidad;
import domain.estudiante.value.FaltaId;

public class Falta extends Entity<FaltaId> {
    private Cantidad cantidad;

    public Falta(FaltaId faltaId, Cantidad cantidad) {
        super(faltaId);
        this.cantidad = cantidad;
    }

}