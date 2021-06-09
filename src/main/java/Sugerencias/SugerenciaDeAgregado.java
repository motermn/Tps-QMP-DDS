package Sugerencias;

import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public class SugerenciaDeAgregado extends Sugerencia{

  public SugerenciaDeAgregado(Prenda prenda) {
    super(prenda);
  }

  @Override
  public void aceptar(GuardarropasCompartido guardarropasCompartido) {
    super.aceptar(guardarropasCompartido);
    guardarropasCompartido.guardarPrenda(this.getPrenda());
  }

  @Override
  public void deshacer(GuardarropasCompartido guardarropasCompartido) {
    guardarropasCompartido.quitarPrenda(this.getPrenda());
  }
}
