package domain.salon.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.salon.Salon;
import domain.salon.command.CrearSalon;

public class CrearSalonUseCase extends UseCase<RequestCommand<CrearSalon>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearSalon> input) {
        var command = input.getCommand();
        var salon = new Salon(command.getSalonId(),command.getArticulo(),command.getCapacidad(),command.getClase());
        emit().onResponse(new ResponseEvents(salon.getUncommittedChanges()));
    }
}
