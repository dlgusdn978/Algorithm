package b1000;

import java.util.Scanner;

public class Main_1052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		if(n<k) {
			System.out.println(0);
			return;
		}
		int total = 0;
		while(true) {
			count = 0;
			int n2 = n;
			while(n2!=0) {
				if(n2%2==1) {
					count+=1;
				}
				n2/=2;
			}
			if(count<=k)break;
			n+=1;
			total+=1;
		}
		System.out.println(total);
	}

}
