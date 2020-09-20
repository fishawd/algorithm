package sort;

import java.util.Arrays;

/**
 * @author fishawd
 * @date 2020/9/17 17:03
 * @description 堆排序
 */
public class HeapSort {

    //堆是一个完全二叉树，分为大顶推和小顶堆，
    //大顶堆的每个结点的值均大于其左右结点， 小顶堆则相反
    // 特点: 结点i的左右结点分别是 2*i+1和 2*i+2
    // 算法步骤(升序)
    // 1. 建立大顶堆
    // 2. 每次取出根节点，放在数组尾部
    // 3. 调整剩下的节点，继续保持大顶堆
    // 4. 重复2,3步， 直至堆为空
    public void heapSort(int[] arr) {
        //非叶结点不用调整，从第一个非叶节点开始
        int begin = arr.length / 2 - 1;
        for (int i = begin; i >= 0; i--) {
            buildHeap(arr, i, arr.length - 1);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            //取出头部元素
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            buildHeap(arr, 0, i - 1);
        }

    }

    // index是调整的结点序号, len是要调整的堆的大小
    public void buildHeap(int[] arr, int index, int len) {
        int left = 2 * index + 1;
        int right = left + 1;
        //比较左右节点的大小，找出较大的结点
        int curMax = left;
        if (curMax > len) return;
        if (right <= len && arr[right] > arr[left]) {
            curMax = right;
        }
        //比较孩子结点和根节点是否符合
        if (arr[index] < arr[curMax]) {
            int t = arr[index];
            arr[index] = arr[curMax];
            arr[curMax] = t;
            //继续调整
            buildHeap(arr, curMax, len);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2
        };
        heapSort.heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
