package Sugerencias;

import Guardarropas.Guardarropas;
import Prendas.Prenda;

public class SugerenciaDeEliminacion extends Sugerencia{

  public SugerenciaDeEliminacion(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void aceptar(Guardarropas guardarropasCompartido) {
    super.aceptar(guardarropasCompartido);
    guardarropasCompartido.quitarPrenda(this.getPrenda());
  }

  @Override
  public void deshacer(Guardarropas guardarropasCompartido) {
    guardarropasCompartido.guardarPrenda(this.getPrenda());
  }
}
