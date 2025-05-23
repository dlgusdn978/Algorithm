package programmers;

import java.util.HashMap;
import java.util.Map;

public class HotelRoom_Allocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
	    public long[] solution(long k, long[] room_number) {
	        // 1 4 5 6
	        // 1, 2
	        // 1, 3
	        // 1, 4 -> 4�� �̹� ���� ��. 
	        long[] answer = new long[room_number.length];
	        // �Ҵ�� �� ������ ������ map
	        Map<Long, Long> map = new HashMap<>();
	        // �θ� ��� ������ ������ nodeMap
	        Map<Long, Long> nodeMap = new HashMap<>();
	        
	        // map =  �� ��ȣ, �� ��ȣ�κ��� �����ؼ� ���������� �Ҵ�� �� ��ȣ
	        // case 1 : ���� ���� �Ҵ�Ǿ� ���� ���� ���. -> ���� ���� �Ҵ��Ű�� ������ ����.
	        // case 2 : ���� ���� �Ҵ�� ��� -> next�� �̵��ϸ� �� �� ã��.
	        // case 3 : ���� ���� �Ҵ�� + ������ ���� ��� -> ���� ���� �� next�� �̵��ϸ� �� �� ã��.
	        for(int i=0; i<room_number.length; i++){
	            long cur = room_number[i];
	            if(nodeMap.containsKey(cur)){
	                // �Ҵ�� ���� �� ???
	                long parent = getParent(nodeMap, cur);
	                long child = map.get(parent);
	                // ���� ��
	                long next = child + 1;
	                while(true){
	                    // p  c   np,nc
	                    // 1234    56     78
	                    // next�� �θ� ���� ��
	                    if(nodeMap.containsKey(next)){
	                        long nextParent = getParent(nodeMap, next);
	                        long nextChild = map.get(nextParent);
	                        
	                        nodeMap.put(nextParent, parent);
	                        map.put(parent, nextChild);
	                        map.remove(nextParent);
	                        next = nextChild + 1;
	                    }else{
	                        // next�� �θ� ���� ��.
	                        
	                        // ������ ������ �� ��ȣ�� �θ� ����� cur�� ����Ŵ.
	                        nodeMap.put(next, parent);
	                        // �θ� ����� cur�� ���� ������ ������ ���ȣ�� next�� ����Ŵ.
	                        map.put(parent, next);
	                        
	                        answer[i] = next;
	                        break;
	                    }
	                }
	            }
	            else{
	                // ���� �� ��ȣ�� �Ҵ���� ���� ���� ��
	                map.put(cur, cur);
	                nodeMap.put(cur, cur);
	                answer[i] = cur;
	            }
	        }
	        return answer;
	    }
	    static long getParent(Map<Long, Long> nodeMap, long child){
	        long parent = nodeMap.get(child);
	        while(true){
	            if(nodeMap.containsKey(parent) && parent != nodeMap.get(parent)) parent = nodeMap.get(parent);
	            else break;
	        }
	        return parent;
	        
	    }
	}
}
