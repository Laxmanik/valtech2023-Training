package arrays;

public class ReverseAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[] revArr = new int[5];
		int count = 0;
		for (int i = arr.length - 1; i>=0; i--) {
			revArr[count] = arr[i];
			System.out.print(revArr[count]+" ");
			count++;
		}
	}
}