package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack<K, V>  {

	//Atributos
	private Node<K,V> top;
	private int size;
	private Node<K,V> actual;

	//constructor
	public Stack(){
		actual = null;
		top = null;
		size = 0;
	}

	//----metodos: getters y setters----------
	public boolean isEmpty(){
		if(top == null){
			return true;
		}else{
			return false;
		}
	}

	public int getSize(){
		return size;
	}
	
	public Node<K,V> darActual(){
		return actual;
	}


	public Node<K,V> darTope(){
		return top;
	}

	
	//hacer el add
	public void add( K key, V value){

		if( key != null && value != null ){
			
			Node<K,V> node = buscar(key);
			
			if (node != null){
				
				node.setValue(value);
				
			}else{

				Node<K,V> tmp = top;
				
				top = new Node<K,V>(key, value);
				
				top.setNex(tmp);
				
				size++;
				
				if(actual == null){
					actual = top;
				}
			}
		}
	}





	public Node<K,V> buscar( K key ){
		
		Node<K,V> n = top;
		
		if(top!= null){
			
			for(int i = size; i>0 && n!=null ; i-- ){

				if( n.getKe( ).equals(key) ){
					return  n;
				}
				
				n = n.getNex(); 
			}
		}
		return null;
	}

	
	public Node<K,V> remove(){
		
		Node<K,V> v = null;
		
		if(top != null){
			
			v = top;
			
			if( top.getNex() == null ) {
				actual = null;
			}
			
			if (top == actual) {
				actual = top.getNex();
			}
			
			
			top = top.getNex();
			
			size--;

		}
		
		return v;

	}









}


