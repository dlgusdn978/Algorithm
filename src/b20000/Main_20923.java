package b20000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_20923 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dodo = new ArrayDeque<Integer>();
		Deque<Integer> su = new ArrayDeque<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			dodo.add(Integer.parseInt(st.nextToken()));
			su.add(Integer.parseInt(st.nextToken()));
		}
		//�׶��忡 ���� �ִ� ������ ī�� ���̿��� ���� ���� ��ġ�� ī���� ���� ���� 5�� �Ǵ� ���� �����̰� ���� ģ��. ��, ��� ���� �׶��嵵 ��������� �ȵȴ�.
		//�׶��忡 ���� �ִ� ������ ī�� ���� �� ���� ���� ��ġ�� ī���� ���ڰ� 5�� ������ ���� ������ ���� ģ��.
		Deque<Integer> dodoGround = new ArrayDeque<>();
		Deque<Integer> suGround = new ArrayDeque<>();
		for(int i=0; i<m; i++) {
			if(dodo.isEmpty() || su.isEmpty()) break;
			if(i%2==0) {
				// dodo
				int dodoCard = dodo.removeLast();
				if(dodo.isEmpty()) break;
				dodoGround.addLast(dodoCard);
				if(dodoCard==5) dodoRing(dodo, su, dodoGround, suGround);
				else if(!suGround.isEmpty() && dodoCard+suGround.getLast()==5) suRing(dodo, su, dodoGround, suGround);
			}else {
				// su
				int suCard = su.removeLast();
				if(su.isEmpty()) break;
				suGround.add(suCard);
				if(suCard==5) dodoRing(dodo, su, dodoGround, suGround);
				else if(!dodoGround.isEmpty() && dodoGround.getLast()+suCard==5) suRing(dodo, su, dodoGround, suGround);
			}
		}
		
		if(dodo.size()==su.size()) {
			System.out.println("dosu");
		}else if(dodo.size()>su.size()) {
			System.out.println("do");
		}else {
			System.out.println("su");
		}
	}
	static void dodoRing(Deque<Integer> dodo, Deque<Integer> su, Deque<Integer> dodoGround, Deque<Integer> suGround) {
		while(!suGround.isEmpty()) {
			dodo.addFirst(suGround.removeFirst());
		}
		while(!dodoGround.isEmpty()) {
			dodo.addFirst(dodoGround.removeFirst());
		}
	}
	static void suRing(Deque<Integer> dodo, Deque<Integer> su, Deque<Integer> dodoGround, Deque<Integer> suGround) {
		while(!dodoGround.isEmpty()) {
			su.addFirst(dodoGround.removeFirst());
		}
		while(!suGround.isEmpty()) {
			su.addFirst(suGround.removeFirst());
		}
	}
}
