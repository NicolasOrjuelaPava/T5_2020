package model.data_structures;

public class Value<K> {
	
	//atributos
	private K data;
	private Value<K> next;
	
	//constructor
	public Value(K pData){
		data = pData;
		next = null;
	}
	
	//getters y setters
	public K getData(){
		return data;
	}
	
	public Value<K> getNext(){
		return next;
	}
	
	public void setNext(Value<K> pValue){
		next = pValue;
	}

}
