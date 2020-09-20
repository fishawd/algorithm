package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 17:04
 * @description 归并排序
 */
public class MergeSort {

    //归并排序，分治思想
    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    //合并两个有序数组
    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int l = left;
        int r = mid + 1;
        int tIndex = left;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[tIndex] = arr[l];
                l++;
            } else {
                temp[tIndex] = arr[r];
                r++;
            }
            tIndex++;
        }
        //合并剩下的数据
        while (l <= mid) {
            temp[tIndex] = arr[l];
            l++;
            tIndex++;
        }
        while (r <= right) {
            temp[tIndex] = arr[r];
            r++;
            tIndex++;
        }
        //将temp复制到原数组
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
