package pt.isec.a2020134077.ex4;

import java.util.Arrays;

public class Main {
    public static int pesquisaBinEx4(int[] tab, int chave) {
        int meio = tab.length / 2;
        int linf = 0, lsup = tab.length-1;
        do{
            if(tab[meio] == chave)
                return meio;
            if(tab[meio] > chave){
                lsup = meio-1;
            }else {
                linf = meio + 1;
            }
            meio = (linf+lsup)/2;
        }while (linf < lsup);
        if(tab[meio] == chave)
            return meio;
        if(tab[meio] < chave)
            return -meio-2;
        return -meio-1;
    }

    public static void main(String[] args) {
        int []tab = {3,7,12,15};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valor procurado = 15 " + pesquisaBinEx4(tab,15));
        System.out.println("Valor procurado = 3 " + pesquisaBinEx4(tab,3));
        System.out.println("Valor procurado = 1 " + pesquisaBinEx4(tab,1));
        System.out.println("Valor procurado = 4 " + pesquisaBinEx4(tab,4));
        System.out.println("Valor procurado = 10 " + pesquisaBinEx4(tab,10));
        System.out.println("Valor procurado = 13 " + pesquisaBinEx4(tab,13));
        System.out.println("Valor procurado = 16 " + pesquisaBinEx4(tab,16));
        /*
        Solução:
            Valor procurado=15 resultado= 3
            Valor procurado=3 resultado= 0
            Valor procurado=1 resultado= -1 (o valor deveria ser inserido na posição 0)
            Valor procurado=4 resultado= -2 (o valor deveria ser inserido na posição 1)
            Valor procurado=10 resultado= -3 (o valor deveria ser inserido na posição 2)
            Valor procurado=13 resultado= -4 (o valor deveria ser inserido na posição 3)
            Valor procurado=16 resultado= -5 (o valor deveria ser inserido na posição 4)

         */
    }

}
