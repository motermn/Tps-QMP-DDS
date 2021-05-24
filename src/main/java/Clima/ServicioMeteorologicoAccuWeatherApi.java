package Clima;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoAccuWeatherApi implements ProveedorClima {

  private AccuWeatherAPI miApi;
  private Map<String, Object> ultimasRespuestas;
  private Duration periodoDeValidez;
  private LocalDateTime proximaExpiracion;

  public ServicioMeteorologicoAccuWeatherApi() {
    this.miApi = new AccuWeatherAPI();
    this.ultimasRespuestas = new HashMap<String, Object>();
    this.periodoDeValidez = Duration.ofMinutes(150);
    this.proximaExpiracion = LocalDateTime.now();
  }

  public Map<String, Object> climaSegunAPISeleccionada() {
    if(this.expiro()) {
      this.ultimasRespuestas = miApi.getWeather("Buenos Aires, Argentina").get(0);
      this.proximaExpiracion = this.proximaExpiracion();
    }
    return ultimasRespuestas;
  }

  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  private boolean expiro() {
    return proximaExpiracion.isBefore((LocalDateTime.now()));
  }

  public double getTemperatura(){
    HashMap<String, Object> temp = (HashMap<String, Object>) climaSegunAPISeleccionada().get("Temperature");
    return (double) temp.get("Value");
  }
}