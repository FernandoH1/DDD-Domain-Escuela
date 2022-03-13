package domain.estudiante.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.estudiante.command.CambiarNombre;
import domain.estudiante.entity.Falta;
import domain.estudiante.entity.Nota;
import domain.estudiante.entity.Utiles;
import domain.estudiante.event.EstudianteCreado;
import domain.estudiante.event.NombreModificado;
import domain.estudiante.value.Cantidad;
import domain.estudiante.value.FaltaId;
import domain.estudiante.value.NotaId;
import domain.generic.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CambiarNombreUseCaseTest {

    @Mock
    DomainEventRepository repository;

    @Test
    void cambiarNombre(){
        EstudianteId estudianteId = EstudianteId.of("xxxx");
        Nombre nombre = new Nombre("Lucia");

        var command = new CambiarNombre(estudianteId, nombre);
        Mockito.when(repository.getEventsBy(null)).thenReturn(events());

        var useCase = new CambiarNombreUseCase();
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (NombreModificado)events.get(0);
        Assertions.assertEquals("domain.estudiante.nombremodificado", event.type);
        Assertions.assertEquals("Lucia", event.getNombre().value());
        Assertions.assertEquals(estudianteId.value(), event.aggregateRootId());
    }

    private List<DomainEvent> events() {
        Nombre nombre = new Nombre("Luciaaa");
        Direccion direccion = new Direccion("Abril","1170");
        Utiles utiles = new Utiles((UtilesId.of("zzz")));
        Nota nota = new Nota((NotaId.of("aaa")));
        Cantidad cantidad = new Cantidad(20);
        Falta falta = new Falta((FaltaId.of("uuu")), cantidad);

        return List.of(new EstudianteCreado(nombre,direccion,utiles,nota,falta));
    }


}