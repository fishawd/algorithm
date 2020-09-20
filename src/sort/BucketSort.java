package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fishawd
 * @date 2020/9/17 17:16
 * @description 桶排序
 */
public class BucketSort {
    //桶排序
    //1. 确定桶的个数
    //2. 将待排序列均匀的放入对应的桶中
    //3. 每个桶内做排序
    //4. 从桶中收集元素
    public void bucketSort(int[] arr) {

        //桶的数量，根据需要调整
        int num = 5;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            buckets.add(new ArrayList<>());
        }
        int max = arr[0];
        int min = arr[0];
        for (int x : arr) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        //桶之间的间隔
        int gap = (int) Math.floor((max - min) * 1.0 / num) + 1;
        for (int i = 0; i < arr.length; i++) {
            //放入第几个桶
            int index = (arr[i] - min) / gap;
            buckets.get(index).add(arr[i]);
        }
        //每个桶内排序
        int k = 0;
        for (List<Integer> bucket : buckets) {
            if (bucket.size() > 0) {
                //这里对桶内元素做排序，为了方便直接用了库函数
                bucket.sort(Comparator.comparingInt(a -> a));
                for (Integer element : bucket) {
                    arr[k] = element;
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] arr = new int[]{
                7, 4, 3, 1, 8, 5, 3, 2, 19, 12, 22, 20, 15, 11, 24, 13, 18
        };
        bucketSort.bucketSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
