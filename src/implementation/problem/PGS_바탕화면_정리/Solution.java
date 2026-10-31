package implementation.problem.PGS_바탕화면_정리;

// 바탕화면은 정사각형인 격자판
// 컴퓨터 바탕화면 상태 wallpaper
// 가장 왼쪽 위 0,0
// 빈칸 ".", 파일 있는 칸 "#"
// 드래그 하면 파일들 선택, 선택 된 파일들을 삭제 가능
// 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고함


// for문 돌면서 최소 x,y 최대 x,y 구하기

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }


        return new int[]{minX, minY, maxX, maxY};
    }
}
