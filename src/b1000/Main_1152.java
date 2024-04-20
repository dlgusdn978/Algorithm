package b1000;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] res = sc.nextLine().trim().split(" ");
//		System.out.println(Arrays.toString(res));
		int count = 0;
		for(String a : res) {
			if(!a.equals(" ") && !a.equals("")) count++;
		}

		System.out.println(count);
	}

}
