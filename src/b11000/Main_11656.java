package b11000;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_11656 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str = sc.nextLine();
		
		String[] arr = new String[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.substring(i, str.length());
		}
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
//		System.out.println(Arrays.toString(arr));

		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
