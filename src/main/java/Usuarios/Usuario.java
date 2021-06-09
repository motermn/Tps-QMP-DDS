package Usuarios;

import Exceptions.GuardarropasInvalidoException;
import Guardarropas.*;
import Prendas.Prenda;
import Sugerencias.Sugerencia;

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

  public void crearGuardarropasCompartido(List<Usuario> usuariosConAcceso) { // Ver esta parte
    GuardarropasCompartido guardarropasCompartido = new GuardarropasCompartido();
    usuariosConAcceso.forEach(usuario -> usuario.agregarGuardarropasCompartidoConmigo(guardarropasCompartido));
    this.guardarropasCompartidosConOtrosUsuarios.add(guardarropasCompartido);
  }

  public void agregarGuardarropasCompartidoConmigo(GuardarropasCompartido guardarropas) {
    guardarropasCompartidosConmigo.add(guardarropas);
  }

  public void sugerirAgregarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo); // Ver si esta línea se puede abstraer apra no repetirla
    guardarropasCompartidoConmigo.generarSugerenciaDeAgregado(prenda);
  }

  public void sugerirQuitarPrenda(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo);
    guardarropasCompartidoConmigo.generarSugerenciaDeEliminacion(prenda);
  }

  public void validarCompartidoConmigo(GuardarropasCompartido guardarropasCompartido) {
    if(!guardarropasCompartidosConmigo.contains(guardarropasCompartido)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas compartido conmigo");
    }
  }

  private void validarpropio(Guardarropas guardarropasPropio) {
    if(!guardarropasPropios.contains(guardarropasPropio)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas propio");
    }
  }

  public void aceptarSugerencia(Sugerencia sugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.aceptar(guardarropasPropioCompartido);
  }

  public void rechazarSugerencia(Sugerencia sugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.rechazar(guardarropasPropioCompartido);
  }

  public void deshacerSugerencia(Sugerencia sugerencia, GuardarropasCompartido guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.deshacer(guardarropasPropioCompartido);
  }
}
