package sort;

import java.util.Arrays;

/**
 * @author jian
 * @date 2020/9/17 15:49
 * @description 快速排序
 */
public class QuickSort {
    // 快速排序，升序
    // 1. 选择第一个元素作为temp哨兵
    // 2. 从后往前，找到第一个比temp小的, 将该元素移动到l的位置
    // 3. 从前往后，找到第一个比temp大的, 将该元素一定能够到r的位置
    public void quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int temp = arr[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && arr[r] > temp) r--;
                if (l < r) {
                    arr[l] = arr[r];
                    l++;
                }
                while (l < r && arr[l] < temp) l++;
                if (l < r) {
                    arr[r] = arr[l];
                    r--;
                }
            }
            arr[l] = temp;
            quicksort(arr, left, l - 1);
            quicksort(arr, l + 1, right);
        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        quickSort.quicksort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
