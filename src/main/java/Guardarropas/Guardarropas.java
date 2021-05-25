package Guardarropas;

import Prendas.Borrador;
import Prendas.Categoria;
import Prendas.Prenda;
import Uniformes.Uniforme;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Guardarropas {
     private List<Prenda> prendas;
     private List<Borrador> borradores;
     private List<Sugerencia> sugerencias;

     public Guardarropas() {
          prendas = new ArrayList<>();
          borradores = new ArrayList<>();
     }

     public void guardarPrenda(Prenda prenda) {
          prendas.add(prenda); // No validé que la prenda no se haya cargado previamente
     }

     public void guardarBorrador(Borrador borrador) {
          borradores.add(borrador); // No validé que el borrador no se haya cargado previamente
     }

     public Optional<Prenda> sugerirPrendaQueCumpla(Categoria categoria, double temperatura) {
          return prendas.stream().filter(prenda -> prenda.acordeA(categoria, temperatura)).findAny();
     }

     List<Uniforme> uniformesPosibles() {
          // TODO
          // Mismas consideraciones que para el método anterior
          return new ArrayList<Uniforme>();
     }

     public void agregarSugerencia(Sugerencia sugerencia) {
          this.sugerencias.add(sugerencia);
     }

     public List<Sugerencia> getSugerencias() {
          return sugerencias;
     }

     public List<Sugerencia> sugerenciasSegun(TipoSugerencia tipoSugerencia) {
          return sugerencias.stream().filter(sugerencia -> sugerencia.esDeTipo(tipoSugerencia)).collect(Collectors.toList());
     }

     public void aceptar(int indiceSugerencia) {
          Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
          sugerencia.aceptar(this);
     }

     public void rechazar(int indiceSugerencia) {
          Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
          sugerencia.rechazar(this);
     }

     public void deshacer(int indiceSugerencia) {
          Sugerencia sugerencia = sugerencias.get(indiceSugerencia);
          sugerencia.deshacer(this);
     }

}
