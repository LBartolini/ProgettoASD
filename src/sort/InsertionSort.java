package sort;

import list.Nodo;

public class InsertionSort {

	public static <T> void sort(Nodo<T>[] array) {
		sort(array, 0, array.length-1);
	}
	
	public static <T> void sort(Nodo<T>[] array, int start, int end){
		
		for(int i = start+1; i <= end; i++) {
			for(int j = i-1, k=i; j >= start; j--, k--) {
				if(array[k].getChiave() < array[j].getChiave()) {
					swap(array, k, j);
				}else {
					break;
				}
			}
		}
		
	}
	
	private static <T> void swap(Nodo<T>[] array, int i, int j) { // swap degli elementi in posizione i e j
		Nodo<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
