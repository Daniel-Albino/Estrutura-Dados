package pt.isec.a2020134077;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ItDezReaisMutavel implements Iterator<Double> {
    private DezReaisMutavel dezReaisMutavel;
    private int pos;
    private int modificacoesConhecidas;
    private boolean podeRemover;
    public ItDezReaisMutavel(DezReaisMutavel dezReaisMutavel) {
        this.dezReaisMutavel = dezReaisMutavel;
        pos = -1;
        modificacoesConhecidas = dezReaisMutavel.getModificacoes();
        podeRemover = false;
    }

    public void verificaModificaccao(){
        if(modificacoesConhecidas != dezReaisMutavel.getModificacoes())
            throw new ConcurrentModificationException();
    }


    @Override
    public boolean hasNext() {
        verificaModificaccao();
        return pos + 1 < dezReaisMutavel.getLastPos();
    }

    @Override
    public Double next() {
        verificaModificaccao();
        if(!hasNext())
            throw new NoSuchElementException();
        podeRemover = true;
        return dezReaisMutavel.getTab(++pos);
    }

    public void remove(){
        if(!podeRemover)
            throw new IllegalStateException();
        podeRemover = false;
        dezReaisMutavel.removeNumbers(pos);
        System.out.println("Modificações: " + dezReaisMutavel.getModificacoes());
        pos--;
        modificacoesConhecidas++;
        System.out.println(modificacoesConhecidas);
    }
}
