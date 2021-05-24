package Guardarropas;

import Prendas.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Atuendo {
    Optional <Prenda> prendaSuperior;
    Optional <Prenda> prendaInferior;
    Optional <Prenda> calzado;
    Optional <Prenda> accesorio;

    public Atuendo(Optional <Prenda> prendaSuperior, Optional <Prenda> prendaInferior, Optional <Prenda> calzado, Optional <Prenda> accesorio) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
    }
}
