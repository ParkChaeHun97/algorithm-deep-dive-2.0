## 백준 2606 - 바이러스

### 문제
컴퓨터 N대와 네트워크 연결 정보가 주어질 때, 1번 컴퓨터가 웜 바이러스에 걸렸을 경우
1번을 통해 전파되어 감염되는 컴퓨터의 수를 구하는 문제.
그래프 탐색(BFS/DFS) 기본 문제.

### 접근
- 큐 기반 BFS로 구현
- 인접 리스트로 그래프 구성 (양방향 간선)
- 큐에 넣는 시점에 visited 처리 → 중복 삽입 방지
- count는 "새로 감염되는 노드"를 방문할 때마다 증가시키는 방식으로 처리
  → 1번 자신은 감염원이지 카운트 대상이 아니므로, 이 방식이면 별도의 `-1` 보정 없이 자동으로 제외됨

```java
private static void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int current = queue.poll();
        for (int next : graph.get(current)) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                queue.offer(next);
            }
        }
    }
}
```

### 헷갈렸던 지점
- visited 처리 시점: DFS는 함수 진입 시 처리해도 무방하지만, BFS는 poll 시점에 처리하면 같은 노드가 큐에 중복으로 여러 번 들어갈 수 있음 → 반드시 큐에 넣는 시점에 처리해야 함
- 1번 컴퓨터 포함 여부: 문제에서 요구하는 답은 "1번을 통해 걸리게 되는" 컴퓨터 수이므로 1번 자신은 제외. count 증가 위치를 "새로 방문하는 노드"에 두면 자연스럽게 해결됨
- 그래프 표현 방식: 정점 수 대비 간선 수가 적을 때는 인접 행렬보다 인접 리스트가 적합

## 회고
- 원래 계획은 다익스트라 원리 학습이었으나, 재귀 DFS/큐 기반 BFS 기본 구현이 흔들린다고 판단해 7주차 계획을 재구성함 (Day 1을 BFS/DFS 기본기 복구로 변경, 이후 일정 하루씩 밀림)
- BFS 템플릿을 백지 상태에서 직접 짜보면서, visited 처리 시점 같은 디테일이 왜 중요한지 체감함
- 다음 문제(1753, 다익스트라)로 넘어가기 전 기본기를 다시 손에 붙이는 단계였음