package b14000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_14572 {

	static class Student{
		int algo;
		int skill;
		int[] algoList;
		public Student(int algo, int skill, int[] algoList) {
			this.algo = algo;
			this.skill = skill;
			this.algoList = algoList;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 학생의 수 n
		int n = Integer.parseInt(st.nextToken());
		// 알고리즘의 수 k
		int k = Integer.parseInt(st.nextToken());
		// 실력 d
		int d = Integer.parseInt(st.nextToken());
		
		// 최대 효율성
		int e = Integer.MIN_VALUE;
		
		Student[] group = new Student[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			// 알고있는 알고리즘 수 m
			int m = Integer.parseInt(st.nextToken());
			// 학생의 실력
			int skill = Integer.parseInt(st.nextToken());
			
			int[] algoList = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				algoList[j] = Integer.parseInt(st.nextToken());
			}
			group[i] = new Student(m, skill, algoList);
		}

		// 실력을 기준으로 내림차순 정렬. 실력이 같다면 algoList 수 기준 내림차순 정렬
		Arrays.sort(group, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.skill==s2.skill ? s1.algoList.length-s2.algoList.length : s2.skill-s1.skill;
			}
		});
		

		
		int start = 0;
		int end = 0;
		int[] algoCount = new int[k+1];
		while(end<n) {
			if(group[start].skill-group[end].skill<=d ) {
				// 10 이상 차이나기 전까지 포인터 이동.
				for(int a : group[end].algoList) {
					algoCount[a] += 1;
				}
				
				int allAlgo = 0;
				int knowAlgo = 0;
				for(int i=1; i<algoCount.length; i++) {
					if(algoCount[i]!=0) {
						if(algoCount[i]==(end-start)+1) knowAlgo++;
						allAlgo++;
					}
				}

				int temp = (allAlgo-knowAlgo) * (end-start+1);

				e = Math.max(e, temp);
				
//				System.out.println(Arrays.toString(algoCount));
				end++;
//				System.out.println(start+"??"+end);
			}else {

				for(int a : group[start].algoList) {
					algoCount[a] -= 1;
				}
				start++;

			}
		}
		System.out.println(e);
	}

}
