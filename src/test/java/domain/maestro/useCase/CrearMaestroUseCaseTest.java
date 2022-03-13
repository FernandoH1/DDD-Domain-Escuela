package domain.maestro.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.generic.Direccion;
import domain.generic.MaestroId;
import domain.maestro.command.CrearMaestro;
import domain.maestro.entity.Especialidad;
import domain.maestro.entity.UtilesMaestro;
import domain.maestro.event.MaestroCreado;
import domain.maestro.value.EspecialidadId;
import domain.maestro.value.InformacionPersonal;
import domain.maestro.value.NombreEspecialidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CrearMaestroUseCaseTest {
    @Test
    void crearMaestro(){
        //arrange
        MaestroId maestroId = MaestroId.of("xxxx");
        InformacionPersonal informacionPersonal = new InformacionPersonal("Raúl","Alzate");
        Direccion direccion = new Direccion("Colombia","101");
        Set<UtilesMaestro> utiles = new HashSet<>();
        NombreEspecialidad ne = new NombreEspecialidad("Ingeniero");
        Especialidad especialidad = new Especialidad((EspecialidadId.of("zzz")),ne);

        var command = new CrearMaestro(maestroId,informacionPersonal,direccion,utiles,especialidad);
        var useCase = new CrearMaestroUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (MaestroCreado)events.get(0);
        Assertions.assertEquals("domain.maestro.maestrocreado", event.type);
        Assertions.assertEquals(utiles, event.getUtiles());
        Assertions.assertEquals(informacionPersonal, event.getInformacionPersonal());
        Assertions.assertEquals("Colombia"+"101", event.getDireccion().value());
        Assertions.assertEquals(especialidad, event.getEspecialidad());

        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}