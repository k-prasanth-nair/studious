package com.ds.list;

import java.util.NoSuchElementException;

public class GenericLinkedList<T> {
	
	private static class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data,Node<T> next){
			this.data  = data;
			this.next = next;
		}
		
		public String toString(){
			return "Current is "+data+" next";
		}
	} 
	
	
	private Node<T> head ;
	
	
	public void addLast(T data){
		Node<T> newNode = new Node(data,null);
		if(head == null){
			head = newNode;			
		}else{
			Node<T> node = head;
			
			while(node.next!=null){
				node = node.next;
			}
			
			node.next = newNode;
		}
	}
	
	public void addFirst(T data){
		Node<T> newNode = new Node(data,null);
		if(head == null){
			head = newNode;			
		}else{
			Node<T> node = head;			
			head = newNode;			
			head.next = node;
		}
	}
	
	public void addBefore(T data,T beforeData){
		Node<T> newNode = new Node(data,null);
		if(head == null){
			throw new RuntimeException("List is empty");		
		}else{
			if(head.data.equals(beforeData))
				addFirst(data);
			else{
				Node<T> prev = null;
				Node<T> node = head;
				while(node.next!=null){
					prev = node;
					node = node.next;
					if(node.data.equals(beforeData)){
						prev.next = new Node(data,node);
						break;
					}
				}				
			}
			
		}
	}
	
	
	public LinkListIterator<T> iterator(){
		return new LinkedListIterator();
	}
	
	
	public interface LinkListIterator<T>{
		T next();
		boolean hasNext();		
	}
	
	public Node<T> getHead(){
		return head;
	}
	
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void printList(){
		LinkListIterator<T> oIterator = iterator();
		while(oIterator.hasNext()){
			System.out.println( oIterator.next() );
		}
	}
	
	public void printListInReverseOrder(Node<T> node){
		if(node == null) return;
		printListInReverseOrder(head.next);
		System.out.println();
	}
	
	public void reverse(){
		head = this.reverseList(head);
	}
	
	private Node<T> reverseList(Node<T> node){
		if(node == null || node.next==null) return node;
		Node<T> rest = reverseList(node.next);
		System.out.println("Node "+node.data);

		node.next.next=node;
		node.next=null;
		return rest;
	}
	
	
	public boolean checkForLoop(){
		
		return detectLoop() != null ? true : false;
	}
	
	private Node<T> detectLoop(){
		if(head == null || head.next==null) 
			return null;
		
		Node<T> slow = head;
		Node<T> fast = head;
		Boolean isLoopExists = false;
		while(slow!=null && fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast){
				isLoopExists = true;
				break;
			}
		}
		
		return isLoopExists == true ? slow : null;
	}
	
	
	public void removeLoop(){
		Node<T> loopNode = detectLoop();
		
		if(loopNode != null){
			
			Node<T> current = head;
			Node<T> loop = null;
			while(true){
				
				loop = loopNode;
				
				while( loop.next != loopNode && loop.next != current ){
					loop = loop.next;
				}
				
				if(loop.next == current)
					break;

				current = current.next;
				
			}
			loop.next = null;
			
		}
		
	}
	
	
	public void rotate(int k){
		if(k==0) return;
		
		if(head==null) throw new RuntimeException("Empty list");
		
		Node<T> current = head;
		
		for(int i=1;i<=k;i++){
			current = current.next;
		}
		Node<T> kNextNode = current.next;	
		
		//Kth node
		current.next = null;	
		
		Node<T> KPlusOnenode = kNextNode;
		
		while(KPlusOnenode.next!=null){
			KPlusOnenode = KPlusOnenode.next;
		}		
		KPlusOnenode.next=head;
		head = kNextNode;
		
	}
	
	private class LinkedListIterator implements LinkListIterator{

		private Node<T> next = head;
		public T next() {
		
			if( !hasNext() )throw new NoSuchElementException();
			T data = next.data;
			next = next.next;
			return data;
		}

		@Override
		public boolean hasNext() {
		
			return next != null;
		}
		
	}
	
	public static void main(String s[]){
		
		GenericLinkedList<String> oList = new GenericLinkedList<String>();
		oList.addLast("b");
		oList.addFirst("a");
		oList.addLast("d");
		oList.addBefore("c","d");
		oList.addLast("e");
		oList.addLast("f");
		oList.addLast("g");
		
		oList.printList();
		
		System.out.println("After reversing");
		oList.reverse();
		oList.printList();
		/*//oList.rotate(3);
		
		//System.out.println("After rotating");
		//oList.printList();*/

		/*oList.head = new Node(1,null);
		oList.head.next = new Node(2,null);
		oList.head.next.next = new Node(3,null);
		oList.head.next.next.next = new Node(4,null);
		oList.head.next.next.next.next = new Node(5,oList.head.next);
		
		System.out.println( oList.checkForLoop() );
		oList.removeLoop();
		System.out.println( oList.checkForLoop() );*/
		
		//oList.printList();
		
	}
	

}
