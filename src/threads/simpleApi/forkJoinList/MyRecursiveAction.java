package threads.simpleApi.forkJoinList;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    public static final int THRESHOLD = 10000;
    private final List<String> words;
    private final int START, END;

    MyRecursiveAction(List<String> words, int start, int end) {
        this.words = words;
        this.START = start;
        this.END = end;
    }
    @Override
    protected void compute() {
        if(this.END - this.START <= THRESHOLD) {
           words.stream().map(String::toUpperCase).forEach(System.out::println);
        } else {
            int indexMid = (this.START + this.END) / 2;

            var left = new MyRecursiveAction(words, this.START, indexMid);
            var right = new MyRecursiveAction(words, indexMid, this.END);

            invokeAll(left, right);
        }
    }
}
