package b1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {

	static class Node {
		int r;
		int c;
		int cnt;
		int digit;

		public Node(int r, int c, int cnt, int digit) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.digit = digit;
		}
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		// 비트마스크 정보 저장할 map
		Map<Character, Integer> map = new HashMap<>();

		// a~z => 97-> 122
		// A~Z => 65-> 90
		char[][] arr = new char[n][m];
		int r = 0;
		int c = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
				if ((int) ch - 0 >= 97 && (int) ch - 0 <= 122)
					map.computeIfAbsent(ch, key -> map.size() + 1);
				if (ch == '0') {
					r = i;
					c = j;
				}
				arr[i][j] = ch;

			}
		}

		int res = bfs(map, arr, r, c);
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);

	}

	static int bfs(Map<Character, Integer> map, char[][] arr, int r, int c) {
		Queue<Node> q = new ArrayDeque<>();
		// 최대 비트마스크 구하기
		int maxDigit = 0;
		for (int i = 1; i <= map.size(); i++) {
			maxDigit |= (1 << i);
		}

		// n차원 방문 체크
		boolean[][][] visited = new boolean[maxDigit + 1][arr.length][arr[0].length];
		int min = Integer.MAX_VALUE;
		q.add(new Node(r, c, 0, 0));
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (visited[cur.digit][cur.r][cur.c])
				continue;
			visited[cur.digit][cur.r][cur.c] = true;

			if (arr[cur.r][cur.c] == '1') {
				min = Math.min(min, cur.cnt);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length && arr[nr][nc] != '#'
						&& !visited[cur.digit][nr][nc]) {
					// 다음 방이 키인 경우. 키 추가하되, 키가 이미 추가된 경우에는 무시.
					int val = (int) arr[nr][nc] - 0;
					if (97 <= val && val <= 122) {
						int keyDigit = map.get(arr[nr][nc]);
						int nextDigit = cur.digit | (1 << keyDigit);
						
						q.add(new Node(nr, nc, cur.cnt + 1, nextDigit));

					} else if (65 <= val && val <= 90) {

						if (map.containsKey((char) (val + 32))) {
							int keyDigit = map.get((char) (val + 32));
							if ((cur.digit & (1 << keyDigit)) != 0)
								q.add(new Node(nr, nc, cur.cnt + 1, cur.digit));
						}

					} else {
						q.add(new Node(nr, nc, cur.cnt + 1, cur.digit));
					}
					// 다음 방이 잠긴 문인데 키가 있는 경우, 키가 없는 경우
				}
			}
		}
		return min;
	}

}
