package b9000;


// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;
public class Main_9086
{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

		// �뀒�뒪�듃 耳��씠�뒪�쓽 媛쒖닔 �꽑�뼵
		int T = sc.nextInt();

		String[] arr = new String[T];

		// 臾몄옄�뿴 �엯�젰諛쏄린
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();

		// �엯�젰諛쏆� 臾몄옄�뿴�쓣substring�쑝濡� 0踰덉㎏ �걹踰덉㎏瑜� 異쒕젰�븳�떎.
		for (int i = 0; i < arr.length; i++) {

			// 留뚯빟 �엯�젰諛쏆� 臾몄옄�뿴�쓽 湲몄씠媛� 1�옄由щ㈃ �븵 �뮘 �몮 �떎 異쒕젰
			if (arr[i].length() < 1) {
				System.out.println(arr[i] + "" + arr[i]);
			} else {
				System.out.print(arr[i].substring(0, 1)); // 0踰덉㎏ 1踰덉㎏ 異쒕젰
				System.out.println((arr[i].substring(arr[i].length() - 1, arr[i].length())));// �걹�뿉�꽌 -1踰덉㎏遺��꽣 �걹踰덉㎏源뚯�
			}

		}
    }
}

