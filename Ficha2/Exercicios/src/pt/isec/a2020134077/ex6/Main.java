package pt.isec.a2020134077.ex6;

import java.util.Arrays;

import static pt.isec.a2020134077.ex4.Main.pesquisaBinEx4;

public class Main {
    public static void main(String[] args) {
        int []tab = {3,7,12,15};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valores = (0,15) -> " + pesquisaBin(tab,0,15));
        System.out.println("Valores = (3,7) -> " + pesquisaBin(tab,3,7));
        System.out.println("Valores = (4,14) -> " + pesquisaBin(tab,4,14));
        System.out.println("Valores = (4,5) -> " + pesquisaBin(tab,4,5));
        System.out.println("Valores = (0,100) -> " + pesquisaBin(tab,0,100));
        /*
        Solução:
            Valores =(0,15) resultado= 4
            Valores=(3,7) resultado= 2
            Valores =(4,14) resultado= 2
            Valores =(4,5) resultado= 0
            Valores =(0,100) resultado= 4
         */
    }

    private static int pesquisaBin(int[] tab, int chave1, int chave2) {
        int n1 = pesquisaBinEx4(tab,chave1);
        int n2 = pesquisaBinEx4(tab,chave2);

        if(n1 < 0)
            n1 = -n1-1;
        if(n2 < 0)
            n2 = -n2-1;
        else
            n2++;
        return n2-n1;
    }
}
