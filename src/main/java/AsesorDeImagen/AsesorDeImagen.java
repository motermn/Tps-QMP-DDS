package AsesorDeImagen;

import Clima.ProveedorClima;
import Guardarropas.Atuendo;
import Guardarropas.Guardarropas;
import Prendas.Categoria;
import Prendas.Prenda;

import java.util.Optional;

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
    Optional<Prenda> prendaSuperior = guardarropas.sugerirPrendaQueCumpla(Categoria.PARTE_SUPERIOR, temperatura);
    Optional<Prenda> prendaInferior = guardarropas.sugerirPrendaQueCumpla(Categoria.PARTE_INFERIOR, temperatura);
    Optional<Prenda> calzado = guardarropas.sugerirPrendaQueCumpla(Categoria.CALZADO, temperatura);
    Optional<Prenda> accesorio = guardarropas.sugerirPrendaQueCumpla(Categoria.ACCESORIO, temperatura);
    return new Atuendo(prendaSuperior, prendaInferior, calzado, accesorio);
  }
}
