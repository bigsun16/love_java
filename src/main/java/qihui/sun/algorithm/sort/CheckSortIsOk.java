package qihui.sun.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：时间：O(N^2)   空间：O(1)    稳定：否
 * 冒泡排序：时间：O(N^2)   空间：O(1)    稳定：是
 * 插入排序：时间：O(N^2)   空间：O(1)    稳定：是
 * 归并排序：时间：O(NlogN) 空间：O(N)    稳定：是
 * 快读排序：时间：O(NlogN) 空间：O(logN) 稳定：否
 * 大堆排序：时间：O(NlogN) 空间：O(1)    稳定：否
 */
public class CheckSortIsOk {
    public static void main(String[] args) throws InterruptedException {
        final int times = 100000;
        final int maxNum = 1000;
        final int maxSize = 1000;
        boolean result = false;
        long l = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] arr = generatorRandomArr(maxSize, maxNum);
            int[] arr2 = copyArray(arr);
//            SelectionSort.sort(arr);//11731
//            BubbleSort.sort(arr);//29463  23580
//            InsertionSort.sort(arr);//7750
//            MergeSort.sort(arr);//7251
//            QuickSort.sort(arr);//6356
            HeapSort.sort(arr);//5502
            Arrays.sort(arr2);
            result = Arrays.equals(arr, arr2);
            if (!result) {
                break;
            }
        }
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(result);
    }

    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static int[] generatorRandomArr(int maxSize, int maxNum) {
        int count = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxNum + 1)) - (int) (Math.random() * (maxNum + 1));
//            arr[i] = (int) (Math.random() * (maxNum + 1));
        }
        return arr;
    }

    public static void swap2(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}
