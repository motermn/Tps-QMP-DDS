package Sugerencias;

import Guardarropas.Guardarropas;
import Prendas.Prenda;

public interface TipoSugerencia {
  void aceptar(Prenda prenda, Guardarropas guardarropas);
  void deshacer(Prenda prenda, Guardarropas guardarropas);
}
