package dedup;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Vincent
 *
 */
public class DeDup {

	public int[] randomIntegers = {1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * Quick sort.
	 *
	 * @param arr the arr
	 * @param low the low
	 * @param high the high
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	/**
	 * sort and get unique element
	 *
	 */
	public static int[] removeDuplicatesAndSort(int[] arr) {
		if (arr.length < 2)
			return arr;

		quickSort(arr, 0, arr.length - 1);
		
		int j = 0;
		int i = 1;

		while (i < arr.length) {
			if (arr[i] == arr[j]) {
				i++;
			} else {
				j++;
				arr[j] = arr[i];
				i++;
			}
		}

		int[] b = Arrays.copyOf(arr, j + 1);

		return b;
	}

	/**
	 * Brute force approach
	 *
	 * Finds each duplicate and removes it.
	 */
	public static int[] removeDuplicatesWithOrder(int[] arr) {

		   int end = arr.length;

		    for (int i = 0; i < end; i++) {
		        for (int j = i + 1; j < end; j++) {
		            if (arr[i] == arr[j]) {                  
		                arr[j] = arr[end-1];
		                end--;
		                j--;
		            }
		        }
		    }

		    int[] whitelist = new int[end];
		  
		    System.arraycopy(arr, 0, whitelist, 0, end);
		    return whitelist;
	}


	/**
	 * Most efficient - but uses a `Set`.
	 *
	 */
	public static int[] removeDuplicates(int[] arr) {

		Set<Integer> set = new HashSet<Integer>();
		final int len = arr.length;

		for (int i = 0; i < len; i++) {
			set.add(arr[i]);
		}

		int[] b = new int[set.size()];
		int i = 0;
		for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
			b[i++] = it.next();
		}
		return b;
	}

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		DeDup deDup = new DeDup();

		// 1. The HashSet approach

		int[] results = removeDuplicates(deDup.randomIntegers);

		System.out.println("HashSet");
		System.out.println(Arrays.toString(results) + "\n");

		// 2. Brute force Set
		results = removeDuplicatesWithOrder(deDup.randomIntegers);
		System.out.println("Brute force Set");
		System.out.println(Arrays.toString(results) + "\n");

		// 3. The sort approach sort the array and resolve only unique items
		results = removeDuplicatesAndSort(deDup.randomIntegers);
		System.out.println("Sort & resolve only unique items");
		System.out.println(Arrays.toString(results));

	}

}
