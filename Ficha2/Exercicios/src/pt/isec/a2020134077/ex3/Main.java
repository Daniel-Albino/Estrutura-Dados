package pt.isec.a2020134077.ex3;

import pt.isec.a2020134077.CriaArray;

import java.util.Arrays;

public class Main {
    private static int pesquisaBin(int[] tab, int chave) {
        int []newTab = tab;
        int meio = newTab.length / 2;
        int indice = meio;
        while (newTab.length > 1){
            meio = newTab.length / 2;
            if(newTab[meio] == chave)
                return indice;
            else{
                if(newTab[meio] > chave){
                    newTab = Arrays.copyOfRange(newTab,0,meio);
                    indice -= meio/2;
                }else {
                    newTab = Arrays.copyOfRange(newTab,meio,newTab.length);
                    indice += meio/2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []tab = CriaArray.criaArrayCom(100,20,true);
        //tab = [0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200]
        System.out.println(Arrays.toString(tab));
        System.out.println("Posição -> " + pesquisaBin(tab,25));
    }
}
