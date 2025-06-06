package threads.simpleApi.forkJoinMitEinemArray;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    public static final int THRESHOLD = 5;
    private final int[] arr;
    private final int START, END;
    private static AtomicInteger zeroCount = new AtomicInteger(0);

    MyRecursiveTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.START = start;
        this.END = end;
    }

    @Override
    protected Integer compute() {
        if ((END - START) <= THRESHOLD) {
            for (int i = this.START; i < this.END; i++) {
                if (arr[i] < 0) zeroCount.incrementAndGet();
            }
        } else {
            int indexMid = (START + END) / 2;

            var leftSide = new MyRecursiveTask(arr, START, indexMid);
            var rightSide = new MyRecursiveTask(arr, indexMid, END);

            invokeAll(leftSide, rightSide);
        }

        return zeroCount.get();
    }

}
