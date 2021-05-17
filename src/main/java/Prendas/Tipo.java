package Prendas;

class Tipo {

    Categoria categoria;

    Tipo(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public Tipo zapato() {
        return new Tipo (Categoria.CALZADO);
    }

    public Tipo remera() {
        return new Tipo(Categoria.PARTE_SUPERIOR);
    }

    public Tipo pantalon() {
        return new Tipo(Categoria.PARTE_INFERIOR);
    }
}

