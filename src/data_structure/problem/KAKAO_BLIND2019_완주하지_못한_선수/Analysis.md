## 완주하지 못한 선수 (프로그래머스 Lv.1, 2019 카카오 블라인드)

### 문제 요약
 - participant 배열과 completion 배열이 주어질 때, completion에 없는 (미완주) 선수 이름을 찾는 문제. 동명이인이 존재할 수 있다는 게 함정.

### 접근
 - HashMap<String, Integer>로 이름별 등장 횟수를 카운팅.
 - participant를 순회하며 각 이름의 카운트 +1
 - completion을 순회하며 각 이름의 카운트 -1
 - 순회 종료 후 카운트가 0이 아닌 이름이 미완주자


### 시행착오
 - 1차 시도: 이름을 0/1 boolean 플래그로만 저장 (있다/없다).
 - 실패 원인: 동명이인이 있는 경우("mislav"가 participant에 2번, completion에 1번) boolean으로는 "몇 번 나왔는지"가 소실되어 구분 불가.
 - 2차 시도: getOrDefault(participant[i], 1) + 1 — 타입 에러(배열 자체를 키로 넣음) + 로직 에러(기본값을 1로 잡아서 최초 등장 시 카운트가 2부터 시작).
 -  3차 시도(정답): getOrDefault(participant[i], 0) + 1로 기본값을 0으로 수정. 처음 등장 시 정확히 1부터 시작하도록 고침.

### 핵심 교훈
 - getOrDefault의 기본값은 "키가 없을 때 대신 쓸 값"이지 "카운트 시작값"이 아니다 — 연산(+1)과 결합될 때 기본값 선택이 최종 결과에 그대로 영향을 준다.
 - boolean 플래그와 카운터는 다른 문제다. "존재 여부"가 아니라 "빈도 차이"를 물어보는 문제인지 먼저 구분해야 함.


### 복잡도
 - 시간: O(N + M) — N = participant 길이, M = completion 길이
 - 공간: O(N) — HashMap