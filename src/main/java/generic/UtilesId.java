package generic;

import co.com.sofka.domain.generic.Identity;

public class UtilesId extends Identity {

    private UtilesId(String valor){
        super(valor);
    }
    public UtilesId(){}

    public static UtilesId of(String valor) {
        return new UtilesId(valor);
    }
}