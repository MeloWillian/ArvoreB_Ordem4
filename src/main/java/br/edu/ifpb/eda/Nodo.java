package br.edu.ifpb.eda;

import java.util.ArrayList;
import java.util.Collections;

public class Nodo {
    ArrayList<Integer> listaElementos;
    ArrayList<Nodo> listaFilhos;
    Nodo pai;

    public Nodo() {
        this.listaElementos = new ArrayList<>(4);
        this.listaFilhos = new ArrayList<>(4);
        this.pai = null;
    }

    public Nodo getPai() {
        return this.pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }

    public void inserirElemento(Integer valor) {
        this.listaElementos.add(valor);
        Collections.sort(this.listaElementos);
    }

    public boolean ehFolha() {
        return this.listaFilhos.isEmpty();
    }

    public void inserirFilho(Nodo nodo) {
        this.listaFilhos.add(nodo);
    }

    // No Nodo
    public String toString(int nivel) {
        StringBuilder sb = new StringBuilder();
        String indent = "    ".repeat(nivel);

        sb.append(indent).append(listaElementos).append("\n");

        for (Nodo filho : listaFilhos) {
            sb.append(filho.toString(nivel + 1));
        }
        return sb.toString();
    }

}
