package domain.maestro.event;

import co.com.sofka.domain.generic.DomainEvent;
import domain.generic.Direccion;
import domain.maestro.entity.Especialidad;
import domain.maestro.entity.UtilesMaestro;
import domain.maestro.value.InformacionPersonal;

import java.util.Set;

public class MaestroCreado extends DomainEvent {
    private final InformacionPersonal informacionPersonal;
    private final Direccion direccion;
    private final Set<UtilesMaestro> utiles;
    private final Especialidad especialidad;


    public MaestroCreado(InformacionPersonal informacionPersonal, Direccion direccion, Set<UtilesMaestro> utiles, Especialidad especialidad) {
        super("domain.maestro.maestrocreado");
        this.informacionPersonal = informacionPersonal;
        this.direccion = direccion;
        this.utiles = utiles;
        this.especialidad = especialidad;
    }

    public InformacionPersonal getInformacionPersonal() {
        return informacionPersonal;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Set<UtilesMaestro> getUtiles() {
        return utiles;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}
