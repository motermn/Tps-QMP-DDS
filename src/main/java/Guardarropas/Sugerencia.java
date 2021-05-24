package Guardarropas;

import Prendas.Prenda;

public class Sugerencia {
  private Prenda prenda;
  private TipoSugerencia tipoSugerencia;

  public Sugerencia(Prenda prenda, TipoSugerencia tipoSugerencia) {
    this.prenda = prenda;
    this.tipoSugerencia = tipoSugerencia;
  }

  public boolean esDeTipo(TipoSugerencia tipoSugerencia) {
    return this.tipoSugerencia.equals(tipoSugerencia);
  }

  public void aceptar() {

  }

  public void rechazar() {

  }

  public void deshacer() {

  }
}
