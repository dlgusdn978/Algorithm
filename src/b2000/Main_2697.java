package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2697 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 스택
		// 뒤에서부터 하나씩 빼서 배열에 값을 추가.
		// 배열을 순회하며 peek의 값과 비교하고, peek보다 클 경우 pop, 큰 값을 스택에 넣기.
		// 나온 값은 오름차순 정렬 수행후 스택에 다시 넣기.
		// 스택 순회하며 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s;
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			s = new Stack<>();
			String str = br.readLine();
			// 스택에 요소 넣기
			for(int j=0; j<str.length(); j++) {
				s.push(str.charAt(j)-48);
			}
			// 뺀 값을 저장할 배열
			int[] temp = new int[80];
			int count = 1;
			// 기본값 세팅
			int top = s.pop();
			temp[0] = top;
			while(!s.isEmpty()) {
				int cur = s.peek();
				int min = Integer.MAX_VALUE;
				int index = -1;
				for(int k=0; k<count; k++) {
					if(cur<temp[k]) {					
						if(min>temp[k]) {
							min = temp[k];
							index = k;
						}
					}
				}
				int peek = s.pop();
				if(min !=Integer.MAX_VALUE) {
					s.push(min);
				}
				temp[count++] = peek;
//				System.out.println(Arrays.toString(temp));
				if(min != Integer.MAX_VALUE) {
					temp[index] = -1;
//					System.out.println(Arrays.toString(temp));
					List<Integer> list = new ArrayList<Integer>();
					for(int k=0; k<count; k++) {
						list.add(temp[k]);
					}
					Collections.sort(list);
					for(int k=0; k<list.size(); k++) {
						if(list.get(k)<0) continue;
						s.push(list.get(k));
					}
					break;
				}
			}
			for(int a : s) {
				sb.append(a);
			}

			System.out.println(s.size()==0 ? "BIGGEST" : sb.toString());
			sb.delete(0, sb.length());
		}
	}

}
