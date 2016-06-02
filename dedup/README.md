
Consulting Firm: Teksystem
Contact Info: 610 925 2515 vsun123@gmail.com

1.	Given the following class, write 3 methods that can be used to return an array that has no duplicates.
	a.	Use a Hashset, Since Set does not allow duplicates in Java.
	b.	Brute force approach loop over an array and comparing each element to every other element.
	c.	Sort the elements using quick sorting rearrange sort order, then remove duplicates
2.	You should define a method signature that you feel is appropriate to the problem. 
	a.	public static int[] removeDuplicates(int[] arr); // Remove the duplication, the order is random.
	b.	public static int[] removeDuplicatesWithOrder(int[] arr); // remove the duplication, keep original order;
	c.	public static int[] removeDuplicatesAndSort(int[] arr); // remove the duplication, sort the order;
	d.	public static void quickSort(int[] arr, int low, int high); // quick sort
3.	We would prefer to see three implementations (one that should take into consideration #4 below) and an explanation of what use-cases are suitable to each implementation 
	a.	Remove the duplication, the order is random. Time complexity of O(n);
	b.	public static int[] removeDuplicatesWithOrder(int[] arr); // remove the duplication, keep original order;  time complexity of O(n^2);
	c.	public static int[] removeDuplicatesAndSort(int[] arr); // remove the duplication, sort the order;  ;  time complexity of O(nLogn) – sort + O(n) - remove
4.	What if we need to retain the original order?
	Solution b is retain the original order.
	Solution a if you want to change from Hashset to LinkedHashset will retain the original order.
5.	What are the positives and negatives of your solution?
	Positive: Remove the duplicates items has varies orders( sort, and original order, random).
	Negitive: b solution the time complexity of O(n^2), it is not suitable for larger data set.
	a.	Can you implement it another way so as to avoid the negatives?
		use LinkedHashSet instead.
6.	Your solution should be testable and “production ready.”
7.	Your solution should be posted to a public github repo that SEI can clone.

public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
                                   20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
                                   13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

public static void main(String [] args) {

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
