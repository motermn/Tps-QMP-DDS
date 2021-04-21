package Prendas;

public class Prenda {
    private Categoria categoria;
    private Color colorPrimario;
    private Color colorSecundario;
    private Material material;
    private Tipo tipo;

    public Prenda(Categoria categoria, Color colorPrimario, Material material, Tipo tipo) {
        this.categoria = categoria;
        this.colorPrimario = colorPrimario;
        this.material = material;
        this.validarTipo();
        this.tipo = tipo;
        // Para esta implementación, no sabría cómo desarrollar el código que valide si no se pasa el valor de alguno de los atributos involucrados en esta sección. En otras palabras, no sabría como implementar una excepción de dominio con esta implementación
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public void validarTipo() {
        // TODO
        // En este método debería validarse si el tipo de la prenda ingresado coincide con el establecido en, por ejemplo, una base de datos
    }
}
