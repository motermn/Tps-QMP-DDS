package Prendas;

public enum Material {
    CUERO, JEAN, SEDA, ALGODON, POLIESTER;
}
/*
import java.util.Objects;

public class Material {
    private TipoMaterial tipo;

    public Material(TipoMaterial tipo) {
        this.validarNoNulo(tipo, "Debe especificarse un tipo de material");
        this.tipo = tipo;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }

    private <T> void validarNoNulo (T parametro, String message) { // De alguna manera voy a abstraer esta lógica repetida
        Objects.requireNonNull(parametro, message);
    }
}*/


