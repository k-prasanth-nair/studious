package com.ds.qs;

import java.util.Arrays;
import java.util.EmptyStackException;


public class MyStack {
	
	private int elements[] = new int[10];
	
	private int size = 0;

	public void push(int elem){
		ensureCapacity();
		elements[size++]=elem;
	}	
	
	public int pop(){
		if(size == 0 ) throw new EmptyStackException();
		//int elem = elements[--size];
		 // elements[size] = null; if it was an object, then this will eliminate obsolete reference
		return elements[--size];
	}	
	
	public boolean isEmpty(){
		return elements.length == 0;
	}
	
	private void ensureCapacity(){
		if(elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}
