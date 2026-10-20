# BOJ 2003 - 수들의 합 2

## 문제
N개의 자연수로 이루어진 수열에서, 합이 정확히 M이 되는
연속 부분 구간의 개수를 구한다.
N ≤ 10,000 → 브루트포스 O(n²)도 통과는 가능하나,
투포인터 O(n) 학습 목적으로 접근.

## 핵심 조건
모든 원소가 **자연수(양수)**라는 제약이 투포인터 성립의 핵심 전제.
→ 구간을 넓히면(right 이동) 합은 단조 증가
→ 구간을 좁히면(left 이동) 합은 단조 감소
이 단조성 덕분에 O(n²) 전수조사 없이 O(n)에 탐색 가능.

## 접근 - 투포인터
- sum < M: right를 늘리며 sum에 더함 (구간 확장)
- sum >= M: left를 늘리며 sum에서 뺌 (구간 축소)
    - 이때 sum == M이면 빼기 전에 count++
- 처음엔 "sum==M, sum<M, sum>M" 세 갈래로 분기했으나,
  sum==M과 sum>M을 sum>=M으로 합쳐도 무방함을 확인

## 겪은 시행착오


### 2. 투포인터 종료 조건 버그 (핵심)
초기 구현:
```java
while (right < n) {
    if (sum < m) { sum += arr[right]; right++; }
    else if (sum > m) { sum -= arr[left]; left++; }
    else { count++; sum -= arr[left]; left++; }
}
```
증상: 예제 입력(N=10, M=5)에서 count=2 (정답 3)로 오답.

원인: right가 배열 끝(n)에 도달하는 순간 while(right < n)이
바로 꺼져버려서, sum이 아직 M 이상으로 남아있는데도
left를 마저 줄이며 확인하는 과정이 생략됨.
→ 배열 끝 근처의 매칭 구간(인덱스 8~9, 합 5)을 놓침.

수정:
```java
while (left < n) {
    if (right < n && sum < m) {
        sum += arr[right]; right++;
    } else if (sum >= m) {
        if (sum == m) count++;
        sum -= arr[left]; left++;
    } else {
        break;
    }
}
```
- 바깥 루프 조건을 right 기준에서 left 기준으로 전환
- right가 끝났어도 sum >= m인 동안은 left를 계속 축소하며 확인


## 결과
- 수정 전: 예제 입력 count=2 (오답)
- 수정 후: 예제 입력 count=3 (정답 일치)

## 회고
- 투포인터의 "종료 조건"은 두 포인터 중 하나만 보고 판단하면
  안 되는 경우가 있음 — 특히 right가 끝에 닿은 뒤에도
  left 쪽 정리 작업이 남아있는지 항상 점검해야 함
- 실수 - 투포인터 종료조건 누락 로직의 뼈대는 맞았지만 경계 조건에서 틀린 패턴임
- 면접에서 "엣지 케이스 어떻게 처리했나" 질문에 쓸 수 있는 구체적 사례로 남겨둘 만함
