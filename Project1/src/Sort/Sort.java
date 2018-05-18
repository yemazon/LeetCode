package Sort;

public class Sort {

    /*
    冒泡排序的原理非常简单，它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。

    步骤：

    1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    2. 对第0个到第n-1个数据做同样的工作。这时，最大的数就“浮”到了数组最后的位置上。
    3. 针对所有的元素重复以上的步骤，除了最后一个。
    4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

    时间复杂度: n^2

    优化1：某一趟遍历如果没有数据交换，则说明已经排好序了，因此不用再进行迭代了。用一个标记记录这个状态即可。

    优化2：记录某次遍历时最后发生数据交换的位置，这个位置之后的数据显然已经有序，不用再排序了。因此通过记录最后发生数据交换的位置就可以确定下次循环的范围了。
     */

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1] > array[j]) {
                    int k = array[j];
                    array[j] = array[j-1];
                    array[j-1] = k;
                }
            }
        }
    }

    /*
    选择排序无疑是最简单直观的排序。它的工作原理如下。

    步骤：

    在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
    再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
    以此类推，直到所有元素均排序完毕。


     */

    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;                                //最小元素下标标记
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;                            //找到最小值的下标
                    int k = array[min];
                    array[min] = array[i];
                    array[i] = k;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] input1 = {5,1,4,76,9,342,43,2};
        int[] input2 = {5,1,4,76,9,342,43,2};

        System.out.print(input1 == input2);

        for (Integer i : input2) {

        }
    }

}
