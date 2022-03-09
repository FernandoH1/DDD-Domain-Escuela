package estudiante.entityStudent;

import co.com.sofka.domain.generic.Entity;
import generic.FaltaId;
import generic.NombreId;

public class Falta extends Entity<FaltaId> {

    public Falta(FaltaId entityId) {
        super(entityId);
    }
}