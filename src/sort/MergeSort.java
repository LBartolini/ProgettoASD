// Bartolini Lorenzo
// De Santis Stefano
// Pasquini Lorenzo

package sort;

import java.util.Arrays;

import list.Nodo;

public class MergeSort {
	
	private static final int SIZE_INSERTION_SORT = 4;
	
	public static <T> void sort(Nodo<T>[] array) {
		mergeSortRicorsivo(array, 0, array.length-1);
	}
	
	private static <T> void mergeSortRicorsivo(Nodo<T>[] A, int left, int right) {
		if(left >= right) return;
		
		int m = (left+right)/2;
		
		if(m-left > SIZE_INSERTION_SORT) {
			mergeSortRicorsivo(A, left, m);
			mergeSortRicorsivo(A, m+1, right);
		}else {
			InsertionSort.sort(A, left, m);
			InsertionSort.sort(A, m+1, right);
		}
		
		merge(A, left, m, right);
	}
	
	private static <T> void merge(Nodo<T>[] A, int left1, int mid, int right) {
		Nodo<T>[] temp = new Nodo[right-left1+1];
		int i = 0; // indice per l'inserimento in temp
		int left2 = mid+1;
		int k=left1;
		
		// scorro i "due vettori" e inserisco in temp il valore minore 
		// tra quelli puntati da i e j
		while(left1 <= mid && left2 <= right) {
			if(A[left1].getChiave() <= A[left2].getChiave()) {
				temp[i++] = A[left1++];
			}else {
				temp[i++] = A[left2++];
			}
		}
		
		// effettuo un for per inserire gli elementi mancanti 
		// dal vettore di destra o sinistra
		if(left1 <= mid) {	
			for(int j = left1; j <= mid; j++) {
				temp[i++] = A[j];
			}
		}else {
			for(int j = left2; j <= right; j++) {
				temp[i++] = A[j];
			}
		}
		
		// copia dal vettore di appoggio nel vettore di partenza
		for(int t=0; k <= right; k++) {
			A[k] = temp[t++];
		}
		
	}
	
}
