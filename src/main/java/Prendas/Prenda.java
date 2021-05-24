package Prendas;

public class Prenda {
    private TipoPrenda tipoPrenda;
    private Material material;
    private Color colorPrimario;
    private Color colorSecundario;
    private Trama trama;
    private double temperaturaMaxima;
    private double temperaturaMinima;

    public Prenda(TipoPrenda tipoPrenda, Material material, Color colorPrimario, Color colorSecundario, Trama trama, double temperaturaMinima, double temperaturaMaxima) {
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.trama = trama;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
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
        return this.getCategoria().equals(categoria) && this.esAdecuada(temperatura);
    }

    private boolean esAdecuada(double temperatura) {
        return temperatura >= this.temperaturaMinima && temperatura <= this.temperaturaMaxima;
    }
}
