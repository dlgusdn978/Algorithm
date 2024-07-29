package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		Integer[] cranes = new Integer[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n;i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Integer[] boxes = new Integer[m];
		for(int i=0; i<m; i++) {
			boxes[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cranes, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());
		
		if(boxes[0]>cranes[0]) {
			System.out.println(-1);
			return;
		}
		 int time = 0;
	        boolean[] moved = new boolean[m];
	        int movedCount = 0;

	        while (movedCount < m) {
	            int boxIndex = 0;
	            for (int i = 0; i < n && boxIndex < m; i++) {
	                while (boxIndex < m) {
	                    if (!moved[boxIndex] && boxes[boxIndex] <= cranes[i]) {
	                        moved[boxIndex] = true;
	                        movedCount++;
	                        boxIndex++;
	                        break;
	                    }
	                    boxIndex++;
	                }
	            }
	            time++;
	        }
		System.out.println(time);
		
		
	}
}
