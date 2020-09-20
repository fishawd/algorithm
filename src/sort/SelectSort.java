package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 17:02
 * @description 选择排序
 */
public class SelectSort {

    // 选择排序和冒泡区别只是在于，选择排序找到最值再交换，而冒泡是两两交换
    // 升序
    public void selectSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            // curMax表示最值下标
            int curMax = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[curMax]){
                    curMax = j;
                }
            }
            //将最大值和i交换
            int t = arr[i];
            arr[i] = arr[curMax];
            arr[curMax] = t;
        }
    }

    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        selectSort.selectSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
