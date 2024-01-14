package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String compareStr = br.readLine();

		int count = 0;
		for(int i=0; i<=str.length()-compareStr.length(); i++) {
			if(str.substring(i, i+compareStr.length()).equals(compareStr)) {
				count++;
				i = i+compareStr.length()-1;

			}
		}
		System.out.println(count);
	}

}
