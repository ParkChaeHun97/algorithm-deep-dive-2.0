## 카카오 2018 BLIND RECRUITMENT - 파일명 정렬

### 문제
파일명 배열이 주어질 때, 각 파일명을 HEAD(숫자 아닌 앞부분) + NUMBER(그 다음 나오는 연속된 숫자, 최대 5자리까지 유효) + TAIL(나머지)로 분리한 뒤, HEAD는 대소문자 구분 없이 사전순, HEAD가 같으면 NUMBER는 숫자 크기로 비교해 정렬하는 문제. 그래도 같으면 원래 입력 순서를 유지(stable)해야 함.

### 접근
- `splitHNT(String str)` 함수로 head/number/tail 분리
    - 문자를 인덱스로 순회하며 `Character.isDigit()`으로 숫자가 처음 나오는 지점까지를 head로 자름
    - 그 지점부터 다시 순회하며 숫자가 아닌 게 나올 때까지를 number로 자름
    - 나머지는 tail
- `Arrays.sort(files, Comparator)`로 정렬
    - head는 `toLowerCase()`로 대소문자 무시 후 `compareTo()`로 사전순 비교
    - head가 같으면 number를 `Integer.parseInt()`로 숫자 변환 후 크기 비교 (`aNum - bNum`)
    - `String[]`은 객체 배열이라 `Arrays.sort`가 자동으로 TimSort(안정 정렬)를 사용하므로, head/number가 모두 같은 경우 별도 처리 없이 원래 순서가 유지됨

### 실수
- **`split`으로 head/number를 나누려다 실패**: 정규식으로 숫자/문자를 구분자 삼아 자르는 방식은 문자열 중간에 숫자와 문자가 섞여 있으면 정보가 손실됨. 인덱스를 직접 순회하며 경계를 찾는 방식으로 전환
- **`bSplit[1]`을 head 자리에 잘못 대입**: number 배열 인덱스를 head 변수에 할당하는 단순 오타
- **`Comparator`가 어떤 값을 기준으로 정렬 방향을 정하는지 헷갈림**: "음수 반환 → a가 앞으로 옴"이라는 규칙 자체를 몰라서, `aNum - bNum`과 `bNum - aNum` 중 어느 쪽이 오름차순인지 혼동함 → `bNum - aNum`(내림차순)으로 잘못 짰다가 방향을 바로잡음

### 토론한 내용
- `Comparator`의 반환값 규칙(음수=a가 앞, 양수=b가 앞, 0=순서유지)을 원리부터 짚음. "오름차순 원하면 a-b, 내림차순 원하면 b-a"로 정리
- NUMBER를 문자열 그대로 비교하면 안 되는 이유(`"12"`가 `"2"`보다 사전순으로 앞에 와버리는 함정)와, `Integer.parseInt()`로 변환해서 숫자 크기로 비교해야 하는 이유를 확인
- Stable sort 여부 확인: `Arrays.sort()`는 원시 타입 배열(`int[]` 등)엔 퀵소트(불안정)를 쓰지만, 객체 배열(`String[]` 등)엔 TimSort(안정 정렬)를 쓴다는 점 — 이번 문제에서 별도 stable 처리 코드 없이도 요구조건을 만족한 이유

## 회고
- `Character.isDigit()`을 처음 알게 됨 — 문자 하나가 숫자인지 판별할 때 매번 `'0' <= c && c <= '9'`처럼 직접 비교할 필요 없이 바로 쓸 수 있는 메서드
- `String`이 `compareTo()`를 기본 지원한다는 것도 이번에 명확히 확인함 — 사전순 비교를 직접 문자 단위로 루프 돌 필요 없음
- Comparator 반환값의 부호와 정렬 방향의 관계를 개념적으로 이해하고 나니, 오름차순/내림차순을 짤 때 헷갈리지 않고 바로 판단할 수 있게 됨