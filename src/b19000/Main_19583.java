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
		// ������ȸ�� ������ �ð� s
		String s = st.nextToken();
		String start = s.split(":")[0] + s.split(":")[1];

		// ������ȸ�� ���� �ð� e
		String e = st.nextToken();
		String end = e.split(":")[0] + e.split(":")[1];

		// ��Ʈ������ ���� �ð� q
		String q = st.nextToken();
		String quit = q.split(":")[0] + q.split(":")[1];

		// ������ȸ ���� ����
		boolean flag = false;
		// ���⼭���ʹ� ä�� ���
		String str = "";

		int count = 0;
		while ((str = br.readLine())!=null) {
			String timeLog = str.split(" ")[0];
			String userId = str.split(" ")[1];

			// ä�� �α� �ð�
			String time = timeLog.split(":")[0] + timeLog.split(":")[1];

			// ���� ��ȸ ���� ���� ���Դ��� Ȯ��.
			if (time.compareTo(start) <= 0) {
				map.put(userId, time);
//				System.out.println(time+" "+userId);
			}
//			System.out.println(time+" "+userId);
			// ���� ��ȸ ���� �� ~ ��Ʈ���� ���� �� ���� ä�� ����� ���Ҵ��� üũ.
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
