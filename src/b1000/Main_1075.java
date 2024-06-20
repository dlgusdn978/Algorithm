package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		
		n = n/100*100;
		for(int i=0; i<100; i++) {
			if((n+i)%f==0) {
				String str = String.valueOf(n+i);
				System.out.println(str.substring(str.length()-2, str.length()));
				break;
			}
		}
		
	}

}
