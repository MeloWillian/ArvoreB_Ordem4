package br.edu.ifpb.eda;

public class ArvoreB {
    Nodo raiz;
    private static final int MAX_CHAVES = 3; // Ordem 4 então máximo 3 chaves

    public ArvoreB() {
        this.raiz = null;
    }

    private void inserir(Integer valor, Nodo nodo) {
        if (this.raiz == null) {
            this.raiz = new Nodo();
            this.raiz.inserirElemento(valor);
        }
        else if (nodo.ehFolha()) {
            nodo.inserirElemento(valor);

            if (nodo.listaElementos.size() > MAX_CHAVES) {
                split(nodo);
            }
        }
        else {
            int i = 0;
            while (i < nodo.listaElementos.size() && valor > nodo.listaElementos.get(i)) {
                i++;
            }
            inserir(valor, nodo.listaFilhos.get(i));
        }
    }

    public void inserir(Integer valor) {
        inserir(valor, this.raiz);
    }

    public void split(Nodo nodo) {
        Nodo pai = nodo.getPai();

        if (pai == null) {
            pai = new Nodo();
            raiz = pai;
        }

        Nodo nodo1 = new Nodo();
        Nodo nodo2 = new Nodo();

        nodo1.inserirElemento(nodo.listaElementos.get(0));

        nodo2.inserirElemento(nodo.listaElementos.get(2));
        nodo2.inserirElemento(nodo.listaElementos.get(3));

        if (!nodo.ehFolha()) {
            nodo1.inserirFilho(nodo.listaFilhos.get(0));
            nodo1.inserirFilho(nodo.listaFilhos.get(1));

            nodo2.inserirFilho(nodo.listaFilhos.get(2));
            nodo2.inserirFilho(nodo.listaFilhos.get(3));
        }

        nodo1.setPai(pai);
        nodo2.setPai(pai);

        pai.inserirElemento(nodo.listaElementos.get(1));

        pai.listaFilhos.remove(nodo);
        int indexMeio = pai.listaElementos.indexOf(nodo.listaElementos.get(1));
        pai.listaFilhos.add(indexMeio, nodo1);
        pai.listaFilhos.add(indexMeio + 1, nodo2);

        if (pai.listaElementos.size() > MAX_CHAVES) {
            split(pai);
        }
    }

    @Override
    public String toString() {
        return raiz == null ? "Árvore vazia" : raiz.toString(0);
    }
}
