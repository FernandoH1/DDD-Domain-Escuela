package domain.clase.value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Puntaje implements ValueObject<Puntaje.Props> {
    private final Integer maximo;
    private final Integer minimo;

    public Puntaje(Integer maximo, Integer minimo) {
        this.maximo = Objects.requireNonNull(maximo);
        this.minimo = Objects.requireNonNull(minimo);
        if(minimo <= 0 && maximo <= 0) {
            throw new IllegalArgumentException("La Cantidad No puede ser vacia");
        }
    }

    @Override
    public Puntaje.Props value() {
        return new Props() {
            @Override
            public Integer maximo() {
                return maximo;
            }

            @Override
            public Integer minimo() {
                return minimo;
            }
        };
    }

    public interface Props{
        Integer maximo();
        Integer minimo();
    }
}
