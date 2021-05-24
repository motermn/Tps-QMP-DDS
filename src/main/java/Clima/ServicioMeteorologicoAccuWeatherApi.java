package Clima;

import java.util.HashMap;
import java.util.Map;

public class ServicioMeteorologicoAccuWeatherApi implements ProveedorClima {

  AccuWeatherAPI miApi = new AccuWeatherAPI();

  public Map<String, Object> climaSegunAPISeleccionada() {
    //miApi.controlarCantidadMaximaDeConsultas();
    return miApi.getWeather("Buenos Aires, Argentina").get(0);
  }

  public double getTemperatura(){
    HashMap<String, Object> temp = (HashMap<String, Object>) climaSegunAPISeleccionada().get("Temperature");
    return (double) temp.get("Value");
  }
}