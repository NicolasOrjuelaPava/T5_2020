package model.data_structures;


public class LinkedList<E> {

	private Node<E> head;
	private int currentSize;
	
	//constructor
	public LinkedList(){
		head = null;
		currentSize = 0;
	}
	
	//Clase del NODO
	public class Node<E>{
		E data;
		Node<E> next;
		public Node (E obj){
			data = obj;
			next = null;
		}
		public String toString(){
			return data.toString();
		}
	}

	
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj);
		node.next = head;
		head = node;
		currentSize++;		
	}

	public void addLast(E obj) {
		Node<E> node = new Node<E>(obj);
		Node<E> tmp = head;
		if (head == null){
			head = node;
			currentSize++;
			return;
		}
		//llego al ultimo
		while (tmp.next != null){
			tmp = (LinkedList<E>.Node<E>) tmp.next;
		}
		tmp.next = node;
		currentSize++;
	}


	public Node<E> getFirst(){
		return head;
	}
	


	public int getSize(){
		return currentSize;
	}





}
