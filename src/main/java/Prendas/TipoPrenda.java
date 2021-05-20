package Prendas;

public class TipoPrenda { // Esto podría haberse modelado con enums con comportamiento...

    private final Categoria categoria;
    private final double temperaturaAdecuadaMaxima;


    public TipoPrenda(Categoria categoria, double temperaturaAdecuadaMaxima) {
        this.categoria = categoria;
        this.temperaturaAdecuadaMaxima = temperaturaAdecuadaMaxima;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public boolean esAdecuada(double temperatura) {
        return temperatura < this.temperaturaAdecuadaMaxima;
    }

    public static TipoPrenda zapatos() {
        return new TipoPrenda(Categoria.CALZADO, 25);
    }

    public static TipoPrenda remera() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR, 35);
    }

    public static TipoPrenda pantalon() {
        return new TipoPrenda(Categoria.PARTE_INFERIOR, 20);
    }

    public static TipoPrenda zapatillas() {
        return new TipoPrenda(Categoria.PARTE_INFERIOR, 30);
    }

    public static TipoPrenda chomba() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR, 20);
    }

    public static TipoPrenda camisa() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR, 20);
    }
}

