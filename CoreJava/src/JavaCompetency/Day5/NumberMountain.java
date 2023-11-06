package JavaCompetency.Day5;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class NumberMountain {

	public static void main(String[] args) {

		NumberMountain nm = new NumberMountain();

		System.out.println(nm.isMountain(4, 5, 3, 2, 1));
		System.out.println(nm.isMountain(4,3,3,2,1));
		System.out.println(nm.isMountain(6, 5, 3, 2, 1));

	}

	private boolean isMountain(int... i) {
		// identify peak
		int peak = identifyPeak(i);

		if (peak == 0 || peak == i.length - 1)
			return false;
		// check if it is in ascending
		boolean asc = checkAscending(i, peak);
		// check if other position is descending
		boolean dsc = checkDescending(i, peak);
		return asc && dsc;
	}

	private boolean checkDescending(int[] i, int peak) {
		boolean dsc = true;
		for (int j = peak; j < i.length - 1; j++) {
			if (i[j] < i[j + 1]) {
				dsc = false;
			}
		}
		return dsc;
	}

	private boolean checkAscending(int[] i, int peak) {
		boolean asc = true;
		for (int j = 0; j < peak - 1; j++) {
			if (i[j] > i[j + 1]) {
				asc = false;
			}
		}
		return asc;
	}

	private int identifyPeak(int[] i) {
		int index = 0;
		int max = 0;

		for (int j = 0; j < i.length; j++) {
			if (i[j] > max) {
				index = j;
				max = i[j];
//				System.out.println(max);
			}

		}
//		System.out.println(index);
		return index;
	}
}
