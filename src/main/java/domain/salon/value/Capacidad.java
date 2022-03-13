package domain.salon.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Capacidad implements ValueObject<Integer> {
    private final Integer value;

    public Capacidad(Integer value) {
        this.value = Objects.requireNonNull(value);
        if(value <= 0){
            throw new IllegalArgumentException("El Valor NO es Valido!!");
        }
    }

    public Integer value() {
        return value;
    }
}
