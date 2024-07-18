package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int[] sensors = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensors);
		
		int[] distance = new int[n-1];
		
		for(int i=0; i<distance.length; i++) {
			distance[i] = sensors[i+1]-sensors[i];
		}
		
		Arrays.sort(distance);
		int total = 0;
		for(int i=0; i<n-k; i++) {
			total += distance[i];
		}
		System.out.println(total);
		
	}

}
