import pt.isec.a2020134077.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testes exercícios 1, 2 e 3:");
        DezReais dezReais = new DezReais();
        ItDezReais itDezReais = new ItDezReais(dezReais);
        double n = 0.0;
        for (int i = 0;i<10;i++) {
            dezReais.addNumbers(n);
            n += 1;
        }

        while (itDezReais.hasNext()){
            System.out.println(itDezReais.next());
        }
        try {
            System.out.println(itDezReais.next());
        }catch (NoSuchElementException e){
            System.err.println("Não há mais elementos");
        }

        try {
            dezReais.addNumbers(10.0);
        }catch (RuntimeException e){
            System.err.println("Não é possivel adicionar mais elementos");
        }

        System.out.println("Testes exercícios 4 e 5:");
        DezReaisMutavel drm = new DezReaisMutavel();
        ItDezReaisMutavel itDezReaisMutavel = new ItDezReaisMutavel(drm);
        for (int i = 0;i<10;i++) {
            drm.addNumbers(i*0.1+5.0);
        }

        int j = 0;
        Double dbl;
        while (itDezReaisMutavel.hasNext() && (dbl = itDezReaisMutavel.next()) < 5.4)
            System.out.println((j++) + ": ultimo: " + dbl);

        itDezReaisMutavel.remove();

        ItDezReaisMutavel idrm2 = new ItDezReaisMutavel(drm);
        j = 0;
        while (idrm2.hasNext())
            System.out.println((j++) + ": Sem 5.4: "+ idrm2.next());


        System.out.println("Teste exercício 6:");
        DezReaisMutavel dezReaisMutavel = new DezReaisMutavel();
        ItDezReaisPositivos itDezReaisPositivos = new ItDezReaisPositivos(dezReaisMutavel);
        n = 0.0;
        System.out.println("Todos os numeros que estão dentro do array: ");
        for(int i = 0;i< dezReaisMutavel.getCAPACITY(); i++){
            dezReaisMutavel.addNumbers(n);
            if(n<0)
                n = -n;
            n+=1;
            if(i%2!=0)
                n = -n;
            System.out.println(i + ": " + n);
        }

        System.out.println();
        System.out.println("Iterador com nº positivos:");
        while (itDezReaisPositivos.hasNext())
            System.out.println(itDezReaisPositivos.next());


        System.out.println("Testes exercício 7 e 8: ");
        ArrayList<Double> arrayList = new ArrayList<>();
        n = 0.0;
        System.out.println("Todos os numeros que estão dentro do array: ");
        for(int i = 0;i< 10; i++){
            arrayList.add(n);
            if(n<0)
                n = -n;
            n+=1;
            if(i%2!=0)
                n = -n;
            System.out.println(i + ": " + n);
        }
        System.out.println(procuraMaior(arrayList));
        System.out.println(procuraMaior(dezReaisMutavel));
        System.out.println(procuraMaior(dezReais));
    }

    private static <T extends Comparable <? super T>> T procuraMaior(Iterable<T> tab) {
        Iterator<T> it = tab.iterator();

        T m, temp;

        m = it.next();

        while (it.hasNext()){
            temp = it.next();
            if(temp.compareTo(m) > 0)
                m = temp;
        }
        return m;
    }

}