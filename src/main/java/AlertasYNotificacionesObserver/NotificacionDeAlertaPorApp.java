package AlertasYNotificacionesObserver;

import Clima.Alerta;
import Usuarios.Usuario;

import java.util.List;

public abstract class NotificacionDeAlertaPorApp implements InteresadoAlerta{
  protected NotificationService notificationService;

  public NotificacionDeAlertaPorApp(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  public void notificarActualizacionDeAlertas(List<Alerta> alertas, Usuario usuario) {
    if(alertas.contains(this.alerta())) {
      notificationService.notify(this.message());
    }
  }

  protected abstract String message();

  protected abstract Alerta alerta();
}
