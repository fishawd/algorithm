package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 17:06
 * @description 希尔排序
 */
public class ShellSort {
    // 希尔排序本质上是分组的插入排
    // 1. 确定增量序列，也就是组数，最后一个序列一定是1
    // 2. 根据序列分组，分别插入排序

    //希尔，升序
    public void shellSort(int[] arr) {
        // 增量序列{ n/2, n/4... 1}
        for (int i = arr.length / 2; i > 0; i /= 2) {
            // 一趟排序所有组
            for (int j = i; j < arr.length; j++) {
                //待排元素
                int temp = arr[j];
                // 已排数组的最后一个位置
                int k = j - i;
                while (k >= 0 && arr[k] > temp) {
                    arr[k + i] = arr[k];
                    k -= i;
                }
                arr[k + i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        shellSort.shellSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
