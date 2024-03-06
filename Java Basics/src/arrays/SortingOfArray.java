package arrays;

public class SortingOfArray {

	public static void main(String[] args) {
		int[] num = {11, 9, 0, 1, 8, 99, 10, 2, 7, 3, 6, 4, 5};

		System.out.print("Ascending Order: ");
		for(int i=0; i < num.length; i++) {
			for(int j = i+1; j< num.length; j++) {
				if(num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
			System.out.print(" "+num[i]);
		}
		
		System.out.println("");
		System.out.print("Descending Order: ");
		for (int i = num.length-1; i >= 0; i--) {
			System.out.print(num[i]+" ");
		}
	}
}