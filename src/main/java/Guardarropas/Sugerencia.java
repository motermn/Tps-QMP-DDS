package Guardarropas;

import Prendas.Prenda;

import java.security.Guard;

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

  public void aceptar(Guardarropas guardarropas) {
    // TODO
  }

  public void rechazar(Guardarropas guardarropas) {
    // TODO
  }

  public void deshacer(Guardarropas guardarropas) {
    // TODO
  }
}
