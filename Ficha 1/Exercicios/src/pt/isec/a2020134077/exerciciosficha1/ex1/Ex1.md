# Exercício 1:

a) A instrução soma++ é executada n x n vezes. O programa é de complexidade O(n^2). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 4n vezes. Portanto, o tempo de execução aumentar 16 vezes. (Quadrático)

b) A instrução soma++ é executada n vezes. O programa é de complexidade O(n). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n vezes. Portanto, o tempo de execução aumentar 4 vezes. (Linear)

c) A instrução soma++ é executada n/2 vezes. O programa é de complexidade O(n). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n vezes. Portanto, o tempo de execução aumentar 4 vezes. (Linear)

```` Nota: Não se pode dizer que o programa é de complexidade O(n/2). ````

d) A instrução soma++ é executada n x 1000 vezes. O programa é de complexidade O(n x 1000). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 1000 vezes. Portanto, o tempo de execução aumentar 4000 vezes. (Linear)

e) A instrução soma++ é executada n x n vezes. O programa é de complexidade O(n^2). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 4n vezes. Portanto, o tempo de execução aumentar 16 vezes. (Quadrático)

f) Algoritmo de ordem constante, O(1). O aumento de n, no limite, não interfere com o tempo de execução, porque o n é
truncado em 20000. Os ciclos encadeados têm um comportamento aparentemente quadrático. No entanto, o valor de n é
limitado a 20000 pela 1ª linha. Isso significa que o ciclo irá ter, sempre 20000 x 20000 iterações de "soma++", para
valores suficientemente elevados de n (neste caso, valores de n >= 20000). Assim, o código tem o mesmo tempo de execução
à medida que n aumenta para valores de n elevados, e dessa forma é de complexidade constante.

g) A instrução soma++ é executada n x n x n vezes. O programa é de complexidade O(n^3). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 4n x 4n vezes. Portanto, o tempo de execução aumentar 64 vezes. (Cúbico)

h) A instrução soma++ é executada n x n vezes. O programa é de complexidade O(n^2).Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 4n vezes. Portanto, o tempo de execução aumentar 16 vezes.

i) A instrução soma++ é executada n x n x n vezes. O programa é de complexidade O(n^3). Se o n for aumentado para 4n, o
soma++ vai ser executado 4n x 4n x 4n vezes. Portanto, o tempo de execução aumentar 64 vezes. 

```` Nota: No exercício h e i forma um triângulo.````

j) O i duplica a cada iteração. Um aumento de 4x de N obriga a mais 2 iterações. Na matemática, um logaritmo é o "inverso"
do expoente: log2(n) = x <=> 2^x = n. É o nº de bits necessário para representar o inteiro n.




