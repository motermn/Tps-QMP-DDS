package Prendas;

import java.util.Objects;

public class Borrador { // Borrador es el PrendaBuilder
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama = Trama.LISA;
  private double temperaturaMinima;
  private double temperaturaMaxima;

  public Borrador(TipoPrenda tipoPrenda) {
    Objects.requireNonNull(tipoPrenda, "Debe especificarse el tipo de prenda");
    this.tipoPrenda = tipoPrenda;
  }

  public void cargarMaterial(Material material) {
    this.validarMaterialConsistenteTipoPrenda(material);
    this.material = material;
  }

  public void cargarColorPrimario(Color colorPrimario) {
    this.validarNoNulo(colorPrimario, "Debe especificarse un color principal");
    this.colorPrimario = colorPrimario;
  }

  public void cargarColorSecundario(Color colorSecundario) {
    this.validarNoNulo(colorSecundario, "Debe especificarse un color secundario");
    this.colorSecundario = colorSecundario;
  }

  public void cargarTrama(Trama trama) {
    this.validarTrama(trama);
    this.trama = trama;
  }

  public void cargarTemperaturas(double temperaturaMinima, double temperaturaMaxima) {
    this.validarNoNulo(temperaturaMinima, "Debe especificarse una temperatura minima para la prenda");
    this.validarNoNulo(temperaturaMaxima, "Debe especificarse una temperatura maxima para la prenda");
    this.temperaturaMaxima = temperaturaMaxima;
  }

  private  <T> void validarNoNulo (T parametro, String message) { // Estoy repitiendo lógica como en la clase Material
    Objects.requireNonNull(parametro, message);
  }

  private void validarMaterialConsistenteTipoPrenda(Material material) {
    // TODO
  }

  private void validarTrama(Trama trama) {
    if (trama == null) {
      this.trama = Trama.LISA;
    }
    else {
      this.trama = trama;
    }
  }

  public Prenda construirPrenda() {
    Prenda prendaTerminada = new Prenda(tipoPrenda, material, colorPrimario, colorSecundario, trama, temperaturaMinima, temperaturaMaxima);
    // Acá debería agregar la prenda al guardarropas del usuario. Podría pasarsele como parámetro a este método
    return prendaTerminada;
  }

}
