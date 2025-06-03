package threads.simpleApi.forkJoinPoolSimple;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolSimple {
    static class MyRecursiveAction extends RecursiveAction {
        public static final int THRESHOLD = 3;

        private final int[] arr;
        private final int start, end;

        public MyRecursiveAction(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) <= THRESHOLD) {
                System.out.println("Unterbereich " + start + " .. " + end);
            } else {
                int indexMid = (start + end) / 2;

                RecursiveAction actionLeft = new MyRecursiveAction(arr, start, indexMid);
                RecursiveAction actionRight = new MyRecursiveAction(arr, indexMid, end);

                invokeAll(actionLeft, actionRight);
            }

        }
    }

    public static void main(String... unused) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ForkJoinPool pool = new ForkJoinPool();

        RecursiveAction action = new MyRecursiveAction(arr, 1, arr.length);
        pool.invoke(action);
    }

}
