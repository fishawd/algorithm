package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 15:50
 * @description 冒泡排序
 */
public class BubbleSort {

    //冒泡排序， 升序
    // 1. 比较相邻两个数字，将大的放在后面的位置，一趟排序后得到最大值放在了末尾
    // 2. 重复n趟, 数组有序
    public void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }

    //优化
    public void bubbleSort2(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int flag = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                    flag = 1;
                }
            }
            //没有发生交换，说明已经有序
            if (flag == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        bubbleSort.bubbleSort2(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
