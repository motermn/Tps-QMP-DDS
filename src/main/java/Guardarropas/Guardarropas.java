package Guardarropas;

import Prendas.Prenda;
import Uniformes.Uniforme;
import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
     private List<Prenda> prendas;

     public Guardarropas() {
          prendas = new ArrayList<>();
     }

     List<Atuendo> atuendosPosibles() {
          // TODO
          // El tipo y cantidad de parámetros de este método dependerá de cómo se va a determinar cada combinación, pero seguramente tomará la lista de prendas para tal acción
          return new ArrayList<Atuendo>();
     }

     List<Uniforme> uniformesPosibles() {
          // TODO
          // Mismas consideraciones que para el método anterior
          return new ArrayList<Uniforme>();
     }
}


