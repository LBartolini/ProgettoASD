// Java program in-place Merge Sort

public class InPlaceMerge {

	static void merge(int arr[], int start, int mid, int end)
	{
		int start2 = mid + 1;
		if (arr[mid] <= arr[start2]) {
			return;
		}

		while (start <= mid && start2 <= end) {
			if (arr[start] <= arr[start2]) {
				start++;
			}
			else {
				int value = arr[start2];
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

	static void mergeSort(int arr[], int l, int r)
	{
		if (l < r) {

			int m = l + (r - l) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public static void main(String[] args)
	{
		int arr[] = { 2, 4, 9, 5, 6, 7 };

		mergeSort(arr, 0, arr.length - 1);

	}
}
