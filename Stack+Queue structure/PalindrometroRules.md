# Palíndromo com Pilha e Fila



## Objetivo
Implementar um algoritmo para determinar se uma string (palavra ou frase) é um palíndromo utilizando, em conjunto, as estruturas de dados **Pilha (Stack)** e **Fila (Queue)**.

## Requisitos
* **Normalização:** Ignorar caracteres não alfanuméricos (pontuação e espaços).
* **Sensibilidade de Caso:** A avaliação deve ignorar a diferença entre maiúsculas e minúsculas (case-insensitive).
* **Critério:** Uma string é um palíndromo se, após a normalização, a leitura de frente para trás for idêntica à de trás para frente.

## Explicação do Fluxo Lógico (Roadmap)
O uso combinado dessas estruturas é extremamente eficaz para este problema porque elas processam dados em ordens opostas:

1.  **Fila (FIFO - First In, First Out):** Retorna os caracteres na sua **ordem original**.
2.  **Pilha (LIFO - Last In, First Out):** Retorna os caracteres na **ordem inversa**.

Ao inserir a string normalizada em ambas as estruturas simultaneamente, podemos remover um caractere por vez de cada uma e compará-los. Se em algum momento os caracteres forem diferentes, a palavra não é um palíndromo. Se ambas esvaziarem sem divergências, temos um palíndromo!
