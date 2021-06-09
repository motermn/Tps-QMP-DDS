package Sugerencias;

import Exceptions.SugerenciaAceptadaException;
import Exceptions.SugerenciaNoAceptadaException;
import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public abstract class Sugerencia {
  private Prenda prenda;
  private boolean aceptada;

  public Sugerencia(Prenda prenda) {
    this.prenda = prenda;
    this.aceptada = false;
  }

  public Prenda getPrenda() {
    return this.prenda;
  }

  public boolean getAceptada() {
    return this.aceptada;
  }

  public void aceptar(GuardarropasCompartido guardarropasCompartido) {
    if(this.aceptada) {
      throw new SugerenciaAceptadaException("La sugerencia ya ha sido aceptada");
    }
    this.aceptada = true;
  }

  public void rechazar(GuardarropasCompartido guardarropasCompartido) {
    if(!this.getAceptada()) {
      throw new SugerenciaNoAceptadaException("La sugerencia no ha sido aceptada, y por lo tanto no se puede rechazar");
    }
    this.aceptada = false;
  }

  public abstract void deshacer(GuardarropasCompartido guardarropasCompartido);
}
