package com.ds.qs;

public class QueueUsingStack<T>{

	private Stack<T> s1;
	
	private Stack<T> s2;
	
	public QueueUsingStack(){ 
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}
	
	
	public void enqueue(T data){
		s1.push(data);
	}
	
	public T dequeue(){
		
		if( !s2.isEmpty() ) 
			return s2.pop();
		else{
			while( !s1.isEmpty() ){
				s2.push( s1.pop() );
			}
			return s2.pop();
		}
		
		
		
	}
	
	
	public static void main(String s[]){
		// TODO Auto-generated method stub
		QueueUsingStack<String> q = new QueueUsingStack<String>();
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		
		System.out.println( q.dequeue() );
		
		q.enqueue("e");
		
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		
		System.out.println( q.dequeue() );
	}
	
	
}
