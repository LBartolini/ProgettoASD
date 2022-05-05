package sort;

import list.Nodo;
public class MergeSort {

	private static <T> void merge(Nodo <T> arr[], int start, int mid, int end)
	{
		int start2 = mid + 1;
		if (arr[mid].getChiave() <= arr[start2].getChiave()) {
			return;
		}

		while (start <= mid && start2 <= end) {
			if (arr[start].getChiave() <= arr[start2].getChiave()) {
				start++;
			}
			else {
				Nodo<T> value = arr[start2];
				int i = start2;

				while (i != start) {
					arr[i] = arr[i - 1];
					i--;
				}
				arr[start] = value;
				start++;
				mid++;
				start2++;
			}
		}
	}

	private static <T> void mergeSort(Nodo <T> arr[], int l, int r)
	{
		if (l < r) {
			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
	
	public static <T> void sort(Nodo <T> arr[]) {
		mergeSort(arr, 0, arr.length-1);
	}
}
