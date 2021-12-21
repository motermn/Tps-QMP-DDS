package AlertasYNotificacionesObserver;

import Clima.Alerta;

public class TormentaObserver extends NotificacionDeAlertaPorApp{

  public TormentaObserver(NotificationService notificationService) {
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
