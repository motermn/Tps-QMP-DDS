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

  public void crearGuardarropasCompartido(List<Usuario> usuariosConAcceso) { // ver esta parte
    GuardarropasCompartido guardarropasCompartido = new GuardarropasCompartido();
    usuariosConAcceso.forEach(usuario -> usuario.agregarGuardarropasCompartidoConmigo(guardarropasCompartido));
    this.guardarropasCompartidosConOtrosUsuarios.add(guardarropasCompartido);
  }

  public void agregarGuardarropasCompartidoConmigo(GuardarropasCompartido guardarropas) {
    guardarropasCompartidosConmigo.add(guardarropas);
  }
/*
  private void generarSugerencia(Prenda prenda, GuardarropasCompartido guardarropasCompartidoConmigo, TipoSugerencia tipoSugerencia) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo);
    Sugerencia sugerencia = new Sugerencia(prenda, tipoSugerencia);
    guardarropasCompartidoConmigo.agregarSugerencia(sugerencia);
  }*/

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

  // pasa referencia de sugerencia, no indice
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
