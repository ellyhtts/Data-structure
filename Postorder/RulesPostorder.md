# Exercício: Percurso em Pós-Ordem (Postorder) em BST

Este repositório contém a resolução de um exercício prático de Estrutura de Dados envolvendo **Árvores Binárias de Busca (BST)** e algoritmos de percurso.

## Objetivo
O objetivo é inserir uma sequência de valores em uma BST e realizar o percurso **Pós-Ordem**, seguindo a regra: **Esquerda → Direita → Raiz**.

## Construção da Árvore
Os valores foram inseridos na seguinte ordem:
**50, 30, 70, 20, 40, 60, 80**

### Estrutura Resultante:
1.  **50** é a raiz.
2.  **30** (menor que 50) vai para a esquerda; **70** (maior que 50) vai para a direita.
3.  **20** e **40** tornam-se filhos de 30.
4.  **60** e **80** tornam-se filhos de 70.

---

## Percurso Pós-Ordem (Postorder)
No percurso Pós-Ordem, visitamos os filhos (subárvores) antes de visitar o nó pai. 

**Lógica de visitação:**
1.  Subárvore Esquerda completa.
2.  Subárvore Direita completa.
3.  Raiz Atual.

**Resultado esperado:**
> `20, 40, 30, 60, 80, 70, 50`
