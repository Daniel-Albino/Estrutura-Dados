package pt.isec.a2020134077.ex8;

import java.util.Arrays;

import static pt.isec.a2020134077.ex4.Main.pesquisaBinEx4;

public class Main {
    public static void main(String[] args) {
        int []tab = {3,7,12,15};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valor = 15 -> " + pesquisaBin(tab,15));
        System.out.println("Valor = 14 -> " + pesquisaBin(tab,14));
        System.out.println("Valor = 3 -> " + pesquisaBin(tab,3));
        System.out.println("Valor = 1 -> " + pesquisaBin(tab,1));
        System.out.println("Valor = 100 -> " + pesquisaBin(tab,100));
        /*
        Solução:
            Valor =15 resultado= 12
            Valor =14 resultado= 12
            Valor =3 resultado= 3
            Valor =1 resultado= 1
            Valor =100 resultado= 15
         */
    }

    private static int pesquisaBin(int[] tab, int Z) {
        int pos = pesquisaBinEx4(tab,Z);
        if(pos == -1 || pos == 0)
            return Z;
        if(pos < 0)
            pos = -pos - 1;
        return tab[pos-1];
    }
}
