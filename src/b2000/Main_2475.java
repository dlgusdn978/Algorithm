package b2000;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		
		int total = 0;
		
		for(int i=0; i<5; i++) {
			int s = Integer.parseInt(st.nextToken());
			total += Math.pow(s, 2);
		}
		System.out.println(total%10);

	}

}
