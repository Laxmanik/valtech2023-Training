package JavaCompetency.Day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//Collections easy implementation
public class Streams {

	private void traditional() {

		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> squares = new ArrayList<>();
		for(int i:nums) { //for integer i in nums
			squares.add(i*i);
		}
		
		System.out.println(nums);
		System.out.println(squares);
	}
	
	public static void main(String[] args) {
		
		Streams s = new Streams();
		s.traditional();
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer> squares = nums.stream().map(i -> i*i).collect(Collectors.toList());
		List<Double> sqrts = nums.stream().map(i -> Math.sqrt(i)).collect(Collectors.toList());
		List<Integer> odds = nums.stream().filter(i -> (i%2) == 1).collect(Collectors.toList());
		List<Integer> oddsSquares = odds.stream().map(i -> i*i).collect(Collectors.toList());
		
		System.out.println(squares);
		System.out.println(sqrts);
		System.out.println(odds);
		System.out.println(oddsSquares);
	}
}
