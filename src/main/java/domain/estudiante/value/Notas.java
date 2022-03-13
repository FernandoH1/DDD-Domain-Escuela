package domain.estudiante.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Notas implements ValueObject<String> {
    private final String nota;

    public Notas(String nota) {
        this.nota = Objects.requireNonNull(nota);
        if (nota == null) {
            throw new IllegalArgumentException("La Nota puede ser Vacia");
        }
    }

    @Override
    public String value() {
        return nota;
    }
}
