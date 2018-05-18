
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by norafang on 8/14/17.
 * add/delete node 的优化， 用circular array, head 和 tail 指针指向queue的头尾
 * follow up: data size is big, store in database
 */
public class MovingAverage {
    Queue<Integer> window;
    int size;
    long sum;
    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        window = new LinkedList<>();
    }
    public static void main(String[] args) {
        MovingAverage test = new MovingAverage(5);
        int[] testcase = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < testcase.length; i++) {
            System.out.println(test.next(testcase[i]));
        }
    }
    public double next(int val) {
        if (window.size() < size) {
            window.offer(val);
            sum += val;
            return (double)sum/window.size();
        } else {
            int removeVal = window.poll();
            sum = sum - removeVal + val;
            return (double)sum/size;
        }
    }
}


