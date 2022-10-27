package pt.isec.a2020134077.ex3;

public class Main {
    public static void main(String[] args) {
        Retangulo retangulo = new Retangulo<>("Rec1",2,2);
        Quadrado quadrado = new Quadrado<>("Quadrado",2);

        System.out.println("CompareTo: ");
        System.out.println("Retangulo: " + (retangulo.compareTo(quadrado) == 0));
        System.out.println("Quadrado: " + (quadrado.compareTo(retangulo) == 0));

    }
}
