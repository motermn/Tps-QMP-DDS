package Usuarios;

import Exceptions.GuardarropasInvalidoException;
import Guardarropas.*;
import Prendas.Prenda;

import java.security.Guard;
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
    usuariosConAcceso.forEach(usuario -> usuario.setGuardarropasCompartidosConmigo(guardarropasCompartido));
    this.guardarropasCompartidosConOtrosUsuarios.add(guardarropasCompartido);
  }

  public void setGuardarropasCompartidosConmigo(GuardarropasCompartido guardarropas) {
    guardarropasCompartidosConmigo.add(guardarropas);
  }

  private void generarSugerencia(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo, TipoSugerencia tipoSugerencia) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo);
    Sugerencia sugerencia = new Sugerencia(prenda, tipoSugerencia);
    guardarropasCompartidoConmigo.agregarSugerencia(sugerencia);
  }

  public void sugerirAgregarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.generarSugerencia(prenda, guardarropasCompartidoConmigo, TipoSugerencia.AGREGAR);
  }

  public void sugerirQuitarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.generarSugerencia(prenda, guardarropasCompartidoConmigo, TipoSugerencia.QUITAR);
  }

  public void validarCompartidoConmigo(GuardarropasCompartido guardarropasCompartido) {
    if(!guardarropasCompartidosConmigo.contains(guardarropasCompartido)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas compartido conmigo");
    }
  }

  public List<Sugerencia> visualizarSugerencias(Guardarropas guardarropasPropio, TipoSugerencia tipoSugerencia) {
    this.validarpropio(guardarropasPropio);
    return guardarropasPropio.sugerenciasSegun(tipoSugerencia);
  }

  public List<Sugerencia> visualizarSugerenciasParaAgregarPrendas(Guardarropas guardarropasPropio) {
    return this.visualizarSugerencias(guardarropasPropio, TipoSugerencia.AGREGAR);
  }

  public List<Sugerencia> visualizarSugerenciasParaQuitarPrendas(Guardarropas guardarropasPropio) {
    return this.visualizarSugerencias(guardarropasPropio, TipoSugerencia.QUITAR);
  }

  private void validarpropio(Guardarropas guardarropasPropio) {
    if(!guardarropasPropios.contains(guardarropasPropio)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas propio");
    }
  }

}
