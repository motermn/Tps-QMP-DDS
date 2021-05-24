package Guardarropas;

import Prendas.Borrador;
import Prendas.Categoria;
import Prendas.Prenda;
import Uniformes.Uniforme;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Guardarropas {
     private List<Prenda> prendas;
     private List<Borrador> borradores;

     public Guardarropas() {
          prendas = new ArrayList<>();
          borradores = new ArrayList<>();
     }

     public void guardarPrenda(Prenda prenda) {
          prendas.add(prenda); // No validé que la prenda no se haya cargado previamente
     }

     public void agregarBorrador(Borrador borrador) {
          borradores.add(borrador); // No validé que el borrador no se haya cargado previamente
     }

     public Atuendo recibirSugerencia(double temperatura) {
          Optional<Prenda> prendaSuperior = this.sugerir(Categoria.PARTE_SUPERIOR, temperatura);
          Optional<Prenda> prendaInferior = this.sugerir(Categoria.PARTE_INFERIOR, temperatura);
          Optional<Prenda> calzado = this.sugerir(Categoria.CALZADO, temperatura);
          Optional<Prenda> accesorio = this.sugerir(Categoria.ACCESORIO, temperatura);
          return new Atuendo(prendaSuperior, prendaInferior, calzado, accesorio);
     }

     private Optional<Prenda> sugerir (Categoria categoria, double temperatura) {
          return prendas.stream().filter(prenda -> prenda.acordeA(categoria, temperatura)).findAny();
     }

     List<Uniforme> uniformesPosibles() {
          // TODO
          // Mismas consideraciones que para el método anterior
          return new ArrayList<Uniforme>();
     }
}
