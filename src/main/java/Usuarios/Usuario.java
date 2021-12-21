package Usuarios;

import AlertasYNotificacionesObserver.InteresadoAlerta;
import AsesorDeImagen.AsesorDeImagen;
import Clima.Alerta;
import Clima.ProveedorClima;
import Clima.ServicioMeteorologicoAccuWeatherApi;
import Exceptions.GuardarropasInvalidoException;
import Exceptions.InteresadoAlertaNoEncontradoException;
import Guardarropas.*;
import Prendas.Prenda;
import Sugerencias.Sugerencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Usuario {
  List<Guardarropas> guardarropasPropios;
  //List<Guardarropas> guardarropasCompartidosConOtrosUsuarios;
  List<Guardarropas> guardarropasCompartidosConmigo;
  Atuendo propuestaAtuendo;
  ProveedorClima proveedorClima; // TODO Ver si cambiar por Singleton (lo más probable)
  List<InteresadoAlerta> interesadosAlerta;
  String email;
  MailSender mailSender;

  // Debería validar no nulos en el constructor e interesados alerta
  public Usuario(ProveedorClima proveedorClima, String email, MailSender mailSender, InteresadoAlerta interesadoAlerta) {
    this.guardarropasCompartidosConmigo = new ArrayList<>();
    this.propuestaAtuendo = new Atuendo(null, null, null,null);
    this.proveedorClima = proveedorClima;
    this.interesadosAlerta = new ArrayList<>(Arrays.asList(interesadoAlerta));
    this.email = email;
    this.mailSender = mailSender;

  }

  public void crearGuardarropas() {
    Guardarropas guardarropasNuevo = new Guardarropas();
    this.guardarropasPropios.add(guardarropasNuevo);
  }

  // Este método sirve para compartirle al usuario un guardarropas
  public void compartir(Guardarropas guardarropas) {
    this.guardarropasCompartidosConmigo.add(guardarropas);
  }

  /*public void crearGuardarropasCompartido(List<Usuario> usuariosConAcceso) { // Ver esta parte
    GuardarropasCompartido guardarropasCompartido = new GuardarropasCompartido();
    usuariosConAcceso.forEach(usuario -> usuario.agregarGuardarropasCompartidoConmigo(guardarropasCompartido));
    this.guardarropasCompartidosConOtrosUsuarios.add(guardarropasCompartido);
  }

  public void agregarGuardarropasCompartidoConmigo(GuardarropasCompartido guardarropas) {
    guardarropasCompartidosConmigo.add(guardarropas);
  }*/

  public void sugerirAgregarPrenda(Prenda prenda, Guardarropas guardarropasCompartidoConmigo) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo); // Ver si esta línea se puede abstraer apra no repetirla
    guardarropasCompartidoConmigo.generarSugerenciaDeAgregado(prenda);
  }

  public void sugerirQuitarPrenda(Prenda prenda, Guardarropas guardarropasCompartidoConmigo) {
    this.validarCompartidoConmigo(guardarropasCompartidoConmigo);
    guardarropasCompartidoConmigo.generarSugerenciaDeEliminacion(prenda);
  }

  public void validarCompartidoConmigo(Guardarropas guardarropasCompartido) {
    if(!guardarropasCompartidosConmigo.contains(guardarropasCompartido)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas compartido conmigo");
    }
  }

  private void validarpropio(Guardarropas guardarropasPropio) {
    if(!guardarropasPropios.contains(guardarropasPropio)) {
      throw new GuardarropasInvalidoException("El guardarropas indicado no es un guardarropas propio");
    }
  }

  public void aceptarSugerencia(Sugerencia sugerencia, Guardarropas guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.aceptar(guardarropasPropioCompartido);
  }

  public void rechazarSugerencia(Sugerencia sugerencia, Guardarropas guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.rechazar(guardarropasPropioCompartido);
  }

  public void deshacerSugerencia(Sugerencia sugerencia, Guardarropas guardarropasPropioCompartido) {
    this.validarpropio(guardarropasPropioCompartido);
    sugerencia.deshacer(guardarropasPropioCompartido);
  }

  /* El usuario queda directamente acoplado al asesor de imagen, y esta dependencia podría parametrizarse en su constructor en
  * el caso de que dicho asesor apsara a ser un servicio externo. Opté por considerar que se limitará a un componente interno
  * al sistema.
  * */

  public void actualizarPropuestaDiariaDeAtuendoSegunTemperatura() {
    this.propuestaAtuendo = AsesorDeImagen.getInstance().sugerirUnAtuendoSegunTemperaturaDeEntreTodosLosGuardarropas(this.guardarropasPropios, this.proveedorClima);
  }

  public void actualizarPropuestaDiariaDeAtuendoSegunAlertas(List<Alerta> alertas) {
    /*
     * Acá se tomarán los guardarropas propios, y en base a un algoritmo (todavía desconocido y a implementar) se elegirá la
     * sugerencia de atuendo, modificando el atributo propuestaAtendo. Además se usará el atributo proveedorClima/singleton
     * Este método resuelve el requerimiento 1: Como usuarie de QueMePongo quiero tener una sugerencia diaria de qué ponerme y que
     * todas las mañanas, diariamente, esta sea actualizada
     */
    this.propuestaAtuendo = AsesorDeImagen.getInstance().sugerirAtuendoSegunAlertas(this.guardarropasPropios, alertas);
  }
  /*
  public void actualizarPropuestaDairiaDeAtuendo(Atuendo atuendo) {
    this.propuestaAtuendo = atuendo;
  }*/

  public void alertasNuevas(List<Alerta> alertas) {
    this.interesadosAlerta.stream().forEach(interesado -> interesado.notificarActualizacionDeAlertas(alertas, this));
  }

  public void enviarMail(String mensaje) {
    this.mailSender.enviarMail(this.email, mensaje);
  }

  public void agergarInteresadoAlerta(InteresadoAlerta interesadoAlerta) {
    this.interesadosAlerta.add(interesadoAlerta);
  }

  public void quitarInteresadoAlerta(InteresadoAlerta interesadoAlerta) {
    if(!this.interesadosAlerta.contains((interesadoAlerta))) {
      throw new InteresadoAlertaNoEncontradoException("La acción a realizar no se puede quitar");
    }
    this.interesadosAlerta.remove(interesadoAlerta);
  }
}
