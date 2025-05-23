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
	        // 1, 4 -> 4가 이미 사용된 방. 
	        long[] answer = new long[room_number.length];
	        // 할당된 방 구간을 저장할 map
	        Map<Long, Long> map = new HashMap<>();
	        // 부모 노드 정보를 저장할 nodeMap
	        Map<Long, Long> nodeMap = new HashMap<>();
	        
	        // map =  방 번호, 방 번호로부터 시작해서 마지막으로 할당된 방 번호
	        // case 1 : 현재 방이 할당되어 있지 않은 경우. -> 현재 방을 할당시키고 구간을 생성.
	        // case 2 : 현재 방이 할당된 경우 -> next로 이동하며 빈 방 찾기.
	        // case 3 : 현재 방이 할당됨 + 구간을 만난 경우 -> 구간 통합 후 next로 이동하며 빈 방 찾기.
	        for(int i=0; i<room_number.length; i++){
	            long cur = room_number[i];
	            if(nodeMap.containsKey(cur)){
	                // 할당된 방일 때 ???
	                long parent = getParent(nodeMap, cur);
	                long child = map.get(parent);
	                // 다음 방
	                long next = child + 1;
	                while(true){
	                    // p  c   np,nc
	                    // 1234    56     78
	                    // next의 부모가 있을 때
	                    if(nodeMap.containsKey(next)){
	                        long nextParent = getParent(nodeMap, next);
	                        long nextChild = map.get(nextParent);
	                        
	                        nodeMap.put(nextParent, parent);
	                        map.put(parent, nextChild);
	                        map.remove(nextParent);
	                        next = nextChild + 1;
	                    }else{
	                        // next의 부모가 없을 때.
	                        
	                        // 구간의 마지막 방 번호는 부모 요소인 cur을 가리킴.
	                        nodeMap.put(next, parent);
	                        // 부모 요소인 cur은 현재 구간의 마지막 방번호인 next를 가리킴.
	                        map.put(parent, next);
	                        
	                        answer[i] = next;
	                        break;
	                    }
	                }
	            }
	            else{
	                // 현재 방 번호가 할당되지 않은 방일 때
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
