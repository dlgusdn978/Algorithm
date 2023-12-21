package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_1958 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] arr = new String[3];
		for(int i=0; i<3; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length()-o1.length();
			}
		});
//		System.out.println(Arrays.toString(arr));
		// 문자열을 2개로 만들어버리고 비교
		int[][][] lcs = new int[arr[0].length()+1][arr[1].length()+1][arr[2].length()+1];
		
		for(int i=1; i<=arr[0].length(); i++) {
			for(int j=1; j<=arr[1].length(); j++) {
				for(int k=1; k<=arr[2].length(); k++) {
					if(arr[0].charAt(i-1)==arr[1].charAt(j-1) && arr[1].charAt(j-1)==arr[2].charAt(k-1)) {
						lcs[i][j][k] = lcs[i-1][j-1][k-1]+1;
					}else {
						lcs[i][j][k] = Math.max(lcs[i-1][j][k], Math.max(lcs[i][j-1][k], lcs[i][j][k-1]));
					}
				}
			}
		}

		System.out.println(lcs[arr[0].length()][arr[1].length()][arr[2].length()]);
		
	}

}
