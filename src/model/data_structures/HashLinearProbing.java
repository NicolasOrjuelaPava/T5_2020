package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

public class HashLinearProbing <K extends Comparable<K>, V> {

	//Atributos
	private int size;
	private int numeroDuplas;
	private Node<K,V> lista_nodos[];
	private int cantRehash;

	
	//-------CONSTRUCTOR---------
	public HashLinearProbing(int m){
		size = m;
		numeroDuplas = 0;
		lista_nodos = new Node[m];
		cantRehash = 0;
	}

	
	
	//-----------METODOS-------------
	public Node<K,V>[] getNodes(){
		return lista_nodos;
	}

	public int darSize(){
		return size;
	}

	public int getNumeroDuplas(){
		return numeroDuplas;
	}

	public int getCantRehash(){
		return cantRehash;
	}


	private int hashFunction(K key){
		
		return (key.hashCode()&0x7fffffff)%size;
		
	}
	
	
	public void put(K key,V value){
		
		if(value == null || key == null){
			return;
		}
		
		if(loadFactorCheck()){
			reSize(10*size);
		}

		
		int i = hashFunction(key);
		
		while(lista_nodos[i] != null){
			
			if(lista_nodos[i].getKe().equals(key)){
				
				lista_nodos[i].setValue(value);
				
				return;
			}

			i = (i+1) % size;
		}
		
		
		lista_nodos[i] = new Node<K,V>(key, value);
		
		numeroDuplas++;
	}

	//TERMIANR EL CHEQUEO
	public boolean loadFactorCheck(){
		
		boolean r = false;
		
		double loadFactor = size / numeroDuplas;
		
		if(loadFactor > 0.75){
			r = true;
		}
		
		return r;
	}
	


	public V get(K key){
		
		V r = null;

		if(key != null){
			
			for(int i = hashFunction(key); lista_nodos[i] != null; i = (i+1) % size){
				
				if(lista_nodos[i].getKe().equals(key)){
					
					r = lista_nodos[i].getFirst().getData();
				}
			}
		}
		return r;
	}
	

	
	public Iterator<V> getSet(K key){
		
		ArrayList<V> iterable = new ArrayList<V>();
		
		
		if(key != null){
			
			for(int i = hashFunction(key); lista_nodos[i] != null; i = (i + 1) % size){
				
				if(lista_nodos[i].getKe().equals(key)){
					
					Value<V> val = lista_nodos[i].getFirst();
					
					
					while(val != null){
						
						iterable.add(val.getData());
						
						val = val.getNext();
					}
				}
			}
		}

		Iterator<V> iter = iterable.iterator();
		
		return iter;

	}




	
	
	public void reHash(int t){
		
		t = (t + 1) % size;
		
		while (lista_nodos[t] != null){
			
			
			V rehashValue = lista_nodos[t].getFirst().getData();

			K rehashKey = lista_nodos[t].getKe();
			
			
			lista_nodos[t]=null;
			numeroDuplas--;
			
			put(rehashKey, rehashValue);
			t = (t + 1) % size;
			
		}
		
		cantRehash++;
	}

	public Iterator<K> keys(){
		
		ArrayList<K> keys = new ArrayList<K>();

		for(int i = 0; i < size; i++){
			
			if(lista_nodos[i] != null){
				
				keys.add(lista_nodos[i].getKe());
			}
		}

		Iterator<K> iter = keys.iterator();
		
		return iter;
	}

	

	private void reSize(int s){
		
		HashLinearProbing<K, V> temp = new HashLinearProbing<K, V>(s);
		
		for (int i = 0; i < size; i++){
			
			if (lista_nodos[i] != null){
				
				temp.put(lista_nodos[i].getKe(), lista_nodos[i].getFirst().getData());
			}
		}
		
		size = temp.darSize();
		lista_nodos = temp.getNodes();
		
		cantRehash++;
	}



	

	
	
}
