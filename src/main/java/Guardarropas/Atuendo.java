package Guardarropas;

import Prendas.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
    Prenda prendaSuperior;
    Prenda prendaInferior;
    Prenda calzado;
    Prenda accesorio;

    public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado, Prenda accesorio) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.accesorio = accesorio;
    }
}
