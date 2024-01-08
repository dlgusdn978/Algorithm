package b1000;

import java.util.Scanner;

public class Main_1214 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 지불해야할 값 d
		int d = sc.nextInt();
		
		// 첫 지폐 p
		int p = sc.nextInt();
		
		// 두번쨰 지폐 q
		int q = sc.nextInt();
		
//		System.out.println(d+" "+p+" "+q);
		if(d%p==0 || d%q==0) {
			System.out.println(d);
			return;
		}
		int small = Math.min(p, q);
		int big = Math.max(p, q);
		// 최솟값
		int min = Integer.MAX_VALUE;

		int share = (d/small)+1;
		for(int i=0; i<=share; i++) {
			// small을 나누고 뺀 값 rem
			int rem = d-(small*i);
			
			int count1 = rem/big;
			int count2 = rem/big+1;
			
			int total1 = small*i + big*count1;
			if(total1<d) {
				
				int total2 = small*i + big*count2;
				if(total2==min) break;
				if(total2<min) min = total2;
			}else {
				if(total1==min) break;
				if(total1==d) {
					System.out.println(total1);
					return;
				}else {
					if(total1<min) min = total1;
				}
			}
		}
//		System.out.println(share);
		System.out.println(min);
	}

}
