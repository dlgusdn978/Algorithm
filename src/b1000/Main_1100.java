package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1100 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean flag = false;
		int count = 0;
		
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				char ch = str.charAt(j);
				if(!flag && ch=='F') count++;
				flag = !flag;
			}
			flag = !flag;
		}
		System.out.println(count);
	}

}
