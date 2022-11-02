# Resumos de Estrutura de dados


## Análise de Complexidade

#### **Nomenlatura (Notação O - grande)**

- O(n) -> linear ou melhor
    - Linear -> Pior caso.
    - Melhor -> Terminar mais cedo.

- Θ(n) -> Extatamente Linear

- Θ(1), O(1) –> Constante
- Θ(N), O(N) –> Linear
- Θ(N2), Θ(N3), …, O(N2), … –> Quadratica, cubica, …
- Θ(log(N)), O (log(N)) –> Logaritmica
- Θ(N x log(N)), O(N x log(N)) –> N-Log

### **Crescimento de Funções:**
![Crescimento de Funções](https://user-images.githubusercontent.com/84712694/194765155-65c8c00d-9061-45a2-a72b-eb3d9a13c267.png)


### **Notação O-Grande:**

Porque é que a notação O-Grande é adequada para descrever a complexidade de um algoritmo?

- O valor de uma função é essencialmente dependente do termo dominante, para valores elevados de N.
- O tempo de execução para valores pequenos de N é inconsequente.
- O valor exacto da constante multiplicativa do termo dominante é dependente do *hardware*, pelo que não tem relevância para termos efeitos de comparação entre algoritmos.

### **Exemplos:**

**1. Menor distância entre pontos**
1. Calcular a distância entre cada par de pontos.
2. Procurar a menor distância.

**2. Colinearidade**
1. Identificar cada conjunto distinto de 3 pontos, e verificar se é ou não colinear.
- Existem N(N-1)(N-2)/6 conjuntos de 3 pontos, pelo que a complexidade é de ordem cúbica…
    - De novo, existem algoritmos (menos óbvios) de complexidade quadrática…

````
Notas da aula sobre os exemplos 1 e 2.
````
![Caderno1](https://user-images.githubusercontent.com/84712694/194766091-7cd8d10f-5946-4a2e-aa1b-18992c124894.jpg)


### **Pesquisa:**

- Dado um número X e um array A, devolver a posição de X em A ou uma indicação que X não existe.
    - Pesquisa Sequencial
    - Pesquisa Binária
    - Pesquisa Interpolada

#### **Pesquisa Sequencial:**

- Qual é a complexidade:
    - De uma pesquisa sem sucesso?
    - De uma pesquisa com sucesso, no pior caso?
    - De uma pesquisa com sucesso, no caso médio?

````
Nota: Informação ordenada ou não. 
````


#### **Pesquisa Binária:**
- Se o espaço de pesquisa está ordenado, procura-se o valor no ponto médio do array, e não no início.
    - Pode-se reduzir para metade o número de valores pesquisados em cada iteração.
        - E se procurassemos o ponto a ¾ do array, em vez de examinarmos o ponto médio?
- Qual a complexidade de uma pesquisa falhada?
- E de uma pesquisa pesquisa com sucesso, no pior caso?
- E de uma pesquisa com sucesso, no caso médio?

![Caderno2](https://user-images.githubusercontent.com/84712694/194766800-cc8edc1e-991e-4139-9063-a72b54d33b8a.jpg)

````
Nota: Informação ordenada obrigatória.
````

#### **Pesquisa Interpolada:**

- Se o array estiver ordenado E a distribuição de números for uniforme…
    - Só é normalmente vantajoso se o acesso aos dados for muito custoso.
- Baseia-se em interpolar a posição do elemento procurado a partir dos valores dos maior e menor elemento.

![PesquisaInterpolada_1](https://user-images.githubusercontent.com/84712694/194766922-203e735a-157b-4b4d-afb2-c80df751e4f1.png)


- Qual é o pior caso?
    - Caso os valores não estejam uniformemente distribuidos, todos os elementos podem vir a ser pesquisados…
        - O(N)
- Qual é o caso médio?
    - Caso a distribuição seja relativamente uniforme:
        - O(log log N)


### **Máxima Sequência Contígua**


Ver: [Aqui](https://github.com/Daniel-Albino/Estrutura-Dados/blob/master/Ficha%201/Exercicios/src/pt/isec/a2020134077/exerciciosficha1/ex4/Main.java)
 
Ou (Branch master -> Ficha 1 -> Exercicios -> src -> pt -> isec -> a2020134077 -> exerciciosficha1 -> ex4 -> Main.java).


## Genéricos

### **Métodos Genéricos**

- Pretende-se um método que imprime o conteúdo de um *array*:
````
public static void imprime(String [] m){
    for(String a : m)
    System.out.println(a);
}

public static void main (String args[]){
    String m[]={“José”,”António”};
    imprime(m);
}
````

- A função anterior só funciona para *arrays* de *Strings*;
- Pode ser *generalizada* para aceitar *arrays* com qualquer tipo de elementos.
````
public static <T> void imprime(T [] m){
    for(T a: m)
    System.out.println(a);
}

public static void main (String args[]){
    String m[]={“José”,”António”};
    Integer n[]={2, 3};
    imprime(m);  
    imprime(n);  
}
````

### **Classes Genéricas**

- O coneito de genéricos também pode ser aplicado a classes.

````
public class Par <T,S> {
    T primeiro;
    S segundo;

    public Par(T a, S b){
        primeiro=a;
        segundo=b;
    }

    public T getPrimeiro(){
        return primeiro;
    }

    public S getSegundo(){
        return segundo;
    }

    public setPrimeiro(T a){
        primeiro=a;
    }

    public setSegundo(S b){
        segundo=b;
    }
}
````

### **Wildcards**

- É possível impor restrições ao parâmetros formais. Por exemplo, neste caso, T:
````
public static <T extends Number> boolean maior (T p1, T p2){
    return p1.doubleValue()>p2.doubleValue();
}

public static void main(String args[]){
    if(maior(33,4))
    System.out.println(“maior”);
    boolean m=maior(“ola”,”adeus”); //erro de compilação
    /String não estende Number.
}
````

- As *wildcards* podem ser especificadas da seguinte forma:
    - **X extends Y:**
        - X é igual a ou estende a classe Y (ou implementa interface Y);
    - **X super Y:**
        - Y é igual a ou estende a classe X (ou implementa interface X);
    - X ou Y podem ser substituidos por ‘?’, o que significa “qualquer classe”.

#### **Exemplo**

- Os wildcards podem ser usados para substituir parâmetros formais que são usados uma única vez:

##### Exemplo 1:

````
public static <T,S> void f(par<T,S> p)
````
- Pode ser escrito como:
````
public static <T,S> void f(par<T,S> p)
````

##### Exemplo 2:

````
public static <T,S> void f(par<T,S> p)
````

- Pode ser escrito como:
````
public static <T,S> void f(par<T,S> p)
````

### **Suporte de Polimorfismo com Wildcards**

````
public class Par <T,S> {
    T primeiro;
    S segundo;

    public Par(T a, S b){
        primeiro=a;
        segundo=b;
    }

    public T getPrimeiro(){return primeiro;}
    public S getSegundo(){return segundo;}

    ...

    public void copia(Par<T,S> outroPar){
        primeiro=outroPar.getPrimeiro();
        Segundo=outroPar.getSegundo();
    }
}


class Rect{
    ...
};

class Quad extends Rect{
    ...
}

public static void main(String args[]){
    Quad q1=new Quad(1), q2=new Quad(2);
    Rect r1=new Rect(2,3), r2= new Rect (3,4);
    Par<Quad,Rect> p1=new Par<>(q1,r1);
    Par<Quad,Rect> p2=new Par<>(q2,r2);
    p2.copia(p1);  //ok
    Par<Rect,Rect> p3=new Par<>(q1,r1);
    Par<Rect,Rect> p4=new Par<>(q2,r2);
    p3.copia(p4);   //ok
    p3.copia(p1);   // erro de compilação: 
    //Par<Quad,Rect> não pode ser usado 
    // no lugar de Par<Rect,Rect>
}
````

![image](https://user-images.githubusercontent.com/84712694/195580689-656d4301-480f-43c8-bc40-5eaaae7e8fff.png)


### **Polimorfismo com Wildcards**

**Considere-se a seguinte hierarquia:**

````
class Figura implements Comparable<Figura>{
    int compareTo(Figura f){ ... }
}
Class Rect extends Figura{ ... }
...
````

**É possível fazer isto:**

````
Rect r=new Rect(2,3), q=new Rect(3,4);
r.compareTo(q);  //ok!
// é válido, apesar de Rect não ser Comparable<Rect>
// porque é Comparable<Figura>
````

**Sendo assim, como usar wildcards para definir um método que recebe um parametro Rect e qualquer outro que possa ser comparado com ele?**


#### **Tentiva 1:**

````
static int compara (Rect r, Comparable<Rect> c){
    //não funciona bem...  Qualquer figura é comparável 
    // com Rect
}
````

#### **Tentiva 2:**
````
static int compara (Rect r, Comparable<Figura> c){
    // Já funciona melhor, mas infelizmente obriga-nos a saber
    // que é exactamente a nível da classe Figura que se 
    // define a comparação.. 

    //Se também for possível comparar uma outra classe não 
    //relacionada com figura (p.ex: Colorido) com um 
    //rectangulo, então não irá funcionar nesse caso
}
````

#### **Como generalizar?:**

**Basta que o objecto recebido por parâmetro seja comparável com uma classe antecessora de Rect!**

````
static int compara (Rect r, Comparable<? super Rect> c){
    ...
    // Já funciona bem em todos os casos
    // pode reber um objecto que seja comparável com Rect,
    // ou então com Figura, ou então com Object...
}
````

**Generalizando o Rect para que a função possa receber qualquer tipo de objectos**

````
static <T> int compara (T r, Comparable<? super T> c){
    return c.compareTo(r);  //ok!
}
````


### **Limitações dos Genéricos**

- Quando um programa é compilado, os parâmetros dos genéricos são removidos, sendo utilizados Objects (ou outra superclasse adequada) no seu lugar. 
    - A informação de genéricos é usada apenas durante o processo de compilação para fazer verificação de tipos.
    - Este processo é designado por Type Erasure
- Isto condiciona as operações possíveis com esses tipos.

![1](https://user-images.githubusercontent.com/84712694/195583603-2845a25d-715f-4660-aab5-1b54ab313194.png)


- Sendo T um parâmetro formal, não é possível:
    - Criar arrays de classes parametrizadas:
        - Par<X,Y> m[] = new Par<>[10]; 
    - Criação de Objectos de tipo T:
        - T obj = new T();
    - Extensão:   
        - class <X> extends X
    - Utilizar o tipo em membros ou métodos estáticos: 
        - private static T valor;
        - public static void f (T in); 
    - Obter dinamicamente informação sobre o tipo:
        - O instanceof T
    - Ser usado em enumerações: 
        - enum State<X> { ... }

### **Exercício:**

- Como definir uma classe ParComparável, sabendo que esta representa um Par cujos elementos são comparáveis. A classe ParComparável deve por sua vez ser também comparável: a comparação deve ser decidida através da comparação dos dois primeiros elementos de cada par, desempatando com a comparação dos segundos.

    - Passo 1:
        - “(...) classe ParComparável, sabendo que esta representa um Par cujos elementos são comparáveis. (...)”

![image](https://user-images.githubusercontent.com/84712694/195584225-a1d6d3df-ff8f-4d69-8560-162a024cf0c2.png)

- A classe ParComparável deve por sua vez ser também comparável:

````
public class ParComparavel <S extends Comparable<? Super S>, T extends Comparable<? Super T>>
extends Par<S,T> implements Comparable<ParComparavel<? extends S,? extends T>> { ... }
````

- A comparação deve ser decidida através da comparação dos dois primeiros elementos de cada par, desempatando com a comparação dos segundos.

````
class ParComparável ...{
    ...
    int compareTo(ParComparavel<? extends S,? extends T> p){
        int compPrimeiro = p.getPrimeiro().compareTo(getPrimeiro());
        if(compPrimeiro==0) 
            return p.getSegundo(getSegundo());
        else 
            return compPrimeiro;
    }
    ...
}
````


## Iteradores

- São objetos utilizados para percorrer estruturas de dados.

![image](https://user-images.githubusercontent.com/84712694/196768442-6fbf20a4-c42b-48f6-8cca-73d46dc566a9.png)


### Interface que se deve implementar em Java:

````
public interface Iterator<E>{
    boolean hasNext();
    E next() ; // gera excepção caso não exista
    default void remove();
    default void forEachRemaining(Consumer<? super E> action); //Java 8+
}
````

- A criação de uma nova estrutura de dadas deve ser acompanhada pela criação de um iterador adequado.
- As estruturas de dados disponibilizam iteradores adequados através de um método fábrica, que devolve um iterador adequado.
````
Iterator<E> interator();
````
- O interface Iterable<T> indica a existência do método acima descrito.


### Exemplo:

````
public class Par <T> implements Iterable<T> {
    T p1,p2;
    Iterator<T> iterator(){
    return new IteratorPar<T>(this);
    }
    …
};

public class IteratorPar<T> implements Iterator<T>{
    int counter=0;
    Par<T> par;
    IteratorPar( Par<T> p){par=p;}
    Boolean hasNext() {return counter!=2;}

    T next(){
        switch(counter) {
            case 0: counter++; return par.p1;
            case 1: counter++; return par.p2;
            default: throw new NoSuchElementException();
        };
    }
}
````

### Algoritmos: 

- Os algoritmos podem ser tornados independentes dos contentores de dados através do uso de Iteradores.

````
public <T> boolean procura(Iterable<T> m, T o){
    Iterator<T> it=m.iterator();
    boolean proximo=it.hasNext();
    while(proximo){
        if(it.next()==o) // compara referência, não conteúdo
            return true;
        proximo=it.hasNext();
    }
    return false;
}
````

### Excepções:

- Os iteradores podem/devem gerar as seguintes excepções:
    - **UnsupportedOperationException:** A operação (p.ex: remoção) não é suportada.
    - **NoSuchElementException:** Tentativa de acesso a um elemento que não existe
    - **IllegalStateException:** Tentativa de remoção sem avançar para primeiro elemento ou tentativa de remover o mesmo elemento mais do que uma vez.
    - **ConcurrentModificationException:** Quando se tenta usar um iterador inválido. Um iterador é inválido quando a colecção foi alterada externamente (através de um outro iterador, por exemplo).
    - O suporte para geração da exceção **ConcurrentModificationException** pode ser realizado através de uma contagem de modificações (p.ex., add, remove) armazenada na estrutura e no iterador:

![2](https://user-images.githubusercontent.com/84712694/196770027-14062831-bf8b-4df7-9e10-b639ff779ebc.png)


## Coleções

- São bibliotecas de estruturas de dados e algortimos.

### API de Coleções:

- Todas as estruturas de dados implementam o interface Collection < T >.
    - **Inserção/Remoção:** add, addAll, remove, removeAll, retainAll, clear.
    - **Conversão para array:** toArray
    - **Suporte para iteradores:** iterator
    - **Informação e pesquisa:** isEmpty, size, contains, containsAll
- Os algoritmos são disponibilizados como métodos estáticos da classe:
    - *java.util.Collections*;
    - *java.util.Arrays*.
    - Cópia, pesquisa binária, contagem de objectos, manipulação, substituição,ordenação e outros.

### Retrocompatibilidade:

- Apesar de todos os contentores de dados serem genéricos, podendo conter objectos de qualquer tipo, alguns métodos manipulam objectos, por motivos de compatibilidade com versões antigas da linguagem:
    - **boolean contains(Object x)** – Devolve verdadeiro se o Objecto está no contentor.
    - **boolean remove(Object x)** - Devolve verdadeiro se o objecto foi removido.

### Conversão para Array:

#### Exemplo:
````
Collection<String> col=…;
String [] m=new String[col.size()];
Col.toArray(m);
````

### Construção de Coleções:

- Não é possível especificar os construtores através de um interface.
- No entanto, por convenção, todas as implementações de Collection deverão possuir os seguintes construtores:
    - *Construtor sem parâmetros*;
    - *Construtor que cria uma colecção que referencia os mesmos elementos que outra colecção*.

````
class Pacote <X> implements Collection<X>{
    Pacote(){
        //cria colecção vazia;
        …
    }
    
    Pacote(Collection<? extends X> c){
        //cria uma colecção que referencia
        //os mesmos elementos que c
        …
    }
    …
}
````

### Métodos Opcionais:

- O que acontece se um dos métodos requerido pelo interface não for suportado?
    - Por exemplo, remoção de elementos em colecções imutáveis?
- Está prevista a existência de métodos opcionais!
    - A execução de um método opcional que não é implementado resulta na geração de uma excepção *UnsupportedOperationException*.

### Algoritmos Genéricos:

- Os algoritmos são fornecidos como métodos estáticos de classes como Collections e Arrays.

### Functores:

- Um functor (ou objecto-função) é um objecto que encapsula uma *função/método*.
- São úteis para API de coleções, para variar a funcionalidade de alguns dos algoritmos.

#### Functor - Comparator:

***Problemas:***
- Como ordenar objectos de classes que não são comparáveis ?
- Como ordenar strings de acordo com o segundo caracter?

***Resolução:***
- Criar um objeto *Comparator* adquado.

````
interface Comparator<T>{
    public int compare(T o1, T o2);
}

class Comparador2Char implements Comparator<String> {
    Public int compare(String o1, String o2) {
        Character c1=new Character(o1.charAt(1));
        Character c2=new Character(o2.charAt(1));
        return o1.compareTo(o2);
    }
}
````

#### Comparador por omissão:

````
class DefaultComparator <E extends Comparable<? super E> > implements Comparator<E> {
    public int compare( E lhs, E rhs ) {
        return lhs.compareTo( rhs );
    }
}
````

### Algoritmos:

**Pesquisa Binária:**
- **Arrays.binarySearch** – versões overloaded para tipos básicos de dados, bem como duas versões para objectos (com e sem um functor Comparator)
````
int binarySearch(Object[] a, Object key)
static<T> int binarySearch(T[] a, T key, Comparator<? super T> c)

````
- Caso o elemento exista, devolve a sua posição.
- Caso o elemento não exista, devolve o inverso da primeira posição com um elemento de valor superior.


**Ordenação:**

- Arrays.sort – versões overloaded para tipos básicos de dados, bem como duas versões para objectos (com e sem um functor Comparator).

### Tipos de coleções:

**List:**

- Colecção na qual os items têm uma posição.
- Acrescenta métodos relacionados com o posicionamento dos elementos.
- Acrescenta também um iterador bidireccional.

**ListIterator:**
- **void add(E e)** – Insere Elemento na lista;
- **Boolean hasPrevious()** – Indica se há um elemento atrás do posição actual
- **int nextIndex()** – Retorna indice do próximo elemento
- **E previous()** - Retorna elemento anterior.
- **void set(E e)** – modifica o ultimo elemento devolvido.

### Operações sobre ArrayLists:

- **Organização interna:**

![image](https://user-images.githubusercontent.com/84712694/196928678-a13d222c-ec1d-4dbb-90f6-56240a17a48f.png)

- **Acrescentar um valor:**

![image](https://user-images.githubusercontent.com/84712694/196928884-e14a9eda-e426-4baf-b083-e3c1b8b7f45f.png)

![image](https://user-images.githubusercontent.com/84712694/196929138-243acc4f-0134-4908-b937-3716e3ecdb73.png)

![image](https://user-images.githubusercontent.com/84712694/196929278-d48105d4-9ddf-40cc-bea4-e3fb2008a0c7.png)

![image](https://user-images.githubusercontent.com/84712694/196929435-6164ab79-918e-4938-b14a-060a57fc8ae7.png)

![image](https://user-images.githubusercontent.com/84712694/196929704-c2fb21c3-6d99-4c2a-b1e1-d5451fd5db78.png)

![image](https://user-images.githubusercontent.com/84712694/196929927-26a12402-de66-40ef-bc15-e86144835a72.png)

![image](https://user-images.githubusercontent.com/84712694/196930044-cda24378-1e19-4e8b-89b0-29d192d70d8f.png)

    Se o aumento da capacidade for sempre proporcional à capacidade anterior (p.ex: 2x), então atinge-se comportamento constante amortizado.
    Uma operação tem custo O(1) amortizado se o custo de a executar N vezes é O(N) (mesmo que nem todas as execuções sejam O(1)).
    Isto deve-se à diluição do custo de inserções O(N) pelas inserções O(1).


- **Remover um valor:**

![image](https://user-images.githubusercontent.com/84712694/196930660-ca695201-ba8b-456d-b717-9c949c4d4753.png)

![image](https://user-images.githubusercontent.com/84712694/196930816-9fa1672f-62aa-4990-b0e0-5d108f41388c.png)


![image](https://user-images.githubusercontent.com/84712694/196930957-e814c0b1-bd75-4065-969d-917ca23c7fea.png)

### Operações sobre LinkedLists:

- **Lista duplamente ligadas:**

![image](https://user-images.githubusercontent.com/84712694/196931126-5957b273-86ad-4598-844d-89aaa30fb509.png)

![image](https://user-images.githubusercontent.com/84712694/196931208-333a298c-5db0-4fe4-9e0b-a82009e8a747.png)


### Tipos de Coleções:

- ***Set*** – Conjunto: colecção que não contém duplicados.
    - SortedSet: Conjunto de elementos ordenáveis
    - HashSet: Conjunto (não ordenado)

- ***Queue*** – Fila: permite a inserção, extracção e inspecção e elementos.
    - PriorityQueue: fila na qual os elementos estão ordenados de acordo com um determinado critério.

- ***Map*** – Colecção de pares de chaves e respectivos valores.
    - TreeMap: Mapa ordenado por chave
    - HashMap: Mapa não ordenado



## Alguns apontamentos importantes de Iteradores e de Coleções:

![Caderno3](https://user-images.githubusercontent.com/84712694/196771882-a78fefea-ab38-4311-8cc0-f78e3cf1422d.jpg)
![Caderno4](https://user-images.githubusercontent.com/84712694/196771850-9c0c52b6-202c-41d4-ad12-0ba05fe32b76.jpg)
![Caderno5](https://user-images.githubusercontent.com/84712694/196771857-e80c9893-7339-4ca0-ab60-151c9e848a30.jpg)
![Caderno6](https://user-images.githubusercontent.com/84712694/196771868-51f188ec-b86c-4c7d-8205-12994fa15f9a.jpg)
![Caderno7](https://user-images.githubusercontent.com/84712694/196771876-a5895b84-6209-45ae-99cd-ad2038e9d188.jpg)




## Árvores Binárias

![image](https://user-images.githubusercontent.com/84712694/198874247-86bca185-b630-464f-8b49-9cd57d9802e3.png)

- Operações Básicas:
    - getNumeroNodos()
    - getAltura()
    - imprimePreOrdem()
    - imprimePosOrdem()
    - imprimeEmOrdem()

### Operações:

- Como calcular o número de nodos de uma árvore com raiz R?

````
O número de nodos de uma árvore com raiz R é dado pela soma dos nodos da subárvore esquerda com os nodos da subárvore direita mais um (própria raiz).
````

### Travessia:

- Há 3 formas de percorrer os nodos (O(N)):
    - **pré-ordem**: O nodo é visitado, sendo depois percorrido o descendenteesquerdo e em seguida o direito;
    - **pós-ordem**: É 1º percorrido o descendente esquerdo, depois o direito e depois visitamos o nodo;
    - **(em-)ordem**: É 1º percorrido o descendente esquerdo, visitamos o nodo e depois percorremos o descendente direito.

- É mais simples usar métodos recursivos para implementar a travessia.

#### Travessia por nível:

![Caderno9](https://user-images.githubusercontent.com/84712694/198875724-5b9c4d85-0597-41ae-a4d2-81e16a471101.jpg)

````
int numeroNodos(Nodo n){
    if(n==null)
        return 0;
    return 1+numeroNodos(n.left)+numeroNodos(n.right);
}
````

### Altura da Árvore:

![Caderno8](https://user-images.githubusercontent.com/84712694/198875259-3874a601-136a-4ffa-a764-99a3e2a58794.jpg)

````
int getAltura(Nodo n){
    if(n==null)
        return 0;
    int esq = getAltura(n.esq);
    int dir = getAltura(n.dir);

    if(esq > dir)
        return esq + 1;
    return dir + 1;
}
````

### Aplicação de Árvores Binárias:

- Representação de expressões:

![image](https://user-images.githubusercontent.com/84712694/198874975-17c33115-4cff-4cb5-9ac0-d60d9ce44ad8.png)

### Representação de expressões:

#### **Impressão:**

#### Em-Ordem:

````
class Nodo{
    String valor;
    Nodo esquerda, direita;
    ...
    void expressao(){
        if(esquerda != null)
            esquerda.expressao();
        System.out.println(valor);
        if(direita != null)
            direita.expressao();
    }
}
````

#### Pós-Ordem:

````
class Nodo{
    String valor;
    Nodo esquerda, direita;
    ...
    Integer CalculaValor(){
        if (esquerda==null)&&(direita==null)
            return Integer.valueOf(valor);
        int valEsq=esquerda.CalculaValor().intValue();
        int valDir=0;
        if(direita!=null)
            direita=direita.CalculaValor().intValue();
        if (valor.equals(“+”))
            return valDir+ValEsq;
        if (valor.equals(“*”))
            return valDir*ValEsq;
        if (valor.equals(“-”))
            return valDir-ValEsq;
        ...
    }
}
````

#### Como construir uma árvore correspondente a uma dada expressão?

- Vamos primeiro analisar o caso de a expressão estar um notação postfix (o operador encontra-se depois dos argumentos) em vez de se encontrar entre eles (notação infix)
    - Exemplo:  4+3*2 (infix) é equivalente a 4 3 2 * + (postfix)

***Nota:*** 
````
3 + 2 -> infix
soma(3,2) -> prefix
3 2 + -> postfix
````

### **Conversão post-fix para árvore:**

![image](https://user-images.githubusercontent.com/84712694/198876862-cf3af84e-4d3e-4995-a02c-42b1933249d8.png)

![image](https://user-images.githubusercontent.com/84712694/198876905-fb74e687-733d-488b-9d7b-f20938986470.png)

![image](https://user-images.githubusercontent.com/84712694/198876930-e44d4531-91da-4814-94b5-5d041b8753a2.png)

![image](https://user-images.githubusercontent.com/84712694/198876963-8a90b911-8874-41e8-bd65-102f07be0793.png)

![image](https://user-images.githubusercontent.com/84712694/198876998-053f25b2-1c9a-4aaf-baba-25df59e9fe05.png)

![image](https://user-images.githubusercontent.com/84712694/198877045-c2a1a649-7fcf-42c7-82dc-bb7e747f2660.png)

![image](https://user-images.githubusercontent.com/84712694/198877074-e69801ae-765e-48f2-9a30-ecee9677b3ec.png)

![image](https://user-images.githubusercontent.com/84712694/198877107-f7d670b8-024a-437a-b8c8-e1fa09526b76.png)

![image](https://user-images.githubusercontent.com/84712694/198877141-66139eb7-1ace-477d-967a-5455d5eec988.png)

![image](https://user-images.githubusercontent.com/84712694/198877156-fe6c5e1b-46f3-4971-b813-cfeb85849f68.png)

![image](https://user-images.githubusercontent.com/84712694/198877173-5c513738-9fea-46a5-84e9-dd3d3f3696ce.png)


### **Infix para postfix:**

![image](https://user-images.githubusercontent.com/84712694/198877509-05f0542c-29ef-4a84-9b79-bbfb486d413b.png)

![image](https://user-images.githubusercontent.com/84712694/198877551-1e70eaec-198d-40d7-8bbd-8bf70ac11066.png)

![image](https://user-images.githubusercontent.com/84712694/198877577-154fb8af-d001-400c-90f2-35869b4c3cb9.png)

![image](https://user-images.githubusercontent.com/84712694/198877591-c4331d0d-142e-4ad4-bd91-12854c7e3ce3.png)

![image](https://user-images.githubusercontent.com/84712694/198877616-866f4c5b-f487-488a-9bd4-7de798e0cfc6.png)

![image](https://user-images.githubusercontent.com/84712694/198877642-a1f71e9d-921d-46e7-ba4f-636278226ed7.png)

![image](https://user-images.githubusercontent.com/84712694/198877664-8944382e-45c3-40e6-ad3b-55da73eee31b.png)


### **Infix para postfix c/ prioridade:**

![image](https://user-images.githubusercontent.com/84712694/198877761-8cd02290-45a6-45fd-aa54-260d0f7f3da4.png)

![image](https://user-images.githubusercontent.com/84712694/198877915-8fcb97ea-7e03-4dea-a561-8314fc6ae1e1.png)

![image](https://user-images.githubusercontent.com/84712694/198877928-f2843e0f-e1ed-49b7-bfcf-243cab1e2870.png)

![image](https://user-images.githubusercontent.com/84712694/198877956-f5fe09b7-505a-4418-bcca-f9f287be9457.png)

![image](https://user-images.githubusercontent.com/84712694/198877971-a0ae4c6a-337d-4ead-b26a-0b631183af63.png)


### **Infix para postfix exemplo final:**

![image](https://user-images.githubusercontent.com/84712694/198878085-9d9b25f2-24cd-476b-98d8-a7bc8d023e4d.png)

![image](https://user-images.githubusercontent.com/84712694/198878093-9b3fea58-51ca-43e1-a9ed-9d037ab3cec0.png)

![image](https://user-images.githubusercontent.com/84712694/198878101-a3c132a4-4af9-4406-aa02-6d213fe4aeec.png)

![image](https://user-images.githubusercontent.com/84712694/198878110-02574895-e10e-4a11-a022-d5dec5726428.png)

![image](https://user-images.githubusercontent.com/84712694/198878119-813f93e3-144e-4bf3-9fea-f77881a0c271.png)

![image](https://user-images.githubusercontent.com/84712694/198878123-f77950e1-d9bc-4f4d-99e3-3b4c5776d4bc.png)

![image](https://user-images.githubusercontent.com/84712694/198878133-753e975b-205d-4103-ba76-3af33bce92cd.png)

![image](https://user-images.githubusercontent.com/84712694/198878137-d0970fc0-eb71-48f9-9c30-0bef5daa84c7.png)

![image](https://user-images.githubusercontent.com/84712694/198878144-7a5bb143-1d44-4269-acc9-3ef8a9e70e59.png)

![image](https://user-images.githubusercontent.com/84712694/198878154-bd2533e8-3ccc-44a6-aa76-e5cedfbae251.png)

![image](https://user-images.githubusercontent.com/84712694/198878162-7635b792-cff8-4d2c-ac23-33e186cf7556.png)

![image](https://user-images.githubusercontent.com/84712694/198878166-d646dae6-6d96-4d6b-9ab5-155a2fbbc709.png)

![image](https://user-images.githubusercontent.com/84712694/198878174-74f4f722-3639-4006-9e44-35344b00133c.png)


### Compressão de dados (árvore de Huffman):

![image](https://user-images.githubusercontent.com/84712694/198881351-095725c3-9396-454a-80b8-be63b7d518c5.png)


- Codificação de Huffman:
    - Como criar uma árvore que minimize o nº de bits necessários?
        - Os símbolos mais frequentes devem ter uma representação mais curta e os símbolos menos frequentes devem ter uma representação mais longa.

- Algoritmo de Huffman:
    - A árvore é construída de baixo para cima, agregando sub-árvores de acordo com a frequência dos respetivos símbolos:
        - Devem sempre ser agregadas as sub-árvores com menos símbolos;
        - Os empates são resolvidos arbitariamente.

#### Exemplo: **"ORANGOTANGO"**

1. Calcula-se a frequência das letras.

![image](https://user-images.githubusercontent.com/84712694/198883535-8f3069e8-5d16-4529-adab-8568c49d6117.png)

2. Agrupam-se 2 dos elementos com menor frequência numa árvore.

![image](https://user-images.githubusercontent.com/84712694/198883581-aa7cbe2e-be7c-439f-86a1-f4d83fdf76b2.png)

3. Repete-se o processo. Neste caso, há 4 sub-árvores com apenas 2 elementos: {*A*, *N*, *G*, e a sub-árvore que acabámos de construir}
    - Podem ser agrupadas quaisquer 2 destas sub-árvores;
    - Vamos escolher, arbitriamente, *N* e *G*.

![image](https://user-images.githubusercontent.com/84712694/198883911-eea8b539-d59d-4869-b156-31fd472b9c3e.png)

4. Repete-se o processo. Agora as sub-árvores menores são "A" e a 1ª que contruimos.

![image](https://user-images.githubusercontent.com/84712694/198883958-ed7068a5-5c0e-4829-958a-54d87187432c.png)

5. Repete-se o processo mais 2x

![image](https://user-images.githubusercontent.com/84712694/198883981-759682a6-9616-4c5a-b045-6c06aae69316.png)

![image](https://user-images.githubusercontent.com/84712694/198884025-0582c727-df3e-42fc-b15a-baf57f483a3f.png)

6. Por fim, obtém.se a codificação.

![image](https://user-images.githubusercontent.com/84712694/198884070-ee6400f5-44d4-4101-aa8e-62cfd71a985d.png)



#### **Árvores de Pesquisa Binárias:**

- Podem permitir a inserção e pesquisa de informação em tempo logaritmico:
    - *Podem ser usadas para implementar diferentes tipos de estruturas de dados.*

- **Propriedade de Ordem:**
    - Todos os nodos na sub-árvore esquerda de um nodo raiz são menores do que a raiz;
    - Todos os nodos na sub-árvore direita de um nodo raiz são maiores do que a raiz.

![image](https://user-images.githubusercontent.com/84712694/198884347-5f0f64c3-86a8-44b0-b1c0-03f256f2a831.png)

- **A propriedade de ordem não permite a existência de elementos duplicados, mas isso é facilmente ultrapassável:**
    - Pode ser usada uma estrutura de dados secundária em cada nodo.
    - ***Exemplo:***
        - Em cada nodo pode existir uma Lista com os elementos iguais (em termos de ordem);
        - Caso os elementos sejam estritamente iguais, pode ser suficiente armazenar uma contagem.

- **Travessia de árvore equilibrada:**
    - Caso uma árvore de pesquisa equilibrada seja percorrida em ordem, os elementos são visitados por ordem crescente.

- **Pesquisa de um valor em árvores binárias equilibradas:**
    - Para procurar o valor *X* numa árvore com raiz *R*, verifica-se *R* contém *X*;
    - Caso isso não aconteça, procura-se na sub-árvore esquerda ou direita (caso o elemento seja menor ou maior do que o valor da raiz).

![image](https://user-images.githubusercontent.com/84712694/199480050-89542abe-719f-4d1f-9066-982eaa894af9.png)
![image](https://user-images.githubusercontent.com/84712694/199480094-7dcc3581-923c-4bcb-b34e-1ee232119d66.png)


#### **Estrutura típica:**

![image](https://user-images.githubusercontent.com/84712694/199480333-3b4f42f3-76dc-4ce2-9fec-ab412d3d4318.png)


**Árvores de Pesquisa Binárias: Pesquisa do Elemento Mínimo:**

***Versão Iterativa***
````
private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t ) { 
    if( t != null ) { 
        while( t.left != null ) 
            t = t.left; 
            return t; // Encontrado 
        } 
    return null; 
}
````

***Versão Recursiva***

````
private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t ) { 
    if (t==null)
        return null; 
    if(t.left==null)
        return t;
    else 
    return findMin(t.left);
}
````

**Árvores de Pesquisa Binárias:**

***Versão Iterativa***
````
private AnyType elementAt( BinaryNode<AnyType> t ) { 
    return t == null ? null : t.element; 
}
    …
private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t ) { 
    while( t != null ) { 
        if( x.compareTo( t.element ) < 0 ) 
            t = t.left; 
        else if( x.compareTo( t.element ) > 0 ) 
            t = t.right; 
        else 
            return t; 
        // Encontrado 
        //(Resultado menos provável testado em último lugar) 
    } 
    return null; 
}
````

***Versão Recursiva***

````
private BinaryNode<AnyType> find( AnyType x, BinaryNode<AnyType> t ) { 
    if( t != null ) { 
        if( x.compareTo( t.element ) < 0 ) 
            return find(x,t.left); 
        else if( x.compareTo( t.element ) > 0 ) 
            return find(x,t.right); 
        else 
            return t; 
        // Encontrado 
        //(Resultado menos provável testado em último lugar) 
    } 
    return null; 
}
````

### Inserção em Árvores de Pesquisa Binárias:

- Caso a árvore esteja vazia, cria-se uma nova raiz;
- Caso contrário:
    - Se for igual à raiz, gera exceção;
    - Se for maior do que a raiz, insere na sub-árvore direita;
    - Se for menor do que a raiz, insere na sub-árvore esquerda.

````
protected BinaryNode<AnyType> insert ( AnyType x, BinaryNode<AnyType> t ) { 
    if( t == null ) 
        t = new BinaryNode<AnyType>( x ); 
    else if( x.compareTo( t.element ) < 0 ) 
        t.left = insert( x, t.left ); 
    else if( x.compareTo( t.element ) > 0 ) 
        t.right = insert( x, t.right ); 
    else 
        throw new DuplicateItemException( x.toString( ) ); 
    // Duplicado 
    return t; //nova raiz desta sub-árvore 
} 
````

### Remoção em Árvores de Pesquisa Binárias:

- Caso simples: remoção do elemento mais pequeno de uma subárvore.

![image](https://user-images.githubusercontent.com/84712694/199483508-84183b8d-c126-467c-90b1-d4d1fff3c48c.png)

![image](https://user-images.githubusercontent.com/84712694/199483622-1510ab75-6602-4ec4-a330-ed3b9f5948f7.png)

![image](https://user-images.githubusercontent.com/84712694/199483655-608cb13a-cd15-4b2d-8a77-f7f80309e015.png)

````
public void removeMin() {
    root=removeMin(root);
}

private BinaryNode<AnyType> removeMin( BinaryNode<AnyType> t ) {
    if( t == null )
        throw new ItemNotFoundException( );
    else if( t.left != null ) {
        t.left = removeMin( t.left );
        return t;
    }
    else
        return t.right;
} 
````

- ***Remoção do Nodo (10):***

![image](https://user-images.githubusercontent.com/84712694/199484085-36fcac17-d9e3-4be6-bfc8-078c8d4011cd.png)

![image](https://user-images.githubusercontent.com/84712694/199484207-ba49398d-e26d-4e90-ae17-64f978e1b587.png)

![image](https://user-images.githubusercontent.com/84712694/199484238-a5ff0803-a6a8-441a-a043-92e93be490a8.png)

![image](https://user-images.githubusercontent.com/84712694/199484270-3806e75d-331c-4e89-a65a-af9cc05a39ce.png)

- ***Casos especiais:***

![image](https://user-images.githubusercontent.com/84712694/199484399-288119bd-ed80-4619-8433-b4a024bf9f9a.png)

![image](https://user-images.githubusercontent.com/84712694/199484437-8a24b474-d245-41bc-9b52-bc6302f6478b.png)

````
protected BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t ) {
    if( t == null )
        throw new ItemNotFoundException( x.toString( ) );
    if( x.compareTo( t.element ) < 0 )
        t.left = remove( x, t.left );
    else if( x.compareTo( t.element ) > 0 )
        t.right = remove( x, t.right );
    else if( t.left != null && t.right != null ) { // Dois descendentes
        t.element = findMin( t.right ).element;
        t.right = removeMin( t.right );
    }
    else
        t = ( t.left != null ) ? t.left : t.right; // Um só descendente
    return t;
} 
````

#### Complexidade das Operações:

![image](https://user-images.githubusercontent.com/84712694/199485014-5c6b0d5c-758e-48e6-8b8e-7e8c7f8469b3.png)

- Complexidade das operações:
    - **A complexidade varia entre O(Log N) e O(N);**
    - **E no caso “médio”?**
        - No caso de uma árvore criada através da inserção de elementos aleatórios distribuidos de forma uniforme, o desempenho é 38% pior do que no caso ideal.
    - **A remoção de nodos pode ser ligeiramente problemática (em teoria) dado que tende a desequilibrar a árvore para a esquerda...**
        - A profundidade de uma àrvore sujeita a N inserções/remoções tende a convergir para O(√N).
        - Mas em termos práticos o efeito não costuma ser observável.
    - **O principal problema não é a complexidade média ou o desequilirio causado pela remoção:**
        - O principal problema reside no facto de a introdução de sequências ordenadas (ou semi-ordenadas) é uma acção relativamente frequente, resultando directamente na redução ao pior caso possível.

### Árvores Equilibradas:

- Abordagem simplificada:
    - A propriedade mais simples é requerer que as sub-árvores direita e esquerda tenham a mesma profundidade.
        - Esta abordagem é demasiado custosa em termos de *inserção* e *remoção* de nodos.

### Árvores AVL:

- **Propriedade de equilibrio AVL:**
    - A profundidade da sub-árvore direita e esquerda só pode diferir em 1.

![image](https://user-images.githubusercontent.com/84712694/199622154-4683c818-7472-4a26-a489-dcf32bd4deeb.png)


### **Inserção:**

![image](https://user-images.githubusercontent.com/84712694/199622211-fd3c6924-ec0d-4cc5-9740-2f5a48b61654.png)

````
Torna-se necessário efetuar uma operação adicional que assegura a preservação de equilíbrio da árvore.
````
**Oberservação:**
![image](https://user-images.githubusercontent.com/84712694/199622345-b2e46caa-92b7-4fca-8e03-806336cd32e9.png)

- Reequilibrar a árvore:
    - Percorrer a árvore desde o nodo inserido até à raiz;
    - Reequilibrando a árvore em cada nodo conforme necessário.
        - Neste caso será necessário reequilibrar apenas o 1º nodo que viola a condição de equilibrio.
    
            ![image](https://user-images.githubusercontent.com/84712694/199622626-b64e107f-5cbd-417b-933d-cc78365a81f0.png)

    - Para reequilibrar a árvore:
        - Identificamos o nodo que necessita de ser reequilibrado (8);
            - 1º Caso (Inserção exterior):
                - Uma inserção na sub-árvore esquerda do descendente esquerdo;
                - Uma inserção na sub-árvore direita do descendente direito.
            - 2º Caso (Inserção interior):
                - Uma inserção na subárvore direita do descendente esquerdo;
                - Uma inserção na subárvore esquerda do descendente direito.
                    
````
O desequilibrio pode acontecer por causa de um dos seguintes cenários:
    > Uma inserção na sub-árvore esquerda do descendente esquerdo;
    > Uma inserção na sub-árvore direita do descendente direito;
    > Uma inserção na sub-árvore direita do descendente esquerdo;
    > Uma inserção na subárvore esquerda do descendente direito.
````

- Rotação:
    - O resultado de uma inserção exterior pode ser equilibrado com uma única rotação da árvore.
    - O resultado de uma inserção interior pode ser equilibrado com duas rotações da árvore.
            ![image](https://user-images.githubusercontent.com/84712694/199623166-2062e204-e30d-4c86-ac91-e11f38fed25d.png)


- Assim, para conseguirmos reequilibrar a árvore temos que:
    ![image](https://user-images.githubusercontent.com/84712694/199623421-53508665-8f94-4f53-a9dd-55746a75ccd2.png)

    1. Identificamos o nodo que necessita de ser reequilibrado (8);
    - Caso de uma inserção exterior:
        2. Efetuamos uma rotação no nodo 8.
            ![image](https://user-images.githubusercontent.com/84712694/199623483-669e5024-5d87-4a64-8a50-7226a8dd4c3e.png)
    - Caso de uma inserção interior:

        ![image](https://user-images.githubusercontent.com/84712694/199623637-5d3ac01f-ffa6-4a22-94eb-c8ebc1cceae4.png)

        2. Vamos subdividir a sub-árvore onde a inserção é feita em duas e fazer 2 rotações.
        ![image](https://user-images.githubusercontent.com/84712694/199623714-fb6dc4c8-8a24-498f-8cea-f08d22c87cbe.png)

    
