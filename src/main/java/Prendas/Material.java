package Prendas;

/*public enum Material {
    CUERO, JEAN, SEDA, ALGODON, POLIESTER;
}*/

import java.util.Objects;

public class Material {
    Color colorPrimario;
    Color colorSecundario;
    Trama trama;
    TipoMaterial tipo;

    public Material(TipoMaterial tipo, Trama trama, Color colorPrimario) {
        this.validar(tipo, "Debe especificarse un tipo de material");
        this.tipo = tipo;
        this.validarTrama(trama);
        this.validar(colorPrimario, "Debe especificarse un color primario");
        this.colorPrimario = colorPrimario;

    }

    public Material(TipoMaterial tipo, Trama trama, Color colorPrimario, Color colorSecundario) {
        this(tipo, trama, colorPrimario);
        this.colorSecundario = colorSecundario;
    }

    private void validarTrama(Trama trama) {
        if (trama == null) {
            this.trama = Trama.LISA;
        }
        else {
            this.trama = trama;
        }
    }

    private <T> void validar (T parametro, String message) {
        Objects.requireNonNull(parametro, message);
    }

    public Trama getTrama() {
        return trama;
    }

    public TipoMaterial getTipo() {
        return tipo;
    }
}


