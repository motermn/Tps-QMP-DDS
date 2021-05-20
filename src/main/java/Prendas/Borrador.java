package Prendas;

import java.util.Objects;

public class Borrador { // Borrador es el PrendaBuilder
  private TipoPrenda tipoPrenda;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Trama trama = Trama.LISA;

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
    return new Prenda(tipoPrenda, material, colorPrimario, colorSecundario, trama);
  }

}
