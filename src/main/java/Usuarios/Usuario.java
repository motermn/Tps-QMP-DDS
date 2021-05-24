package Usuarios;

import Exceptions.GuardarropasInvalidoException;
import Guardarropas.*;
import Prendas.Prenda;

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

  /*public void proponerAgregarPrendaAGaurdarropas(Prenda prenda, GuardarropasCompartido guardarropasCompartidoC) {

  }*/

}
