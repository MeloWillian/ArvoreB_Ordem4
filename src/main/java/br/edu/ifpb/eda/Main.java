package br.edu.ifpb.eda;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArvoreB arvoreB = new ArvoreB();

        int[] valores = {10, 20, 30, 40, 50, 60, 70, 15, 25, 35, 45, 55, 65};

        for (int valor : valores) {
            System.out.println("\nInserindo: " + valor);
            arvoreB.inserir(valor);
            System.out.println(arvoreB);
        }
    }
}