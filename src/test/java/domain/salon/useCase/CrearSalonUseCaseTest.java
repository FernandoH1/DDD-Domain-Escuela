package domain.salon.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.generic.ClaseId;
import domain.generic.Nombre;
import domain.generic.SalonId;
import domain.salon.command.CrearSalon;
import domain.salon.entity.Articulo;
import domain.salon.event.SalonCreado;
import domain.salon.value.ArticuloId;
import domain.salon.value.Capacidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CrearSalonUseCaseTest {

    @Test
    void crearSalon(){
        //arrange
        SalonId salonId = SalonId.of("xxxx");
        Nombre nombre = new Nombre("Lucia");
        Articulo articulo = new Articulo(ArticuloId.of("zzz"),nombre);
        Capacidad capacidad = new Capacidad(120);
        Set<ClaseId> clase = new HashSet<>();;


        var command = new CrearSalon(salonId,articulo,capacidad,clase);
        var useCase = new CrearSalonUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (SalonCreado)events.get(0);
        Assertions.assertEquals("domain.salon.saloncreado", event.type);
        Assertions.assertEquals(articulo, event.getArticulo());
        Assertions.assertEquals(120, event.getCapacidad().value());
        Assertions.assertEquals(clase, event.getClase());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}