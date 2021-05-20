package Prendas;

public class TipoPrenda { // Esto podría haberse modelado con enums con comportamiento...

    private final Categoria categoria;

    public TipoPrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public static TipoPrenda zapatos() {
        return new TipoPrenda(Categoria.CALZADO);
    }

    public static TipoPrenda remera() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR);
    }

    public static TipoPrenda pantalon() {
        return new TipoPrenda(Categoria.PARTE_INFERIOR);
    }

    public static TipoPrenda zapatillas() {
        return new TipoPrenda(Categoria.PARTE_INFERIOR);
    }

    public static TipoPrenda chomba() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR);
    }

    public static TipoPrenda camisa() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR);
    }
}

