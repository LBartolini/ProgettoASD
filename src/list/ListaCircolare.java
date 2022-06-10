// Bartolini Lorenzo 7073016
// De Santis Stefano 7074785
// Pasquini Lorenzo 7074017

package list;

import java.util.ArrayList;
import java.util.List;

import sort.MergeSort;

public class ListaCircolare<T> {
	
	private Nodo<T> head;
	private int size; // numero di elementi nella lista
	
	public ListaCircolare() {
		// Costruttore semplice
		size = 0;
	}
	
	public ListaCircolare(T info, int chiave) {
		// Costruttore in cui si definisce le informazioni contenute in Head
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
			// Se non c'è la testa allora la inizializzo
			initHead(info, chiave);
			return;
		}
			
		// Se esiste già un nodo con la stessa chiave e informazione allora non lo aggiungo
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
		// Rimuove il nodo modificando i puntatori
		el.getPrev().setNext(el.getNext());
		el.getNext().setPrev(el.getPrev());
		size--;
	}
	
	public List<Nodo<T>> remove(int chiave) {
		// Rimuove dalla lista i nodi in base alla chiave che siano alla stessa distanza da HEAD
		List<Nodo<T>> out = new ArrayList<>();
		
		if(head.getChiave() == chiave) { 
			out.add(head);
			
			if(this.size == 1) {
				// Se c'è solo l'HEAD nella lista allora basta renderla null e azzerare size 
				head = null;
				size = 0;
			}else {
				// Se ci fosse almeno un elemento basta usare la procedura remove
				remove(head);
				head = head.getNext();
			}
			
			return out;
		}
		
		// searchPrivate restituisce i nodi alla stessa distanza da Head con chiave uguale a quella cercata
		for(Nodo<T> nodo: searchPrivate(chiave)) { 
			out.add(nodo);
			remove(nodo);
		}
		
		return out;
	}
	
	private List<Nodo<T>> searchPrivate(T info, int chiave) { 
		// Restituisce una lista contenente i nodi che hanno sia chiave che info uguale a qualli cercati
		// con la condizione che siano alla stessa distanza da head
		
		List<Nodo<T>> ret = new ArrayList<>();
		
		if(head == null)
			return ret;
		
		if(head.getChiave() == chiave && head.getInfo().equals(info)) {
			ret.add(head);
			return ret;
		}
		
		// Utilizzo questi due oggetti per riferirmi all'elemento successivo e a quello precedente rispetto a HEAD
		// Poi scorro i due oggetti nelle due direzioni e termino il ciclo se:
		// ritorno alla HEAD, 
		// se ho trovato l'elemento cercato,
		// se il riferimento al successivo ha superato il riferimento al precedente
		Nodo<T> el_fw = head.getNext();
		Nodo<T> el_bw = head.getPrev();
		boolean trovato = false;
		while(el_fw.getPrev() != el_bw && !trovato && el_fw != head) {
			
			if(el_fw.getChiave() == chiave && el_fw.getInfo().equals(info)) {
				// Controllo prima se l'elemento cercato corrisponde al riferimento al Successivo
				ret.add(el_fw);
				trovato = true;	
			}
			
			if(el_fw != el_bw && el_bw.getChiave() == chiave && el_bw.getInfo().equals(info)) {
				// Controllo anche l'elemento Precedente con la condizione che non sia lo stesso elemento di quello Successivo
				// altrimenti si duplicherebbero i riferimenti quando in realtà esiste un solo oggetto nella lista
				ret.add(el_bw);
				trovato = true;
			}
			
			// Scorro ai nodi successivi
			el_fw = el_fw.getNext();
			el_bw = el_bw.getPrev();
		}
		
		return ret;
	}
	
	private List<Nodo<T>> searchPrivate(int chiave) {
		// restituisce una lista contenente i nodi che hanno la chiave uguale a qualla cercata
		// con la condizione che siano alla stessa distanza da head
		// NB: funziona allo stesso modo tranne per il fatto che controlla solo la chiave e non anche l'informazione
		
		List<Nodo<T>> ret = new ArrayList<>();
		
		if(head == null)
			return ret;
		
		if(head.getChiave() == chiave) {
			ret.add(head);
			return ret;
		}
		
		Nodo<T> el_fw = head.getNext();
		Nodo<T> el_bw = head.getPrev();
		boolean trovato = false;
		while(el_fw.getPrev() != el_bw && !trovato && el_fw != head) {
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
		// Ricerco in base alla chiave
		
		List<Nodo<T>> nodi = searchPrivate(chiave);
		
		if(nodi.size()==0)
			return "Nessun nodo con la chiave ["+chiave+"]";
		
		// Creo la stringa da restituire in output
		String ret = nodi.remove(0).toString();
		for(Nodo<T> nodo: nodi) {
			ret += ", "+nodo.toString(); 
		}
		
		return ret;
	}
	
	public Nodo<T> get(int indice){ // 1 <= indice <= size
		// Cerco il nodo che si trova all'indice indicato
		
		if(indice <= 0)
			return null;
		
		// effettuo l'operazione di modulo (sommo 1 a size perchè l'indice parte da 1) perchè la struttura dati è circolare 
		// perciò ricercando un elemento maggiore del numero di elementi presenti attualmente
		// restituirà l'elemento in posizione modulo size
		indice = indice%(size+1); 
		
		Nodo<T> temp = head;
		
		// controllo affinchè possa procedere nella direzione giusta 
		// per dimezzare il numero di elementi da scorrere prima di arrivare a quello cercato
		if(indice <= size/2) { 
			for(int i = 1; i<indice; i++) { // i comincia da 1 perchè l'indice in input può essere minimo 1
				temp = temp.getNext();
			}
		}else {
			for(int i = 0; i<size-indice+1; i++) {
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
		// Converto la lista in un array per eseguire l'ordinamento 
		
		Nodo<T>[] ret = new Nodo[size];
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
		// Ordino gli elementi e successivamente creo la stringa di output 
		
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
