package AlertasYNotificacionesObserver;

import Clima.Alerta;
import Usuarios.Usuario;

import java.util.List;

public class RecalculoDeAtuendoObserver implements InteresadoAlerta {
  public void notificarActualizacionDeAlertas(List<Alerta> alertas, Usuario usuario) {
    usuario.actualizarPropuestaDiariaDeAtuendoSegunAlertas(alertas);
  }
}
