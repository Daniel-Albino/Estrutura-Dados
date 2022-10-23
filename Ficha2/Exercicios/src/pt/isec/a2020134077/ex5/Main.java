package pt.isec.a2020134077.ex5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []tab = {3,7,12,15};
        System.out.println(Arrays.toString(tab));
        System.out.println("Valor procurado = 15 " + pesquisaBin(tab,15) + "%");
        System.out.println("Valor procurado = 14 " + pesquisaBin(tab,14) + "%");
        System.out.println("Valor procurado = 3 " + pesquisaBin(tab,3) + "%");
        System.out.println("Valor procurado = 1 " + pesquisaBin(tab,1) + "%");
        System.out.println("Valor procurado = 100 " + pesquisaBin(tab,100) + "%");
        /*
        Solução:
            Valor =15 resultado= 75%
            Valor =14 resultado= 75%
            Valor =3 resultado= 0%
            Valor =1 resultado= 0%
            Valor =100 resultado= 100%
        */
    }

    private static int pesquisaBin(int[] tab, int chave) {
        int lsup = tab.length-1;
        int linf = 0;
        int meio = tab.length/2;

        do{
            if(tab[meio] == chave)
                return (meio*100)/tab.length;
            if(tab[meio] > chave){
                lsup = meio - 1;
            }else{
                linf = meio + 1;
            }
            meio = (linf+lsup)/2;
        }while (linf < lsup);
        if(lsup > 0 && chave > tab[lsup])
            return 100;
        return (meio*100)/tab.length;
    }
}
