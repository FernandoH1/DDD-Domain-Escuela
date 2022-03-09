package generic;

import co.com.sofka.domain.generic.Identity;

public class ClaseId extends Identity {

    private ClaseId(String valor){
        super(valor);
    }
    public ClaseId(){}

    public static ClaseId of(String valor) {
        return new ClaseId(valor);
    }
}