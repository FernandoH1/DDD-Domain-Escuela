package domain.salon.entity;

import co.com.sofka.domain.generic.Entity;
import domain.generic.Nombre;
import domain.salon.value.ArticuloId;

public class Articulo extends Entity<ArticuloId> {
    private Nombre nombre;

    public Articulo(ArticuloId entityId, Nombre nombre) {
        super(entityId);
        this.nombre = nombre;
    }

    public Nombre nombre() {
        return nombre;
    }
}
