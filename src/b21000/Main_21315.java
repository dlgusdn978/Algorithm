package b21000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21315 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		int[] res = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			res[i] = Integer.parseInt(st.nextToken());
		}
		int k = 0;
		for(int i=1; i<=10; i++) {
			int val = (int) Math.pow(2, i);
			if(val<= n) k = i;
		}
//		System.out.println(k);
		for(int i=1; i<=k; i++) {
			boolean flag = false;
			for(int j=1; j<=k; j++) {
				int[] temp = Arrays.copyOf(arr, arr.length);
				temp = shuffle(temp, i);
				temp = shuffle(temp, j);
				if(check(res, temp)) {
					sb.append(i+" "+j);
					flag = true;
					break;
				}
			}
			if(flag) break;
		}
		System.out.println(sb.toString());
	}
	static boolean check(int[] arr, int[] temp) {
		boolean flag = true;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=temp[i]) flag = false;
		}
		return flag;
	}
	static int[] shuffle(int[] arr, int k) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		Deque<Integer> q = new ArrayDeque<Integer>();
		int[] res = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			dq.add(arr[i]);
		}
		int power = k;
		int count = 1;
		while(count<=k+1) {
			int num = (int) Math.pow(2, power-count+1);
			int size = dq.size();
			for(int i=0; i<size; i++) {
				if(i>=num) q.add(dq.pollLast());
				else dq.addFirst(dq.pollLast());
			}
			count++;
		}
		while(!q.isEmpty()) {
			dq.addLast(q.pollLast());
		}
//		for(int a : dq) {
//			System.out.println(a);
//		}
		for(int i=0; i<arr.length; i++) {
			res[i] = dq.pollFirst();
		}
		return res;
	}
}
