package com.ds.qs;

public class MyQueue {

	private int elements[] = new int[10];
	
	private int size = 0;
	
	private int top = -1;
	
	public void enqueue(int elem){
		if(size < elements.length){
			elements[size++] = elem;
		}else{
			System.out.println("Queue is full");
		}
			
	}
	
	public int dequeue(){
		if(top < size - 1){		
			System.out.println( "size "+top );
			return elements[++top];
		}else{
			throw new RuntimeException("Queue is empty");
		}
		
	}
	
	public static void main(String s[]){
		
		MyQueue q = new MyQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);
		
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		System.out.println( q.dequeue() );
		
		System.out.println( q.dequeue() );
		
		
		
	}
	
}
