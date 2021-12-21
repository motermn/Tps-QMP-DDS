package Sugerencias;

import Exceptions.SugerenciaAceptadaException;
import Exceptions.SugerenciaRechazadaException;
import Guardarropas.Guardarropas;
import Prendas.Prenda;

public abstract class Sugerencia {
  private Prenda prenda;
  private Estado estado;

  public Sugerencia(Prenda prenda) {
    this.prenda = prenda;
    this.estado = Estado.PENDIENTE;
  }

  public Prenda getPrenda() {
    return this.prenda;
  }

  public boolean tieneEstado(Estado estado) {
    return this.estado.equals(estado);
  }

  public void aceptar(Guardarropas guardarropasCompartido) {
    if(this.tieneEstado(Estado.ACEPTADO)) {
      throw new SugerenciaAceptadaException("La sugerencia ya ha sido aceptada");
    }
    this.cambiarEstadoA(Estado.ACEPTADO);
  }

  private void cambiarEstadoA(Estado nuevoEstado) {
    this.estado = nuevoEstado;
  }

  public void rechazar(Guardarropas guardarropasCompartido) {
    if(this.tieneEstado(Estado.RECHAZADO)) {
      throw new SugerenciaRechazadaException("La sugerencia ya ha sido rechazada, y por lo tanto no se puede rechazar");
    }
    this.cambiarEstadoA(Estado.RECHAZADO);
  }

  public abstract void deshacer(Guardarropas guardarropasCompartido);

}
