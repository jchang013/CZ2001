
public class InsertionSort {
	
	public int arr[];
	public int asc[];
	public int desc[];
	public long comparison;
	
	public InsertionSort() {
		
	}
	
	public InsertionSort(int arr[], int n) {
		this.arr = new int[n];
		asc = new int[n];
		desc = new int[n];
		System.arraycopy(arr, 0, this.arr, 0, n);
		for (int i = 0; i < n; i++) {
			asc[i] = i + 1;
		}
		
		for (int i = 0; i < n; i++) {
			desc[i] = n - i;
		}
	}
	
	public void sort(int arr[]) {
		comparison = 0;
		for (int i = 1; i < arr.length; i++) {
			
			for (int j = i; j > 0; j--) {
				comparison++;
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				} else
					break;
			}
		}
	}
	
}
