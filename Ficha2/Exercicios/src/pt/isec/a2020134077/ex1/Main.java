package pt.isec.a2020134077.ex1;


import pt.isec.a2020134077.CriaArray;

import java.util.Arrays;

public class Main {
    public static boolean pesquisaRecursiva(int []tab, int chave){
        if(tab.length <= 1)
            return false;

        int meio = tab.length/2;
        int []newTab = new int[0];
        if(tab[meio] == chave)
            return true;
        else {
            if (tab[meio] > chave)
                newTab = Arrays.copyOfRange(tab, 0, meio);
            if (tab[meio] < chave)
                newTab = Arrays.copyOfRange(tab, 0, meio);
        }
        return pesquisaRecursiva(newTab,chave);
    }

    public static void main(String[] args) {
        int []tab = CriaArray.criaArrayCom(100,20,true);
        //tab = [0,10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200]
        System.out.println(Arrays.toString(tab));
        System.out.println(pesquisaRecursiva(tab,10));
    }
}
