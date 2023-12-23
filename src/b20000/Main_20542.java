package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20542 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 두 문자열 중 가장 길이가 긴 것을 구분
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		String result = br.readLine();
		String answer = br.readLine();
		
		int[][] arr = new int[result.length()+1][answer.length()+1];
		for(int i=1; i<=result.length(); i++) {
			arr[i][0] = i;
		}
		for(int i=1; i<=answer.length(); i++) {
			arr[0][i] = i;
		}
		for(int i=1; i<=result.length(); i++) {
			for(int j=1; j<=answer.length(); j++) {
				if(check(result.charAt(i-1), answer.charAt(j-1))) {
					arr[i][j] = arr[i-1][j-1];
				}else {
					arr[i][j] = Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]))+1;
				}
			}
		}
		
		int lcs = arr[result.length()][answer.length()];
		
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		// lcs 
	
		
	}

	static boolean check(char res, char ans) {
		if(res==ans) return true;
		else if(res == 'i' && (ans=='i'||ans=='j'||ans=='l')) return true;
		else if(res == 'v' && (ans=='v'||ans=='w')) return true;
		else return false;
	}
}
