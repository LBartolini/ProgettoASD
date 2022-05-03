package list;

public class Elemento<T> {

	private T info;
	private int chiave;
	
	private Elemento<T> next, prev;
	
	public Elemento(T info, int chiave) throws Exception {
		if(chiave < 0 || chiave > 1000000) // 0 <= chiave <= 10^6
			throw new Exception("Valore chiave fuori dal range consentito!");
	
		this.info = info;
		this.chiave = chiave;
	}
	
	public Elemento<T> getNext() {
		return next;
	}

	public void setNext(Elemento<T> next) {
		this.next = next;
	}

	public Elemento<T> getPrev() {
		return prev;
	}

	public void setPrev(Elemento<T> prev) {
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
		return "Elemento "+info.toString()+", Chiave "+chiave;
	}
	
	
}
