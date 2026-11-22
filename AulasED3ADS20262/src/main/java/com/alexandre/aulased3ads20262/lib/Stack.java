/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alexandre.aulased3ads20262.lib;

import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class Stack<T> {
    
    private ArrayList<T> data; // Lista interna privada
    private ArrayList<T> historyData; // elementos que já sairam com pop
    private int limit; // tamanho maximo da pilha

    public Stack() {
        this(100); // limite padrão
    }
    
    public Stack(int limit) {
        this.data = new ArrayList<T>(); // lista vazia
        this.historyData = new ArrayList<T>();
        this.limit = limit;
    }
    
    //método para inserção de dados na pilha
    public void push(T val){
        if(this.data.size() >= limit){
            System.out.println("Erro: pilha cheia, nao foi possivel inserir " + val);
            return;
        }
        this.data.add(val);
    }
    
    //método para remoção de dados na pilha
    public T pop(){
        if(isEmpty()) return null;
        T removido = this.data.remove(this.data.size() - 1);
        historyData.add(removido);
        return removido;
    }
    
    //retorna o historico do que foi removido
    public ArrayList<T> getHistory(){
        return historyData;
    }
    
    //método para informar se a pailha está vazia
    public boolean isEmpty(){
        return this.data.isEmpty();
    }
    
    //método para consultar o topo (última posição) da pilha (sem remover)
    public T peek(){
        if(isEmpty()) return null;
        return this.data.get(this.data.size() - 1);
    }
    
    // método que imprime a pilha para efeitos de depuração
    public String print(){
        return this.data.toString();
    }
}


