package pt.isec.a2020134077.ex9;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []tab = {3,6,8, -10,-3,-2,-1};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valor = 3 -> " + pesquisaBin(tab,3));
        System.out.println("Valor = 6 -> " + pesquisaBin(tab,6));
        System.out.println("Valor = 8 -> " + pesquisaBin(tab,8));
        System.out.println("Valor = -10 -> " + pesquisaBin(tab,-10));
        System.out.println("Valor = -3 -> " + pesquisaBin(tab,-3));
        System.out.println("Valor = -2 -> " + pesquisaBin(tab,-2));
        System.out.println("Valor = -1 -> " + pesquisaBin(tab,-1));
        System.out.println("Valor = -100 -> " + pesquisaBin(tab,-100));
        System.out.println("Valor = 1 -> " + pesquisaBin(tab,1));
    }

    private static int pesquisaBin(int[] tab, int chave) {
        int linf = 0, lsup = tab.length-1;
        int meio = tab.length/2;
        do{
            if(tab[meio] == chave)
                return meio;
            if(chave * tab[meio] >= 0) {
                if (tab[meio] < chave)
                    linf = meio + 1;
                else
                    lsup = meio - 1;
            }else{
                if(tab[meio] < chave)
                    lsup = meio - 1;
                else
                    linf = meio + 1;
            }
            meio = (linf + lsup) / 2;
        }while (linf < lsup);
        if(tab[meio] == chave)
            return meio;
        return -1;
    }
}
