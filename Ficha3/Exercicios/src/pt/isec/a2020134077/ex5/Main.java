package pt.isec.a2020134077.ex5;

public class Main {
    public static void main(String[] args) {
        Ponto<Integer, Integer> p = new Ponto< >(3,4);
        Ponto<Number, Number> x = new Ponto<>(0,0);
        System.out.println(p); // imprime (3,4)
        System.out.println(x); // imprime (0,0)
        x.copy(p);
        System.out.println(x); // imprime (3,4)
        //Ponto<String, Integer> erro = new Ponto<String,Integer>(“olá”,3);// erro de compilação
    }
}
