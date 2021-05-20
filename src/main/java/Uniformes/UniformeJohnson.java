package Uniformes;

import Prendas.*;

import java.time.temporal.Temporal;

public class UniformeJohnson extends UniformeInstitucional{

  @Override
  protected Prenda determinarParteInferior() {
    Borrador borradorPantalonDeVestir = new Borrador(TipoPrenda.pantalon());
    borradorPantalonDeVestir.cargarColorPrimario(new Color(0, 0, 0)); // Color negro
    borradorPantalonDeVestir.cargarMaterial(Material.GABARDINA);
    borradorPantalonDeVestir.cargarTrama(Trama.LISA);
    return borradorPantalonDeVestir.construirPrenda();
  }

  @Override
  protected Prenda determinarParteSuperior() {
    Borrador borradorCamisa = new Borrador(TipoPrenda.camisa());
    borradorCamisa.cargarColorPrimario(new Color(255, 255, 255)); // Color blanco
    borradorCamisa.cargarMaterial(Material.ALGODON);
    borradorCamisa.cargarTrama(Trama.LISA);
    return borradorCamisa.construirPrenda();
  }

  @Override
  protected Prenda determinarCalzado() {
    Borrador borradorCalzado = new Borrador(TipoPrenda.zapatos());
    borradorCalzado.cargarColorPrimario(new Color(0, 0, 0)); // Color negro
    borradorCalzado.cargarMaterial(Material.CUERO);
    borradorCalzado.cargarTrama(Trama.LISA);
    return borradorCalzado.construirPrenda();
  }
}
