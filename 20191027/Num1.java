package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// s와 t사이의 숫자 n개의 수들의 소수 체크가 가장 많이 걸린다.
// 대략적으로 n개의 숫자마다 n개보다 작은 수로 나누어 보게 되지만 
// 소수가 아닐 경우엔 바로 나오게 되느로 O(n2) 보다는 적게 걸린다고 생각한다.
public class Num1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] num = input.split("\\s");
		
		int s = Integer.parseInt(num[0]);
		int t = Integer.parseInt(num[1]);
		
		if(s < 1000 || s > 9999 || t < 1000 || t > 9999 || s > t) {
			// 입력이 잘못됐을 경우 그대로 종료
		} else {
			Map<Integer, Integer> m = new HashMap<Integer, Integer>();
			for(int n = s+1; n<t; n++) {
				if(isPrime(n)) {
					String str = String.valueOf(n);
					isClose(num[0], str, m);
					isClose(num[1], str, m);
				}
			}
			int temp = Integer.MAX_VALUE;
			for(int k : m.keySet()) {
				if(k < temp) {
					temp = k;
				}
			}
			if(temp != Integer.MAX_VALUE) {
				System.out.println(s);
				System.out.println(m.get(temp));
				System.out.println(t);
			}
		}

	}
	
	// 인접한 수 체크
	private static void isClose(String input, String n, Map<Integer, Integer> m) {
		int sameCount = 0;
		for(int i =0; i < input.length(); i++) {
			if(input.charAt(i) == n.charAt(i)) {
				sameCount++;
			}
		}
		if(sameCount == 3) {
			int a = Integer.parseInt(input);
			int b = Integer.parseInt(n);
			int c = a - b;
			if(c < 0) {
				c *= -1;
			}
			m.put(c, b);
		}
	}
	
	// 소수 체크 
	private static boolean isPrime(int num) {
		boolean isPrime = true;
		for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
		return isPrime;
	}

}
