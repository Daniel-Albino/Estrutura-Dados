package pt.isec.a2020134077.ex3;

import java.util.Objects;

public class Retangulo <T extends Number> extends Figura{

    private T l1;
    private T l2;

    public Retangulo(String nome, T l1,T l2) {
        super(nome);
        this.l1 = l1;
        this.l2 = l2;
    }

    public T getL1() {
        return l1;
    }

    public T getL2() {
        return l2;
    }

    @Override
    public Double getArea() {
        return l1.doubleValue()*l2.doubleValue();
    }

    @Override
    public int compareTo(Object o) {
        Figura aux = (Figura) o;
        if(Objects.equals(getArea(), aux.getArea()))
            return 0;
        return -1;
    }
}
