package list;

public class ListaCircolare<T> {
	
	private Elemento<T> head;
	private int size;
	
	public ListaCircolare(Elemento<T> head) {
		this.head = head;
		size = 1;
	}
	
	public void insert(Elemento<T> elemento) throws Exception {
		if(elemento == null)
			throw new Exception("Null non ammesso!");
		
		Elemento<T> temp = head.getNext();
		
		head.setNext(elemento);
		temp.setPrev(elemento);
		
		elemento.setNext(temp);
		elemento.setPrev(head);
		
		size++;
	}
	
	public void remove() {
		
	}
	
	public Elemento<T> get(int indice){
		if(indice >= size)
			throw new IndexOutOfBoundsException();
		
		if(indice < size/2) {
			
		}else {
			
		}
		
		return null;
	}
	
	public int getNumNodi() {
		return size;
	}
	
}
