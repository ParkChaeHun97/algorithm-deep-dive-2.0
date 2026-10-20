## 비밀지도 (2018 KAKAO BLIND RECRUITMENT)

### 문제
지도 1과 지도 2가 각각 정수 배열(arr1, arr2)로 주어질 때, 두 지도를 겹쳐서(OR 연산) 실제 비밀지도를 구하는 문제. 각 정수를 n자리 이진수로 봤을 때 1인 자리는 벽(#), 0인 자리는 공백으로 표시. 15분 만에 풀이 완료.

### 접근
- `arr1[i] | arr2[i]`로 OR 연산해서 "벽이 있는 자리"를 합침
- `Integer.toBinaryString()`으로 이진수 문자열 변환 — 이때 앞자리 0이 생략되는 문제를 `" ".repeat(n - str.length())`로 왼쪽 패딩하여 해결
- 0은 공백, 1은 #으로 치환해서 최종 문자열 완성


### 1차 코드
```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        
        for(int i = 0; i < n; i++) {
            int num = arr1[i] | arr2[i];
            String a = Integer.toBinaryString(num); // 101;
            // 101이면 00101로 바꿔야하는데?
            
            StringBuilder sb = new StringBuilder(); 
            
            // n - a.length()만큼 먼저 공백 삽입
            sb.append(" ".repeat(n - a.length()));
            
            for(int j = 0; j < a.length(); j++) {
                if(a.charAt(j) - '0' == 1 ) sb.append("#");
                else sb.append(" ");
            }
            
            
            answer[i] = sb.toString();
            
        }
        
        
        return answer;
    }
}
```


### 2차 코드
```java
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            String temp = " ".repeat(n - str.length()) + str.replaceAll("0", " ").replaceAll("1","#");
            answer[i] = temp;
        }
        
        return answer;
    }
}
```


### 리팩토링
- 1차: for문 + if-else로 문자 하나하나 순회하며 0→공백, 1→# 치환
- 2차(참고 후 리팩토링): `str.replaceAll("0", " ").replaceAll("1", "#")`로 한 줄에 압축
- 두 방식 비교: 1차는 문자 단위 비교라 미세하게 더 빠르지만, 2차는 의도가 코드에 바로 드러나서 가독성이 훨씬 좋음. 이 문제 규모(n이 작음)에서는 성능 차이가 무의미해 2차 방식이 더 실용적이라는 결론
- replaceAll이 정규식 기반이라는 점도 짚음 — 지금 케이스(단순 "0","1" 치환)는 문제없지만, 나중에 정규식 메타문자를 다뤄야 하는 상황에서는 이스케이프 처리를 신경 써야 한다는 점을 참고로 확인

## 회고
- 이진수 변환 시 앞자리 0이 생략되는 함정을 처음부터 놓치지 않고 패딩으로 처리한 것 — 이전 문제들(파일명 정렬, 압축 등)에서 반복해온 "경계값 먼저 체크하기" 습관이 자연스럽게 적용된 사례
- 15분 만에 로직 실수 없이 완성 — Lv1~2급 문제에 대한 기본기가 확실히 자리잡았다는 신호
- 정답을 맞힌 뒤에도 "다른 사람 코드와 비교해보며 더 나은 표현 방식을 찾아보는" 습관을 유지함 — 통과 여부에서 끝나지 않고 코드 품질까지 점검하는 흐름이 이어지고 있음