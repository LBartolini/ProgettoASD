// Bartolini Lorenzo
// De Santis Stefano
// Pasquini Lorenzo

package list;

import java.util.LinkedList;
import java.util.ArrayList;

import sort.MergeSort;

public class ListaCircolare<T> {
	
	private Nodo<T> head;
	private int size;
	
	public ListaCircolare() {
		size = 0;
	}
	
	public ListaCircolare(T info, int chiave) {
		initHead(info, chiave);
	}
	
	private void initHead(T info, int chiave) {
		Nodo<T> head = new Nodo<>(info, chiave);
		
		this.head = head;
		this.head.setNext(head);
		this.head.setPrev(head);
		
		size = 1;
	}
	
	public void insert(T info, int chiave) {
		if(head == null) {
			initHead(info, chiave);
			return;
		}
			
		if(searchPrivate(info, chiave).size() > 0) 
			return;
		
		Nodo<T> elemento = new Nodo<>(info, chiave);
		Nodo<T> temp = head.getNext();
		
		head.setNext(elemento);
		temp.setPrev(elemento);
		
		elemento.setNext(temp);
		elemento.setPrev(head);
		
		size++;
	}
	
	private void remove(Nodo<T> el) {
		el.getPrev().setNext(el.getNext());
		el.getNext().setPrev(el.getPrev());
		size--;
	}
	
	public void remove(int chiave) {
		if(head.getChiave() == chiave) { 
			remove(head);
			head = head.getNext();
			return;
		}
		
		for(Nodo<T> nodo: searchPrivate(chiave)) {
			remove(nodo);
		}
	}
	
	private LinkedList<Nodo<T>> searchPrivate(T info, int chiave) {
		LinkedList<Nodo<T>> ret = new LinkedList<>();
		
		if(head == null)
			return ret;
		
		if(head.getChiave() == chiave && head.getInfo().equals(info)) {
			ret.add(head);
			return ret;
		}
		
		Nodo<T> el_fw = head.getNext();
		Nodo<T> el_bw = head.getPrev();
		boolean trovato = false;
		while(el_fw.getPrev() != el_bw && !trovato && el_fw != head) {
			if(el_fw.getChiave() == chiave && el_fw.getInfo().equals(info)) {
				ret.add(el_fw);
				trovato = true;	
			}
			
			if(el_fw != el_bw && el_bw.getChiave() == chiave && el_bw.getInfo().equals(info)) {
				ret.add(el_bw);
				trovato = true;
			}
			
			el_fw = el_fw.getNext();
			el_bw = el_bw.getPrev();
		}
		
		return ret;
	}
	
	private LinkedList<Nodo<T>> searchPrivate(int chiave) {
		LinkedList<Nodo<T>> ret = new LinkedList<>();
		
		if(head == null)
			return ret;
		
		if(head.getChiave() == chiave) {
			ret.add(head);
			return ret;
		}
		
		Nodo<T> el_fw = head.getNext();
		Nodo<T> el_bw = head.getPrev();
		boolean trovato = false;
		while(el_fw.getPrev() != el_bw && !trovato) {
			if(el_fw.getChiave() == chiave) {
				ret.add(el_fw);
				trovato = true;	
			}
			
			if(el_fw != el_bw && el_bw.getChiave() == chiave) {
				ret.add(el_bw);
				trovato = true;
			}
			
			el_fw = el_fw.getNext();
			el_bw = el_bw.getPrev();
		}
		
		return ret;
	}
	
	public String search(int chiave) {
		LinkedList<Nodo<T>> nodi = searchPrivate(chiave);
		
		if(nodi.size()==0)
			return "Nessun nodo con la chiave ["+chiave+"]";
		
		String ret = nodi.remove(0).toString();
		
		for(Nodo<T> nodo: nodi) {
			ret += ", "+nodo.toString(); 
		}
		
		return ret;
	}
	
	public Nodo<T> get(int indice){
		if(indice >= size || indice < 0)
			return null;
		
		Nodo<T> temp = head;
		
		if(indice < size/2) {
			for(int i = 0; i<indice; i++) {
				temp = temp.getNext();
			}
		}else {
			for(int i = 0; i<indice; i++) {
				temp = temp.getPrev();
			}
		}
		
		return temp;
	}
	
	public int size() {
		return size;
	}
	
	public Nodo<T> getHead(){
		return head;
	}
	
	public Nodo<T> getLast(){
		return head.getPrev();
	}
	
	private Nodo<T>[] getArray(){
		Nodo<T>[] ret =  new Nodo[size];
		int i=0;
		ret[i++] = head;
		Nodo<T> x = head.getNext();
		
		while(x != head) {
			ret[i++] = x;
			x = x.getNext();
		}
		
		return ret;
	}
	
	public String getStringSPrime() {
		if(head == null)
			return "Empty";
		
		Nodo<T>[] array = getArray();
		MergeSort.sort(array);
		
		String ret = array[0].toString();
		for(int i = 1; i < array.length; i++) {
			ret += ", "+array[i].toString();
		}
		
		return ret;
	}
	
	public String getStringS() {
		return toString();
	}
	
	public String toString() {
		if(head == null)
			return "Empty";
		
		String ret = head.toString();
		Nodo<T> x = head.getNext();
		
		while(x != head) {
			ret += ", "+x.toString();
			x = x.getNext();
		}
		
		return ret;
	}

	
	
}
