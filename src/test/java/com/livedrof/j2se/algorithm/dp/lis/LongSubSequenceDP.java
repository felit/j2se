package com.livedrof.j2se.algorithm.dp.lis;

import org.junit.Test;

import java.util.Arrays;

/**
 * 数据是一维的，是二维的？
 */
public class LongSubSequenceDP {
    int[] a = new int[]{13, 7, 19, 16, 38, 24, 37, 18, 44, 19, 21, 22, 63, 15};

    /**
     * #include <iostream>
     * using namespace std;
     * #define len(a) (sizeof(a) / sizeof(a[0])) //数组长度
     * int lis(int arr[], int len)
     * {
     * int longest[len];
     * for (int i=0; i<len; i++)
     * longest[i] = 1;
     * <p>
     * for (int j=1; j<len; j++) {
     * for (int i=0; i<j; i++) {
     * if (arr[j]>arr[i] && longest[j]<longest[i]+1){ //注意longest[j]<longest[i]+1这个条件，不能省略。
     * longest[j] = longest[i] + 1; //计算以arr[j]结尾的序列的最长递增子序列长度
     * }
     * }
     * }
     * <p>
     * int max = 0;
     * for (int j=0; j<len; j++) {
     * cout << "longest[" << j << "]=" << longest[j] << endl;
     * if (longest[j] > max) max = longest[j];  //从longest[j]中找出最大值
     * }
     * return max;
     * }
     * <p>
     * int main()
     * {
     * int arr[] = {1, 4, 5, 6, 2, 3, 8}; //测试数组
     * int ret = lis(arr, len(arr));
     * cout << "max increment substring len=" << ret << endl;
     * return 0;
     * }
     * O(n平方)
     */
    @Test
    public void testLeftToRight2() {
        int[] longest = new int[a.length];
        //初始状态均为1
        for (int i = 0; i < longest.length; i++) {
            longest[i] = 1;
        }

        for (int endWith = 1; endWith < a.length; endWith++) {
            for (int cur = 0; cur < endWith; cur++) {
                //最优子结构；判断+上一个结果
                //a[cur] < a[endWith]不下降; 依赖上一个阶段的结果即longest[cur]
                if (a[cur] < a[endWith] && longest[cur] + 1 >= longest[endWith]) {
                    longest[endWith] = longest[cur] + 1;
                }
            }
        }
        printArray(longest);
        Arrays.sort(longest);
        System.out.println(longest[longest.length - 1]);

    }

    private void printArray(int[] arr) {
        System.out.println();
        //输出
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        System.out.println();
    }

    /**
     * 最长不下降子序列
     * 正序
     * 含义：f[n],从起点到当前的最大长度
     * 公式：f[n] = max{f[x]} + 1;{0<=x<n && a[x]<=a[n]}
     * 边界：f[0] = 1;
     */
    @Test
    public void testLeftToRight() {
        int length = a.length;
        int[] maxLength = new int[length];
        int[] c = new int[length];

        // border
        maxLength[0] = 1;

        // formula
        //i: 结束位置；即当前位置
        //j: 内层迭代变量
        //k: 记录解
        int i, j, l, k;
        for (i = 1; i < length; i++) {
            l = 0;
            k = 0;
            for (j = 0; j < i; j++) {
                if (l < maxLength[j] && a[j] <= a[i]) {
                    l = maxLength[j];
                    k = j;
                }
            }
            maxLength[i] = l + 1;
            c[i] = k;
        }

        // result
        int temp = 0;
        k = 0;
        for (i = 0; i < length; i++) {
            if (temp < maxLength[i]) {
                temp = maxLength[i];
                k = i;
            }
        }
        System.out.println("the long of sub sequence : " + temp);
        System.out.print("the sub sequence is : ");
        while (k != 0) {
            System.out.print(a[k] + " ");
            k = c[k];
        }
    }

    @Test
    public void testRightToLeft() {
        int length = a.length;
        int[] f = new int[length];
        int[] c = new int[length];

        // border
        f[length - 1] = 1;

        // formula
        int i, j;
        for (i = length - 2; i >= 0; i--) {
            // 保存长度
            int l = 0;
            // 保存索引
            int k = 0;
            for (j = i + 1; j <= length - 1; j++) {
                if (l < f[j] && a[i] <= a[j]) {
                    l = f[j];
                    k = j;
                }
            }
            f[i] = l + 1;
            c[i] = k;
        }

        // result
        int maxLength = 0;
        int index = 0;
        for (i = 0; i < length; i++) {
            if (maxLength < f[i]) {
                maxLength = f[i];
                index = i;
            }
        }
        System.out.println("the long of sub sequence : " + maxLength);
        System.out.print("the sub sequence is : ");
        while (index != 0) {
            System.out.print(a[index] + " ");
            index = c[index];
        }
    }
}
