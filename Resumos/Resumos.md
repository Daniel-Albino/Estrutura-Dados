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


### Alguns apontamentos importantes:

![Caderno3](https://user-images.githubusercontent.com/84712694/196771882-a78fefea-ab38-4311-8cc0-f78e3cf1422d.jpg)
![Caderno4](https://user-images.githubusercontent.com/84712694/196771850-9c0c52b6-202c-41d4-ad12-0ba05fe32b76.jpg)
![Caderno5](https://user-images.githubusercontent.com/84712694/196771857-e80c9893-7339-4ca0-ab60-151c9e848a30.jpg)
![Caderno6](https://user-images.githubusercontent.com/84712694/196771868-51f188ec-b86c-4c7d-8205-12994fa15f9a.jpg)
![Caderno7](https://user-images.githubusercontent.com/84712694/196771876-a5895b84-6209-45ae-99cd-ad2038e9d188.jpg)



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

