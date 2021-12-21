package Sugerencias;

import Guardarropas.Guardarropas;
import Prendas.Prenda;

public class SugerenciaDeAgregado extends Sugerencia{

  public SugerenciaDeAgregado(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void aceptar(Guardarropas guardarropasCompartido) {
    super.aceptar(guardarropasCompartido);
    guardarropasCompartido.guardarPrenda(this.getPrenda());
  }

  @Override
  public void deshacer(Guardarropas guardarropasCompartido) {
    guardarropasCompartido.quitarPrenda(this.getPrenda());
  }
}
