package AlertasYNotificacionesObserver;

import Clima.Alerta;
import Usuarios.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class NotificacionDeTipoDeAlertaPorMail implements InteresadoAlerta {
  public void notificarActualizacionDeAlertas(List<Alerta> alertas, Usuario usuario) {
    String alertasGeneradas = alertas.stream().map(alerta -> alerta.toString()).toString();
    usuario.enviarMail("Se han generado las siguientes alertas: ".concat(alertasGeneradas));
  }
}
