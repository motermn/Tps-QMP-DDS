package Uniformes;

import Prendas.Prenda;

public class Uniforme {
  private Prenda parteSuperior;
  private Prenda parteInferior;
  private Prenda calzado;

  public Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado) {
    this.parteSuperior = parteSuperior;
    this.parteInferior = parteInferior;
    this.calzado = calzado;
  }
}
