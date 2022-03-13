package domain.clase.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Turno implements ValueObject<String> {
    private final String matutino;
    private final String vespertino;

    public Turno(String matutino, String vespertino) {
        this.matutino = Objects.requireNonNull(matutino);
        this.vespertino = Objects.requireNonNull(vespertino);
        if (matutino == null && vespertino == null) {
            throw new IllegalArgumentException("El turno no  puede ser Vacio");
        }
    }

    @Override
    public String value() {
        return matutino + vespertino;
    }

}
