package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 17:02
 * @description 插入排序
 */
public class InsertSort {

    // 插入排序(升序)
    // 1. 遍历待排序列
    // 2. 在有序系列中找到插入的位置
    // 3. 移动元素
    public void insertSort(int[] arr) {
        //遍历待排序列
        for (int i = 1; i < arr.length; i++) {
            //在有序序列中找到插入的位置, 正序查找，也可以倒序查找
            int j = 0;
            while (j < i && arr[j] < arr[i]) j++;
            //移动元素
            int t = arr[i];
            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        insertSort.insertSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
