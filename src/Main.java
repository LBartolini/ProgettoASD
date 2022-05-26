// Bartolini Lorenzo
// De Santis Stefano
// Pasquini Lorenzo

import list.ListaCircolare;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ListaCircolare<String> lc = new ListaCircolare<>();
		lc.insert("Lorenzo", 0);
		lc.insert("Claudio", 5);
		lc.insert("Alessio", 2);
		lc.insert("Marco", 5);
		lc.insert("Stefano", 3);
		lc.insert("Andrea", 7);
		lc.insert("Sofia", 8);
		lc.insert("Claudio", 3);
		lc.insert("Alessio", 1);
		lc.insert("Marco", 7);
		lc.insert("Stefano", 8);
		lc.insert("Andrea", 9);
		lc.insert("Sofia", 11);
		lc.insert("Irene", 2);
		lc.insert("Irene", 9);
		lc.insert("Serena", 10);
		lc.insert("Lorenzo", 12);
		lc.insert("Marco", 1);
		lc.insert("Giovanni", 5);
		
		System.out.println(lc.size());
		System.out.println(lc.get(6));
		
		System.out.println(lc.getStringSPrime());
		System.out.println(lc);
		
		System.out.println(lc.search(5));
		lc.remove(0);
		
		System.out.println(lc);
	}

}
