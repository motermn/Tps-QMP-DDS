package Sugerencias;

import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public class SugerenciaDeEliminacion extends Sugerencia{

  public SugerenciaDeEliminacion(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void aceptar(GuardarropasCompartido guardarropasCompartido) {
    super.aceptar(guardarropasCompartido);
    guardarropasCompartido.quitarPrenda(this.getPrenda());
  }

  @Override
  public void deshacer(GuardarropasCompartido guardarropasCompartido) {
    guardarropasCompartido.guardarPrenda(this.getPrenda());
  }
}
