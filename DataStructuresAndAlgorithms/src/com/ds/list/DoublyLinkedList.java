package com.ds.list;

import java.util.LinkedList;

/**
 * Created by prasanth on 30/3/16.
 */
public class DoublyLinkedList<E> {


    private static class Node<E>{
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E data, Node<E> next,Node<E> prev){
            this.next = next;
            this.prev= prev;
            this.data = data;
        }

        public String toString(){
            return "Current is "+data+" next";
        }
    }


    private Node<E> head ;
    private Node<E> tail ;
    private int size;

    public void add(E data){

        Node<E> newNode = new Node<E>(data,null,tail);
        if(head == null){
            head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;

    }


    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }








}
