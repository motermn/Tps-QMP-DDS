package AsesorDeImagen;

import Clima.ProveedorClima;
import Guardarropas.Atuendo;
import Guardarropas.Guardarropas;

public class AsesorDeImagen {
  private ProveedorClima proveedorClima;

  public AsesorDeImagen(ProveedorClima proveedorClima) {
    this.proveedorClima = proveedorClima;
  }

  public void setProveedorClima(ProveedorClima proveedorClima) {
    this.proveedorClima = proveedorClima;
  }

  public Atuendo sugerirAtuendo(Guardarropas guardarropas) {
    double temperatura = proveedorClima.getTemperatura();
    Atuendo atuendoDeSugrencia = guardarropas.recibirSugerencia(temperatura);
    return atuendoDeSugrencia;
  }
}
