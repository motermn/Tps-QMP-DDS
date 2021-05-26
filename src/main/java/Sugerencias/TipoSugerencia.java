package Sugerencias;

import Guardarropas.GuardarropasCompartido;
import Prendas.Prenda;

public interface TipoSugerencia {
  void aceptar(Prenda prenda, GuardarropasCompartido guardarropas);
  void deshacer(Prenda prenda, GuardarropasCompartido guardarropas);
}
