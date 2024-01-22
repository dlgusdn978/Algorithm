package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[4][m];
		String[] strs = new String[n];
		for(int i=0; i<n; i++) {
			String t = br.readLine();
			strs[i] = t;
			char[] temp = t.toCharArray();
//			System.out.println(Arrays.toString(temp));
			// 0, 1, 2, 3 ÀÌ °¢°¢ a c g t °¡ µÊ.
			for(int j=0; j<temp.length; j++) {
				if(temp[j]=='A') arr[0][j] += 1;
				else if(temp[j]=='C') arr[1][j] +=1;
				else if(temp[j]=='G') arr[2][j] += 1;
				else arr[3][j] +=1;
			}
		}

		String str = "";
		for(int i=0; i<m; i++) {
			char t = ' ';
			int max = 0;
			for(int j=0; j<4; j++) {
				if(arr[j][i]>max ) {
					max = arr[j][i];
					if(j==0) t='A';
					else if(j==1) t='C';
					else if(j==2 ) t='G';
					else t='T';
				}
			}
			str+=t;
		}
		System.out.println(str);

		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(str.charAt(j)!=strs[i].charAt(j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
