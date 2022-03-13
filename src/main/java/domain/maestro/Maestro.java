package domain.maestro;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;
import domain.maestro.entity.Especialidad;
import domain.maestro.entity.UtilesMaestro;
import domain.maestro.event.DireccionModificada;
import domain.maestro.event.MaestroCreado;
import domain.maestro.value.InformacionPersonal;
import domain.generic.MaestroId;

import java.util.List;
import java.util.Set;

public class Maestro extends AggregateEvent<MaestroId> {
    protected InformacionPersonal informacionPersonal;
    protected Direccion direccion;
    protected Set<UtilesMaestro> utiles;
    protected Especialidad especialidad;

    public Maestro(MaestroId maestroId, InformacionPersonal informacionPersonal, Direccion direccion, Set<UtilesMaestro> utiles, Especialidad especialidad) {
        super(maestroId);
        appendChange(new MaestroCreado(informacionPersonal,direccion,utiles,especialidad));
    }

    private Maestro(MaestroId maestroId){
        super(maestroId);
        subscribe(new MaestroChange(this));
    }

    public static Maestro from(MaestroId maestroId, List<DomainEvent> events){
        var maestro = new Maestro(maestroId);
        events.forEach(maestro::applyEvent);
        return maestro;
    }

    public void cambiarDireccion(Direccion direccion){
        appendChange(new DireccionModificada(direccion)).apply();
    }

}
