package pt.isec.a2020134077.ex7;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int []tab = {3,3,7,12,12,15};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valor procurado = 15 " + pesquisaBin(tab,15));
        System.out.println("Valor procurado = 14 " + pesquisaBin(tab,14));
        System.out.println("Valor procurado = 12 " + pesquisaBin(tab,12));
        System.out.println("Valor procurado = 3 " + pesquisaBin(tab,3));
    }

    private static boolean pesquisaBin(int[] tab, int chave) {
        int meio = tab.length / 2;
        int linf = 0, lsup = tab.length-1;
        int cont = 0;
        do{
            if(meio-1 >= 0 && (tab[meio] == chave && tab[meio-1] == chave))
                return true;
            if(meio+1 < tab.length && (tab[meio] == chave && tab[meio+1] == chave))
                return true;
            if(tab[meio]<chave)
                linf = meio + 1;
            else
                lsup = meio - 1;
            meio = (linf+lsup)/2;
        }while (lsup > linf);
        return false;
    }
}
