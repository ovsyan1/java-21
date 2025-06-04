package threads.simpleApi.forkJoinMitEinemArray;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    public static final int THRESHOLD = 5;
    private final int[] arr;
    private final int start, end;

    MyRecursiveAction(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    @Override
    protected void compute() {
        if((end - start) <= THRESHOLD) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] < 0) {
                    arr[i] = 0;
                }
            }
        } else {
            int indexMid = (start + end) / 2;

            var leftSide = new MyRecursiveAction(arr, start, indexMid);
            var rightSide = new MyRecursiveAction(arr, indexMid, end);

            invokeAll(leftSide, rightSide);
        }
    }
}
