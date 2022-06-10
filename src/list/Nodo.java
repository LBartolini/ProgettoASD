// Bartolini Lorenzo 7073016
// De Santis Stefano 7074785
// Pasquini Lorenzo 7074017

package list;

public class Nodo<T>{

	private T info;
	private int chiave;
	
	private Nodo<T> next, prev;
	
	public Nodo(T info, int chiave) {
		this.info = info;
		this.chiave = chiave;
	}
	
	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}

	public Nodo<T> getPrev() {
		return prev;
	}

	public void setPrev(Nodo<T> prev) {
		this.prev = prev;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public int getChiave() {
		return chiave;
	}

	public void setChiave(int chiave) {
		this.chiave = chiave;
	}
	
	public String toString() {
		return "["+info.toString()+","+chiave+"]";
	}
	
	
}
