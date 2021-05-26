package Sugerencias;

import Guardarropas.Guardarropas;
import Prendas.Prenda;

public class Agregar implements TipoSugerencia{

  public void aceptar(Prenda prenda, Guardarropas guardarropas) {
    guardarropas.guardarPrenda(prenda);
  }

  public void deshacer(Prenda prenda, Guardarropas guardarropas) {
    guardarropas.quitarPrenda(prenda);
  }
}
