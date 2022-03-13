package domain.estudiante.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cantidad implements ValueObject<Integer> {
    private final Integer cantidad;

    public Cantidad(Integer cantidad) {
        this.cantidad = Objects.requireNonNull(cantidad);
        if(cantidad <= 0){
            throw new IllegalArgumentException("La Cantidad No puede ser vacia");
        }
    }

    @Override
    public Integer value() {
        return cantidad;
    }
}
