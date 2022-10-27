package pt.isec.a2020134077.ex5;

public class Ponto <T extends Number, T1 extends Number> {
    private T p1;
    private T1 p2;

    public Ponto(T p1, T1 p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public T getP1() {
        return p1;
    }

    public T1 getP2() {
        return p2;
    }

    public void setP1(T p1) {
        this.p1 = p1;
    }

    public void setP2(T1 p2) {
        this.p2 = p2;
    }

    public void copy(Ponto<? extends T, ? extends T1> p) {
        setP1(p.getP1());
        setP2(p.getP2());
    }

    @Override
    public String toString() {
        return "(" + p1 + "," + p2 + ")";
    }
}










