package Guardarropas;

import Exceptions.PrendaNoExistenteException;
import Prendas.Borrador;
import Prendas.Categoria;
import Prendas.Prenda;
import Sugerencias.Estado;
import Sugerencias.Sugerencia;
import Sugerencias.SugerenciaDeAgregado;
import Sugerencias.SugerenciaDeEliminacion;
import Uniformes.Uniforme;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Guardarropas {
     private List<Prenda> prendas;
     private List<Borrador> borradores;
     private List<Sugerencia> sugerencias;

     public Guardarropas() {
          this.prendas = new ArrayList<>();
          this.borradores = new ArrayList<>();
          this.sugerencias = new ArrayList<>();
     }

     public void guardarPrenda(Prenda prenda) {
          prendas.add(prenda); // No validé que la prenda no se haya cargado previamente
     }

     public void quitarPrenda(Prenda prenda) {
          this.validarQueSeaPrendaExistente(prenda);
          this.prendas.remove(prenda);
     }

     private void validarQueSeaPrendaExistente(Prenda prenda) {
          if(!this.prendas.contains(prenda)) {
               throw new PrendaNoExistenteException("La prenda que se desea quitar no pertenece al guardarropas");
          }
     }

     public void guardarBorrador(Borrador borrador) {
          borradores.add(borrador); // No validé que el borrador no se haya cargado previamente
     }

     public Optional<Prenda> sugerirPrendaQueCumpla(Categoria categoria, double temperatura) {
          return prendas.stream().filter(prenda -> prenda.acordeA(categoria, temperatura)).findAny();
     }

     public List<Uniforme> uniformesPosibles() {
          // TODO
          // Mismas consideraciones que para el método anterior
          return new ArrayList<Uniforme>();
     }

     public void agregarSugerencia(Sugerencia sugerencia) {
          this.sugerencias.add(sugerencia);
     }

     public void generarSugerenciaDeAgregado(Prenda prenda) {
          Sugerencia nuevaSugerenciaDeAgregado = new SugerenciaDeAgregado(prenda);
          this.agregarSugerencia(nuevaSugerenciaDeAgregado);
     }

     public void generarSugerenciaDeEliminacion(Prenda prenda) {
          Sugerencia nuevaSugerenciaDeEliminacion = new SugerenciaDeEliminacion(prenda);
          this.agregarSugerencia(nuevaSugerenciaDeEliminacion);
     }

     public List<Sugerencia> getSugerenciasPendientes() {
          List<Sugerencia> sugerenciasPendientes = this.getSugerencias().stream().filter(sugerencia -> sugerencia.tieneEstado(Estado.PENDIENTE)).collect(Collectors.toList());
          return sugerenciasPendientes;
     }

     private List<Sugerencia> getSugerencias() {
          return this.sugerencias;
     }
}
