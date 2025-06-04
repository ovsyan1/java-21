package threads.simpleApi.forkJoinList;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {
    public static final int THRESHOLD = 15000;
    private final List<String> words;
    private final int START, END;

    MyRecursiveTask(List<String> words, int start, int end) {
        this.words = new CopyOnWriteArrayList<>(words);
        this.START = start;
        this.END = end;
    }

    @Override
    protected String compute() {
        if (this.END - this.START <= THRESHOLD) {
            return words.subList(this.START, this.END).stream()
                    .max(Comparator.naturalOrder())
                    .orElse("");
        } else {
            int indexMid = (this.START + this.END) / 2;

            var left = new MyRecursiveTask(words, this.START, indexMid);
            var right = new MyRecursiveTask(words, indexMid, this.END);

            invokeAll(left, right);
            String leftResult = left.join();
            String rightResult = right.join();

            return leftResult.compareTo(rightResult) >= 0 ? leftResult : rightResult;
        }
    }
}
