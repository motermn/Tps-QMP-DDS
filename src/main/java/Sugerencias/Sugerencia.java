package Sugerencias;

import Exceptions.SugerenciaAceptadaException;
import Exceptions.SugerenciaNoAceptadaException;
import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public class Sugerencia {
  private Prenda prenda;
  private TipoSugerencia tipoSugerencia;
  private boolean aceptada;

  public Sugerencia(Prenda prenda, TipoSugerencia tipoSugerencia) {
    this.prenda = prenda;
    this.tipoSugerencia = tipoSugerencia;
    this.aceptada = false;
  }

  public boolean esDeTipo(TipoSugerencia tipoSugerencia) {
    return this.tipoSugerencia.equals(tipoSugerencia);
  }

  public Prenda getPrenda() {
    return this.prenda;
  }

  public void aceptar(GuardarropasCompartido guardarropas) {
    if(this.aceptada) {
      throw new SugerenciaAceptadaException("La sugerencia ya ha sido aceptada");
    }
    this.aceptada = true;
    //this.aplicarSegunTipo(this, guardarropas);
    this.tipoSugerencia.aceptar(this.getPrenda(), guardarropas);
  }

  public void rechazar(/*Guardarropas guardarropas*/) {
    if(!this.aceptada) {
      throw new SugerenciaNoAceptadaException("La sugerencia no ha sido aceptada, y por lo tanto no se puede rechazar");
    }
    this.aceptada = false;
    //this.aplicarSegunTipo(this, guardarropas);
  }

  public void deshacer(GuardarropasCompartido guardarropas) {
    this.tipoSugerencia.deshacer(this.getPrenda(), guardarropas);
  }

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
