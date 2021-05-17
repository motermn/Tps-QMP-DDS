package Prendas;

import java.util.Objects;

public class Prenda {
    private Color colorPrimario;
    private Color colorSecundario;
    private Material material;
    private Tipo tipo;

    public Prenda(Tipo tipo, Material material) {
        this.validar(tipo, material);
        this.material = material;
        this.tipo = tipo;
    }

    public void validar(Tipo tipo, Material material) {
        Objects.requireNonNull(tipo, "Debe especificarse un tipo de prenda");
        Objects.requireNonNull(material, "Debe especificarse un material");
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Categoria categoria() {
        return tipo.getCategoria();
    }

}
