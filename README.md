# 🔍 이분 탐색 (Binary Search)

정렬된 데이터에서 탐색 범위를 절반씩 좁혀나가며 타겟 데이터를 빠르게 찾아내는 $O(\log N)$ 알고리즘

---

## 💡 핵심 메커니즘
이분 탐색의 핵심은 **절반으로 나누기**이다. 전체를 하나씩 확인하는 순차 탐색(O(N))과 달리, 단 몇 번의 비교만으로 수억 개의 데이터 중 원하는 값을 찾아낼 수 있다.



1. **전제 조건:** 데이터가 반드시 **오름차순 또는 내림차순으로 정렬**되어 있어야 함.
2. **포인터 설정:** 탐색 범위의 시작점(`start`)과 끝점(`end`)을 지정.
3. **무한 루프 조율:** `start <= end`인 동안 중간점(`mid`)을 계산하여 타겟 값과 비교.
   - `mid` 값 == `target` ➡️ 탐색 성공 (인덱스 반환)
   - `mid` 값 > `target` ➡️ 범위를 왼쪽 절반으로 축소 (`end = mid - 1`)
   - `mid` 값 < `target` ➡️ 범위를 오른쪽 절반으로 축소 (`start = mid + 1`)

---

## 🛠️ 표준 구현 템플릿 (Java)

 **반복문(Iteration)** 기반의 구현 코드

```java
public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // (start + end) / 2 시 발생할 수 있는 정수 오버플로우 방지 양식
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid; // 찾은 경우 인덱스 반환
            } else if (arr[mid] > target) {
                end = mid - 1; // 왼쪽 영역 탐색
            } else {
                start = mid + 1; // 오른쪽 영역 탐색
            }
        }
        return -1; // 찾지 못한 경우
    }
}
```

---

## 문제 풀이 시 주의사항
**1. mid 계산 시 발생하는 타입 오버플로우**
  > start와 end가 정답에 가까워질 때 순간적으로 타입 상한을 초과하는 경우 발생.
  >> ex) int형 연산 시 start+end 값이 2,147,483,647 초과.
   -> **int mid = start + (end - start) / 2;** 를 활용하여 타입 오버플로우 방지
   
**2. 초기 탐색 범위 오버플로우**
  > 최악의 케이스를 상정하여 end 포인터의 초깃값을 연산할 때 발생.
  >> ex) long end = max_value * total_count;
   -> **long end = (long) max_value * total_count;** 를 활용하여 명시적 형변환
   
**3. 조건 만족 여부 누적 시 오버플로우**
  > start, end, mid 제외, count 등 추가적인 변수 연산 시 오버플로우 발생하지 않도록 유의.
