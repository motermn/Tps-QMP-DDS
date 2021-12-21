package Usuarios;

import Clima.Alerta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioUsuarios {
  private static  final  RepositorioUsuarios INSTANCE = new RepositorioUsuarios();

  private List<Usuario> usuarios = new ArrayList<>();

  public static RepositorioUsuarios getInstance() {
    return INSTANCE;
  }

  public void agregarUsuario(Usuario usuario) {
    usuarios.add(usuario);
  }

  public List<Usuario> getUsuarios() {
    return this.usuarios;
  }

  /*ublic void actualizarPropuestasDiariasDeAtuendosSegunAlertas() {
    this.usuarios.stream().forEach(usuario -> usuario.actualizarPropuestaDiariaDeAtuendoSegunAlertas());
  }*/

  public void huboActualizacionDeAlertas(List<Alerta> alertas) {
    this.getUsuarios().stream().forEach(usuario -> usuario.alertasNuevas(alertas));
  }
}







