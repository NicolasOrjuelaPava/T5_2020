package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class Node <K,V>{

	//atributos
	private Value<V> first;
	private K key; 
	private int cantidad;
	private Node<K,V> next;

	//constructor
	public Node (K pKey, V pValue){
		key = pKey;
		first = new Value<V>(pValue);
		cantidad = 1;
	}
	
	
	//metodos: getters y setters
	public K getKe(){
		return key;
	}
	
	public Node<K,V> getNex(){
		return next;
	}
	
	public void setNex(Node<K,V> n ){
		next = n;
	}

	
	public Value<V> getFirst(){
		return first;
	}
	

	
	public void putValue(V pValue){
		Value<V> anteriorPrimero = first;
		
		first = new Value<V>(pValue);
		
		first.setNext(anteriorPrimero);
		
		cantidad++;
	}
	
	
	public void setValue(V pValue){
		first = new Value<V>(pValue);
	}
	
	
	public Iterator<Value<V>> iterator( ){
		
		ArrayList<Value<V>> array = new ArrayList< Value<V>>();
		
		Value<V> val = first;
		
		for( int i=0; i<cantidad; i++){
			
			array.add( val );
			val = val.getNext();
			
			}
		
		return  array.iterator();
	}
	
	



}
