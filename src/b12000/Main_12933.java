package b12000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12933 {

	public static void main(String[] args) throws IOException {
		// 문자열을 앞에서부터 탐색하면서 q u a c k 를 순서대로 찾음.
		// 조합에 사용된 문자열은 true 처리.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] count = new int[5];
		int ducks = 0;
		int maxDucks = 0;
		
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			
			switch(cur) {
			case 'q' : 
				count[0]++;
				maxDucks = Math.max(maxDucks, count[0]-count[4]);
				break;
			case 'u' :
				if(count[0] < count[1]+1) {
					System.out.println(-1);
					return;
				}
				count[1]++;
				break;
			case 'a' :
				if(count[1]<count[2]+1) {
					System.out.println(-1);
					return;
				}
				count[2]++;
				break;
			case 'c' :
				if(count[2]<count[3]+1) {
					System.out.println(-1);
					return;
				}
				count[3]++;
				break;
			case 'k' :
				if(count[3]<count[4]+1) {
					System.out.println(-1);
					return;
				}
				count[4]++;
				break;
			default:
				System.out.println(-1);
				return;
				
			}
		}
		
		if(count[0]==count[1] && count[1]==count[2] && count[2]==count[3] && count[3]==count[4]) {
			System.out.println(maxDucks);
		}else {
			System.out.println(-1);
		}
	}

}
