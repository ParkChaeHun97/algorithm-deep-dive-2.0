

## LIS O(N log N) 풀이

### O(N²) vs O(N log N) 비교

#### O(N²) 풀이
- `dp[i]` = i번째 원소를 마지막으로 하는 LIS의 길이
- i 이전의 모든 j를 순회하며 A[j] < A[i]인 경우 `dp[j] + 1` 계산
- 각 원소마다 이전 원소 모두 확인 → O(N²)

#### O(N log N) 풀이
- `dp[i]` = **길이 i+1인 LIS의 마지막 원소의 최솟값**
- dp 배열은 항상 정렬된 상태 유지
- 각 원소가 들어갈 위치를 이분탐색으로 O(log N)에 찾기
- 총 O(N log N)

### 핵심 아이디어

**길이별 최솟값을 추적하는 이유:**

- 길이 3인 LIS가 여러 개 있을 때, 마지막 원소가 작을수록 다음 원소를 추가할 때 더 많은 선택지가 생긴다.
- 예: {1, 2, 3}의 마지막 3 vs {1, 3, 5}의 마지막 5
→ 마지막이 3인 경우가 4를 추가할 때 더 유리

  
### 이진 탐색 구조

각 원소가 들어갈 위치를 찾는 이분탐색:
```java
left = 0, right = len;
    while (left < right) {
        mid = (left + right) / 2;
        if (dp[mid] < number) {
        left = mid + 1;  // number가 더 오른쪽
        } else {
        right = mid;  // number는 이 위치 또는 왼쪽
        }
    }
return left;  // number가 들어갈 위치

```

**핵심:**
- `right = mid - 1`이 아니라 `right = mid` (경계 조건 중요)
- 루프 종료 후 `left`가 정확하게 삽입 위치를 가리킴

### 시간복잡도
- 각 원소마다 이진 탐색: O(log N)
- N개 원소 처리: O(N log N)
- 공간: O(N)

### 최적화 포인트
- Java의 Arrays.binarySearch() 활용 가능
- 직접 구현 시 `right = mid` 실수 주의
- dp 배열은 항상 정렬된 상태 유지 (불변)