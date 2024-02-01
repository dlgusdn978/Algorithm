package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main_2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int gcdValue = Math.abs(arr[1]-arr[0]);
		for(int i=2; i<n; i++) {
			gcdValue = gcd(Math.abs(arr[i]-arr[i-1]), gcdValue);
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=2; i<=gcdValue; i++) {
			if(gcdValue%i==0) {
				list.add(i);
			}
		}
//		System.out.println(Math.sqrt(gcdValue));
		Collections.sort(list);
		
		for(int a : list) {
			System.out.print(a+" ");
		}
		
	}

	static int gcd(int left, int right) {
		while(right!=0) {
			int temp = right;
			right = left%right;
			left = temp;
		}
		return left;
	}
}
