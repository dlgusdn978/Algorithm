package b2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2042 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n+1];
		long[] tree = new long[4*n];
		for(int i=1; i<=n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
//		System.out.println(Arrays.toString(arr));
		init(arr, tree, 1, n, 1);
//		System.out.println(Arrays.toString(tree));
		for(int i=0; i<m+k; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int val1 = Integer.parseInt(st.nextToken());
			
			
			if(cmd==1) {
				// val1번째 수를 val2로 변경
				long val2 = Long.parseLong(st.nextToken());
				update(tree, 1, n, 1, val1, val2-arr[val1]);
				arr[val1] = val2;
			}else {
				// val1~ val2 구간합 구하기
				int val2 = Integer.parseInt(st.nextToken());
				long res = sum(tree, 1, n, 1, val1, val2);
				sb.append(res).append("\n");
			}
//			System.out.println(Arrays.toString(tree));
		}
		System.out.println(sb.toString());
	}
	
	static long init(long[] arr, long[] tree, int start, int end, int idx) {
		if(start==end) return tree[idx] = arr[start];
		int mid = (start+end)/2;
		return tree[idx] = init(arr, tree, start, mid, idx*2) + init(arr, tree, mid+1, end, idx*2+1);
	}
	// start, end 는 현재 선택한 범위
	// left, right는 구간합을 구하고자 하는 범위
	static long sum(long[] tree, int start, int end, int idx, int left, int right) {
		if(left>end || right<start) return 0;
//		System.out.println(start+" "+end);
		if(left<=start && right>=end) return tree[idx];
		int mid = (start+end)/2;
		return sum(tree, start, mid, idx*2, left, right) + sum(tree, mid+1, end, idx*2+1, left, right);
	}
	// idx는 현재 노드
	// el은 값을 변경한 노드
	static void update(long[] tree, int start, int end, int idx, int el, long val) {
		if(el<start || el>end) return;
		tree[idx] += val;
		if(start==end) return;
		int mid = (start+end)/2;
		update(tree, start, mid, idx*2, el, val);
		update(tree, mid+1, end, idx*2+1, el, val);
	}
}
