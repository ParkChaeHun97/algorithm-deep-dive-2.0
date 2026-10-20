## 튜플 (2019 KAKAO BLIND RECRUITMENT)

### 문제
`{{a1},{a1,a2},{a1,a2,a3},...,{a1,a2,...,an}}` 형태로 표현된 문자열 s가 주어질 때, 원래 튜플의 순서 (a1, a2, ..., an)를 복원하는 문제. 집합이라 중괄호 안 원소들의 순서는 뒤섞여 있을 수 있고, 바깥 중괄호 묶음들의 순서도 보장되지 않음.

### 접근 원리
- 각 안쪽 집합의 "길이(원소 개수)"가 튜플에서 원소가 추가된 순서와 대응됨 — 길이 1인 집합이 {a1}, 길이 2인 집합이 {a1,a2}...
- 이걸 직접 정렬하지 않고도, **각 숫자의 "등장 횟수"를 세는 것만으로 순서를 알아낼 수 있음**: a1은 모든 집합에 다 포함되므로 등장 횟수가 가장 많고, an은 가장 큰 집합 하나에만 등장하므로 가장 적음. 등장 횟수 내림차순 정렬 = 튜플 원래 순서


### 1차 풀이 — 2차원 배열 기반
```java
public int[] solution(String s) {
    String[] sSplit = s.split("[{},]");
    int[][] numbers = new int[100000+1][2];

    for (int i = 1; i < numbers.length; i++) {
        numbers[i][0] = i;
    }

    for (int i = 0; i < sSplit.length; i++) {
        if(!sSplit[i].equals("")) {
            int key = Integer.parseInt(sSplit[i]);
            numbers[key][1]++;
        }
    }

    Arrays.sort(numbers, (a,b) -> {
        if(a[1] == b[1]) {
            return b[0] - a[0];
        }
        return b[1] - a[1];
    });

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
        if(numbers[i][1] == 0) {
            break;
        }
        list.add(numbers[i][0]);
    }

    return list.stream().mapToInt(Integer::intValue).toArray();
}
```
- `numbers[i][0]`에 숫자 자체를, `numbers[i][1]`에 등장 횟수를 저장하는 방식으로 (숫자, 빈도) 쌍을 관리
- 100,001 크기의 배열을 전부 순회하며 인덱스를 숫자로, 빈도를 0으로 초기화한 뒤, 등장할 때마다 해당 인덱스의 빈도를 증가시키는 "인덱스 자체를 키로 쓰는" 접근
- 정렬 후 빈도가 0인 지점에서 break하여 실제 등장한 숫자만 추림
- 이 방식으로도 정확히 동작하며 통과함

### 2차(최종) 풀이 — HashMap 기반
```java
public int[] solution(String s) {
    String[] sSplit = s.split("[{},]");

    Map<Integer, Integer> countMap = new HashMap<>();

    for(String str : sSplit) {
        if(!str.isEmpty()) {
            int num = Integer.parseInt(str);
            countMap.put(num, countMap.getOrDefault(num,0) + 1);
        }
    }

    List<Integer> keys = new ArrayList<>(countMap.keySet());
    keys.sort((a, b) -> countMap.get(b) - countMap.get(a));
    return keys.stream().mapToInt(Integer::intValue).toArray();
}
```

### 두 풀이 방식 비교하며 깨달은 것
- 처음엔 HashMap으로 빈도수까지는 세었는데, **그 HashMap을 어떻게 정렬 가능한 형태(배열/리스트)로 바꿀지 몰라서 막힘** — HashMap을 배열로 바로 변환하려던 시도가 생각보다 잘 안 풀려서, 결국 처음부터 2차원 배열(인덱스=숫자, 값=빈도)로 접근을 바꿔서 풀이를 완성함
- 이후 `new ArrayList<>(map.keySet())`으로 **HashMap의 키 집합을 곧바로 List로 변환할 수 있다는 걸 새로 알게 됨** — 이 패턴을 알았다면 처음 시도(HashMap)로도 막힘 없이 끝까지 갈 수 있었던 상황
- 2차원 배열 방식은 "숫자 범위가 제한적으로 작을 때" 인덱스를 키처럼 쓰는 방식으로 유효하지만, 범위가 크거나 음수/비연속적인 값이 섞이면 비효율적이거나 아예 못 쓰는 방식 — HashMap 방식이 더 일반적이고 유연한 해법

## 회고
- 같은 문제를 두 가지 자료구조(2차원 배열 vs HashMap)로 풀어보면서, 각 방식의 장단점을 직접 비교해본 게 소득이었음 — 특히 "HashMap에서 원하는 대로 값을 꺼내 쓰지 못해서 결국 다른 자료구조로 우회했던 경험"이, 이번에 `keySet() → new ArrayList<>()` 패턴을 배우면서 해소됨
- 앞으로 Map을 정렬해야 하는 상황에서는 굳이 배열로 억지로 변환하려 하지 말고, `keySet()`이나 `entrySet()`을 List로 감싸서 Comparator로 정렬하는 패턴을 먼저 떠올리기로 함
- "자료구조 변환"이라는 구체적이고 재사용 가능한 교훈 하나를 확실히 챙긴 하루였음