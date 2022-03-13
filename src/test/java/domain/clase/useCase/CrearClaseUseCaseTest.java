package domain.clase.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.clase.command.CrearClase;
import domain.clase.event.ClaseCreada;
import domain.clase.value.Puntaje;
import domain.clase.value.Turno;
import domain.generic.ClaseId;
import domain.generic.EstudianteId;
import domain.generic.MaestroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CrearClaseUseCaseTest {

    @Test
    void crearClase(){
        //arrange
        ClaseId claseId = ClaseId.of("xxxx");
        Set<MaestroId> maestroIds = new HashSet<>();
        Set<EstudianteId> estudianteIds = new HashSet<>();
        Puntaje puntaje = new Puntaje(12,1);
        Turno turno = new Turno("m","v");

        var command = new CrearClase(claseId,maestroIds,estudianteIds,puntaje,turno);
        var useCase = new CrearClaseUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClaseCreada)events.get(0);
        Assertions.assertEquals("domain.clase.clasecreada", event.type);
        Assertions.assertEquals(maestroIds, event.getMaestroId());
        Assertions.assertEquals(estudianteIds, event.getEstudianteId());
        Assertions.assertEquals(puntaje, event.getPuntaje());
        Assertions.assertEquals(turno, event.getTurno());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}