package b1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main_1038 {

	static List<Long> list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		list = new ArrayList<>();
		
		if(n<=10) System.out.println(n);
		else if(n>1022) System.out.println("-1");
		else {
			for(int i=0; i<10; i++) {
				checker(i, 1);
			}
			Collections.sort(list);
			System.out.println(list.get(n));
		}
		
	}

	static void checker(long num, long i) {
		if(i>10) return;
		
		list.add(num);
		for(int j=0; j<num%10; j++) {
			checker((num*10)+j, i+1);
		}
	}
}
