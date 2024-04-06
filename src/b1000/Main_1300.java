package b1000;

import java.util.Scanner;

public class Main_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		int k = sc.nextInt();
		
		long low = 1;
		long high = k;
		
		while(low<high) {
			long mid = (low+high)/2;
			
			long count = 0;
			
			for(int i=1; i<=n; i++) {
				count += Math.min(n, mid/i);

			}
			
			if(k<=count) {
				high = mid;
			}else {
				low = mid+1;
			}
		}

		System.out.println(low);
	}

}
