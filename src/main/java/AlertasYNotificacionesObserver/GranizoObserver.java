package AlertasYNotificacionesObserver;

import Clima.Alerta;

public class GranizoObserver extends NotificacionDeAlertaPorApp{

  public GranizoObserver(NotificationService notificationService) {
    super(notificationService);
  }

  @Override
  protected String message() {
    return "Hay alerta de Tormenta.";
  }

  @Override
  protected Alerta alerta() {
    return Alerta.TORMENTA;
  }
}
