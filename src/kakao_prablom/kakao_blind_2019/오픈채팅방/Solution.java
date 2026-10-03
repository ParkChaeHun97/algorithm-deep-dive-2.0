package kakao_prablom.kakao_blind_2019.오픈채팅방;

import java.util.*;
class Solution {
    public String[] solution(String[] record) {

        HashMap<String, String> map = new HashMap<>();
        // uid랑 Message 넣는 용도, uid의 키값으로 value를 뽑아냄
        List<String[]> uidAndMessage = new ArrayList<>();


        for (int i = 0; i < record.length; i++) {
            // 행동, uid, 아이디로 분리
            String[] split = record[i].split(" ");

            String action = split[0];
            String uid = split[1];

            //  길이가 3인 경우만 새로 생성,길이가 2인 경우는 나가기뿐
            if(split.length == 3) {

                String nickname = split[2]; // change랑 enter일 경우 2번 인덱스까지 있음(닉네임)
                map.put(uid, nickname); // change나 enter일 경우 공통으로 put해야한다.(생성 및 수정)

                if(action.equals("Enter")) { // 엔터인경우는 맵에 키 : 아이디 생성
                    uidAndMessage.add(new String[]{uid, "님이 들어왔습니다."});
                }


            } else { // 길이가 2인경우, 나가기
                uidAndMessage.add(new String[]{uid, "님이 나갔습니다."});
            }

        }

        String[] result = new String[uidAndMessage.size()];

        for(int i = 0; i < result.length; i++) {
            String nickname = map.get(uidAndMessage.get(i)[0]);
            String actionMessage = uidAndMessage.get(i)[1];
            result[i] = nickname + actionMessage;
        }





        return result;
    }
}