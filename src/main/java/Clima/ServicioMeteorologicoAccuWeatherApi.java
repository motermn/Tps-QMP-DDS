package Clima;

import Usuarios.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Está modelado como un Singleton

public class ServicioMeteorologicoAccuWeatherApi implements ProveedorClima {

  private static final ServicioMeteorologicoAccuWeatherApi INSTANCE = new ServicioMeteorologicoAccuWeatherApi();
  private AccuWeatherAPI miApi;
  List<Alerta> alertas;

  public static ServicioMeteorologicoAccuWeatherApi getInstance() {
    return INSTANCE;
  }

  //private Map<String, Object> ultimasRespuestas;
  //private Duration periodoDeValidez;
  //private LocalDateTime proximaExpiracion;

  public ServicioMeteorologicoAccuWeatherApi() {
    this.miApi = new AccuWeatherAPI();
    this.alertas = new ArrayList<>();
    //this.ultimasRespuestas = new HashMap<String, Object>();
    //this.periodoDeValidez = Duration.ofMinutes(150);
    //this.proximaExpiracion = LocalDateTime.now();
  }
/*
  public Map<String, Object> climaSegunAPISeleccionada() {
    if(this.expiro()) {
      this.ultimasRespuestas = miApi.getWeather("Buenos Aires, Argentina").get(0);
      this.proximaExpiracion = this.proximaExpiracion();
    }
    return ultimasRespuestas;
  }*/
/*
  private LocalDateTime proximaExpiracion() {
    return LocalDateTime.now().plus(this.periodoDeValidez);
  }

  //private boolean expiro() {
    return proximaExpiracion.isBefore((LocalDateTime.now()));
  }*/

  public double getTemperatura(){
    HashMap<String, Object> temp = (HashMap<String, Object>) miApi.getWeather("Buenos Aires, Argentina").get(0).get("Temperature");
    return (double) temp.get("Value");
  }
 // Acá estarían cubiertos los requerimientos 4 y 5
  public void actualizarAlertas() {
    this.alertas = this.convertirAlertas(this.miApi.getAlertas("Buenos Aires"));
    // Acá estaría cubierto el requerimiento 5
    RepositorioUsuarios.getInstance().huboActualizacionDeAlertas(this.getAlertas());
  }

  // Acá estaría cubierto el requerimiento 3
  public List<Alerta> getAlertas() {
    return this.alertas;
  }

  private List<Alerta> convertirAlertas(List<String> alertasDeApi) {
    return new ArrayList<>();
  }
}