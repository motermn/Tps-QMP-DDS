package AlertasYNotificacionesObserver;

import Clima.Alerta;
import Usuarios.Usuario;

import java.util.List;

public interface InteresadoAlerta {
  void notificarActualizacionDeAlertas(List<Alerta> alertas, Usuario usuario); // Mensaje que desencadenará una serie de acciones correspondientes según el observador
}
