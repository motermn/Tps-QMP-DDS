package Sugerencias;

import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public class Agregar implements TipoSugerencia{

  public void aceptar(Prenda prenda, GuardarropasCompartido guardarropas) {
    guardarropas.guardarPrenda(prenda);
  }

  public void deshacer(Prenda prenda, GuardarropasCompartido guardarropas) {
    guardarropas.quitarPrenda(prenda);
  }
}
