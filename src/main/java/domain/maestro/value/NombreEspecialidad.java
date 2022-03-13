package domain.maestro.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NombreEspecialidad implements ValueObject<String> {
    private final String nombre;

    public NombreEspecialidad(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (nombre == null) {
            throw new IllegalArgumentException("el Nombre no puede ser Vacio");
        }
    }

    @Override
    public String value() {
        return nombre;
    }
}

