package b1000;

import java.util.Scanner;
import java.util.Set;

public class Main_1342 {

	static int[] alphabet = new int[27];
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		for(int i=0; i<str.length(); i++) {
			alphabet[str.charAt(i)-'a'] += 1;
		}
		
		dfs(0, ' ', str.length());
		System.out.println(total);
	}
	
	
	static void dfs(int count, char temp, int len) {
		if(count==len) {
			total++;
			return;
		}
		for(int i=0; i<27; i++) {
			if(alphabet[i]==0) continue;
			
			if(temp != (char)(i+'a')) {
				alphabet[i]-=1;
				dfs(count+1, (char)(i+'a'), len);
				alphabet[i]+=1;
			}
			
		}
	}

}
