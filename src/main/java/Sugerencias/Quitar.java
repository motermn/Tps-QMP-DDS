package Sugerencias;

import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public class Quitar implements TipoSugerencia{

  public void aceptar(Prenda prenda, GuardarropasCompartido guardarropas) {
    guardarropas.quitarPrenda(prenda);
  }

  public void deshacer(Prenda prenda, GuardarropasCompartido guardarropas) {
    guardarropas.guardarPrenda(prenda);
  }
}
