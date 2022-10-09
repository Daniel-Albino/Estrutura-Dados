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


