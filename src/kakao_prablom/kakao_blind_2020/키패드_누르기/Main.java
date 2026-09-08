package kakao_prablom.kakao_blind_2020.키패드_누르기;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int[][] phoneMap = new int[4][3];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[] currentLeftHand = new int[]{3,0};
        int[] currentRightHand = new int[]{3,2};

        for (int i = 0; i < numbers.length; i++) {

            int leftResult;
            int rightResult;

            switch (numbers[i]) {
                case 1:
                    sb.append("L");
                    currentLeftHand = new int[]{0,0};
                    break;
                case 4:
                    sb.append("L");
                    currentLeftHand = new int[]{1,0};
                    break;
                case 7:
                    sb.append("L");
                    currentLeftHand = new int[]{2,0};
                    break;
                case 3:
                    sb.append("R");
                    currentRightHand = new int[]{0,2};
                    break;
                case 6:
                    sb.append("R");
                    currentRightHand = new int[]{1,2};
                    break;
                case 9:
                    sb.append("R");
                    currentRightHand = new int[]{2,2};
                    break;
                case 2:
                    leftResult = bfs(currentLeftHand, new int[]{0,1});
                    phoneMap = new int[4][3];
                    rightResult = bfs(currentRightHand, new int[]{0,1});
                    phoneMap = new int[4][3];

                    if(leftResult < rightResult) {
                        sb.append("L");
                        currentLeftHand = new int[]{0,1};
                    } else if (leftResult > rightResult) {
                        sb.append("R");
                        currentRightHand = new int[]{0,1};
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            currentLeftHand = new int[]{0,1};
                        }else {
                            sb.append("R");
                            currentRightHand = new int[]{0,1};
                        }
                    }

                break;

                case 5:
                    leftResult = bfs(currentLeftHand, new int[]{1,1});
                    phoneMap = new int[4][3];
                    rightResult = bfs(currentRightHand, new int[]{1,1});
                    phoneMap = new int[4][3];

                    if(leftResult < rightResult) {
                        sb.append("L");
                        currentLeftHand = new int[]{1,1};
                    } else if (leftResult > rightResult) {
                        sb.append("R");
                        currentRightHand = new int[]{1,1};
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            currentLeftHand = new int[]{1,1};
                        }else {
                            sb.append("R");
                            currentRightHand = new int[]{1,1};
                        }
                    }



                    break;

                case 8:
                    leftResult = bfs(currentLeftHand, new int[]{2,1});
                    phoneMap = new int[4][3];
                    rightResult = bfs(currentRightHand, new int[]{2,1});
                    phoneMap = new int[4][3];

                    if(leftResult < rightResult) {
                        sb.append("L");
                        currentLeftHand = new int[]{2,1};
                    } else if (leftResult > rightResult) {
                        sb.append("R");
                        currentRightHand = new int[]{2,1};
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            currentLeftHand = new int[]{2,1};
                        }else {
                            sb.append("R");
                            currentRightHand = new int[]{2,1};
                        }
                    }

                    break;
                case 0:
                    leftResult = bfs(currentLeftHand, new int[]{3,1});
                    phoneMap = new int[4][3];
                    rightResult = bfs(currentRightHand, new int[]{3,1});
                    phoneMap = new int[4][3];

                    if(leftResult < rightResult) {
                        sb.append("L");
                        currentLeftHand = new int[]{3,1};
                    } else if (leftResult > rightResult) {
                        sb.append("R");
                        currentRightHand = new int[]{3,1};
                    } else {
                        if (hand.equals("left")) {
                            sb.append("L");
                            currentLeftHand = new int[]{3,1};
                        }else {
                            sb.append("R");
                            currentRightHand = new int[]{3,1};
                        }
                    }

                    break;

            }
        }

        return sb.toString();
    }

    private static int bfs(int[] currentHand, int[] goal) {

        if(currentHand[0] == goal[0] && currentHand[1] == goal[1]) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(currentHand);

        while (!queue.isEmpty()) {
            int[] cHand = queue.poll();
            int cx = cHand[0];
            int cy = cHand[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < 4 && ny >= 0 && ny < 3 && phoneMap[nx][ny] == 0) {
                    phoneMap[nx][ny] = phoneMap[cx][cy] + 1;

                    if(nx == goal[0] && ny == goal[1]) {
                        return phoneMap[nx][ny];
                    }

                    queue.add(new int[]{nx,ny});
                }
            }
        }
        return phoneMap[goal[0]][goal[1]];
    }

}
