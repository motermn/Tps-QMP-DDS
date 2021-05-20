package Uniformes;

import Prendas.*;

public class UniformeSanJuan extends UniformeInstitucional {

  @Override
  protected Prenda determinarParteInferior() {
    Borrador borradorPantalon = new Borrador(TipoPrenda.pantalon());
    borradorPantalon.cargarColorPrimario(new Color(155, 155, 155)); // Color gris
    borradorPantalon.cargarMaterial(Material.ACETATO);
    borradorPantalon.cargarTrama(Trama.LISA);
    return borradorPantalon.construirPrenda();
  }

  @Override
  protected Prenda determinarParteSuperior() {
    Borrador borradorChomba = new Borrador(TipoPrenda.chomba());
    borradorChomba.cargarColorPrimario(new Color(0, 153, 57)); // Color verde
    borradorChomba.cargarMaterial(Material.PIQUE);
    // No se setea la trama entonces se defaultea como LISA
    return borradorChomba.construirPrenda();
  }

  @Override
  protected Prenda determinarCalzado() {
    Borrador borradorCalzado = new Borrador(TipoPrenda.zapatillas());
    borradorCalzado.cargarColorPrimario(new Color(255, 255, 255)); // Color blanco
    borradorCalzado.cargarMaterial(Material.LONA);
    borradorCalzado.cargarTrama(Trama.LISA);
    return borradorCalzado.construirPrenda();
  }
}
