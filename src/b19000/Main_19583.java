package b19000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_19583 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<String, String> map = new HashMap<String, String>();
		// 개강총회를 시작한 시간 s
		String s = st.nextToken();
		String start = s.split(":")[0] + s.split(":")[1];

		// 개강총회를 끝낸 시간 e
		String e = st.nextToken();
		String end = e.split(":")[0] + e.split(":")[1];

		// 스트리밍을 끝낸 시간 q
		String q = st.nextToken();
		String quit = q.split(":")[0] + q.split(":")[1];

		// 개강총회 시작 여부
		boolean flag = false;
		// 여기서부터는 채팅 기록
		String str = "";

		int count = 0;
		while ((str = br.readLine())!=null) {
			String timeLog = str.split(" ")[0];
			String userId = str.split(" ")[1];

			// 채팅 로그 시간
			String time = timeLog.split(":")[0] + timeLog.split(":")[1];

			// 개강 총회 시작 전에 들어왔는지 확인.
			if (time.compareTo(start) <= 0) {
				map.put(userId, time);
//				System.out.println(time+" "+userId);
			}
//			System.out.println(time+" "+userId);
			// 개강 총회 종료 후 ~ 스트리밍 종료 시 까지 채팅 기록이 남았는지 체크.
			if (time.compareTo(end) >= 0 && time.compareTo(quit) <= 0) {
//				System.out.println(time+" "+userId+"?");
				if (map.containsKey(userId)) {
					count++;
					map.remove(userId);
				}
			}
//			System.out.println(map);
		}
		System.out.println(count);
	}

}
