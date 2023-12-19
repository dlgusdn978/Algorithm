package b1000;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_1141 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length()-o2.length();
			}
		});
		
		int count = 0;
		
		for(int i=0; i<n; i++) {
			boolean checker = false;
			String a = arr[i];
			for(int j=i+1; j<n; j++) {
				String b = arr[j];
				if(a.equals(b.substring(0, a.length()))) {
					checker = true;
					break;
				}
			}
			if(!checker) count++;
		}
		
		System.out.println(count);
	}

}
