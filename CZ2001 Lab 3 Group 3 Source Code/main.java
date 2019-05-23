
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[];
		long start, end;
		
		System.out.println("Enter array size: ");
		int n = sc.nextInt();
		System.out.println();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        Collections.shuffle(list);
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = list.get(i);
		}
		
		InsertionSort insertsort = new InsertionSort(arr, n); 
		MergeSort mergesort = new MergeSort(arr, n);
		
		System.out.println("Generated array of integers: ");
		//printArray(arr);
		System.out.println("Generated array of integers sorted in ascending order to be sorted by Insertion Sort: ");
		//printArray(insertsort.asc);
		System.out.println("Generated array of integers sorted in descending order to be sorted by Insertion Sort: ");
		//printArray(insertsort.desc);
		System.out.println("Generated array of integers sorted in ascending order to be sorted by Merge Sort: ");
		//printArray(mergesort.asc);
		System.out.println("Generated array of integers sorted in descending order to be sorted by Merge Sort: ");
		//printArray(mergesort.desc);
		System.out.println();
		
		start = System.nanoTime();
		insertsort.sort(insertsort.arr);
		end = System.nanoTime();
		System.out.println("Generated array of random integers sorted in ascending order by insertion sort (Average Case): ");
		//printArray(insertsort.arr);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + insertsort.comparison);
		System.out.println();
		
		start = System.nanoTime();
		insertsort.sort(insertsort.asc);
		end = System.nanoTime();
		System.out.println("Generated array of integers initially in ascending order sorted by insertion sort (Best Case): ");
		//printArray(insertsort.asc);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + insertsort.comparison);
		System.out.println();
		
		start = System.nanoTime();
		insertsort.sort(insertsort.desc);
		end = System.nanoTime();
		System.out.println("Generated array of integers initially in descending order sorted by insertion sort (Worst Case): ");
		//printArray(insertsort.desc);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + insertsort.comparison);
		System.out.println();
		
		mergesort.comparison = 0;
		start = System.nanoTime();
		mergesort.sort(mergesort.arr, 0, n - 1);
		end = System.nanoTime();
		System.out.println("Generated array of random integers sorted in ascending order by merge sort (Average Case): ");
		//printArray(mergesort.arr);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + mergesort.comparison);
		System.out.println();
		
		mergesort.comparison = 0;
		start = System.nanoTime();
		mergesort.sort(mergesort.asc, 0, n - 1);
		end = System.nanoTime();
		System.out.println("Generated array of integers initially in ascending order sorted by merge sort (Best Case): ");
		//printArray(mergesort.asc);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + mergesort.comparison);
		System.out.println();
		
		mergesort.comparison = 0;
		start = System.nanoTime();
		mergesort.sort(mergesort.desc, 0, n - 1);
		end = System.nanoTime();
		System.out.println("Generated array of integers initially in descending order sorted by merge sort (Worst Case): ");
		//printArray(mergesort.desc);
		System.out.println("Time taken: " + (end - start) + " nanoseconds");
		System.out.println("Number of key comparisons: " + mergesort.comparison);
		System.out.println();
		
		
	}	

	public static void printArray(int arr[]) {
	    int n = arr.length;
	    for (int i=0; i<n; ++i)
	        System.out.print(arr[i] + " ");

	    System.out.println();
	}
	
}

