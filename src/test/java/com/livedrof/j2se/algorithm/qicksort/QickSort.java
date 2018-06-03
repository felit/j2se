package com.livedrof.j2se.algorithm.qicksort;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

public class QickSort {
    public int[] original;

    @Before
    public void setUp() {
        original = new int[]{48, 6, 57, 88, 60, 42, 83, 73, 88, 85};
    }

    @Test
    public void test() {
        this.quick_sort1(original, 1, original.length - 1);
        this.printOriginal(this.original);
        System.out.println(quickSortNotRecursion(this.original));
        int[] result = this.quickSortNotRecursion(this.original);
        this.printOriginal(result);
    }

    private void printOriginal(int[] result) {
        for (int i : result) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.print("\n");
    }

    void quick_sort1(int s[], int l, int r) {
        if (l < r) {
            int i = AdjustArray(s, l, r);//先成挖坑填数法调整s[]
            quick_sort1(s, l, i - 1); // 递归调用
            quick_sort1(s, i + 1, r);
        }
    }

    protected int AdjustArray(int s[], int l, int r) //返回调整后基准数的位置
    {
        int i = l, j = r;
        int x = s[l]; //s[l]即s[i]就是第一个坑
        while (i < j) {
            // 从右向左找小于x的数来填s[i]
            while (i < j && s[j] >= x)
                j--;
            if (i < j) {
                s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                i++;
            }

            // 从左向右找大于或等于x的数来填s[j]
            while (i < j && s[i] < x)
                i++;
            if (i < j) {
                s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
                j--;
            }
        }
        //退出时，i等于j。将x填到这个坑中。
        s[i] = x;

        return i;
    }

    /**
     * https://blog.csdn.net/haolvshiqi/article/details/54290670
     *
     * @param result
     * @return
     */
    public int[] quickSortNotRecursion(int[] result) {
        int i;
        int j;
        int min;    // Every loop's max index
        int max;    // Every loop's minus index
        int key;

        Stack<Integer> conditions = new Stack<Integer>();   // Record the minus index and the max index
        conditions.push(0);
        conditions.push(result.length - 1);
        int temp;

        // In every loop will get a left index and right index.
        while (!conditions.empty()) {
            max = conditions.pop();
            min = conditions.pop();
            key = result[min];
            i = min + 1;
            j = max;

            // With this step, the numbers can be divided to 2 sections,
            // the left side is smaller than the key value,
            // the right side is bigger than the key value.
            while (i < j) {
                // Get the number's index which is smaller than key
                while (key < result[j] && i < j) {
                    j--;
                }

                // Get the number's index which is bigger than key
                while (key > result[i] && i < j) {
                    i++;
                }

                // Swap
                temp = result[j];
                result[j] = result[i];
                result[i] = temp;
            }

            // Swap the key and i(or j)
            if (key > result[i]) {
                temp = result[min];
                result[min] = result[j];
                result[j] = temp;
            }

            // Store the left side minus index and the max index
            if (min < i - 1) {
                conditions.push(min);
                conditions.push(i - 1);
            }

            // Store the right side minus index and the max index
            if (max > i + 1) {
                conditions.push(i + 1);
                conditions.push(max);
            }
        }

        return result;
    }

    /**
     * 自定义递归
     * 总结一下，快速排序的步骤：
     1、找到一个key值（就是数组第一个值），先从右到左找，找到一个比它小的值，记录下标。
     2、然后从左往右找，找到一个比它大的值，记录下标。
     3、交换找到的两个数字。
     4、继续，直到从右往左找的数字和从左往右找的数字下标重合。交换key值和重合值。
     5、这时key值左边就全是比它小的数字，key值右边全是比它大的数字。
     6、以key值为基准，将数组分为两段，左边和右边重新进行以上5步。
     * @param result
     * @return
     */
    public int[] quickSortNotRecursion2(int[] result) {
        int minPoint, maxPoint, minIndex, maxIndex, tmpValue, pointValue;
        while (true) {

        }
    }
}


