package Usuarios;

import Exceptions.GuardarropasInvalidoException;
import Guardarropas.*;
import Prendas.Prenda;
import Sugerencias.Agregar;
import Sugerencias.Quitar;
import Sugerencias.Sugerencia;
import Sugerencias.TipoSugerencia;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  List<Guardarropas> guardarropasPropios;
  List<GuardarropasCompartido> guardarropasCompartidosConOtrosUsuarios;
  List<GuardarropasCompartido> guardarropasCompartidosConmigo;

  public Usuario() {
    this.guardarropasPropios = new ArrayList<>();
    this.guardarropasCompartidosConmigo = new ArrayList<>();
  }

  public void crearGuardarropasPropio() {
    Guardarropas guardarropasNuevo = new Guardarropas();
    this.guardarropasPropios.add(guardarropasNuevo);
  }

  public void crearGuardarropasCompartido(List<Usuario> usuariosConAcceso) {
    GuardarropasCompartido guardarropasCompartido = new GuardarropasCompartido();
    usuariosConAcceso.forEach(usuario -> usuario.agregarGuardarropasCompartidoConmigo(guardarropasCompartido));
    this.guardarropasCompartidosConOtrosUsuarios.add(guardarropasCompartido);
  }

  public void agregarGuardarropasCompartidoConmigo(GuardarropasCompartido guardarropas) {
    guardarropasCompartidosConmigo.add(guardarropas);
  }

  private void generarSugerencia(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo, TipoSugerencia tipoSugerencia) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo);
    Sugerencia sugerencia = new Sugerencia(prenda, tipoSugerencia);
    guardarropasCompartidoConmigo.agregarSugerencia(sugerencia);
  }

  public void sugerirAgregarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.generarSugerencia(prenda, guardarropasCompartidoConmigo, new Agregar());
  }

  public void sugerirQuitarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.generarSugerencia(prenda, guardarropasCompartidoConmigo, new Quitar());
  }

  public void validarCompartidoConmigo(GuardarropasCompartido guardarropasCompartido) {
    if(!guardarropasCompartidosConmigo.contains(guardarropasCompartido)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas compartido conmigo");
    }
  }
// Acá hice que sea posible distinguir entre los dos tipos de sugerencias, pero esto me trajo problemas luego apra aceptar o rechazar y me evitaba tener una posible resolución como la que está ahora, con polimorfismo
  /*private List<Sugerencia> visualizarSugerencias(Guardarropas guardarropasPropio, TipoSugerencia tipoSugerencia) {
    this.validarpropio(guardarropasPropio);
    return guardarropasPropio.sugerenciasSegun(tipoSugerencia);
  }

  public List<Sugerencia> visualizarSugerenciasParaAgregarPrendas(Guardarropas guardarropasPropio) {
    return this.visualizarSugerencias(guardarropasPropio, TipoSugerencia.AGREGAR);
  }

  public List<Sugerencia> visualizarSugerenciasParaQuitarPrendas(Guardarropas guardarropasPropio) {
    return this.visualizarSugerencias(guardarropasPropio, TipoSugerencia.QUITAR);
  }*/

  private void validarpropio(Guardarropas guardarropasPropio) {
    if(!guardarropasPropios.contains(guardarropasPropio)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas propio");
    }
  }

  public void aceptarSugerencia(int indiceSugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    guardarropasPropioCompartido.aceptar(indiceSugerencia);
  }

  public void rechazarSugerencia(int indiceSugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    guardarropasPropioCompartido.rechazar(indiceSugerencia);
  }

  public void deshacerSugerencia(int indiceSugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    guardarropasPropioCompartido.deshacer(indiceSugerencia);
  }
}
