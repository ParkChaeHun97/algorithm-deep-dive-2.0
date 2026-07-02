package week_04_binary_search_parameters.binary_search.template;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 5, 7, 9, 11, 13, 15}; // 7 찾기

        int target = 7;

        int left = 0;
        int right = arr.length-1;


        while (left <= right) {
            int mid = left + right / 2;

            if (arr[mid] == target) {
                System.out.println(arr[mid]);
                break;
            } else if (arr[mid] < target) { // 오른쪽 중에 탐색
                left = mid + 1;
            }else { // 왼쪽 중에 탐색
                right = mid - 1;
            }

        }



    }
}
