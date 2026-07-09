# Parametric Search / 나무 자르기

## Parametric Search 개념

### 일반 이분탐색 vs Parametric Search
- 일반 이분탐색: 정렬된 배열에서 **값을 찾는** 것
- Parametric Search: **정답 자체를 이분탐색으로 좁혀나가는** 것

### 적용 조건
- 정답이 될 수 있는 범위가 명확할 때
- 조건이 **단조성**을 가질 때 (H가 높아질수록 얻는 나무가 줄어드는 것처럼 한 방향으로만 변함)

### 패턴
```
left = 최솟값, right = 최댓값
while (left <= right) {
    mid = (left + right) / 2
    if (mid가 조건 만족) {
        answer = mid  // 정답 후보 저장
        left = mid + 1  // 더 좋은 값 탐색
    } else {
        right = mid - 1
    }
}
```

---

## 백준 2805 (나무 자르기)

### 문제
- 절단기 높이 H를 설정했을 때 M미터 이상 얻을 수 있는 H의 최댓값 구하기

### 해결
- H의 범위: 0 ~ 나무 최대 높이
- H가 높아질수록 얻는 나무가 줄어듦 → 단조성 성립 → Parametric Search 적용
- 조건 만족(treeSum >= M)이면 answer에 저장하고 더 높은 H 탐색 (left = mid + 1)
- 조건 불만족이면 H 낮추기 (right = mid - 1)
- O(N log N)으로 해결

### 핵심 포인트
- **오버플로우 주의**: 나무 높이 최대 10^9 × 나무 개수 10^6 = 최대 10^15 → treeSum, M 모두 long 필수
- **정답 처리**: treeSum == M일 때 바로 return하면 안 됨 → 더 높은 H에서도 M 이상 나올 수 있음 → answer에 후보 저장하고 계속 탐색
- **else if (treeSum <= M)** → 사실 else로 충분 (treeSum >= M이 아닌 경우만 남으니까)

### 처음 실수했던 것들
1. treeSum, M을 int로 선언 → long으로 수정
2. treeSum == M일 때 바로 출력하고 return → 최댓값 보장 안 됨, 삭제
3. while (left < right) → left <= right로 수정