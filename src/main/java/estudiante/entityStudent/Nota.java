package estudiante.entityStudent;

import co.com.sofka.domain.generic.Entity;
import generic.NombreId;
import generic.NotaId;

public class Nota extends Entity<NotaId> {

    public Nota(NotaId entityId) {
        super(entityId);
    }
}