package Prendas;

import java.util.Objects;

public class Prenda {
    private Material material;
    private TipoPrenda tipo;

    public Prenda(TipoPrenda tipo, Material material) {
        this.validar(tipo, material);
        this.material = material;
        this.tipo = tipo;
    }

    public void validar(TipoPrenda tipo, Material material) { // Esto va a ser responsabilidad del borrador
        Objects.requireNonNull(tipo, "Debe especificarse un tipo de prenda");
        Objects.requireNonNull(material, "Debe especificarse un material");
    }

    public Categoria categoria() {
        return tipo.getCategoria();
    }
}
