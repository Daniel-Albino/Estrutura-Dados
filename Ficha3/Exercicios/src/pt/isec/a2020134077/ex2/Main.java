package pt.isec.a2020134077.ex2;

public class Main {
    private static  <T extends Comparable> boolean encontraElemento(T []tab, T chave){
        int c = 0;
        for(T t : tab){
            if(t.compareTo(chave) == 0) //Resolve o problema do exercício 1
                c++;
        }
        if(c>1)
            return true;
        return false;
    }
    public static void main(String[] args) {
        Integer []tabi = {1,2,3,4,4,5,6};
        Double []tabd = {1.0,2.0,3.0,4.4,4.4,5.0};
        Float []tabf = {1.0f,2.0f,3.0f,4.4f,4.4f,5.0f};
        String []tabn = {"Ana","João","Maria","Maria","Ze"};
        System.out.println("Exercício 2: " + encontraElemento(tabi,4));
        System.out.println("Exercício 2: " + encontraElemento(tabf,4.4f));
        System.out.println("Exercício 2: " + encontraElemento(tabd,4.4));
        System.out.println("Exercício 2: " + encontraElemento(tabn,"Maria"));

    }
}
