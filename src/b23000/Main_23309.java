package b23000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23309 {

	
	static class LinkedList{
		int[] prevList;
		int[] nextList;
		public LinkedList() {
			prevList = new int[1000001];
			nextList = new int[1000001];
		}
		
		public void add(int cur, int next) {
			if(cur==-1) {
				// head��� ��.
				prevList[next] = next;
				nextList[next] = next;
				return;
			}
			// next�� next�� cur�� next�� �ȴ�.
			// cur�� next�� next�� �ȴ�.
			// next�� prev�� cur�� �ȴ�.
			// next�� next�� prev ���� next�� �ȴ�.
			nextList[next] = nextList[cur];
			nextList[cur] = next;
			prevList[next] = cur;
			prevList[nextList[next]] = next;
		}
		public void insert(int prev, int mid, int next) {
			nextList[prev] = mid;
			nextList[mid] = next;
			prevList[next] = mid;
			prevList[mid] = prev;
		}

		public void delete(int prev, int mid, int next) {
			nextList[prev] = nextList[mid];
			prevList[next] = prevList[mid];
			prevList[mid] = 0;
			nextList[mid] = 0;
		}
	}
	// 7 2 7
	// 2 7 3
	// 7 3 2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList list = new LinkedList();
		
		// ó�� ��ġ�� ��
		st = new StringTokenizer(br.readLine());
		int cur = -1;
		for(int i=0; i<n; i++) {
			int next = Integer.parseInt(st.nextToken());
			list.add(cur, next);
			cur = next;
		}
//		System.out.println(Arrays.toString(list.nextList));
//		System.out.println(Arrays.toString(list.prevList));
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(cmd.equals("BN")) {
				// ������ ������ȣ ���, �� ���̿� ���� ��ȣ j ����
				int next = list.nextList[num];
				int mid = Integer.parseInt(st.nextToken());
				list.insert(num, mid, next);
				sb.append(next).append("\n");
			}else if(cmd.equals("BP")) {
				// ������ ``
				int prev = list.prevList[num];
				int mid = Integer.parseInt(st.nextToken());
				list.insert(prev, mid, num);
				sb.append(prev).append("\n");
			}else if(cmd.equals("CP")) {
				// ���� �� ���.
				int mid = list.prevList[num];
				int prev = list.prevList[mid];
				list.delete(prev, mid, num);
				sb.append(mid).append("\n");
			}else {
				// ���� �� ���.
				int mid = list.nextList[num];
				int next = list.nextList[mid];
				list.delete(num, mid, next);
				sb.append(mid).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
