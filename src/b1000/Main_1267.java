package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1267 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int total1 = 0;
		int total2 = 0;
		for(int i=0; i<n; i++) {
			// 영식 -> 30초 10원
//			System.out.println(Math.ceil((double)arr[i]/30));
			total1 += arr[i]%30==0 ? (arr[i]/30+1)*10 : Math.ceil((double)arr[i]/30)*10;
			// 민식 -> 60초 15원
			total2 += arr[i]%60==0 ? (arr[i]/60+1)*15 : Math.ceil((double)arr[i]/60)*15;
		}
		if(total1>total2) {
			System.out.println("M "+total2);
		}else if(total1<total2) {
			System.out.println("Y "+total1);
		}else {
			System.out.println("Y M "+total1);
		}

	}

}
