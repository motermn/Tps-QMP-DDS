package Guardarropas;

import Sugerencias.Sugerencia;
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

  public List<Sugerencia> getSugerencias() {
    return sugerencias;
  }

     /*public List<Sugerencia> sugerenciasSegun(TipoSugerencia tipoSugerencia) {
          return sugerencias.stream().filter(sugerencia -> sugerencia.esDeTipo(tipoSugerencia)).collect(Collectors.toList());
     }*/

  public void aceptar(int indiceSugerencia) {
    Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
    sugerencia.aceptar(this);
  }

  public void rechazar(int indiceSugerencia) {
    Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
    sugerencia.rechazar(this);
  }

  public void deshacer(int indiceSugerencia) {
    Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
    sugerencia.deshacer(this);
  }
}
