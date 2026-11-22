package com.alexandre.trabalho2bimestre;

import com.alexandre.aulased3ads20262.lib.Deque;
import com.alexandre.aulased3ads20262.lib.LinkedList;
import com.alexandre.aulased3ads20262.lib.Queue;
import com.alexandre.aulased3ads20262.lib.Stack;

/**
 * Trabalho 2º Bimestre - Estrutura de Dados
 */
public class Main {

    public static void main(String[] args) {

        // ---------- Exercicio 1 ----------
        System.out.println("=== Exercicio 1 - Fila de atendimento ===");
        Queue<String> atendimento = new Queue<>();
        atendimento.enqueue("Joao");
        atendimento.enqueue("Maria");
        atendimento.enqueue("Pedro");
        atendimento.enqueue("Ana");
        System.out.println("Fila: " + atendimento.print());
        System.out.println("Atendido: " + atendimento.dequeue());
        System.out.println("Atendido: " + atendimento.dequeue());
        System.out.println("Fila: " + atendimento.print());
        System.out.println("Total de operacoes: " + atendimento.getOperationCount());

        // ---------- Exercicio 2 ----------
        System.out.println("\n=== Exercicio 2 - Navegador ===");
        Stack<String> navegador = new Stack<>();
        navegador.push("google.com");
        navegador.push("youtube.com");
        navegador.push("github.com");
        navegador.push("stackoverflow.com");
        System.out.println("Paginas: " + navegador.print());
        System.out.println("Voltar -> saiu " + navegador.pop());
        System.out.println("Voltar -> saiu " + navegador.pop());
        System.out.println("Paginas: " + navegador.print());
        System.out.println("Historico: " + navegador.getHistory());

        // ---------- Exercicio 3 ----------
        System.out.println("\n=== Exercicio 3 - Deque com limite 5 ===");
        Deque<Integer> deque = new Deque<>(5);
        for (int i = 1; i <= 6; i++) {
            deque.insertBack(i * 10);
        }
        System.out.println("Deque: " + deque.print());

        // ---------- Exercicio 4 ----------
        System.out.println("\n=== Exercicio 4 - Undo do editor (5 acoes) ===");
        Stack<String> undo = new Stack<>(5);
        undo.push("digitou 'Ola'");
        undo.push("negrito");
        undo.push("digitou ' mundo'");
        undo.push("apagou palavra");
        undo.push("italico");
        undo.push("sublinhado"); // essa nao deve entrar
        System.out.println("Acoes: " + undo.print());
        System.out.println("Desfazer: " + undo.pop());
        undo.push("sublinhado"); // agora tem espaço
        System.out.println("Acoes: " + undo.print());

        // ---------- Exercicio 5 ----------
        System.out.println("\n=== Exercicio 5 - Carrinho sem itens repetidos ===");
        Deque<String> carrinho = new Deque<>();
        carrinho.insertBack("Notebook");
        carrinho.insertBack("Mouse");
        carrinho.insertFront("Teclado");
        carrinho.insertBack("Mouse");
        carrinho.insertFront("Notebook");
        carrinho.insertBack("Monitor");
        System.out.println("Carrinho: " + carrinho.print());

        // ---------- Exercicio 6 ----------
        System.out.println("\n=== Exercicio 6 - Historico da lista ===");
        LinkedList<Integer> lista = new LinkedList<>();
        lista.insertTail(5);
        lista.insertTail(8);
        lista.insertTail(12);
        lista.insertTail(20);
        lista.insertHead(1);
        System.out.println(lista.print());
        lista.removeHead();
        lista.removeTail();
        lista.remove(1);
        System.out.println(lista.print());
        System.out.println("Removidos: " + lista.getHistory());

        // ---------- Exercicio 7 ----------
        System.out.println("\n=== Exercicio 7 - Reverse ===");
        LinkedList<String> letras = new LinkedList<>();
        letras.insertTail("A");
        letras.insertTail("B");
        letras.insertTail("C");
        letras.insertTail("D");
        System.out.println("Antes:  " + letras.print());
        letras.reverse();
        System.out.println("Depois: " + letras.print());
        letras.insertTail("E"); // so pra conferir se o tail ficou certo
        System.out.println("Inserindo E no fim: " + letras.print());

        // ---------- Exercicio 8 ----------
        System.out.println("\n=== Exercicio 8 - Contagem ===");
        LinkedList<Integer> numeros = new LinkedList<>();
        int[] valores = {3, 7, 3, 9, 7, 3, 1};
        for (int v : valores) {
            numeros.insertTail(v);
        }
        System.out.println(numeros.print());
        System.out.println("3 aparece " + numeros.countOccurrences(3) + " vezes");
        System.out.println("7 aparece " + numeros.countOccurrences(7) + " vezes");
        System.out.println("5 aparece " + numeros.countOccurrences(5) + " vezes");

        // ---------- Exercicio 9 ----------
        System.out.println("\n=== Exercicio 9 - RemoveAll ===");
        LinkedList<Integer> rep = new LinkedList<>();
        int[] valores2 = {2, 2, 4, 2, 6, 8, 2, 2};
        for (int v : valores2) {
            rep.insertTail(v);
        }
        System.out.println("Antes:  " + rep.print());
        rep.removeAll(2);
        System.out.println("Depois: " + rep.print());
        System.out.println("Head: " + rep.peekHead() + " | Tail: " + rep.peekTail());

        // ---------- Exercicio 10 ----------
        System.out.println("\n=== Exercicio 10 - toArray ===");
        LinkedList<String> frutas = new LinkedList<>();
        frutas.insertTail("Maca");
        frutas.insertTail("Banana");
        frutas.insertTail("Uva");
        System.out.println(frutas.print());
        System.out.println("ArrayList: " + frutas.toArray());
    }
}
