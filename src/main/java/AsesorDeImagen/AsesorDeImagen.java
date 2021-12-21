package AsesorDeImagen;

import Clima.Alerta;
import Clima.ProveedorClima;
import Guardarropas.Atuendo;
import Guardarropas.Guardarropas;
import Prendas.Categoria;
import Prendas.Prenda;
import Usuarios.RepositorioUsuarios;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AsesorDeImagen {
  /*private ProveedorClima proveedorClima;

  public AsesorDeImagen(ProveedorClima proveedorClima) {
    this.proveedorClima = proveedorClima;
  }

  public void setProveedorClima(ProveedorClima proveedorClima) {
    this.proveedorClima = proveedorClima;
  }
*/

  private static  final AsesorDeImagen INSTANCE = new AsesorDeImagen();

  public static AsesorDeImagen getInstance() {
    return INSTANCE;
  }

  private Atuendo sugerirAtuendoSegunTemperaturaParaUnGuardarropas(Guardarropas guardarropas, ProveedorClima proveedorClima) {
    double temperatura = proveedorClima.getTemperatura();
    Optional<Prenda> prendaSuperior = guardarropas.sugerirPrendaQueCumpla(Categoria.PARTE_SUPERIOR, temperatura);
    Optional<Prenda> prendaInferior = guardarropas.sugerirPrendaQueCumpla(Categoria.PARTE_INFERIOR, temperatura);
    Optional<Prenda> calzado = guardarropas.sugerirPrendaQueCumpla(Categoria.CALZADO, temperatura);
    Optional<Prenda> accesorio = guardarropas.sugerirPrendaQueCumpla(Categoria.ACCESORIO, temperatura);
    return new Atuendo(prendaSuperior, prendaInferior, calzado, accesorio);
  }

  public Atuendo sugerirUnAtuendoSegunTemperaturaDeEntreTodosLosGuardarropas(List<Guardarropas> guardarropas, ProveedorClima proveedorClima) {
    List<Atuendo> atuendosSugeridos = guardarropas.stream().map(unGuardarropas -> this.sugerirAtuendoSegunTemperaturaParaUnGuardarropas(unGuardarropas, proveedorClima)).collect(Collectors.toList());
    Atuendo elAtuendoElegido = this.elegirUnAtuendo(atuendosSugeridos);
    return elAtuendoElegido;
  }

  private Atuendo elegirUnAtuendo(List<Atuendo> atuendos) {
    // Acá podría elegirse un atuendo en base a un criterio o aleatoriamente (no se sabe todavía)
    return new Atuendo(null, null, null, null);
  }

  public Atuendo sugerirAtuendoSegunAlertas(List<Guardarropas> guardarropas, List<Alerta> alertas) {
    // TODO El algoritmo de sugerencia no se conoce
    return new Atuendo(null, null, null, null);
  }
}
