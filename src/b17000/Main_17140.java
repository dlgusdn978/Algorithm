package b17000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_17140 {

	static int[][] arr;
	public static void main(String[] args) throws IOException {
		// [3, 1, 1] => 3이 1개, 1이 2개,
		// ==> 3, 1, 1, 2
		// [3, 1, 1, 2] => 3이 1개, 1이 2개, 2가 1개
		// ==> 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 찾는 원소의 위치
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 찾는 원소 값
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[3][3];
		// 3x3 배열 입력
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행과 열의 길이를 기준으로 정렬 연산 시작.
		// 행의 개수 >= 열의 개수 인 경우 R 연산(모든 행 정렬)
		// 행의 개수 < 열의 개수 인 경우 C 연산(모든 열 정렬)
		
		// 1. 각 숫자의 개수 세기.
		// 2. 수 등장횟수, 수 크기 순 정렬을 수행.
		// 3. 가장 큰 행 or 열의 원소 갯수 알아야 하고.
		// 4. 나머지 행의 크기를 맞춰서 원소 0 넣기. (정렬 시 0은 무시)
		// 5. 행 or 열의 크기가 100을 넘어가면 처음~100을 제외한 나머지는 버림.
		int count = 0;
		while(count!=101) {
			
			// 행의 길이
			int rowLen = arr.length;
			// 열의 길이
			int colLen = arr[0].length;
			
			if(rowLen>=r && colLen>=c && arr[r-1][c-1]==k) break;
			if(rowLen>=colLen) {
				// r 연산 수행
				sortR();
			}else {
				// c 연산 수행.
				sortC();
			}
//			print();
//			System.out.println();
			count++;
		}
		System.out.println(count==101 ? -1 : count);
	}

	// r 연산
	static void sortR() {
		// 정렬 결과 넣을 배열
		List<Integer>[] list = new ArrayList[arr.length];
		// 초기화
		for(int i=0; i<arr.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// map 써서 개수 구하기.
		for(int i=0; i<arr.length; i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==0) continue;
				if(map.containsKey(arr[i][j])) {
					map.put(arr[i][j], map.get(arr[i][j])+1);
				}else {
					map.put(arr[i][j], 1);
				}
			}
			List<Entry<Integer,Integer>> mapList = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
			Collections.sort(mapList, new Comparator<Entry<Integer,Integer>>(){
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					return o1.getValue()==o2.getValue() ? o1.getKey()-o2.getKey() : o1.getValue()-o2.getValue();
				}
			});
			for(Entry<Integer, Integer> entry : mapList) {
				if(list[i].size()>100) break;
				list[i].add(entry.getKey());
				list[i].add(entry.getValue());
			}
		}
		// 가장 많은 원소 개수를 가지는 행 구하기
		int max = 0;
		for(int i=0; i<arr[0].length; i++) {
			max = Math.max(max, list[i].size());
		}
		arr = new int[arr.length][max];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<list[i].size(); j++) {
				arr[i][j] = list[i].get(j);
			}
		}
		
	}
	
	// c 연산
		static void sortC() {
			// 정렬 결과 넣을 배열
			List<Integer>[] list = new ArrayList[arr[0].length];
			// 초기화
			for(int i=0; i<arr[0].length; i++) {
				list[i] = new ArrayList<Integer>();
			}
			// map 써서 개수 구하기.
			for(int i=0; i<arr[0].length; i++) {
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for(int j=0; j<arr.length; j++) {
					if(arr[j][i]==0) continue;
					if(map.containsKey(arr[j][i])) {
						map.put(arr[j][i], map.get(arr[j][i])+1);
					}else {
						map.put(arr[j][i], 1);
					}
				}
				List<Entry<Integer,Integer>> mapList = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
				Collections.sort(mapList, new Comparator<Entry<Integer,Integer>>(){
					@Override
					public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
						return o1.getValue()==o2.getValue() ? o1.getKey()-o2.getKey() : o1.getValue()-o2.getValue();
					}
				});
				for(Entry<Integer, Integer> entry : mapList) {
					if(list[i].size()>100) break;
					list[i].add(entry.getKey());
					list[i].add(entry.getValue());
				}
			}
			// 가장 많은 원소 개수를 가지는 행 구하기
			int max = 0;
			for(int i=0; i<arr.length; i++) {
				max = Math.max(max, list[i].size());
			}
			arr = new int[max][arr[0].length];
			for(int i=0; i<arr[0].length; i++) {
				for(int j=0; j<list[i].size(); j++) {
					arr[j][i] = list[i].get(j);
				}
			}
			
		}
	
		static void print() {
			for(int[] a : arr) {
				for(int b : a) {
					System.out.print(b+" ");
				}
				System.out.println();
			}
		}
}
