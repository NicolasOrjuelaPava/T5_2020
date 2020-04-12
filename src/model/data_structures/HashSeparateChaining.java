package model.data_structures;
import java.util.ArrayList;
import java.util.Iterator;

public class HashSeparateChaining<K extends Comparable<K>,V>  { 

	//---ATRIBUTOS---
	//tamaño
	private int o; 
	//cant elementos por posicion
	private int n;
	private Stack< K,V>[] stack; 
	//cantidad de rehashes
	private int cantRehash;

	//-----CONSTRUCTOR-----
	public HashSeparateChaining(int j){ 
		n = 0;
		o = j;
		stack = (Stack< K, V >[]) new Stack[o];
		
		for (int i = 0; i < o; i++)
			stack[i] = new Stack<K,V>( );
	}
	
	
	//------METODOS-----
	public int darTamanio( ){
		return o;
	}
	
	public int darNumeroParejas(){
		return n;
	}
	
	private int hashFunction( K key ){ 
		return (key.hashCode() & 0x7fffffff) % o; 
	}

	public int darCantidadReHash(){
		return cantRehash;
	}

	
	public Value<V> get(K key){ 
		
		Node<K,V> nodo = stack[hashFunction(key)].buscar(key);
		
		if(nodo!=null){
			
			return (Value<V>) nodo.getFirst( ); 
		}
		
		return null;
	}

	
	public Iterator <Value<V>> getSet(K key){ 
		
		Node<K,V> nodo = stack[hashFunction(key)].buscar(key);
		
		
		if(nodo!=null){
			
			return  nodo.iterator( ); 
		
		}
		
		return new ArrayList<Value<V>>().iterator( );
	}

	
	public void put(K key, V val){ 
		
		if(((float) n/o ) > 5.0) {
			rehash( ); 
		}
		
		stack[hashFunction(key)].add(key, val);
		
		n++;

	}

	
	
	public void add(K key, V val){ 
		
		if( val ==null ||key==null){
			return;
		}
		
		if( ((double) n/o )>5.0 ) {
			rehash( ); 
		}
		
		stack[hashFunction(key)].add(key, val);
		
		n++;

	}

	public Node<K, V> delete( K key ){
		n--;
		
		return stack[hashFunction(key)].remove();
	}




	public void rehash( ){
		
		Stack<K,V>[ ] stack2 = stack;
		
		o = o*3/2;
		
		
		
		stack = (Stack<K,V>[ ]) new Stack[o];



		for( int i = 0 ; i<o; i++){
			
			int a= 0;
			
			Node<K,V> n = stack2[i].darTope( );
			
			while ( a < stack2[i].getSize( ) ){
				
				add(n.getKe( ), n.getFirst( ).getData( ) );
				n = n.getNex( );
				a++;
			}
		}
		
		cantRehash++;

	}

	
	
	
	
	public Iterator<K> keys(){
		
		ArrayList<K> arrray = new ArrayList<K>( );
		
		for(int i = 0 ; i<o; i++){
			
			int u = 0;
			
			Node<K,V> n = stack[i].darTope( );
			
			
			while (u < stack[i].getSize()){
				
				arrray.add(n.getKe( ) );
				
				n = n.getNex( );
				
				u++;
			}
		}

		Iterator<K> iter = arrray.iterator();
		
		
		return iter;

	}
	
	
	
	
	
}



