package Prendas;

class TipoPrenda {

    Categoria categoria;

    TipoPrenda(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public TipoPrenda zapato() {
        return new TipoPrenda(Categoria.CALZADO);
    }

    public TipoPrenda remera() {
        return new TipoPrenda(Categoria.PARTE_SUPERIOR);
    }

    public TipoPrenda pantalon() {
        return new TipoPrenda(Categoria.PARTE_INFERIOR);
    }
}

