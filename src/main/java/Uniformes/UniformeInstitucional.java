package Uniformes;

import Prendas.Prenda;

public abstract class UniformeInstitucional {

  public Uniforme crearUniforme() {
    return new Uniforme(this.determinarParteSuperior(), this.determinarParteInferior(), this.determinarCalzado());
  }

  protected abstract Prenda determinarParteInferior();

  protected abstract Prenda determinarParteSuperior();

  protected abstract Prenda determinarCalzado();
}
