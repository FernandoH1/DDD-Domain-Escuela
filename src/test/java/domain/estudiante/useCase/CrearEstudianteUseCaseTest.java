package domain.estudiante.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.estudiante.command.CrearEstudiante;
import domain.estudiante.entity.Falta;
import domain.estudiante.entity.Nota;
import domain.estudiante.entity.Utiles;
import domain.estudiante.event.EstudianteCreado;
import domain.estudiante.value.Cantidad;
import domain.estudiante.value.FaltaId;
import domain.estudiante.value.NotaId;
import domain.generic.Direccion;
import domain.generic.EstudianteId;
import domain.generic.Nombre;
import domain.generic.UtilesId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrearEstudianteUseCaseTest {
    @Test
    void crearEstudiante(){
        //arrange
        EstudianteId estudianteId = EstudianteId.of("xxxx");
        Nombre nombre = new Nombre("Lucia");
        Direccion direccion = new Direccion("Abril","1170");
        Utiles utiles = new Utiles((UtilesId.of("zzz")));
        Nota nota = new Nota((NotaId.of("aaa")));
        Cantidad cantidad = new Cantidad(20);
        Falta falta = new Falta((FaltaId.of("uuu")), cantidad);


        var command = new CrearEstudiante(estudianteId,nombre,direccion,utiles,nota,falta);
        var useCase = new CrearEstudianteUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstudianteCreado)events.get(0);
        Assertions.assertEquals("doamin.estudiante.estudianteCreado", event.type);
        Assertions.assertEquals("Lucia", event.getNombre().value());
        Assertions.assertEquals("Abril"+"1170", event.getDireccion().value());
        Assertions.assertEquals(utiles, event.getUtiles());
        Assertions.assertEquals(nota, event.getNota());
        Assertions.assertEquals(falta, event.getFalta());
        Assertions.assertEquals("xxxx", event.aggregateRootId());
    }
}