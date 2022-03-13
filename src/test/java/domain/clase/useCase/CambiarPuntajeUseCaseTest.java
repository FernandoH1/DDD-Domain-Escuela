package domain.clase.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.clase.command.ModificarPuntaje;
import domain.clase.event.ClaseCreada;
import domain.clase.event.PuntajeModificado;
import domain.clase.value.Puntaje;
import domain.clase.value.Turno;
import domain.generic.ClaseId;
import domain.generic.EstudianteId;
import domain.generic.MaestroId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CambiarPuntajeUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarPuntaje(){
        ClaseId claseId = ClaseId.of("xxxx");
        Puntaje puntaje = new Puntaje(6,1);


        var command = new ModificarPuntaje(claseId, puntaje);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarPuntajeUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (PuntajeModificado)events.get(0);
        Assertions.assertEquals("domain.clase.puntajemodificado", event.type);
        Assertions.assertEquals(puntaje, event.getPuntaje());
        Assertions.assertEquals(claseId.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Set<MaestroId> maestroIds = new HashSet<>();
        Set<EstudianteId> estudianteIds = new HashSet<>();
        Puntaje puntaje = new Puntaje(12,1);
        Turno turno = new Turno("m","v");

        return List.of(new ClaseCreada(maestroIds,estudianteIds,puntaje,turno));
    }



}