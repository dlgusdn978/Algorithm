package b9000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_9081 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			char[] word = br.readLine().toCharArray();
			if(nextPermutation(word)) {
				System.out.println(word);
			}else {
				System.out.println(String.valueOf(word));
			}
		}
	}
	
	private static boolean nextPermutation(char[] word) {
		int i = word.length-1;
		while(i>0 && word[i-1]>=word[i]) i--;
		if(i<=0) return false;
		
		
		int j = word.length-1;
		while(word[j]<=word[i-1]) j--;
		
		char temp = word[i-1];
		word[i-1] = word[j];
		word[j] = temp;
		
		j = word.length-1;
		while(i<j) {
			temp = word[i];
			word[i] = word[j];
			word[j] = temp;
			i++;
			j--;
		}
		return true;
	}
	
	
}
