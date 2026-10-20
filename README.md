# algorithm-deep-dive-2.0

**1일 1알고리즘**을 목표로 매일 꾸준히 문제를 풀어 가는 알고리즘 학습 레포입니다.
백준 · 프로그래머스 · 카카오 기출 풀이를 **알고리즘 주제별**로 정리하고, 자주 쓰는 알고리즘은 직접 템플릿으로 만들어 둡니다.

## 학습 원칙

- **30분 룰**: 문제를 받으면 최소 30분은 힌트 없이 스스로 붙잡고 고민한 뒤에만 풀이를 검색한다.
- **템플릿은 직접 작성**: BFS/DFS, 다익스트라, 유니온 파인드처럼 반복해서 쓰는 알고리즘은 직접 짜서 `template/`에 정리하고, 문제를 풀 때 외워서 다시 쓸 수 있을 때까지 반복한다.
- **다시 풀기**: 한 번 푼 주제도 시간이 지나면 처음부터 다시 풀어 보고 `Solution_review.java`로 남겨 이전 풀이와 비교한다.
- **손으로 그리기**: 재귀 호출 스택, 그래프 탐색 순서처럼 헷갈리는 흐름은 그림으로 먼저 그려보고 코드로 옮긴다.
- **1일 1커밋**: 하루에 최소 한 문제를 풀고, 그날 푼 풀이를 커밋으로 남긴다.

## 폴더 구조

알고리즘 **주제별**로 폴더를 나누고, 문제의 출처(백준 · 프로그래머스 · 카카오)는 폴더 이름 접두사로 구분합니다.

```
src/
├── graph_search/              BFS / DFS
├── tree/                      트리 순회, 트리 탐색
├── prefix_sum/                누적합 / 구간 합
├── number_theory/             정수론 (GCD/LCM, 에라토스테네스, 소인수분해)
├── binary_search/             이분 탐색 / 파라메트릭 서치
├── two_pointer/               투 포인터 / 슬라이딩 윈도우
├── data_structure/            스택 · 큐 · 힙 · 해시
├── greedy/                    그리디 (정렬 기반 포함)
├── shortest_path/             다익스트라 · 0-1 BFS · 플로이드
├── union_find/                유니온 파인드 / MST
├── brute_force_backtracking/  완전탐색 / 백트래킹 (순열 · 조합 · 중복순열)
├── bitmask/                   비트마스크
├── recursion/                 재귀 기초 (팩토리얼, 피보나치 등 워밍업)
├── dp/                        동적 계획법 (Top-down / Bottom-up 비교 포함)
└── implementation/            구현 · 시뮬레이션 · 문자열 파싱
```

각 주제 폴더는 아래 구성을 따릅니다.

```
<주제>/
├── problem/      문제 풀이
├── template/     직접 정리한 알고리즘 템플릿 (있는 주제만)
└── review/       복습 노트 (있는 주제만)
```

문제 폴더 이름 규칙:

| 출처 | 형식 | 예시 |
|---|---|---|
| 백준 | `BOJ_번호_문제이름` | `BOJ_1753_최단경로` |
| 프로그래머스 | `PGS_문제이름` | `PGS_네트워크` |
| 카카오 기출 | `KAKAO_<전형><연도>_문제이름` (BLIND / INTERN / WINTER / TRYOUT) | `KAKAO_BLIND2021_합승_택시_요금` |

각 문제 폴더는 기본적으로 아래 구성을 따릅니다.

```
BOJ_XXXX_문제이름/
├── Solution.java         (또는 TopDown.java / BottomUp.java 등 풀이 방식별 구분)
├── Solution_review.java  복습 때 다시 푼 풀이 (있는 경우)
└── Analysis.md           풀이 메모 · 시행착오 (있는 경우)
```

## 실행 방법

- `src/`를 소스 루트로 둔 순수 Java 프로젝트입니다 (빌드 도구 없음, JDK 17 이상).
- 패키지 이름은 폴더 경로와 같습니다. 예: `src/dp/problem/BOJ_1463_1로_만들기/BottomUp.java` → `package dp.problem.BOJ_1463_1로_만들기;`
- IntelliJ에서는 각 파일의 `main`을 바로 실행하면 되고, 터미널에서 전체 컴파일은 아래처럼 합니다.

```bash
javac -encoding UTF-8 -d out $(find src -name '*.java')
```

## 템플릿 모음

| 알고리즘 | 파일 |
|---|---|
| BFS | [BFS_Template.java](src/graph_search/template/BFS_Template.java) |
| DFS | [DFS_Template.java](src/graph_search/template/DFS_Template.java) |
| 유클리드 호제법 (GCD / LCM) | [Euclidean.java](src/number_theory/template/Euclidean.java) |
| 이분 탐색 | [BinarySearch.java](src/binary_search/template/BinarySearch.java) |
| 다익스트라 (우선순위 큐) | [Dijkstra_PQ.java](src/shortest_path/template/Dijkstra_PQ.java) |
| 다익스트라 (배열, O(V²)) | [Dijkstra_Array.java](src/shortest_path/template/Dijkstra_Array.java) |
| 0-1 BFS | [ZeroOneBFS.java](src/shortest_path/template/ZeroOneBFS.java) |
| 유니온 파인드 | [UnionFind.java](src/union_find/template/UnionFind.java) |
| 백트래킹 (순열) | [Backtracking.java](src/brute_force_backtracking/template/Backtracking.java) |
| 비트마스크 기본 연산 | [BitmaskPractice.java](src/bitmask/template/BitmaskPractice.java) |

## 복습 노트

| 주제 | 노트 |
|---|---|
| DP (계단 오르기 / LIS / 연속합) | [Day3_DP_복습.md](src/dp/review/Day3_DP_복습.md) |
| 다익스트라 / 0-1 BFS (최단경로 / 알고스팟) | [Day4_다익스트라_0-1BFS_복습.md](src/shortest_path/review/Day4_다익스트라_0-1BFS_복습.md) |
| 유니온 파인드 / MST (집합의 표현 / 최소 스패닝 트리) | [Day5_유니온파인드_MST_복습.md](src/union_find/review/Day5_유니온파인드_MST_복습.md) |

## 진행 현황

| 주제 | 폴더 | 문제 수 | template |
|---|---|---|---|
| BFS / DFS | [graph_search](src/graph_search) | 10 | BFS · DFS |
| 트리 | [tree](src/tree) | 2 | |
| 누적합 | [prefix_sum](src/prefix_sum) | 4 | |
| 정수론 | [number_theory](src/number_theory) | 5 | 유클리드 호제법 |
| 이분 탐색 / 파라메트릭 서치 | [binary_search](src/binary_search) | 4 | 이분 탐색 |
| 투 포인터 / 슬라이딩 윈도우 | [two_pointer](src/two_pointer) | 6 | |
| 자료구조 | [data_structure](src/data_structure) | 7 | |
| 그리디 | [greedy](src/greedy) | 7 | |
| 최단 경로 | [shortest_path](src/shortest_path) | 4 | 다익스트라(PQ · 배열) · 0-1 BFS |
| 유니온 파인드 / MST | [union_find](src/union_find) | 3 | 유니온 파인드 |
| 완전탐색 / 백트래킹 | [brute_force_backtracking](src/brute_force_backtracking) | 11 | 백트래킹 |
| 비트마스크 | [bitmask](src/bitmask) | 2 | 비트 연산 |
| 재귀 | [recursion](src/recursion) | 3 | |
| DP | [dp](src/dp) | 11 | |
| 구현 / 시뮬레이션 / 문자열 | [implementation](src/implementation) | 15 | |
| **합계** | | **94** | |

## 출처별 색인

### 카카오 기출 (27문제)

| 연도 | 전형 | 문제 | 주제 |
|---|---|---|---|
| 2017 | 카카오코드 예선 | [카카오프렌즈 컬러링북](src/graph_search/problem/KAKAO_TRYOUT2017_카카오프렌즈_컬러링북) | BFS / DFS |
| 2018 | 블라인드 | [다트 게임](src/implementation/problem/KAKAO_BLIND2018_다트_게임) | 구현 |
| 2018 | 블라인드 | [모의고사](src/brute_force_backtracking/problem/KAKAO_BLIND2018_모의고사) | 완전탐색 |
| 2018 | 블라인드 | [비밀지도](src/bitmask/problem/KAKAO_BLIND2018_비밀지도) | 비트마스크 |
| 2018 | 블라인드 | [압축](src/implementation/problem/KAKAO_BLIND2018_압축) | 구현 |
| 2018 | 블라인드 | [추석 트래픽](src/implementation/problem/KAKAO_BLIND2018_추석_트래픽) | 구현 |
| 2018 | 블라인드 | [캐시](src/implementation/problem/KAKAO_BLIND2018_캐시) | 구현 |
| 2018 | 블라인드 | [파일명 정렬](src/implementation/problem/KAKAO_BLIND2018_파일명_정렬) | 구현 |
| 2019 | 블라인드 | [실패율](src/implementation/problem/KAKAO_BLIND2019_실패율) | 구현 |
| 2019 | 블라인드 | [오픈채팅방](src/data_structure/problem/KAKAO_BLIND2019_오픈채팅방) | 해시 |
| 2019 | 블라인드 | [완주하지 못한 선수](src/data_structure/problem/KAKAO_BLIND2019_완주하지_못한_선수) | 해시 |
| 2019 | 겨울 인턴십 | [크레인 인형뽑기 게임](src/data_structure/problem/KAKAO_WINTER2019_크레인_인형뽑기_게임) | 스택 |
| 2019 | 겨울 인턴십 | [튜플](src/implementation/problem/KAKAO_WINTER2019_튜플) | 구현 |
| 2020 | 블라인드 | [괄호 회전하기](src/data_structure/problem/KAKAO_BLIND2020_괄호_회전하기) | 스택 |
| 2020 | 블라인드 | [문자열 압축](src/implementation/problem/KAKAO_BLIND2020_문자열_압축) | 구현 |
| 2020 | 블라인드 | [키패드 누르기](src/implementation/problem/KAKAO_BLIND2020_키패드_누르기) | 구현 |
| 2020 | 겨울 인턴십 | [보석 쇼핑](src/two_pointer/problem/KAKAO_WINTER2020_보석_쇼핑) | 투 포인터 |
| 2021 | 블라인드 | [메뉴 리뉴얼](src/brute_force_backtracking/problem/KAKAO_BLIND2021_메뉴_리뉴얼) | 조합 |
| 2021 | 블라인드 | [신규 아이디 추천](src/implementation/problem/KAKAO_BLIND2021_신규_아이디_추천) | 구현 |
| 2021 | 블라인드 | [합승 택시 요금](src/shortest_path/problem/KAKAO_BLIND2021_합승_택시_요금) | 플로이드 |
| 2021 | 인턴십 | [숫자 문자열과 영단어](src/implementation/problem/KAKAO_INTERN2021_숫자_문자열과_영단어) | 구현 |
| 2021 | 겨울 인턴십 | [거리두기 확인하기](src/graph_search/problem/KAKAO_WINTER2021_거리두기_확인하기) | BFS |
| 2022 | 블라인드 | [주차 요금 계산](src/implementation/problem/KAKAO_BLIND2022_주차_요금_계산) | 구현 |
| 2022 | 인턴십 | [성격 유형 검사하기](src/implementation/problem/KAKAO_INTERN2022_성격_유형_검사하기) | 구현 |
| 2023 | 블라인드 | [이모티콘 할인행사](src/brute_force_backtracking/problem/KAKAO_BLIND2023_이모티콘_할인행사) | 중복순열 |
| 2023 | 블라인드 | [택배 배달과 수거하기](src/greedy/problem/KAKAO_BLIND2023_택배_배달과_수거하기) | 그리디 |
| 2025 | 하반기 1차 | [바이러스 파이프](src/graph_search/problem/KAKAO_BLIND2025_바이러스_파이프) | BFS + 중복순열 |

### 프로그래머스 (14문제)

| 문제 | 주제 |
|---|---|
| [네트워크](src/graph_search/problem/PGS_네트워크) | BFS / DFS |
| [여행 경로](src/graph_search/problem/PGS_여행_경로) | DFS |
| [폰켓몬](src/data_structure/problem/PGS_폰켓몬) | 해시 |
| [가장 큰 수](src/greedy/problem/PGS_가장_큰수) | 정렬 |
| [귤 고르기](src/greedy/problem/PGS_귤_고르기) | 그리디 |
| [조이스틱](src/greedy/problem/PGS_조이스틱) | 그리디 |
| [최솟값 만들기](src/greedy/problem/PGS_최솟값_만들기) | 그리디 |
| [소수 찾기](src/brute_force_backtracking/problem/PGS_소수_찾기) | 완전탐색 (순열) |
| [타겟 넘버](src/brute_force_backtracking/problem/PGS_타겟_넘버) | 백트래킹 |
| [피로도](src/brute_force_backtracking/problem/PGS_피로도) | 완전탐색 (순열) |
| [멀리 뛰기](src/dp/problem/PGS_멀리_뛰기) | DP |
| [정수 삼각형](src/dp/problem/PGS_정수_삼각형) | DP |
| [최댓값과 최솟값](src/implementation/problem/PGS_최댓값과_최솟값) | 문자열 |
| [핸드폰 번호 가리기](src/implementation/problem/PGS_핸드폰_번호_가리기) | 문자열 |

