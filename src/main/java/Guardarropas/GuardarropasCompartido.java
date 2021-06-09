package Guardarropas;

import Prendas.Prenda;
import Sugerencias.Sugerencia;
import Sugerencias.SugerenciaDeAgregado;
import Sugerencias.SugerenciaDeEliminacion;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GuardarropasCompartido extends Guardarropas{
  private List<Sugerencia> sugerencias;

  public GuardarropasCompartido() {
    super();
    this.sugerencias = new ArrayList<>();
  }

  public void agregarSugerencia(Sugerencia sugerencia) {
    this.sugerencias.add(sugerencia);
  }

  public void generarSugerenciaDeAgregado(Prenda prenda) {
    Sugerencia nuevaSugerenciaDeAgregado = new SugerenciaDeAgregado(prenda);
    this.agregarSugerencia(nuevaSugerenciaDeAgregado);
  }

  public void generarSugerenciaDeEliminacion(Prenda prenda) {
    Sugerencia nuevaSugerenciaDeEliminacion = new SugerenciaDeEliminacion(prenda);
    this.agregarSugerencia(nuevaSugerenciaDeEliminacion);
  }

  public List<Sugerencia> getSugerencias() {
    return sugerencias;
  }
}
