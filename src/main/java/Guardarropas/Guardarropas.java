package Guardarropas;

import Prendas.Categoria;
import Prendas.Prenda;
import Uniformes.Uniforme;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Guardarropas {
     private List<Prenda> prendas;

     public Guardarropas() {
          prendas = new ArrayList<>();
     }

     public void agregarPrenda(Prenda prenda) {
          prendas.add(prenda); // No validé que la prenda no se haya cargado previamente
     }

     public Atuendo recibirSugerencia(double temperatura) {
          Prenda prendaSuperior = this.sugerir(Categoria.PARTE_SUPERIOR, temperatura);
          Prenda prendaInferior = this.sugerir(Categoria.PARTE_INFERIOR, temperatura);
          Prenda calzado = this.sugerir(Categoria.CALZADO, temperatura);
          Prenda accesorio = this.sugerir(Categoria.ACCESORIO, temperatura);
          return new Atuendo(prendaSuperior, prendaInferior, calzado, accesorio);
     }

     private Prenda sugerir (Categoria categoria, double temperatura) {
          return prendas.stream().findAny(prenda -> prenda.acordeA(categoria, temperatura));
     }

     List<Uniforme> uniformesPosibles() {
          // TODO
          // Mismas consideraciones que para el método anterior
          return new ArrayList<Uniforme>();
     }
}


