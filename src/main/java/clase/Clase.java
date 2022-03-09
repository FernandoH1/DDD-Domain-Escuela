package clase;

import co.com.sofka.domain.generic.AggregateEvent;
import generic.ClaseId;
import generic.EstudianteId;
import generic.MaestroId;

public class Clase extends AggregateEvent<ClaseId> {
 protected ClaseId claseId;
 protected MaestroId maestroId;
 protected EstudianteId estudianteId;


    public Clase(ClaseId entityId) {
        super(entityId);
    }
}
