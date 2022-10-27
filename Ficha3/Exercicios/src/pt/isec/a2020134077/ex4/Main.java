package pt.isec.a2020134077.ex4;

public class Main {
    public static void main(String[] args) {
        Integer m[]={3,2,6,3};
        String n[]={"Ada", "Albino"};
        System.out.println(search(m,2)); // true
        System.out.println(search(n,"Francisco")); // false
    }

    private static <E extends Comparable> boolean search(E[] tab, E chave) {
        for(E t : tab)
            if(t.compareTo(chave) == 0)
                return true;
        return false;
    }
}
