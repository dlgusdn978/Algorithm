package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1107 {

	static int curChannel = 100;
	static boolean click, plus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 이동해야할 채널 n번 => 5457
		int n = Integer.parseInt(br.readLine());

		// 고장난 버튼의 개수 m => 3개
		int m = Integer.parseInt(br.readLine());
		
		// 고장난 버튼 입력 받기.
		List<Integer> list = new ArrayList<>();
		
		if(m!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				int temp = Integer.parseInt(st.nextToken());
				list.add(temp);
			}
		}
		// + - 만으로 변경 or 자릿수 중 어떤 방법이 더 적게 걸리는지 확인해야 됨.
		int diff = Integer.MAX_VALUE;
		int count = 0;
		for(int i=0; i<=1000000; i++) {
			char[] arr = Integer.toString(i).toCharArray();
			
			boolean visit = true;
			for(int j=0; j<arr.length; j++) {
				if(list.contains(arr[j]-48)) {
					visit = false;
				}
			}
			if(!visit) continue;
			int sum = Math.abs(n-i) + arr.length;
			if(sum<diff) {
				diff = sum;
			}
		}
		System.out.println(diff<Math.abs(curChannel-n) ? diff : Math.abs(curChannel-n));
	}

}
