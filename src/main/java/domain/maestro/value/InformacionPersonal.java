package domain.maestro.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InformacionPersonal implements ValueObject<String> {
    private final String nombre;
    private final String apellido;

    public InformacionPersonal(String nombre, String apellido) {
        this.nombre = Objects.requireNonNull(nombre);
        this.apellido = Objects.requireNonNull(apellido);
        if (nombre == null && apellido == null) {
            throw new IllegalArgumentException("La Informacion personal no puede ser Vacia");
        }
    }

    @Override
    public String value() {
        return nombre + apellido;
    }

}