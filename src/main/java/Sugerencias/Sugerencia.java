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

  /*public boolean esDeTipo(TipoSugerencia tipoSugerencia) {
    return this.tipoSugerencia.equals(tipoSugerencia);
  }*/

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
    //this.aplicarSegunTipo(this, guardarropasCompartido);
  }

  public void rechazar(GuardarropasCompartido guardarropasCompartido) {
    if(!this.getAceptada()) {
      throw new SugerenciaNoAceptadaException("La sugerencia no ha sido aceptada, y por lo tanto no se puede rechazar");
    }
    this.aceptada = false;
    //this.aplicarSegunTipo(this, guardarropas); ESTOD EBERIA ELIMINARSE
  }

  public abstract void deshacer(GuardarropasCompartido guardarropasCompartido);

  //ublic abstract void aplicar(GuardarropasCompartido guardarropasCompartido);

  /*private void aplicarSegunTipo(Sugerencia sugerencia, Guardarropas guardarropas) {
    if(sugerencia.esDeTipo(TipoSugerencia.AGREGAR)) {
      guardarropas.guardarPrenda(sugerencia.getPrenda());
    }
    else
    {
      guardarropas.quitarPrenda(sugerencia.getPrenda());
    }
  }*/
}
