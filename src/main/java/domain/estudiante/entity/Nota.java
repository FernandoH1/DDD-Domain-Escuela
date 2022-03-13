package domain.estudiante.entity;

import co.com.sofka.domain.generic.Entity;
import domain.estudiante.value.NotaId;
import domain.estudiante.value.Notas;

public class Nota extends Entity<NotaId> {
    private Notas notas;

    public Nota(NotaId entityId) {
        super(entityId);
    }
}