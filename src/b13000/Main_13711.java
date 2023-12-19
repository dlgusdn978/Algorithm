package b13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13711 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n+1];
		int[] b = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			a[Integer.parseInt(st.nextToken())]= i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			b[i] = a[Integer.parseInt(st.nextToken())];
		}
		int size = 0;
		a[size++] = b[0];
		for(int i=1; i<n; i++) {
			int index = Arrays.binarySearch(a, 0, size, b[i]);
			if(index==-(size+1)) a[size++] = b[i];
			else a[-(index+1)] = b[i];
		}
		
//		Arrays.binary
		System.out.println(size);

		
	}

}
