package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long gcd = Long.parseLong(st.nextToken());
		long lcm = Long.parseLong(st.nextToken());
		
		long temp = lcm/gcd;
		
		// 조건
		// 두 수 모두 gcd의 배수여야 함.
		// 두 수의 곱은 lcm * gcd
		// 
		long min = 0;
		long max = 0;
		long sum = Long.MAX_VALUE;
		for(long i=1; i*i<=temp; i++) {
			if(temp%i!=0) continue;

			long x = i;
			long y = temp/i;
			
			if(gcd(x, y)==1) {
				long a = gcd * x;
				long b = gcd * y;
				if(a+b<sum) {
					min = Math.min(a, b);
					max = Math.max(a, b);
					sum = a+b;
				}
			}
		}
		
		System.out.println(min+" "+max);
	}

	
	static long gcd(long a, long b) {
		while(b!=0) {
			long temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
}
