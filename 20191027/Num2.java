package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		int highestValue = 0;
		for(int i = 0; i < size-1; i++ ) {
			weights.get(i);
			for(int j = 1; j < size; j++) {
				
			}
		}
	}

}
