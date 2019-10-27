package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String first = scan.nextLine();
		String[] arr = first.split("\\s");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		
		List<Integer> values = new ArrayList<Integer>();
		List<Integer> weights = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			String line = scan.nextLine();
			String[] arr2 = line.split("\\s");
			int v = Integer.parseInt(arr2[0]);
			int w = Integer.parseInt(arr2[1]);
			values.add(v);
			weights.add(w);
		}
		int size = values.size();
		int value = 0;
		for(int i = 0; i < size-1; i++ ) {
			int wSum = weights.get(i);
			int vSum = values.get(i);
			for(int j = i+1; j < size; j++) {
				int vSum2 = sumValues(j, m, wSum, vSum, values, weights);
				if(value < vSum2) {
					value = vSum2;
				}
			}
		}
		System.out.println(value);
	}
	
	
	
	private static int sumValues(int index,
			int m,
			int wSum,
			int vSum,
			List<Integer> values, 
			List<Integer> weigths) {
		
		if(index >= values.size())
			return vSum;
		int temp = wSum + weigths.get(index);
		if(temp > m) {
			return sumValues(index+1, m, wSum, vSum, values, weigths);
		} else {
			vSum += values.get(index);
		}
		return sumValues(index+1, m, temp, vSum, values, weigths);
	}

}
