package Prendas;

public class Prenda {
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrimario;
    private Color colorSecundario;
    private Trama trama;

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario, Color colorSecundario, Trama trama) {
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
    }

    public Categoria getCategoria() {
        return tipoPrenda.getCategoria();
    }

    public Trama getTrama() {
        return trama;
    }

    private TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public boolean acordeA(Categoria categoria, double temperatura) {
        return this.getCategoria().equals(categoria) && this.getTipoPrenda().esAdecuada(temperatura);
    }
}
