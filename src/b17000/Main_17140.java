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
		// [3, 1, 1] => 3�� 1��, 1�� 2��,
		// ==> 3, 1, 1, 2
		// [3, 1, 1, 2] => 3�� 1��, 1�� 2��, 2�� 1��
		// ==> 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// ã�� ������ ��ġ
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// ã�� ���� ��
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[3][3];
		// 3x3 �迭 �Է�
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ��� ���� ���̸� �������� ���� ���� ����.
		// ���� ���� >= ���� ���� �� ��� R ����(��� �� ����)
		// ���� ���� < ���� ���� �� ��� C ����(��� �� ����)
		
		// 1. �� ������ ���� ����.
		// 2. �� ����Ƚ��, �� ũ�� �� ������ ����.
		// 3. ���� ū �� or ���� ���� ���� �˾ƾ� �ϰ�.
		// 4. ������ ���� ũ�⸦ ���缭 ���� 0 �ֱ�. (���� �� 0�� ����)
		// 5. �� or ���� ũ�Ⱑ 100�� �Ѿ�� ó��~100�� ������ �������� ����.
		int count = 0;
		while(count!=101) {
			
			// ���� ����
			int rowLen = arr.length;
			// ���� ����
			int colLen = arr[0].length;
			
			if(rowLen>=r && colLen>=c && arr[r-1][c-1]==k) break;
			if(rowLen>=colLen) {
				// r ���� ����
				sortR();
			}else {
				// c ���� ����.
				sortC();
			}
//			print();
//			System.out.println();
			count++;
		}
		System.out.println(count==101 ? -1 : count);
	}

	// r ����
	static void sortR() {
		// ���� ��� ���� �迭
		List<Integer>[] list = new ArrayList[arr.length];
		// �ʱ�ȭ
		for(int i=0; i<arr.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// map �Ἥ ���� ���ϱ�.
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
		// ���� ���� ���� ������ ������ �� ���ϱ�
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
	
	// c ����
		static void sortC() {
			// ���� ��� ���� �迭
			List<Integer>[] list = new ArrayList[arr[0].length];
			// �ʱ�ȭ
			for(int i=0; i<arr[0].length; i++) {
				list[i] = new ArrayList<Integer>();
			}
			// map �Ἥ ���� ���ϱ�.
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
			// ���� ���� ���� ������ ������ �� ���ϱ�
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
