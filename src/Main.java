// Bartolini Lorenzo
// De Santis Stefano
// Pasquini Lorenzo

import list.ListaCircolare;

public class Main {
	
	public static void main(String[] args) throws Exception {
		ListaCircolare<String> lc = new ListaCircolare<>();
		lc.insert("plapla", 0);
		lc.insert("pluto", 1);
		lc.insert("pluggg", 1);
		lc.insert("plusac", 5);
		lc.insert("plaaau", 3);
		lc.insert("plubbn", 7);
		lc.insert("pluxcx", 8);
		lc.insert("plufgf", 9);
		lc.insert("pluuu", 10);
		lc.insert("pluvf", 12);
		lc.insert("platone", 1);
		
		System.out.println(lc.getStringSPrime());
		System.out.println(lc.getStringS());
		System.out.println(lc.search(1));
	
		lc.remove(1);
		System.out.println(lc.getStringS());
	}

}
