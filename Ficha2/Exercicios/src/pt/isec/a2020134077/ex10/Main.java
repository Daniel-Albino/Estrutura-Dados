package pt.isec.a2020134077.ex10;

public class Main {
    public static void main(String[] args) {
        int[] tab1 = {3,7,12,15};
        int[] tab2 = {-3,1,7,12,15};
        int[] tab3 = {-15,-14,1,2,3,4};

        System.out.println("Tab1: " + ex10(tab1));
        System.out.println("Tab2: " + ex10(tab2));
        System.out.println("Tab3: " + ex10(tab3));
    }

    private static int ex10(int[] tab) {
        int linf = 0, lsup = tab.length-1;
        int meio = tab.length/2;
        do{
            if(tab[meio] > meio)
                lsup = meio;
            else
                linf = meio + 1;
            meio = (linf + lsup) / 2;
        }while(linf < lsup);
        if(tab[meio] > meio)
            return meio;
        return -1;
    }


}
