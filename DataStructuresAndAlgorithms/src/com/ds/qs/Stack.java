package com.ds.qs;

public class Stack<T> {
	
	private Node<T> top;
	
	public void push(T data){
		Node<T> temp = new Node(data,null);
		temp.next  = top;
		top = temp;
	}
	
	
	public T pop(){
		
		Node<T> top1 = top;
		top = top.next;
		return top1.data;
		
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public String toString(){
		
		Node<T> node = top;
		StringBuilder ob=new StringBuilder();
		while(node!=null){
			ob.append(node.data+" ");
			node = node.next;
			
		}
		return ob.toString();
	}
	
	
	private static class Node<T>{
		T data;
		Node<T> next ;
		
		public Node(T data,Node<T> n)
		{
		    this.data = data;
		    this.next = n;
		}
	}
	
	
	public static void main(String s[]){
		
		Stack<String> obj = new Stack<String>();
		obj.push("a");
		obj.push("b");
		obj.push("c");
		obj.push("d");
		
		System.out.println( obj.toString() );
		
		System.out.println( obj.pop() );
		System.out.println( obj.pop() );
		
		System.out.println( obj.toString() );
	}

}
