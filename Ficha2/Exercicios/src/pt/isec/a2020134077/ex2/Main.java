package pt.isec.a2020134077.ex2;

import pt.isec.a2020134077.CriaArray;

import java.util.Arrays;

public class Main {
    public static boolean pesquisaIterativa(int []tab, int chave){
        int []newTab = tab;
        while (newTab.length > 1){
            int meio = newTab.length/2;
            if(newTab[meio] == chave)
                return true;
            else{
                if(newTab[meio] > chave)
                    newTab = Arrays.copyOfRange(newTab,0,meio);
                else
                    newTab = Arrays.copyOfRange(newTab,meio,newTab.length);
            }
            System.out.println("New Tab -> " + Arrays.toString(newTab));
        }
        return false;
    }
    public static void main(String[] args) {
        int []tab = CriaArray.criaArrayCom(100,20,true);
        //tab = [0,10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200]
        System.out.println(Arrays.toString(tab));
        System.out.println(pesquisaIterativa(tab,100));
        //Testes -> chave = 10 / chave = 190 / chave = 100
    }
}
