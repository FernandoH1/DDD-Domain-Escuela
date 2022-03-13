package domain.salon.value;

import co.com.sofka.domain.generic.Identity;

public class ArticuloId extends Identity {
    private ArticuloId(String id){
        super(id);
    }

    public ArticuloId(){ }

    public static ArticuloId of(String id) {
        return new ArticuloId(id);
    }
}
